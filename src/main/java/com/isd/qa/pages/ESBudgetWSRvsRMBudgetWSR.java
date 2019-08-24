package com.isd.qa.pages;

import java.sql.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ESBudgetWSRvsRMBudgetWSR {
	
	WebDriver driver;
//	JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
	
	public ESBudgetWSRvsRMBudgetWSR(WebDriver driver) {
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
	
  @Test(priority=1)
  public void budget_WSR() throws InterruptedException {
	  
//	  test = extent.createTest("BUDWSR");
	  
	  driver.findElement(locatorClass.kpiStrip).getText();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebElement ESBUD= driver.findElement(locatorClass.kpi_Name_Budget);
	  System.out.println(ESBUD.getText());
	  WebElement ESBUDvalue =  driver.findElement(locatorClass.kpi_Value_Budget);
	  String ESValue=ESBUDvalue.getText();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  WebElement ESWSR= driver.findElement(locatorClass.kpi_Name_WSR);
	  System.out.println(ESWSR.getText());
	  WebElement ESWSRvalue = driver.findElement(locatorClass.kpi_Value_WSR);
	  Thread.sleep(3000);
	  String EWSRvl = ESWSRvalue.getText();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(locatorClass.tab_Roadmap).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		WebElement RMBUD= driver.findElement(locatorClass.kpi_Name_Budget);
		
		WebElement RMBUDvalue = driver.findElement(locatorClass.kpi_Value_Budget);

		String RMvalue = RMBUDvalue.getText();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  WebElement RMWSR= driver.findElement(locatorClass.kpi_Name_WSR);

		  WebElement RMWSRValue = driver.findElement(locatorClass.kpi_Value_WSR);
		  
		  String RMWSRvl = RMWSRValue.getText();
		  
		  System.out.println(("**********************************************************************")); 
		  if(ESValue.equals(RMvalue)) {
			  System.out.println("Budgets for ES is "+ESValue+" and RM is "+RMvalue+" are matching : True");
//			  Assert.assertTrue(ESValue.equals(RMvalue), "Matched and passed");
			  softassert.assertTrue(ESValue.equals(RMvalue), "Budgets for ES is "+ESValue+" and RM is "+RMvalue+" are matching : True");
			  
		  }
		  
		  else {
			  
			  System.out.println("Budgets for ES is "+ESValue+" and RM is "+RMvalue+" are not matching : False");
//			  Assert.assertFalse(!(ESValue.equals(RMvalue)), "Data fails to match");
			  softassert.assertFalse(!ESValue.equals(RMvalue), "Budgets for ES is "+ESValue+" and RM is "+RMvalue+" are not matching : False");
			 
		
		  }
		  
		  System.out.println(("**********************************************************************"));
		  
		  if(EWSRvl.equals(RMWSRvl)) {
			  System.out.println("WSR for ES is "+EWSRvl+" and RM is "+RMWSRvl+" are matching : True");
//			  Assert.assertTrue(EWSRvl.equals(RMWSRvl), "Matched and passed");
			  softassert.assertTrue(EWSRvl.equals(RMWSRvl), "WSR for ES is "+EWSRvl+" and RM is "+RMWSRvl+" are matching : True");
		  }
		  
		  
		  else {
			  
			  
			  System.out.println("WSR for ES is "+EWSRvl+" and RM is "+RMWSRvl+" are not matching : False");
//		     Assert.assertFalse(!(EWSRvl.equals(RMWSRvl)), "WSR for ES is "+EWSRvl+" and RM is "+RMWSRvl+" are not matching : False");
			  softassert.assertFalse(!EWSRvl.equals(RMWSRvl), "WSR for ES is "+EWSRvl+" and RM is "+RMWSRvl+" are not matching : False");
			  
	
	  }
		  softassert.assertAll();  
  
  }
  
//  @AfterClass 
  public void Quit() {
	  driver.quit();
  }
  
  
}