package com.training.functional.tests;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ExtentReportGenerator;
import com.training.generics.ScreenShot;

import com.training.pom.LoginPOM;

import com.training.pom.RETC_076_Add_Multiple_Users_POM;
import com.training.pom.RETC_078_Add_Invalid_Users_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_078 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_076_Add_Multiple_Users_POM add_Multiple_Users_POM;
	private RETC_078_Add_Invalid_Users_POM add_Invalid_Users_POM;
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
		add_Multiple_Users_POM = new RETC_076_Add_Multiple_Users_POM(driver);
		add_Invalid_Users_POM= new RETC_078_Add_Invalid_Users_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = ExtentReportGenerator.generateReport();
		test = report.startTest("Test Case name: RETC_078");
		// open the browser
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Pre-Condition 1:", "User launched the application by entering valid URL.");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		test.log(LogStatus.INFO, "Pre-Condition 2:", "Admin logged in.");
		screenShot.captureScreenShot("RETC_078_Pre-Condition2_Admin_Login_Success");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void Functional_Test_RETC_078(String userName,String email,String firstName,String lastName,String webSite,String password,String role) throws Exception {
		String expectedResult="ERROR: The email address isn�t correct.";
		add_Multiple_Users_POM.clickOnUsers();
		test.log(LogStatus.INFO, "Test Step 1.", "Clicked on Users link");

		add_Multiple_Users_POM.clickLinkAddNew();
		test.log(LogStatus.INFO, "Test Step 2.", "Clicked on Add New link");	
		
		add_Multiple_Users_POM.enterUserName(userName);
		test.log(LogStatus.INFO, "Test Step 3.", "Entered Valid credentials in Username textbox: "+userName);
		
		add_Multiple_Users_POM.enterEmail(email);
		test.log(LogStatus.INFO, "Test Step 4.", "Entered Valid credentials in Email textbox: "+email);
		
		add_Multiple_Users_POM.enterFirstName(firstName);
		test.log(LogStatus.INFO, "Test Step 5.", "Entered Valid credentials in First Name textbox: "+firstName);
		
		add_Multiple_Users_POM.enterLastName(lastName);
		test.log(LogStatus.INFO, "Test Step 6.", "Enter Valid credentials in Last Name textbox: "+lastName);
		
		add_Multiple_Users_POM.enterWebsite(webSite);
		test.log(LogStatus.INFO, "Test Step 7.", "Enter Valid credentials in Website textbox: "+webSite);
		
		add_Multiple_Users_POM.clickButtonShowPassword();
		test.log(LogStatus.INFO, "Test Step 8.", "Clicked on Show Password button");
		
		add_Multiple_Users_POM.enterPassword(password);
		test.log(LogStatus.INFO, "Test Step 9.", "Entered Valid credentials in Password textbox");
		
		add_Multiple_Users_POM.selectRoleDropdown(role);
		test.log(LogStatus.INFO, "Test Step 10.", "Clicked on Role list box");
		test.log(LogStatus.INFO, "Test Step 11.", "Selected Valid credentials in Role list box: "+role);
		
		add_Multiple_Users_POM.clickButtonAddNewUser();
		test.log(LogStatus.INFO, "Test Step 12.", "Clicked on Add New User button");
		
		String actualResult=add_Invalid_Users_POM.gettextMessageInvalidUserCreated();
				
		if (actualResult.equalsIgnoreCase(expectedResult)) {
			test.log(LogStatus.PASS, "Test Passed", "Error message is get displayed due to invalid email id:"+email);
		} else {
			test.log(LogStatus.FAIL, "Test Failed", "Error message is not displayed due to invalid email id:"+email);
		}

		screenShot.captureScreenShot("RETC_078_Step12_InvalidEmailUsercreated"+userName);		
		Assert.assertEquals(actualResult, expectedResult);		
		report.endTest(test);
		report.flush();
	}
	
	
		
}


