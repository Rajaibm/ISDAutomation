package com.isd.qa.pages;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



//import junit.framework.Assert;

public class ComparisiondataWSR {
	
	
	
	WebDriver driver;
//	JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
	
	public ComparisiondataWSR(WebDriver driver) {
		this.driver = driver;
		
	}
	
	locatorClass locatorClass = new locatorClass(driver);
	SoftAssert softassert = new SoftAssert();
	
//	@AfterTest
	public void loganalisys() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
        	System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
            
            //do something useful with the data
	}
        
  @Test
  public void es_WSR() throws InterruptedException {
	  
//	  test = extent.createTest("WSRES");
//	  System.out.println(driver.manage().logs().getAvailableLogTypes());
	  System.out.println("Comparision of WSR in ES deals vs Keydeals List WSR");
	  
	  Thread.sleep(1000);
	  WebElement WSRdata = driver.findElement(locatorClass.block_WSR_KPI);
	  System.out.println(WSRdata.getText());
	  WSRdata.click();
	  Thread.sleep(2000);
	 
	  System.out.println("To check WSRDeals LiCountvalue");
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  List<WebElement> WSRLivalue= driver.findElements(locatorClass.kpi_LiVal);
	  String WSRdealsvalue[] = new String[WSRLivalue.size()];
	  System.out.println("XXXXXXXXXXXXXXXXXXXXXSummary LI valueXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ");
	  for(int i=0; i<WSRLivalue.size();i++) {
		  WSRdealsvalue[i]= WSRLivalue.get(i).getText();
		  System.out.println(WSRLivalue.get(i).getText());
		  Reporter.getCurrentTestResult();
		  Reporter.getOutput();
		  Reporter.log(WSRLivalue.get(i).getText());
		  
	  }
	  System.out.println("XXXXXXXXXXXXXXXXXXXSummary LI valueXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	  
	 
	  List<WebElement> WSRdeals = driver.findElements(locatorClass.kpi_Deals);
	  System.out.println(driver.findElements(locatorClass.kpi_Deals).size());
		for(int i=1; i<WSRdeals.size(); i++) {
			System.out.println(WSRdeals.get(i).getText());
			Reporter.getCurrentTestResult();
			  Reporter.getOutput();
			  Reporter.log(WSRdeals.get(i).getText());
		}
		
		Thread.sleep(5000);
		@SuppressWarnings("unused")
		
		List<WebElement> lis = driver.findElements(locatorClass.kpi_LiCol);
//		System.out.println(driver.findElement(By.cssSelector("#skylineDealListTable .datatable-row-wrapper div.col-md-2:nth-of-type(2)")).getText());
		String ValueLI[] = new String[lis.size()];

		for(int i=0; i<lis.size(); i++) {
			ValueLI[i]=lis.get(i).getText();
			System.out.println(lis.get(i).getText());
			Reporter.getCurrentTestResult();
			  Reporter.getOutput();
			  Reporter.log(lis.get(i).getText());
		}
		
		Thread.sleep(1000);
		driver.findElement(locatorClass.kpi_ShowAllDeals).click();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		System.out.println("**************  Data fetching from Keydeals ***********");
		List<WebElement> KDlis = driver.findElements(locatorClass.allDeals_LiCol);

		for(int i=0; i<KDlis.size(); i++) {
			System.out.println("*************************");
			System.out.println(KDlis.get(i).getText());
			Reporter.getCurrentTestResult();
			  Reporter.getOutput();
			  Reporter.log(KDlis.get(i).getText());
			
			if(KDlis.get(i).getText().trim().equalsIgnoreCase(ValueLI[i].trim())) {
				softassert.assertEquals(KDlis.get(i).getText().trim(),ValueLI[i].trim());
				System.out.println("Keydeals "+ KDlis.get(i).getText().trim()+"::      True(Data is matching)      :: Executive summary "+ ValueLI[i].trim());
				System.out.println(Reporter.getCurrentTestResult());
				  Reporter.getOutput();
				  Reporter.log(KDlis.get(i).getText());
				  

			}
			

			else
				softassert.assertFalse(!KDlis.get(i).getText().trim().equalsIgnoreCase(ValueLI[i].trim()), KDlis.get(i).getText().trim()+"::    False(data is not matching)     ::"+ValueLI[i].trim());
				System.out.println(KDlis.get(i).getText().trim()+"::    False(data is not matching)     ::"+ValueLI[i].trim());
				
			
//			
		}
		
		softassert.assertAll();

		
  
  } 
		

		
		
}

