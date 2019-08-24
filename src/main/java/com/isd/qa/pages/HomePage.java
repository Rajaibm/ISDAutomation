package com.isd.qa.pages;


import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
import net.bytebuddy.utility.RandomString;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='profilePic']")WebElement ProfielPic;
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
	@FindBy(how = How.XPATH, using = "(//*[text()='Save'])[1]")WebElement Savebutton;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'MODIFY PROFILE')]")WebElement modifyprofile;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'MODIFY PROFILE')]//*[@class='savedProfile']")WebElement savedprofile;
	

	private static String getUniqueKeyname() {
		RandomString tickets = new RandomString(7);
		String num = tickets.nextString();
		System.out.println(num);
	    return tickets.nextString();
	}
	
	private static int getUniqueKeynumber() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 50 + 1;
		int randomInt = (int) randomDouble;
		System.out.println(randomInt);
		return randomInt;
	}
	@Test
	public void profilepic() {
		Assert.assertTrue(ProfielPic.isDisplayed());

	}

	@Test
	public void Profiledropdown() {
		Profiledropdown.click();

	}

	/*@Test
	public void modifyprofile() {
		Actions  actions  = new Actions(driver);;
	    actions.moveToElement(driver.findElement(By.xpath("//div[contains(text(), 'MODIFY PROFILE')]"))).build().perform();
	    savedprofile.click();

	}*/
	@Test
	public void ClckOnNewProfile() {
		ClickOnNewprofile.click();

	}
	
	@Test
	public void ClickOnUserRole() {
		UserRole.click();

	}

	@Test
	public void SelectBusinessUnits() {
		BusinessUnits.click();

	}

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
	public void ClickONCreateNewProfile() {
		CreateNewProfile.click();

	}

	@Test
	public void EnterProfileName() {
	

	   EnterProfileName.sendKeys("MyProfile - " + getUniqueKeyname());
	}
	
	@Test
	public void EnterName() {
		
		
		EnterName.sendKeys("Name - " + getUniqueKeyname());

	}

	@Test
	public void EnterJobTitle() {
		
		EnterJobTitle.sendKeys("jobTitle - " +  getUniqueKeyname());

	}

	@Test
	public void EnterPhoneNumber() {
		EnterPhoneNumber.sendKeys("" + getUniqueKeynumber());

	}

	@Test
	public void EnterEmailId() {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		EnterEmailId.sendKeys("Emaild" + randomInt + "@in.ibm.com");

	}
	
	
	
	@Test
	public void uploadimage() {
		WebElement browse = profileimage;
		browse.sendKeys("C:\\Users\\RajagopalReddy\\Desktop\\ALL files\\addecco\\Certificates\\Raja photo.PNG");

	}
	
	@Test
	public void ClickonSavebutton() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Savebutton);
		

	}

	
	
	
	
	
	
}




