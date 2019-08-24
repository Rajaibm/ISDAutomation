package com.isd.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class ProfileNA {

	WebDriver driver;

	public ProfileNA(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='profilePic']")WebElement ProfielPic;
	@FindBy(how = How.XPATH, using = "(//*[@class='bx--overflow-menu'])[2]")WebElement Profiledropdown;
	@FindBy(how = How.XPATH, using = "//*[@bindlabel='multiUserRole.bindLabel']")WebElement UserRole;
	@FindBy(how = How.XPATH, using = "//*[@bindlabel='multiUserRole.bindLabel']")WebElement UserRole1;
	@FindBy(how = How.XPATH, using = "//*[text()='Role']/..//*[@bindlabel='select.bindLabel']")WebElement Role;
	@FindBy(how = How.XPATH, using = "//*[text()='BU-level17']")WebElement Level17;
	@FindBy(how = How.XPATH, using = "//*[text()='Role']/..//*[@bindlabel='select.bindLabel']")WebElement Level17Role;
	@FindBy(how = How.XPATH, using = "//*[text()='BU-level10']")WebElement Level10;
	@FindBy(how = How.XPATH, using = "//*[text()='Global Mkt - SVP & GM']")WebElement BusinessUnitsSVPGM;
	@FindBy(how = How.XPATH, using = "//*[text()='Business Units']")WebElement BusinessUnits;
	@FindBy(how = How.XPATH, using = "//*[@class='ng-clear-wrapper ng-star-inserted']")WebElement promptclear;
	@FindBy(how = How.XPATH, using = "(//*[@class='ng-clear-wrapper ng-star-inserted'])[2]")WebElement promptclear1;
	@FindBy(how = How.XPATH, using = "//*[text()='BU-level10']/..//*[@bindlabel='select.bindLabel']")WebElement Level10PropmtDropdown;
	@FindBy(how = How.XPATH, using = "//*[@class='bx--checkbox-label']") WebElement listbox;
	@FindBy(how = How.XPATH, using = "//*[text()='GBS']")WebElement GBS;
	@FindBy(how = How.XPATH, using = "//*[text()='Geo']/..//*[@bindlabel='select.bindLabel']")WebElement GeoPropmtDropdown;
	@FindBy(how = How.XPATH, using = "//*[text()='North America']")WebElement NA;
	@FindBy(how = How.XPATH, using = "//*[text()='GBS BU 2nd Level']/..//*[@bindlabel='select.bindLabel']")WebElement GBS2NDLevelPropmtDropdown;
	@FindBy(how = How.XPATH, using = "//*[text()='GBS Business Unit']/..//*[@bindlabel='select.bindLabel']")WebElement GBSBusinessUnitPropmtDropdown;
	@FindBy(how = How.XPATH, using = "//*[text()='US-COMM']") WebElement USCOMM;
	@FindBy(how = How.XPATH, using = "//*[text()='Energy & Utilities']")WebElement EnergyUtilities;
	@FindBy(how = How.XPATH, using = "(//*[text()='Save'])[2]")WebElement Savebutton;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'MODIFY PROFILE')]")WebElement modifyprofile;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'MODIFY PROFILE')]//*[@class='bx--overflow-menu-options__btn ']")WebElement savedprofile;
	@FindBy(how = How.XPATH, using = "//button[text()='UPDATE PROFILE']")WebElement updateprofile;
	@FindBy(how = How.XPATH, using = "//*[@class='searchValue']")WebElement Nodedropdown;
	@FindBy(how = How.XPATH, using = "//*[@class='scrollable ng-untouched ng-pristine ng-valid']")WebElement topnav;
	@FindBy(how = How.XPATH, using = "//*[@class='ng-dropdown-panel-items scroll-host']")WebElement topnavlistvalue;
	@FindBy(how = How.XPATH, using = "//*[@class='expand-icon']")WebElement expand;
	
	

	
	@Test
	public void profilepic() {
		Assert.assertTrue(ProfielPic.isDisplayed());

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
	public void ClickOnUserRole() {
		UserRole.click();
		

	}

	@Test
	public void SelectBusinessUnitsSVPGM() {
		BusinessUnitsSVPGM.click();
		

	}

	@Test
	public void ClickOnUserRole1() {
		UserRole1.click();
		

	}

	
	@Test
	public void SelectBusinessUnits() {
		BusinessUnits.click();

	}
	
	
	@Test
	public void SelectRole() {
		Role.click();

	}
	
	
	/*@Test
	public void SelectBU() {
		Level10.click();

	}*/
	
	
	
	@Test
	public void promptclear() {
		
	promptclear.click();

	}

	@Test
	public void ClickLevel10PropmtDropdown()  {
		Level10PropmtDropdown.click();
		
	}

	
	
	@Test
	public void SelectGBS() {
		GBS.click();

	}

	
	@Test
	public void ClickGeo0PropmtDropdown()  {
		GeoPropmtDropdown.click();
		
	}
	
	
	@Test
	public void SelectNA() {
		NA.click();

	}
	
	
	@Test
	public void NAGBS2ndLevel() {
		GBS2NDLevelPropmtDropdown.click();

	}
	
	/*@Test
	public void promptclear1() {
		
		promptclear1.click();

	}*/
	
	@Test
	public void GBSBusinessUnitUSIND() {

		USCOMM.click();

	}
	
	@Test
	public void GBSBusinessUnit() {
		
		GBSBusinessUnitPropmtDropdown.click();

	}
	
	@Test
	public void BussinessUnit() {
		
		EnergyUtilities.click();

	}
	
	@Test
	public void nodeprompt() {
		
		Nodedropdown.click();

	}
	
	
	@Test
	public void ClickonupdateProfile() {
		updateprofile.click();

	}

	
	@Test
	public void ClickonSavebutton() {
		Savebutton.click();

	}

	@Test
public void EStopnavclicking() throws InterruptedException {
		
	SoftAssert softAssert = new SoftAssert();
	expand.click();
	List <WebElement> topnav = driver.findElements(By.xpath("//*[@class='scrollable ng-untouched ng-pristine ng-valid']"));
	for(int i =0; i < topnav.size(); i++) {
	topnav .get(i).click();
	System.out.println("topnav");
	Thread.sleep(1000);
	System.out.println( topnavlistvalue.getText());
	softAssert.assertAll();
			}
	}
	
	@Test
public void APtopnavclicking() throws InterruptedException {
	System.out.println("Aggregate pipeline");
	driver.findElement(By.xpath("//*[@id='agg']")).click();
	SoftAssert softAssert = new SoftAssert();
	List <WebElement> topnav = driver.findElements(By.xpath("//*[@class='scrollable ng-untouched ng-pristine ng-valid']"));
	for(int i =0; i < topnav.size(); i++) {
	topnav .get(i).click();
	System.out.println("topnav");
	Thread.sleep(1000);
	System.out.println( topnavlistvalue.getText());
	softAssert.assertAll();
			}

	}

	@Test
public void sptopnavclicking() throws InterruptedException {
		
	System.out.println("Segmented pipeline");
	driver.findElement(By.xpath("//*[@id='seg']")).click();
	SoftAssert softAssert = new SoftAssert();
	List <WebElement> topnav = driver.findElements(By.xpath("//*[@class='scrollable ng-untouched ng-pristine ng-valid']"));
	for(int i =0; i < topnav.size(); i++) {
	topnav .get(i).click();
	System.out.println("topnav");
	Thread.sleep(1000);
	System.out.println( topnavlistvalue.getText());
	softAssert.assertAll();
			}

	}
	
public void RMtopnavclicking() throws InterruptedException {
		System.out.println("Roadmap tab");
		driver.findElement(By.xpath("//*[@id='roadmap']")).click();
		driver.findElement(By.xpath("//*[@id='caret--up']")).click();
		SoftAssert softAssert = new SoftAssert();
		List <WebElement> topnav = driver.findElements(By.xpath("//*[@class='scrollable ng-untouched ng-pristine ng-valid']"));
		for(int i =0; i < topnav.size(); i++) {
		topnav .get(i).click();
		System.out.println("topnav");
		Thread.sleep(1000);
		System.out.println( topnavlistvalue.getText());
		softAssert.assertAll();
				}

		}
	
public void KDtopnavclicking() throws InterruptedException {
		System.out.println("KEY DEALS");
		
		driver.findElement(By.xpath("(//span[text()='KEY DEALS'])[1]")).click();
		driver.findElement(By.xpath("(//*[@style='cursor:pointer'])[2]")).click();
		SoftAssert softAssert = new SoftAssert();
		List <WebElement> topnav = driver.findElements(By.xpath("//*[@class='scrollable ng-untouched ng-pristine ng-valid']"));
		for(int i =0; i < topnav.size(); i++) {
		topnav .get(i).click();
		System.out.println("topnav");
		Thread.sleep(1000);
		System.out.println( topnavlistvalue.getText());
		softAssert.assertAll();
				}

		}
	
public void Milestonetopnavclicking() throws InterruptedException {
	System.out.println("Milestone");
    driver.findElement(By.xpath("(//span[text()='MILESTONE'])[1]")).click();
	driver.findElement(By.xpath("(//*[@style='cursor:pointer'])[2]")).click();
	SoftAssert softAssert = new SoftAssert();
	List <WebElement> topnav = driver.findElements(By.xpath("//*[@class='scrollable ng-untouched ng-pristine ng-valid']"));
	for(int i =0; i < topnav.size(); i++) {
	topnav .get(i).click();
	System.out.println("topnav");
	Thread.sleep(1000);
	System.out.println( topnavlistvalue.getText());
	softAssert.assertAll();
			}

	}
	
	
}



