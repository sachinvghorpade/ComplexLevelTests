package com.training.functional.tests;

import java.io.FileInputStream;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ExtentReportGenerator;
import com.training.generics.ScreenShot;

import com.training.pom.LoginPOM;


import com.training.pom.RETC_079_Add_Multiple_New_Features_POM;
import com.training.pom.RETC_080_Add_New_Property_Details_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_080 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_080_Add_New_Property_Details_POM add_New_Property_Details_POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentTest test;
	private ExtentReports report;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		add_New_Property_Details_POM = new RETC_080_Add_New_Property_Details_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = ExtentReportGenerator.generateReport();
		test = report.startTest("Test Case name: RETC_080");
		// open the browser
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Pre-Condition 1:", "User launched the application by entering valid URL.");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		test.log(LogStatus.INFO, "Pre-Condition 2:", "Admin logged in.");
		screenShot.captureScreenShot("RETC_080_Pre-Condition2_Admin_Login_Success");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test()
	public void Functional_Test_RETC_080() throws Exception {
		
		String expectedPropertyDetails="new launch For Sale Apartments";
		add_New_Property_Details_POM.clickOnProperties();
		test.log(LogStatus.INFO, "Test Step 1.", "Clicked on Properties link");
		
		add_New_Property_Details_POM.clickLinkAddNew();
		test.log(LogStatus.INFO, "Test Step 2.", "Clicked on Add New link");
		
		add_New_Property_Details_POM.enterTitleTextBox("new launch");
		test.log(LogStatus.INFO, "Test Step 3.", "Entered valid credentials in Enter Title Here textbox");
		
		add_New_Property_Details_POM.enterContentTextArea("new launch");
		test.log(LogStatus.INFO, "Test Step 4.", "Entered valid credentials in textbox");
		
		add_New_Property_Details_POM.enterPriceTextBox("50000.00");		
		test.log(LogStatus.INFO, "Test Step 5.", "Entered valid credentials in Price Here textbox");
		add_New_Property_Details_POM.enterPricePerSqMeterTextBox("200.00");
		test.log(LogStatus.INFO, "Test Step 6.", "Entered valid credentials in Price per sq. meter/sq. ft textbox");
		
		add_New_Property_Details_POM.clickLink("Main Details");
		test.log(LogStatus.INFO, "Test Step 7.", "Clicked on Main Details tab");
		add_New_Property_Details_POM.enterStatusTextBox("New");
		test.log(LogStatus.INFO, "Test Step 8.", "Entered valid credentials in Status textbox");
		add_New_Property_Details_POM.enterLocationTextBox("Electronic city");
		test.log(LogStatus.INFO, "Test Step 9.", "Entered valid credentials in Location textbox");
		add_New_Property_Details_POM.enterPossessionTextBox("immediate");
		test.log(LogStatus.INFO, "Test Step 10.", "Entered valid credentials in Possession textbox");
		
		add_New_Property_Details_POM.clickLink("Location");
		test.log(LogStatus.INFO, "Test Step 11.", "Clicked on Location tab");
		add_New_Property_Details_POM.enterAddressTextBox("yeshwanthapur");
		test.log(LogStatus.INFO, "Test Step 12.", "Entered valid credentials in Address textbox");
		add_New_Property_Details_POM.enterGoogleMapAddressTextBox("yeshwanthapur");
		test.log(LogStatus.INFO, "Test Step 13.", "Entered valid credentials in Google Maps Address textbox");
		add_New_Property_Details_POM.enterLatitudeTextBox("120");
		test.log(LogStatus.INFO, "Test Step 14.", "Entered valid credentials in Latitude textbox");
		add_New_Property_Details_POM.enterLongitudeTextBox("56");
		test.log(LogStatus.INFO, "Test Step 15.", "Entered valid credentials in Longitude textbox");
		
		add_New_Property_Details_POM.clickLink("Details");
		test.log(LogStatus.INFO, "Test Step 16.", "Clicked on Details tab");
		add_New_Property_Details_POM.enterStorageRoomTextBox("2");
		test.log(LogStatus.INFO, "Test Step 17.", "Entered valid credentials in Storage Room textbox");

		add_New_Property_Details_POM.selectCheckBoxCentralBangalore();
		test.log(LogStatus.INFO, "Test Step 18.", "Clicked on Central Bangalore Checkbox");
	
		
		add_New_Property_Details_POM.selectCheckBoxFirstFeature();
		test.log(LogStatus.INFO, "Test Step 19.", "Clicked on checkbox beside Feature of Features section");
		add_New_Property_Details_POM.selectCheckBoxFirstRegion();
		test.log(LogStatus.INFO, "Test Step 20.", "Click on checkbox beside Region of Regions section");
		add_New_Property_Details_POM.clickButtonPublish();
		test.log(LogStatus.INFO, "Test Step 21.", "Clicked on Publish button");
		
		
		add_New_Property_Details_POM.clickLogOutLink();
		test.log(LogStatus.INFO, "Test Step 22.", "Clicked on Logout");
		
		add_New_Property_Details_POM.clickLink("Real Estate");
		test.log(LogStatus.INFO, "Test Step 23.", "Clicked on Real Estate icon");
		add_New_Property_Details_POM.enterSearchHereForProperties("New Launch");
		test.log(LogStatus.INFO, "Test Step 24.", "Searched added property");
		add_New_Property_Details_POM.selectSpanForSearchedProperty();
		test.log(LogStatus.INFO, "Test Step 25.", "Selected searched property");
				
		String actualPropertyDetails=add_New_Property_Details_POM.getTextNewLaunchPropertyDetails();
		
		if(expectedPropertyDetails.equals(actualPropertyDetails))
			test.log(LogStatus.PASS, "Test Passed", "Added property details is displayed as: "+actualPropertyDetails);
		else
			test.log(LogStatus.FAIL, "Test Failed", "Added property details is not displayed as: "+expectedPropertyDetails);
		
		screenShot.captureScreenShot("RETC_080_Step25_SearchedPropertyDetails"+actualPropertyDetails);
		
		Assert.assertEquals(expectedPropertyDetails, actualPropertyDetails);
		
		report.endTest(test);
		report.flush();
	}
	
	
		
}


