package com.training.pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RETC_078_Add_Invalid_Users_POM {
	private WebDriver driver;

	public RETC_078_Add_Invalid_Users_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[contains(text(),': The email address isn’t correct.')]")	// Locator to locate "New user created. Edit user" message
	private WebElement textMessageInvalidUserCreated;
	

	public String gettextMessageInvalidUserCreated() //Method to get message "New user created. Edit user" message
	{
		return this.textMessageInvalidUserCreated.getText();
	}
	
	
	
	
}
