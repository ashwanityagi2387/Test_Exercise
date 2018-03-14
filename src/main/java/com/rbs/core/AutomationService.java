package com.rbs.core;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationService {
	
	private WebDriver driver;
	private Properties Config;
	private Properties OR;
	public String orderRefNumber;
	
	public AutomationService(WebConnector wc){
		driver = wc.getWebDriver();
		Config = wc.getConfig();
		OR = wc.getOR();
	}
	
	public void navigate(String url) {
		driver.get(Config.getProperty("url"));
	}
	
	
	public void type(String locator, String value) {
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
	}
	
	public void clearAndType(String locator, String value) {
		driver.findElement(By.xpath(OR.getProperty(locator))).clear();
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
	}

	public void click(String locator) {
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}
	
	public void select(String locator) {
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}
	
	public void waitForElement(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(locator))));

	}
	
	public void saveOrderRefNumber() {
		String line= driver.findElement(By.xpath(OR.getProperty("order_reference_number"))).getText();
		orderRefNumber = line.split("reference ")[1].split(" ")[0].trim();
	}
	
	public boolean isOrderPresent() {
		return driver.findElements(By.xpath(OR.getProperty("orderReference"))).get(0).getText().trim().equals(orderRefNumber);
	}
	
	public boolean isHomePage(String locator) {
		if(driver.findElements(By.xpath(OR.getProperty(locator))).size() != 0){
			return true;
		}
		return false;
	}
	
	public boolean orderConfirmationScreen() {
		List<WebElement> elements = driver.findElements(By.xpath(OR.getProperty("pageHeading")));
		if(elements.size() > 0 && elements.get(0).getText().equalsIgnoreCase("Order confirmation")){
			return true;
		}
		return false;
	}
	
	public boolean verifyconfirmationText(String locator) {
		return driver.findElement(By.xpath(OR.getProperty(locator))).getText().equals("Your personal information has been successfully updated.");
	}
	

}
