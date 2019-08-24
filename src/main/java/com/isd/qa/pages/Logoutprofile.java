    package com.isd.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

public class Logoutprofile {
	
WebDriver driver;

public Logoutprofile(WebDriver driver) {
		this.driver = driver;
		
		}

	
	@FindBy(how = How.XPATH, using = "(//*[@class='bx--overflow-menu'])[2]")WebElement ProfielPic;
	@FindBy(how = How.XPATH, using = " //*[text()=' LOG OUT ']")WebElement logout;
	@FindBy(how = How.XPATH, using = " //a[contains(text(),'Log Back In')]")WebElement logbackin;
	
	
@Test(description= "logbackin")
public void lOGINbackAndOutchecking() throws InterruptedException {
	Thread.sleep(1000);
	ProfielPic.click();
	Thread.sleep(1000);
	logout.click();
	System.out.println(" checking Log back in ");	    
	Thread.sleep(2000);
     JavascriptExecutor executor = (JavascriptExecutor)driver;
	 executor.executeScript("arguments[0].click();", logbackin);
		    
}	    
	
}
