package com.rbs.login.StepDef;

import org.junit.Assert;

import com.rbs.core.AutomationService;
import com.rbs.core.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutomationStepDefinition {
	
	WebConnector selenium = new WebConnector();
	AutomationService service;
	
	@Given("^I open \"([^\"]*)\" on \"([^\"]*)\"$")
	public void openApplication(String url, String browser) {	
		selenium.openBrowser(browser);
		service = new AutomationService(selenium);
		service.navigate(url);
	}
	
	@When("^I click on \"(.*?)\"$")
	public void i_click_on(String arg1) throws Throwable {
		service.waitForElement(arg1);
		service.click(arg1);
	}

	
	@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void enteringData(String object, String value) {		
		service.type(object, value);
	}
	
	@And("^I update \"([^\"]*)\" as \"([^\"]*)\"$")
	public void updatingData(String object, String value) {		
		service.clearAndType(object, value);
	}	
	
	@Then("^I should land on \"([^\"]*)\"$")
	public void loginResult(String expectedResult) {		
		boolean ispresent = service.isHomePage(expectedResult);
		Assert.assertTrue("Not Logged in", ispresent);
	}	
	
	@And("^I select on \"(.*?)\"$")
	public void i_select_on(String arg1) throws Throwable {
		service.click(arg1);
	}	
	
	@Then("^I verify my order history$")
	public void verifyOrderRefNumber() {	
		boolean ispresent = service.isOrderPresent();
		Assert.assertTrue("Order not present in history", ispresent);
		selenium.getWebDriver().quit();
	}
	
	@Then("^I should see orderConfirmation$")
	public void orderConfirmationScreen(){
		boolean ispresent = service.orderConfirmationScreen();
		service.saveOrderRefNumber();
		Assert.assertTrue("Order Confirmation screen not appeared", ispresent);
	}
	
	@Then("^I confirm my \"([^\"]*)\"$")
	public void verifyConfirmationText(String object) {	
		boolean textPresent = service.verifyconfirmationText(object);
		Assert.assertTrue("Updation failed", textPresent);
		selenium.getWebDriver().quit();
	}
	

	
} 
