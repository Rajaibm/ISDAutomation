package com.isd.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Modifyprofile {

	WebDriver driver;

	public Modifyprofile(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='profilePic']")WebElement ProfielPic;
	@FindBy(how = How.XPATH, using = "(//*[@class='bx--overflow-menu'])[4]")WebElement MESgearicon;
	@FindBy(how = How.XPATH, using = "//*[text()=' NEW FILTERS/VIEWS']")WebElement MESNewfilterViews;
	@FindBy(how = How.XPATH, using = "//button[text()='UPDATE']")WebElement MESupdate;
	@FindBy(how = How.XPATH, using = "(//*[@class='bx--overflow-menu'])[2]")WebElement Profiledropdown;
	@FindBy(how = How.XPATH, using = "//*[text()=' NEW PROFILE ']")WebElement ClickOnNewprofile;
	@FindBy(how = How.XPATH, using = "//*[@bindlabel='multiUserRole.bindLabel']")WebElement UserRole;
	@FindBy(how = How.XPATH, using = "//*[text()='Business Units']")WebElement BusinessUnits;
	@FindBy(how = How.XPATH, using = "//*[@class='ng-clear-wrapper ng-star-inserted']")WebElement promptclear;
	@FindBy(how = How.XPATH, using = "//*[text()='BU-level10']/..//*[@bindlabel='select.bindLabel']")WebElement Level10PropmtDropdown;
	@FindBy(how = How.XPATH, using = "//*[@class='bx--checkbox-label']") WebElement listbox;
	@FindBy(how = How.XPATH, using = "//*[text()='GBS']")WebElement GBS;
	@FindBy(how = How.XPATH, using = "//*[text()='Geo']/..//*[@bindlabel='select.bindLabel']")WebElement GeoPropmtDropdown;
	@FindBy(how = How.XPATH, using = "//*[text()='North America']")WebElement NA;
	@FindBy(how = How.XPATH, using = "//button[text()='CREATE PROFILE']")WebElement CreateNewProfile;
	@FindBy(how = How.XPATH, using = "//input[@id='text-input5']")WebElement EnterProfileName;
	@FindBy(how = How.XPATH, using = "(//input[@label='Name'])[1]")WebElement EnterName;
	@FindBy(how = How.XPATH, using = "(//*[@label='Job Title'])[1]")WebElement EnterJobTitle;
	@FindBy(how = How.XPATH, using = "(//*[@label='Phone'])[1]")WebElement EnterPhoneNumber;
	@FindBy(how = How.XPATH, using = "(//*[@label='Email'])[1]")WebElement EnterEmailId;
	@FindBy(how = How.XPATH, using = "(//*[@type='file'])[1]")WebElement  profileimage;
	@FindBy(how = How.XPATH, using = "(//*[text()='Save'])[2]")WebElement Savebutton;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'MODIFY PROFILE')]")WebElement modifyprofile;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'MODIFY PROFILE')]//*[@class='savedProfile']")WebElement savedprofile;
	@FindBy(how = How.XPATH, using = "//button[text()='UPDATE PROFILE']")WebElement updateprofile;
	

	
	@Test
	public void profilepic() {
		Assert.assertTrue(ProfielPic.isDisplayed());

	}
	
	
	@Test
	public void MESGearicon() {
		MESgearicon.click();

	}
	
	@Test
	public void MESnewfilterviews() {
		MESNewfilterViews.click();

	}
	
	@Test
	public void MESupdate() {
		MESupdate.click();

	}
	
	@Test
	public void Profiledropdown() {
		Profiledropdown.click();

	}

	@Test
	public void modifyprofile() {
		Actions  actions  = new Actions(driver);;
	    actions.moveToElement(driver.findElement(By.xpath("//div[contains(text(), 'MODIFY PROFILE')]"))).build().perform();
	    savedprofile.click();

	}
	
	@Test
	public void ClickonupdateProfile() {
		updateprofile.click();

	}

	
	@Test
	public void ClickonSavebutton() {
		Savebutton.click();

	}

	
	
	
	
	
	
}




