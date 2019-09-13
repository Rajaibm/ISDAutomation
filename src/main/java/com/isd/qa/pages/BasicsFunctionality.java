package com.isd.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicsFunctionality {
	
	
	
	WebDriver driver;

	public  BasicsFunctionality(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority=1, description = "Checking is executive summarytab Breadcrumbs")
	public void checkingAlltabs() throws InterruptedException {	
		 
		 System.out.println("Executive summary  Breadcrunbs");

		 //driver.findElement(By.xpath("//*[@name='chevron--right']")).click();
		 driver.findElement(By.xpath("//*[@id='exe']")).click();
		 Thread.sleep(500);
		 String BreadcrumbcheckingES = driver.findElement(By.xpath("(//span[text()='Executive Summary'])[2]")).getText();
		 System.out.println("Breadcrumb checking:" +BreadcrumbcheckingES);
		 Assert.assertEquals(BreadcrumbcheckingES, BreadcrumbcheckingES);
		 Thread.sleep(1500);
		 
		 System.out.println("Aggregate pipeline Breadcrunbs");
		 
		 driver.findElement(By.xpath("//*[@id='agg']")).click();
		 Thread.sleep(500);
		 String BreadcrumbcheckingAP = driver.findElement(By.xpath("(//span[text()='Aggregated Pipeline'])[2]")).getText();
		 System.out.println("Breadcrumb checking:" +BreadcrumbcheckingAP);
		 Assert.assertEquals(BreadcrumbcheckingAP, BreadcrumbcheckingAP);
		 Thread.sleep(1500);
		 
		 
	// Segmented pipeline===============================
		 
		 
		 System.out.println("Segmented pipeline Breadcrunbs");
		 
		driver.findElement(By.xpath("//*[@id='seg']")).click();
	    Thread.sleep(500);
	    String BreadcrumbcheckingSP = driver.findElement(By.xpath("(//span[text()='Segmented Pipeline'])[2]")).getText();
		System.out.println("Breadcrumb checking:" +BreadcrumbcheckingSP);
		Assert.assertEquals(BreadcrumbcheckingSP, BreadcrumbcheckingSP);	 
		Thread.sleep(1500);
			 
	//Road map ===============================
		
		System.out.println("Roadmap Breadcrunbs");
			 
		driver.findElement(By.xpath("//*[@id='roadmap']")).click();
		Thread.sleep(500);
		String BreadcrumbcheckingRM = driver.findElement(By.xpath("(//span[text()='Transactional Pipeline > ROADMAP'])[1]")).getText();
		System.out.println("Breadcrumb checking:" +BreadcrumbcheckingRM);
		Assert.assertEquals(BreadcrumbcheckingRM, BreadcrumbcheckingRM);	 
		Thread.sleep(1000);	
		
	//Key deals ===============================
		
	 System.out.println("Keydeals Breadscrunbs");
		 
	  driver.findElement(By.xpath("//*[@id='keydeals']")).click();
	  Thread.sleep(500);
	  String BreadcrumbcheckingKD = driver.findElement(By.xpath("(//span[text()='Transactional Pipeline > KEY DEALS'])[1]")).getText();
	  System.out.println("Breadcrumb checking:" +BreadcrumbcheckingKD);
	  Assert.assertEquals(BreadcrumbcheckingKD, BreadcrumbcheckingKD);	 
	  Thread.sleep(1500);	
	  System.out.println("Key deals Refresh ICon clicking");
	  driver.findElement(By.xpath("//*[@class='refreshIcon']")).click();
	  
	//Mile stone ===============================
	  
	  System.out.println("Milestone Breadscrunbs");
		 
	  driver.findElement(By.xpath("(//span[text()='MILESTONE'])[1]")).click();
	  Thread.sleep(500);
	  String BreadcrumbcheckingMS = driver.findElement(By.xpath("(//span[text()='Transactional Pipeline > MILESTONE'])[1]")).getText();
	  System.out.println("Breadcrumb checking:" +BreadcrumbcheckingMS);
	  Assert.assertEquals(BreadcrumbcheckingMS, BreadcrumbcheckingMS);	 
	  Thread.sleep(1500);		
	  System.out.println("Key deals Refresh ICon clicking");
	  driver.findElement(By.xpath("//*[@class='refreshIcon']")).click();
	  WebDriverWait wait1 = new WebDriverWait(driver, 5000);
	  wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='caret--up']")));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='caret--up']")).click();
	  driver.findElement(By.xpath("//*[@id='caret--up']")).click();
		 
	  
	 }
	 

}
