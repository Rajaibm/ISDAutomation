package com.isd.qa.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	
public static WebDriver driver = null;
	
@BeforeSuite
 public void initialize() throws IOException{
	 
	System.setProperty("webdriver.chrome.driver", "C:\\selenium softerwares\\selenium softerwares\\chromedriver.exe");
	driver = new ChromeDriver(); 
		
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://skyline.epm-sales-staging.us-south.containers.appdomain.cloud/esa-skyline-ibm-dev/uiappltest/");
	//driver.get("https://skylinestag.epm-sales-staging.us-south.containers.appdomain.cloud/esa-skyline-ibm-dev/epmsales/");
	//driver.get("https://skyline.epm-sales-production.us-south.containers.appdomain.cloud/sales/management-dashboard/");
		  
	}
}
