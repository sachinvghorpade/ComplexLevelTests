package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RETC_077_Add_Multiple_Users_From_DB_POM {
	private WebDriver driver;

	public RETC_077_Add_Multiple_Users_From_DB_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[contains(text(),'New user created.')]")	// Locator to locate "New user created. Edit user" message
	private WebElement textMessageNewUserCreated;
	
	
	
	public String gettextMessageNewUserCreated() //Method to get message "New user created. Edit user" message
	{
		return this.textMessageNewUserCreated.getText();
	}
	
	
	
}
	
	


