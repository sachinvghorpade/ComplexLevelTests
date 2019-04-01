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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_079 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_079_Add_Multiple_New_Features_POM add_Multiple_New_Features_POM;
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
		add_Multiple_New_Features_POM = new RETC_079_Add_Multiple_New_Features_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = ExtentReportGenerator.generateReport();
		test = report.startTest("Test Case name: RETC_079");
		// open the browser
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Pre-Condition 1:", "User launched the application by entering valid URL.");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		test.log(LogStatus.INFO, "Pre-Condition 2:", "Admin logged in.");
		screenShot.captureScreenShot("RETC_079_Pre-Condition2_Admin_Login_Success");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void Functional_Test_RETC_079(String name,String slug,String parentFeature,String description) throws Exception {
				
		add_Multiple_New_Features_POM.clickOnProperties();
		test.log(LogStatus.INFO, "Test Step 1.", "Clicked on Properties link");
		
		add_Multiple_New_Features_POM.clickLinkFeature();
		test.log(LogStatus.INFO, "Test Step 2.", "Clicked on Features link");
		
		add_Multiple_New_Features_POM.enterNameTextBox(name);
		test.log(LogStatus.INFO, "Test Step 3.", "Entered Valid Credentials in Name textbox");
		
		add_Multiple_New_Features_POM.enterSlugTextBox(slug);
		test.log(LogStatus.INFO, "Test Step 4.", "Entered Valid Credentials in Slug textbox");
		
		add_Multiple_New_Features_POM.selectParentFeatureListBox(parentFeature);
		test.log(LogStatus.INFO, "Test Step 5.", "Selected details from Parent Feature list box");
		
		add_Multiple_New_Features_POM.enterDescriptionTextBox(description);
		test.log(LogStatus.INFO, "Test Step 6.", "Entered Valid Credentials in Description textbox");
		
		add_Multiple_New_Features_POM.clickAddNewFeatureButton();
		test.log(LogStatus.INFO, "Test Step 7.", "Clicked on Add New Feature button");
		
		add_Multiple_New_Features_POM.refreshWebPage();
		test.log(LogStatus.INFO, "Refresh Web Page", "After refreshing page, Added new feature is updated in the Feature module");
		
		String expectedFeatureName=name;
		String actualFeatureName=add_Multiple_New_Features_POM.getTextAndVerifyAddedFeatureinTable(name);
		if(expectedFeatureName.equals(actualFeatureName))
			test.log(LogStatus.PASS, "Test Passed", "Added feature("+actualFeatureName+") in existing feature module is displayed");
		else
			test.log(LogStatus.FAIL, "Test Failed", "Added feature("+actualFeatureName+") in existing feature module is displayed");
		
		screenShot.captureScreenShot("RETC_079_Step07_Addedfeature"+actualFeatureName);
		
		Assert.assertEquals(expectedFeatureName, actualFeatureName);
		report.endTest(test);
		report.flush();
	}
	
	
		
}


