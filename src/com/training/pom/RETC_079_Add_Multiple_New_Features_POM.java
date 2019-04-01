package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_079_Add_Multiple_New_Features_POM {
	private WebDriver driver;
	public RETC_079_Add_Multiple_New_Features_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Properties')]") // Locator to locate Properties link
	private WebElement Properties;

	@FindBy(linkText = "Features") // Locator to locate Add new Feature link in Feature section
	private WebElement linkFeature;

	@FindBy(id = "tag-name") // Locator to Locate the Enter Title Text box
	private WebElement enterNameTextBox;

	@FindBy(id = "tag-slug") // Locator to Locate the Enter Slug Text box
	private WebElement enterSlugTextBox;

	@FindBy(id = "parent") // Locator to Locate the Parent Feature list box
	private WebElement selectParentFeatureListBox;

	@FindBy(id = "tag-description")// Locator to Locate the Description Text area
	private WebElement enterDescriptionTextBox;

	@FindBy(id = "submit")//Locator to locate Add New Feature button
	private WebElement btnAddNewFeature;

	@FindBy(xpath = "//table[1]/tbody[1]/tr")//Locator to locate added feature in existing feature module
	private WebElement tableRowAddNewFeature;

	public void clickOnProperties() { // Method for clicking on Properties link
		this.Properties.click();
	}

	public void clickLinkFeature() { // Method for Clicking on Add new Feature link in Feature section
		this.linkFeature.click();
	}

	public void enterNameTextBox(String name) { // Method for Clicking on Add new Feature link in Feature section
		this.enterNameTextBox.sendKeys(name.replaceAll("&nbsp;", ""));
	}

	public void enterSlugTextBox(String slug) { // Method for Clicking on Add new Feature link in Feature section
		this.enterSlugTextBox.sendKeys(slug);
	}

	public void selectParentFeatureListBox(String parentFeature) { // Method for Clicking on Add new Feature link in
																	// Feature section
		Select select_feature = new Select(this.selectParentFeatureListBox);
		select_feature.selectByVisibleText(parentFeature);
	}

	public void enterDescriptionTextBox(String description) { // Method for Clicking on Add new Feature link in Feature
																// section
		this.enterDescriptionTextBox.sendKeys(description);
	}

	public void clickAddNewFeatureButton() //Method to click on Add New Feature button
	{
		this.btnAddNewFeature.click();
	}

	public void refreshWebPage(){//Refresh the web page to see added feature 
		driver.navigate().refresh();
		
	}

	public String getTextAndVerifyAddedFeatureinTable(String name) { // Method to verify added feature in existing feature module
		String featureName=null;
		List<WebElement> tableRowsFeature = driver.findElements(By.xpath("//form[1]/table[1]/tbody[1]/tr/td[1]"));
		for(int i=1;i<tableRowsFeature.size();i++)
		{
			featureName = tableRowsFeature.get(i).getText();	
			featureName=featureName.replaceAll("—", "").trim();
					
			if (featureName.equalsIgnoreCase(name))
			{				
				System.out.println("Newly Added Feature Name := " + featureName);
				break;
			}
				
		
		}
		return featureName;

	}

}
