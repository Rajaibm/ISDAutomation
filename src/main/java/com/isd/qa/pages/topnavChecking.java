package com.isd.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class topnavChecking {

	WebDriver driver;

	public  topnavChecking(WebDriver driver) {
		this.driver = driver;
		
		}
	
	@FindBy(how = How.XPATH, using = "//*[@class='scrollable ng-pristine ng-valid ng-touched']") WebElement topnavlist;
	
	@Test(priority=1)
	public void EStopnavclickchecking() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@class='expand-icon']")).click();
		 
		System.out.println("Executive summary");
		driver.findElement(By.xpath("//span[text()='Executive Summary']")).click();
		SoftAssert softAssert = new SoftAssert();
	   
		System.out.println("--- Executive summary top nav clicking ---");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		List<WebElement> topnav = driver.findElements(By.xpath("//*[@class='ng-select-container ng-has-value']"));
		
		System.out.println("Count = "+ topnav.size());
		for (int i =0; i < topnav.size(); i++) {
		
			topnav.get(i).click();
			WebElement topnavlist = driver.findElement(By.xpath("//*[@class='ng-dropdown-panel-items scroll-host']"));
			System.out.println(topnavlist.getText());
			Thread.sleep(1000);
			  softAssert.assertAll();	
			
	}}



	@Test(priority=2)
	public void APtopnavclickchecking() throws InterruptedException {
		
		System.out.println("Aggregate Pipeline");
		
		driver.findElement(By.xpath("//*[@id='agg']")).click();
		//driver.findElement(By.xpath("//*[@id='caret--up']")).click();
		
		SoftAssert softAssert = new SoftAssert();
		System.out.println("--- Aggregate pipeline top nav clicking ---");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Thread.sleep(1000);
		
		List<WebElement> topnav = driver.findElements(By.xpath("//*[@class='scrollable ng-untouched ng-pristine ng-valid']"));
		System.out.println("Count = "+ topnav.size());
		for (int i =0; i < topnav.size(); i++) {
			topnav .get(i).click();
			WebElement topnavlist = driver.findElement(By.xpath("//*[@class='ng-dropdown-panel-items scroll-host']"));
			System.out.println(topnavlist.getText());
			
			Thread.sleep(1000);
			
			softAssert.assertAll();
			
			
	}}
	 


	@Test(priority=3)
	public void SPtopnavclickchecking() throws InterruptedException {
		
		System.out.println("Segmented Pipeline");
		
		driver.findElement(By.xpath("//*[@id='seg']")).click();
		//driver.findElement(By.xpath("//*[@id='caret--up']")).click();
		SoftAssert softAssert = new SoftAssert();
	    
		System.out.println("--- Executive summary top nav clicking ---");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		List<WebElement> topnav = driver.findElements(By.xpath("//*[@class='scrollable ng-untouched ng-pristine ng-valid']"));
		
		System.out.println("Count = "+ topnav.size());
		for (int i =0; i < topnav.size(); i++) {
			topnav .get(i).click();
			//js.executeScript("arguments[0].click();",topnav.get(i));
			
			WebElement topnavlist = driver.findElement(By.xpath("//*[@class='ng-dropdown-panel-items scroll-host']"));
			System.out.println(topnavlist.getText());
			Thread.sleep(1000);
			 softAssert.assertAll();	
			
			
	}
		
	}
			


	@Test(priority=4)
	public void RMtopnavclickchecking() throws InterruptedException {
		
		System.out.println("RoadMap");
		
		driver.findElement(By.xpath("//*[@id='roadmap']")).click();
		driver.findElement(By.xpath("//*[@id='caret--up']")).click();
		Thread.sleep(500);

		SoftAssert softAssert = new SoftAssert();
	   
		System.out.println("--Roadmap top nav clicking ---");
		JavascriptExecutor js = (JavascriptExecutor)driver;
			
		List<WebElement> topnav = driver.findElements(By.xpath("//*[@class='scrollable ng-untouched ng-pristine ng-valid']"));
		System.out.println("Count = "+ topnav.size());
		for (int i =0; i < topnav.size(); i++) {
			topnav .get(i).click();
			//js.executeScript("arguments[0].click();",topnav.get(i));
			WebElement topnavlist = driver.findElement(By.xpath("//*[@class='ng-dropdown-panel-items scroll-host']"));
			System.out.println(topnavlist.getText());
			Thread.sleep(1000);
			
			  softAssert.assertAll();	
	}
	
	}
}
