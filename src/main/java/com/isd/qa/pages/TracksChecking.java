package com.isd.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TracksChecking {
	
	WebDriver driver;

	public  TracksChecking(WebDriver driver) {
		this.driver = driver;
	}
	

	
	@Test(priority=1)
	  public void VPTrackGraphExpandDataTableChecking() throws InterruptedException {

		  
		  System.out.println("VP Track Graph checking");
		  	Thread.sleep(500);
		  	SoftAssert softAssert = new SoftAssert();
		  	
		  	
		  	driver.findElement(By.xpath("//span[text()='Aggregated Pipeline']")).click();
		  	Thread.sleep(500);
		  	
		  	driver.findElement(By.xpath("(//*[@name='icon--maximize'])[4]")).click();
		  	Thread.sleep(500);
		  	
//		  	driver.findElement(By.xpath("//*[@id='sharedTrackDropdown_5']")).click();
//		  	Thread.sleep(500);
//		  	
//		  	driver.findElement(By.xpath("//*[text()='VP TRACK']")).click();
//		  	Thread.sleep(500);
		  	driver.findElement(By.xpath("//*[@class='buttonShowHide']")).click();
		  	Thread.sleep(500);
		  	
		  	String actualTitle = driver.findElement(By.xpath("//h4[text()='VP TRACK']")).getText();
		  	
		  	System.out.println("Graph Title Checking :"+actualTitle);
		  
		  	String ExpectedTitle = "VP TRACK";
		      Assert.assertEquals(actualTitle, ExpectedTitle);
		  	 
		 
	//QP Track Graph checking-----------------------
		  	 System.out.println("QP Track Graph checking");
		  	 driver.findElement(By.xpath("(//*[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper'])[7]")).click();
		     Thread.sleep(500);
		  	 driver.findElement(By.xpath("//*[text()='QP TRACK']")).click();
		  	 Thread.sleep(1000);
		  	 String QPTrackTitle = driver.findElement(By.xpath("//h4[text()='QP TRACK']")).getText();
		  	 System.out.println("Graph Title Checking :"+QPTrackTitle);
		  	 String QPTrackExpectedTitle = "QP TRACK";
		  	 Assert.assertEquals(QPTrackTitle, QPTrackExpectedTitle);
		  	 Thread.sleep(1000);
		  	 
	//CP Track Graph checking-----------------------	 
		     System.out.println("CP Track Graph checking");
		  	 driver.findElement(By.xpath("(//*[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper'])[7]")).click();
		  	 Thread.sleep(500);
		  	 driver.findElement(By.xpath("//*[text()='CP TRACK']")).click();
		  	 Thread.sleep(1000);
		  	 String CPTrackTitle = driver.findElement(By.xpath("//h4[text()='CP TRACK']")).getText();
		  	 System.out.println("Graph Title Checking :"+CPTrackTitle);
		  	 String CPTrackExpectedTitle = "CP TRACK";
		  	 Assert.assertEquals(CPTrackTitle, CPTrackExpectedTitle);
		  	 Thread.sleep(1000);
		  	 
	//WON Track Graph checking----------------------- 
		  	 
		     System.out.println("WONP Track Graph checking");
		  	 driver.findElement(By.xpath("(//*[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper'])[7]")).click();
		  	 Thread.sleep(500);
		  	 driver.findElement(By.xpath("//*[text()='WON TRACK']")).click();
		  	 Thread.sleep(1000);
		  	 String WONTrackTitle = driver.findElement(By.xpath("//h4[text()='WON TRACK']")).getText();
		  	 System.out.println("Graph Title Checking :"+WONTrackTitle);
		  	 String WONTrackExpectedTitle = "WON TRACK";
		  	 Assert.assertEquals(WONTrackTitle , WONTrackExpectedTitle);
		  	 Thread.sleep(1000);
		     System.out.println("WONP Track Graph checking");
		     Thread.sleep(1000);
		     
	//PPA Track Graph checking-----------------------  
		  	 driver.findElement(By.xpath("(//*[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper'])[7]")).click();
		  	 Thread.sleep(500);
		  	 
	//Find element by link text and store in variable "Element"        		
		    WebElement Element = driver.findElement(By.xpath("//*[text()='PPA']"));
		    
		    
	//This will scroll the page till the element is found		
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView();", Element);
		    
		  	 driver.findElement(By.xpath("//*[text()='PPA']")).click();
		  	 Thread.sleep(1000);
		  
		  	 String PPATrackTitle = driver.findElement(By.xpath("//h4[text()='PERFORM Pipeline Assessment']")).getText();
		  	 System.out.println("Graph Title Checking :"+PPATrackTitle);
		  	 String PPATrackExpectedTitle = "PERFORM Pipeline Assessment";
		  	 Assert.assertEquals(PPATrackTitle , PPATrackExpectedTitle);
		  	
		  	
		  	  WebDriverWait wait = new WebDriverWait(driver, 20);
		  	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ppaGraph']")));
		  		if( driver.findElement(By.xpath("//*[@id='ppaGraph']")).isDisplayed()){
		  		System.out.println("Element is Visible");
		  		}else{
		  		System.out.println("Element is InVisible");
		  		}
		  		boolean titleTextfield = driver.findElement(By.xpath("//*[@id='ppaGraph']")).isDisplayed();
		  		
		  	    softAssert.assertTrue(titleTextfield, "Element is notpresent");
		  		Thread.sleep(500);
		  		softAssert.assertTrue(titleTextfield, "Element is notpresent");
		  		driver.findElement(By.xpath("//carbon-icon[@name='icon--minimize']/*[@class='ng-star-inserted']")).click();
		  		
		  		softAssert.assertAll();
		
	  }     
	  
}