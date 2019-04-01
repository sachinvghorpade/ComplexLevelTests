package com.training.pom;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RETC_080_Add_New_Property_Details_POM {
	private WebDriver driver;

	public RETC_080_Add_New_Property_Details_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Properties')]") // Locator to locate Properties link
	private WebElement tabProperties;

	@FindBy(xpath = "//a[@href='post-new.php?post_type=property']") // Locator to locate Add New Button
	private WebElement linkAddNew;

	@FindBy(id = "title") // Locator to Locate the Enter Title Text box
	private WebElement enterTitleTextBox;

	@FindBy(xpath = "//body[@id='tinymce']") // Locator to Locate the Content Text Area
	private WebElement enterCotentTextArea;

	@FindBy(id = "_price")// Locator to locate Price Here text box
	private WebElement enterTextBoxPrice;

	@FindBy(id = "_price_per")// Locator to locate Price per sq. meter/sq. ft text box
	private WebElement enterTextBoxPricePerSqMeter;

	@FindBy(id = "_status")// Locator to locate Status text box
	private WebElement enterTextBoxStatus;

	@FindBy(id = "_location")// Locator to locate Location text box
	private WebElement enterTextBoxLocation;

	@FindBy(id = "_possession")// Locator to locate Possession text box
	private WebElement enterTextBoxPossession;

	@FindBy(id = "_friendly_address")// Locator to locate Address text box
	private WebElement enterTextBoxAddress;

	@FindBy(id = "_address")// Locator to locate Google Maps Address text box
	private WebElement enterTextBoxGoogleMapAddress;

	@FindBy(id = "_geolocation_lat")// Locator to locate Latitude text box
	private WebElement enterTextBoxLatitude;

	@FindBy(id = "_geolocation_long")// Locator to locate Longitude text box
	private WebElement enterTextBoxLongitude;

	@FindBy(id = "_storage_room")// Locator to locate Storage Room text box
	private WebElement enterTextBoxStorageRoom;

	@FindBy(xpath = "//ul[@class='children acf-bl']//input[@value='50']")// Locator to locate Central Bangalore Check box
	private WebElement chkboxCentralBangalore;

	@FindBy(id = "in-property_feature-135") // Locator to Locate check box beside added Feature of Features
	private WebElement chkboxFirstFeature; // section

	@FindBy(css = "input[id^='in-region-']") // Locator to locate check box beside added Region of Regions section
	private WebElement chkboxFirstRegion;

	@FindBy(id = "publish") // Locator to locate Publish Button
	private WebElement btnPublish;

	@FindBy(xpath = "//a[contains(text(),'Howdy,')]") // Locator to locate Admin icon before logout
	private WebElement adminIcon;

	@FindBy(xpath = "//a[@class='ab-item'][contains(text(),'Log Out')]") // Locator to locate logout link
	private WebElement linkLogOut;

	@FindBy(className = "orig")// Locator to locate search box for added property
	private WebElement enterSearchHereForProperties;

	@FindBy(xpath = "//div[@class='resdrg']/descendant::span[1]")// Locator to locate span of added property details
	private WebElement spanSelectSearchedProperty;

	@FindBy(xpath = "//h2[contains(text(),'new launch')]")// Locator to locate added property details
	private WebElement getTextNewLaunchPropertyDetails;

	public void clickOnProperties() { // Method for clicking on Properties link
		this.tabProperties.click();
	}

	public void clickLinkAddNew() throws Exception { // Method for clicking Add New Button
		this.linkAddNew.click();

	}

	public void enterTitleTextBox(String title) // Method for Entering valid credentials in Enter Title Here text box
	{
		this.enterTitleTextBox.clear();
		this.enterTitleTextBox.sendKeys(title);
	}

	public void enterContentTextArea(String content) throws Exception // Enter valid credentials in Content text Area
	{
		driver.switchTo().frame(0);
		this.enterCotentTextArea.clear();
		this.enterCotentTextArea.sendKeys(content);
		driver.switchTo().defaultContent();
	}

	public void clickLink(String linkName) //Method to click on any link on web page
	{
		driver.findElement(By.linkText(linkName)).click();
	}

	public void enterPriceTextBox(String price)//Method to enter valid credentials in Price Here text box 
	{
		this.enterTextBoxPrice.clear();
		this.enterTextBoxPrice.sendKeys(price);
	}

	public void enterPricePerSqMeterTextBox(String pricePerSqMeter)//Method to enter valid credentials in Price per sq. meter/sq. ft textbox 
	{
		this.enterTextBoxPricePerSqMeter.clear();
		this.enterTextBoxPricePerSqMeter.sendKeys(pricePerSqMeter);
	}

	public void enterStatusTextBox(String status)//Method to enter valid credentials in Status text box 
	{
		this.enterTextBoxStatus.clear();
		this.enterTextBoxStatus.sendKeys(status);
	}

	public void enterLocationTextBox(String location) //Method to enter valid credentials in Location text box
	{
		this.enterTextBoxLocation.clear();
		this.enterTextBoxLocation.sendKeys(location);
	}

	public void enterPossessionTextBox(String possession)//Method to enter valid credentials in Possession text box 
	{
		this.enterTextBoxPossession.clear();
		this.enterTextBoxPossession.sendKeys(possession);
	}

	public void enterAddressTextBox(String address)//Method to enter valid credentials in Address text box 
	{
		this.enterTextBoxAddress.clear();
		this.enterTextBoxAddress.sendKeys(address);
	}

	public void enterGoogleMapAddressTextBox(String googleMapAddress) //Method to enter valid credentials in Google Maps Address text box
	{
		this.enterTextBoxGoogleMapAddress.clear();
		this.enterTextBoxGoogleMapAddress.sendKeys(googleMapAddress);
	}

	public void enterLatitudeTextBox(String latitude)// Method to enter valid credentials in Latitude text box 
	{
		this.enterTextBoxLatitude.clear();
		this.enterTextBoxLatitude.sendKeys(latitude);
	}

	public void enterLongitudeTextBox(String longitude)//Method to enter valid credentials in Longitude text box 
	{
		this.enterTextBoxLongitude.clear();
		this.enterTextBoxLongitude.sendKeys(longitude);
	}

	public void enterStorageRoomTextBox(String storageRoom) //Method to enter valid credentials in Storage Room text box
	{
		this.enterTextBoxStorageRoom.clear();
		this.enterTextBoxStorageRoom.sendKeys(storageRoom);
	}

	public void selectCheckBoxCentralBangalore() //Method to click on Central Bangalore Checkbox
	{
		this.chkboxCentralBangalore.click();
	}

	public void selectCheckBoxFirstFeature() { // Method for Clicking on check box beside added Feature of Features
												// section

		WebElement tabAllFeatures = driver.findElement(By.xpath("//a[contains(text(),'All Features')]"));
		Actions act = new Actions(driver);
		act.moveToElement(tabAllFeatures).build().perform();
		this.chkboxFirstFeature.click();
	}

	public void selectCheckBoxFirstRegion() { // Method for Clicking on check box beside
												// added Region of
		this.chkboxFirstRegion.click();

	}

	public void clickButtonPublish() throws Exception { // Method for clicking Publish Button
		WebElement spanPublish = driver
				.findElement(By.xpath("//h2[@class='hndle ui-sortable-handle']//span[contains(text(),'Publish')]"));
		Actions act = new Actions(driver);
		act.moveToElement(spanPublish).build().perform();
		this.btnPublish.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Post published.')]")));

	}

	
	public void clickLogOutLink() { // Method for clicking on logout link for admin
		Actions act = new Actions(driver);
		act.moveToElement(this.adminIcon).build().perform();
		this.linkLogOut.click();
	}

	public void enterSearchHereForProperties(String propertyName) //Method to search added property
	{
		this.enterSearchHereForProperties.clear();
		this.enterSearchHereForProperties.sendKeys(propertyName);
	}

	public void selectSpanForSearchedProperty()//Method to select span of added property details 
	{
		this.spanSelectSearchedProperty.click();
	}

	public String getTextNewLaunchPropertyDetails() //Method to get details of added property details
	{
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		return this.getTextNewLaunchPropertyDetails.getText();
	}
}
