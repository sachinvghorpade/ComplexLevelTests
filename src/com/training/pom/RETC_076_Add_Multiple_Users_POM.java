package com.training.pom;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class RETC_076_Add_Multiple_Users_POM {
	private WebDriver driver;

	public RETC_076_Add_Multiple_Users_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Users')]") // Locator to locate Users link
	private WebElement linkUsers;

	@FindBy(xpath = "//a[@href='user-new.php']") // Locator to locate Add New link
	private WebElement linkAddNew;
	
	@FindBy(id="user_login")	// Locator to locate User name text box
	private WebElement textboxUsername;

	@FindBy(id="email")	// Locator to locate  Email text box
	private WebElement textboxEmail;
	
	@FindBy(id="first_name")	// Locator to locate First Name text box
	private WebElement textboxFirstName;
	
	@FindBy(id="last_name")	// Locator to locate Last Name text box
	private WebElement textboxLastName;
	
	@FindBy(id="url")	// Locator to locate Web site text box
	private WebElement textboxWebsite;
	
	@FindBy(xpath="//button[contains(text(),'Show password')]")	// Locator to locate Show Password button
	private WebElement btnShowPassword;	
	
	@FindBy(id="pass1-text")	// Locator to locate Password text box
	private WebElement textboxPassword;
	
	@FindBy(id="role")	// Locator to locate Role list box
	private WebElement dropdownRole;
	
	@FindBy(id="createusersub")	// Locator to locate Add New User button
	private WebElement btnAddNewUser;
	
	@FindBy(xpath="//p[contains(text(),'New user created.')]")	// Locator to locate "New user created. Edit user" message
	private WebElement textMessageNewUserCreated;
	
	

	public void clickOnUsers() { // Method for clicking on Users link
		this.linkUsers.click();
	}

	public void clickLinkAddNew() { // Method for clicking Add New Button
		this.linkAddNew.click();

	}

	public void enterUserName(String username) //Method for entering Valid credentials in User name text box
	{
		this.textboxUsername.clear();
		Date date=new Date();
		long time = date.getTime();
		this.textboxUsername.sendKeys(username+time);

	}
	
	public void enterEmail(String email) //Method for entering Valid credentials in Email text box
	{
		this.textboxEmail.clear();
		Date date=new Date();
		long time = date. getTime();
		this.textboxEmail.sendKeys(time+email);

	}
	
	public void enterFirstName(String firstname) //Method for entering Valid credentials in First Name text box
	{
		this.textboxFirstName.clear();
		this.textboxFirstName.sendKeys(firstname);

	}
	
	public void enterLastName(String lastname) //Method to enter Valid credentials in Last Name text box
	{
		this.textboxLastName.clear();
		this.textboxLastName.sendKeys(lastname);

	}
	
	public void enterWebsite(String website) //Method to enter Valid credentials in Web site text box
	{
		this.textboxWebsite.clear();
		this.textboxWebsite.sendKeys(website);

	}
	
	public void clickButtonShowPassword() { //Method to click on Show Password button
		this.btnShowPassword.click();

	}
	
	public void enterPassword(String password) //Method to enter Valid credentials in Password text box
	{
		this.textboxPassword.clear();
		this.textboxPassword.sendKeys(password);

	}
	
	public void selectRoleDropdown(String role) //Method to click on Role list box and select Valid credentials in Role list box
	{
		Select selectRole=new Select(this.dropdownRole);
		selectRole.selectByVisibleText(role);
		
	}
	
	public void clickButtonAddNewUser() //Method to click on Add New User button
	{ 
		this.btnAddNewUser.click();

	}
	
	public String gettextMessageNewUserCreated() //Method to get message "New user created. Edit user" message
	{
		return this.textMessageNewUserCreated.getText();
	}
	
	
	
	
}
