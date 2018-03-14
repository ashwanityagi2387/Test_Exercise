package com.rbs.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebConnector {
	
	public static WebDriver driver;
	public static Properties OR;
	public static Properties Config;
	public static FileInputStream fis;
	public static Logger logs = Logger.getLogger("devpinoyLogger");
	
		
	public WebConnector() {
		
		if(OR==null) {
			OR = new Properties();
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\rbs\\config\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Config = new Properties();
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\rbs\\config\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
	}
	
	public void openBrowser(String browserType) {
		
		if(Config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(Config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	}
	
	public Properties getConfig(){
		return Config;
	}
	
	public Properties getOR(){
		return OR;
	}
	
	public WebDriver getWebDriver(){
		return driver;
	}
	
}
