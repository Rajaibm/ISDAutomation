package com.isd.qa.pages;


import static org.testng.Assert.assertTrue;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class KPISummaryDetail  {
	
	  WebDriver driver;
	  
	  SoftAssert softassert = new SoftAssert();
	 
	  
	  By tableelements = By.cssSelector("div.datatable-header-inner");
	  
		public KPISummaryDetail(WebDriver driver) {
			this.driver = driver;
			
		}
	 
		locatorClass locatorClass = new locatorClass(driver);
		
  
	
  @Test(priority=1) 
  
  public void es_VPdata() throws InterruptedException {
	  
	  
	  WebDriverWait wait = new WebDriverWait(driver, 1000);
	  Actions actions = new Actions(driver);
	  System.out.println("Comparision of VP in ES KPI vs Deallist LIcount Value");
	  driver.findElement(By.xpath("//*[@id='exe']")).click();
	  driver.findElement(locatorClass.kpiStrip).getText();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebElement VPdata = driver.findElement(locatorClass.kpi_Name_VP);
	  WebElement Vpvalue = driver.findElement(locatorClass.kpi_Value_VP);
	  WebElement VPKPI = driver.findElement(locatorClass.VPKPI);
	  VPKPI.click();
	  String VP$Value=Vpvalue.getText().replaceAll("[^0-9.]", "");
	  System.out.println(VP$Value);
	  Thread.sleep(500);
	 
	  
	  Thread.sleep(2000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  
	  driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	  WebElement Vpdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String Vp$summaryLI = Vpdealsummary.getText().replaceAll("[^0-9.]", "");
	  System.out.println(Vp$summaryLI);
	  
	  
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(VP$Value)-Double.parseDouble(Vp$summaryLI));
	  	
	 Thread.sleep(1000);
	  if(dif<=1) {
	    	 System.out.println("ESVP summary ("+VP$Value+") vs deals LI values ("+Vp$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "ESVP summary ("+VP$Value+") vs deals LI values ("+Vp$summaryLI+") are partially matched(True) : Diff Val  " + dif );
	    	 softassert.assertTrue(dif<=1, "ESVP summary ("+VP$Value+") vs deals LI values ("+Vp$summaryLI+") are partially matched(True) : Diff Val  " + dif);
	    	 
	    	 Thread.sleep(1000);
	    	 

	     }
	     
	  else {
	    	 System.out.println("ESVP summary  ("+VP$Value+") vs deals LI values ("+Vp$summaryLI+") are not matched(False): Diff Val  "   +  dif );
//	    	 Assert.assertFalse(dif>1, "ESVP summary  ("+VP$Value+") vs deals LI values ("+Vp$summaryLI+") are not matching(False): Diff Val  "   +  dif);
	    	 softassert.assertFalse(dif>1, "ESVP summary  ("+VP$Value+") vs deals LI values ("+Vp$summaryLI+") are not matching(False): Diff Val  "   +  dif);
	    	 
	    	 Thread.sleep(1000);
	  	   
	     }

	  System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"  + df.format(diff) );
	    	 
	    	 
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
	     
	     softassert.assertAll();
  }
  
  

  @Test(priority=2)
public void es_WSR() throws InterruptedException {
//	  test = extent.createTest("ESWSR");
	 
	  WebDriverWait wait = new WebDriverWait(driver, 1000);
	  Actions actions = new Actions(driver);
	  System.out.println("***********************************************************************************");
	  System.out.println("Comparision of WSR in ES KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(2000);
	  WebElement WSRdata = driver.findElement(locatorClass.kpi_Name_WSR);
	  WebElement WSRvalue = driver.findElement(locatorClass.kpi_Value_WSR);
	  WebElement WSRKPI = driver.findElement(locatorClass.WSRKPI);
	  WSRKPI.click();
	  String WSR$Value=WSRvalue.getText().replaceAll("[^0-9.]", "");
	 
	  Thread.sleep(1000);
	  
	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	 
	  
	  WebElement WSRdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String WSR$summaryLI = WSRdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	 
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(WSR$Value)-Double.parseDouble(WSR$summaryLI));
	  
	 	 
	  if(dif<=1) {
	    	 System.out.println("ESWSR summary ("+WSR$Value+") vs deals LI values ("+WSR$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "ESWSR summary ("+WSR$Value+") vs deals LI values ("+WSR$summaryLI+") are partially matched(True) : Diff Val  " + dif);
	    	 softassert.assertTrue(dif<=1, "ESWSR summary ("+WSR$Value+") vs deals LI values ("+WSR$summaryLI+") are partially matched(True) : Diff Val  " + dif);
	    	
	     }
	     
	  else {
	    	 System.out.println("ESWSR summary  ("+WSR$Value+") vs deals LI values ("+WSR$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "ESWSR summary  ("+WSR$Value+") vs deals LI values ("+WSR$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertTrue(dif>1, "ESWSR summary  ("+WSR$Value+") vs deals LI values ("+WSR$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	
	     }
	 
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff) );
	    	 
	     }
	     
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
	     softassert.assertAll();
  }
  
@Test(priority=3)
public void es_Won() throws InterruptedException {
//	test = extent.createTest("ESWon");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("***********************************************************************************");
	  System.out.println("Comparision of WON in ES KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(1000);
	  WebElement WONdata = driver.findElement(locatorClass.kpi_Name_WON);
	  WebElement WONvalue = driver.findElement(locatorClass.kpi_Value_WON);
	  WebElement WONKPI = driver.findElement(locatorClass.WONKPI);
	  WONKPI.click();
	  String WON$Value=WONvalue.getText().replaceAll("[^0-9.]", "");
	  Thread.sleep(1000);
	 
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  WebElement WONdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String WON$summaryLI = WONdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	  
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(WON$Value)-Double.parseDouble(WON$summaryLI));
	
	 	  
	  if(dif<=1) {
	    	 System.out.println("ESWON summary ("+WON$Value+") vs deals LI values ("+WON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "ESWON summary ("+WON$Value+") vs deals LI values ("+WON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "ESWON summary ("+WON$Value+") vs deals LI values ("+WON$summaryLI+") are partially matched(True) : Diff Val  " + dif );
	    	 
	     }
	     
	  else {
	    	 System.out.println("ESWON summary  ("+WON$Value+") vs deals LI values ("+WON$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "ESWON summary  ("+WON$Value+") vs deals LI values ("+WON$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertTrue(dif>1, "ESWON summary  ("+WON$Value+") vs deals LI values ("+WON$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 
	     }
	 
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  "  + df.format(diff) );
	    	 
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
	    	 
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
	     
	     softassert.assertAll();
}

@Test(priority=4)
public void agg_VP() throws InterruptedException {
//	test = extent.createTest("AggVP");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("..........................................................................................................................");
	System.out.println("XXXXXXXXXXXXXXXXXXX                    Aggregated tab details          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	System.out.println("..........................................................................................................................");
	driver.findElement(By.xpath("//*[@id='agg']")).click();
	Thread.sleep(1000);
	System.out.println("Comparision of VP in AGG KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(1000);
	  WebElement AggVPdata = driver.findElement(locatorClass.kpi_Name_VP);
	  WebElement AggVPvalue = driver.findElement(locatorClass.kpi_Value_VP);
	  WebElement VPKPI = driver.findElement(locatorClass.VPKPI);
	  String AggVP$Value=AggVPvalue.getText().replaceAll("[^0-9.]", "");
	  Thread.sleep(1000);
	  VPKPI.click();
	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  WebElement AggVPdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String AggVP$summaryLI = AggVPdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	  
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(AggVP$Value)-Double.parseDouble(AggVP$summaryLI));
	 
	 
	  if(dif<=1) {
	    	 System.out.println("Aggregated VP summary ("+AggVP$Value+") vs deals LI values ("+AggVP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "Aggregated VP summary ("+AggVP$Value+") vs deals LI values ("+AggVP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "Aggregated VP summary ("+AggVP$Value+") vs deals LI values ("+AggVP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	
	     }
	  
	     
	  else {
	    	 System.out.println("Aggregated VP summary  ("+AggVP$Value+") vs deals LI values ("+AggVP$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "Aggregated VP summary  ("+AggVP$Value+") vs deals LI values ("+AggVP$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertFalse(dif>1, "Aggregated VP summary  ("+AggVP$Value+") vs deals LI values ("+AggVP$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 
	     }
	 
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertTrue(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff) );
	    	
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
	     
	     softassert.assertAll();
}


@Test(priority=5)
public void agg_QP() throws InterruptedException {
	
//	test = extent.createTest("AggQP");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("***********************************************************************************");
	System.out.println("Comparision of QP in AGG KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebElement AggQPdata = driver.findElement(locatorClass.kpi_Name_QP);
	  WebElement AggQPvalue = driver.findElement(locatorClass.kpi_Value_QP);
	  WebElement QPKPI = driver.findElement(locatorClass.QPKPI);
	  String AggQP$Value=AggQPvalue.getText().replaceAll("[^0-9.]", "");
	  
	  Thread.sleep(1000);
	  QPKPI.click();
	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  WebElement AggQPdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String AggQP$summaryLI = AggQPdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	  
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(AggQP$Value)-Double.parseDouble(AggQP$summaryLI));
	 
	 
	  if(dif<=1) {
	    	 System.out.println("Aggregated QP summary ("+AggQP$Value+") vs deals LI values ("+AggQP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "Aggregated QP summary ("+AggQP$Value+") vs deals LI values ("+AggQP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "Aggregated QP summary ("+AggQP$Value+") vs deals LI values ("+AggQP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 
	     }
	     
	  else {
	    	 System.out.println("Aggregated QP summary  ("+AggQP$Value+") vs deals LI values ("+AggQP$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "Aggregated QP summary  ("+AggQP$Value+") vs deals LI values ("+AggQP$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertFalse(dif>1, "Aggregated QP summary  ("+AggQP$Value+") vs deals LI values ("+AggQP$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 
	     }
	 
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 
	    	 
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertTrue(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
	    	
	     
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
	     
	     softassert.assertAll();

}

@Test(priority=6)
public void agg_WON() throws InterruptedException {
	
//	test = extent.createTest("AggWON");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("***********************************************************************************");
	  System.out.println("Comparision of WON in Agg KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebElement AggWONdata = driver.findElement(locatorClass.kpi_Name_WON);
	  WebElement AggWONvalue = driver.findElement(locatorClass.kpi_Value_WON);
	  WebElement WONKPI = driver.findElement(locatorClass.WONKPI);
	  String AggWON$Value=AggWONvalue.getText().replaceAll("[^0-9.]", "");
	  Thread.sleep(1000);
	  WONKPI.click(); 
	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  WebElement AggWONdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String AggWON$summaryLI = AggWONdealsummary.getText().replaceAll("[^0-9.]", "");

	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(AggWON$Value)-Double.parseDouble(AggWON$summaryLI));
	  

	  if(dif<=1) {
	    	 System.out.println("Aggregated WON summary ("+AggWON$Value+") vs deals LI values ("+AggWON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "Aggregated WON summary ("+AggWON$Value+") vs deals LI values ("+AggWON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "Aggregated WON summary ("+AggWON$Value+") vs deals LI values ("+AggWON$summaryLI+") are partially matched(True) : Diff Val  " + dif );
	    	 
	     }
	     
	  else {
	    	 System.out.println("Aggregated WON summary  ("+AggWON$Value+") vs deals LI values ("+AggWON$summaryLI+") are not matched(False): Diff Val  "   + dif );
//	    	 Assert.assertFalse(dif>1, "Aggregated WON summary  ("+AggWON$Value+") vs deals LI values ("+AggWON$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertTrue(dif>1, "Aggregated WON summary  ("+AggWON$Value+") vs deals LI values ("+AggWON$summaryLI+") are not matching(False): Diff Val  "   + dif );
	    	 
	     }
	  
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 
	    	 
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertTrue(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff) );
	    	 
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
	     softassert.assertAll();
	     
}


@Test(priority=7)
public void segmented_VP() throws InterruptedException {
	
//	test = extent.createTest("SegmentedVP");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("..........................................................................................................................");
	System.out.println("XXXXXXXXXXXXXXXXXXX                    Segmented tab details          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	System.out.println("..........................................................................................................................");
	driver.findElement(locatorClass.tab_SegPipe).click();
	System.out.println("Comparision of VP in Segmented KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(1000);
	  WebElement SegVPdata = driver.findElement(locatorClass.kpi_Name_VP);
	  WebElement SegVPvalue = driver.findElement(locatorClass.kpi_Value_VP);
	  WebElement VPKPI = driver.findElement(locatorClass.VPKPI);
	  
	  String SegVP$Value=SegVPvalue.getText().replaceAll("[^0-9.]", "");
	  Thread.sleep(1000);
	  VPKPI.click();
	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  WebElement SegVPdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String SegVP$summaryLI = SegVPdealsummary.getText().replaceAll("[^0-9.]", "");

	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(SegVP$Value)-Double.parseDouble(SegVP$summaryLI));
	  

	 
	  if(dif<=1) {
	    	 System.out.println("Segmented VP summary ("+SegVP$Value+") vs deals LI values ("+SegVP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "Segmented VP summary ("+SegVP$Value+") vs deals LI values ("+SegVP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "Segmented VP summary ("+SegVP$Value+") vs deals LI values ("+SegVP$summaryLI+") are partially matched(True) : Diff Val  " + dif );
	    	 
	     }
	     
	  else {
	    	 System.out.println("Segmented VP summary  ("+SegVP$Value+") vs deals LI values ("+SegVP$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "Segmented VP summary  ("+SegVP$Value+") vs deals LI values ("+SegVP$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertFalse(dif>1, "Segmented VP summary  ("+SegVP$Value+") vs deals LI values ("+SegVP$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 
	     }
	  
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
	  
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff) );
	    	 softassert.assertAll();
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
	 
	
}

@Test(priority=8)
public void segmented_QP() throws InterruptedException {
	
//	test = extent.createTest("SegmentedQP");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("***********************************************************************************");
	System.out.println("Comparision of QP in Segmented KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(1000);
	  WebElement SegQPdata = driver.findElement(locatorClass.kpi_Name_QP);
	  WebElement SegQPvalue = driver.findElement(locatorClass.kpi_Value_QP);
	  WebElement QPKPI = driver.findElement(locatorClass.QPKPI);
	  String SegQP$Value=SegQPvalue.getText().replaceAll("[^0-9.]", "");
	  
	  
	  QPKPI.click();

	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  
	  WebElement SegQPdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String SegQP$summaryLI = SegQPdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	  
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(SegQP$Value)-Double.parseDouble(SegQP$summaryLI));
	  
	 
	  if(dif<=1) {
	    	 System.out.println("Segmented QP summary ("+SegQP$Value+") vs deals LI values ("+SegQP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "Segmented QP summary ("+SegQP$Value+") vs deals LI values ("+SegQP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "Segmented QP summary ("+SegQP$Value+") vs deals LI values ("+SegQP$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertAll();
	     }
	     
	  else {
	    	 System.out.println("Segmented QP summary  ("+SegQP$Value+") vs deals LI values ("+SegQP$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "Segmented QP summary  ("+SegQP$Value+") vs deals LI values ("+SegQP$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertFalse(dif>1, "Segmented QP summary  ("+SegQP$Value+") vs deals LI values ("+SegQP$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertAll();
	     }
	 
	    
	     
	     System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
		  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
			System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
			
			Double AllLineItemssum=0.0;
			for(int i=0; i<Deallistlis.size(); i++) {
				
				System.out.println(Deallistlis.get(i).getText());
				System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
				AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
	}
			System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
			System.out.println("*******SummaryLI********");
			
			java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
			Double Summarysum=0.0;

			for(int i=0; i<SummaryLIcount.size(); i++) {
				
				System.out.println(SummaryLIcount.get(i).getText());
				
				System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
				Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
		
				
	}
			System.out.println("SummaryLineItemsSum:::"+Summarysum);	
			
			Double diff=Math.abs(AllLineItemssum-Summarysum);
			
			
			 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
			 actions.moveToElement(xclick).build().perform();
			 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
			
			 DecimalFormat df = new DecimalFormat("###.#######");
		     System.out.println("Diff Val  : "+df.format(diff));

		    System.out.println("*************************************************************"); 
		     if(diff<1) {
		    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//		    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
		    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
		    	 softassert.assertAll();
		     }
		     
		     else {
		    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//		    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
		    	 softassert.assertTrue(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
		    	 softassert.assertAll();
		     }
		     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");

	     
	     
}
@Test(priority=9)
public void segmented_WON() throws InterruptedException {
	
//	test = extent.createTest("SegmentedWON");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("***********************************************************************************");
	  System.out.println("Comparision of WON in Segmented KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(1000);
	  WebElement SegWONdata = driver.findElement(locatorClass.kpi_Name_WON);
	  WebElement SegWONvalue = driver.findElement(locatorClass.kpi_Value_WON);
	  WebElement  WONKPI = driver.findElement(locatorClass. WONKPI);
	  WONKPI.click();
	  
	  String SegWON$Value=SegWONvalue.getText().replaceAll("[^0-9.]", "");
	  
	  
	 

	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  WebElement SegWONdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String SegWON$summaryLI = SegWONdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	  
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(SegWON$Value)-Double.parseDouble(SegWON$summaryLI));
	  
	  Thread.sleep(1000);
	 
	 
	  if(dif<=1) {
	    	 System.out.println("Segmented WON summary ("+SegWON$Value+") vs deals LI values ("+SegWON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "Segmented WON summary ("+SegWON$Value+") vs deals LI values ("+SegWON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "Segmented WON summary ("+SegWON$Value+") vs deals LI values ("+SegWON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertAll();
	     }
	     
	  else {
	    	 System.out.println("Segmented WON summary  ("+SegWON$Value+") vs deals LI values ("+SegWON$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "Segmented WON summary  ("+SegWON$Value+") vs deals LI values ("+SegWON$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertTrue(dif>1, "Segmented WON summary  ("+SegWON$Value+") vs deals LI values ("+SegWON$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertAll();
	     }
	 
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 softassert.assertAll();
	    	 
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertTrue(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff) );
	    	 softassert.assertAll();
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
}


@Test(priority=10)
public void roadMap_WSR() throws InterruptedException {
	
//	test = extent.createTest("ROADMAPWSR");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("..........................................................................................................................");
	System.out.println("XXXXXXXXXXXXXXXXXXX                    Roadmap tab details          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	System.out.println("..........................................................................................................................");
	driver.findElement(locatorClass.tab_Roadmap).click();
	System.out.println("***********************************************************************************");
	  System.out.println("Comparision of WSR in ROADMAP KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(2000);
	  WebElement RodmapWSRdata = driver.findElement(locatorClass.kpi_Name_WSR);
	  WebElement RodmapWSRvalue = driver.findElement(locatorClass.kpi_Value_WSR);
	  String RodmapWSR$Value=RodmapWSRvalue.getText().replaceAll("[^0-9.]", "");
	  
	  RodmapWSRdata.click();

	  Thread.sleep(1000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  WebElement RodmapWSRdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String RodmapWSR$summaryLI = RodmapWSRdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	  
	  
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(RodmapWSR$Value)-Double.parseDouble(RodmapWSR$summaryLI));
	  
	 
	 
	  if(dif<=1) {
	    	 System.out.println("RoadmapWSR summary ("+RodmapWSR$Value+") vs deals LI values ("+RodmapWSR$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "RoadmapWSR summary ("+RodmapWSR$Value+") vs deals LI values ("+RodmapWSR$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "RoadmapWSR summary ("+RodmapWSR$Value+") vs deals LI values ("+RodmapWSR$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertAll();
	     }
	     
	  else {
	    	 System.out.println("RoadmapWSR summary  ("+RodmapWSR$Value+") vs deals LI values ("+RodmapWSR$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "RoadmapWSR summary  ("+RodmapWSR$Value+") vs deals LI values ("+RodmapWSR$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertFalse(dif>1, "RoadmapWSR summary  ("+RodmapWSR$Value+") vs deals LI values ("+RodmapWSR$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertAll();
	     }
	 
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************/n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 softassert.assertAll();
	    	 
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
	    	 softassert.assertAll();
	     
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");


}
@Test(priority=11)
public void roadMap_WON() throws InterruptedException {
	
//	test = extent.createTest("RoadmapWON");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("***********************************************************************************");
	
	  System.out.println("Comparision of WON in ROADMAP KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(1000);
	  WebElement RodmapWONdata = driver.findElement(locatorClass.kpi_Name_WON);
	  WebElement RodmapWONvalue = driver.findElement(locatorClass.kpi_Value_WON);
	  String RodmapWON$Value=RodmapWONvalue.getText().replaceAll("[^0-9.]", "");
	  Thread.sleep(1000);
	  RodmapWONdata.click();
 
	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  WebElement RodmapWONdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String RodmapWON$summaryLI = RodmapWONdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	  
	 
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(RodmapWON$Value)-Double.parseDouble(RodmapWON$summaryLI));
	  Thread.sleep(1000);
	  
	 
	 
	  if(dif<=1) {
	    	 System.out.println("RodmapWON summary ("+RodmapWON$Value+") vs deals LI values ("+RodmapWON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "RodmapWON summary ("+RodmapWON$Value+") vs deals LI values ("+RodmapWON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "RodmapWON summary ("+RodmapWON$Value+") vs deals LI values ("+RodmapWON$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertAll();
	     }
	     
	  else {
	    	 System.out.println("RodmapWON summary  ("+RodmapWON$Value+") vs deals LI values ("+RodmapWON$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "RodmapWON summary  ("+RodmapWON$Value+") vs deals LI values ("+RodmapWON$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertFalse(dif>1, "RodmapWON summary  ("+RodmapWON$Value+") vs deals LI values ("+RodmapWON$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertAll();
	     }
	 
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************/n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 softassert.assertAll();
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff) );
	    	 softassert.assertAll();
	     
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
}

@Test(priority=12)
public void roadMap_SolidAtRisk() throws InterruptedException {
	
//	test = extent.createTest("RoadmapSolidAtRisk");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	System.out.println("***********************************************************************************");
	
	  System.out.println("Comparision of SolidAtRisk in ROADMAP KPI vs Deallist LIcount Value");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(1000);
	  WebElement RodmapSoAtRdata = driver.findElement(locatorClass.kpi_Name_SolAR);
	  WebElement RodmapSoAtRvalue = driver.findElement(locatorClass.kpi_Value_SolAR);
	  String RodmapSoAtR$Value=RodmapSoAtRvalue.getText().replaceAll("[^0-9.]", "");
	  
	  Thread.sleep(1000);
	  RodmapSoAtRdata.click();
	 
	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  
	  WebElement RodmapSoAtRdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String RodmapSoAtR$summaryLI = RodmapSoAtRdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	  
	 
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(RodmapSoAtR$Value)-Double.parseDouble(RodmapSoAtR$summaryLI));
	  
	  Thread.sleep(1000);
	 
	 
	  if(dif<=1) {
	    	 System.out.println("RodmapSolidAtRisk summary ("+RodmapSoAtR$Value+") vs deals LI values ("+RodmapSoAtR$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "RodmapSolidAtRisk summary ("+RodmapSoAtR$Value+") vs deals LI values ("+RodmapSoAtR$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertTrue(dif<=1, "RodmapSolidAtRisk summary ("+RodmapSoAtR$Value+") vs deals LI values ("+RodmapSoAtR$summaryLI+") are partially matched(True) : Diff Val  " +dif);
	    	 softassert.assertAll();
	     }
	     
	  else {
	    	 System.out.println("RodmapSolidAtRisk summary  ("+RodmapSoAtR$Value+") vs deals LI values ("+RodmapSoAtR$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "RodmapSolidAtRisk summary  ("+RodmapSoAtR$Value+") vs deals LI values ("+RodmapSoAtR$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertFalse(dif>1, "RodmapSolidAtRisk summary  ("+RodmapSoAtR$Value+") vs deals LI values ("+RodmapSoAtR$summaryLI+") are not matching(False): Diff Val  "   +dif);
	    	 softassert.assertAll();
	     }
	 
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************\n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 softassert.assertAll();
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff) );
	    	 softassert.assertAll();
	     
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
	  
}

@Test(priority=13)
public void roadMap_WsrKeyStretch() throws InterruptedException {
	
//	test = extent.createTest("RoadmapWsrKeyStretch");
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	Actions actions = new Actions(driver);
	  System.out.println("Comparision of WsrKeyStretch in ROADMAP KPI vs Deallist LIcount Value");
	  System.out.println("***********************************************************************************");
	  driver.findElement(locatorClass.kpiStrip).getText();
	  Thread.sleep(2000);
	  WebElement RodmapWSRKStdata = driver.findElement(locatorClass.kpi_Name_WsrKS);
	  WebElement RodmapWSRKStvalue = driver.findElement(locatorClass.kpi_Value_WsrKS);
	  String RodmapWSRKSt$Value=RodmapWSRKStvalue.getText().replaceAll("[^0-9.]", "");
	  
	  Thread.sleep(1000);
	  RodmapWSRKStdata.click();

	  Thread.sleep(3000);
	  WebElement datatable = driver.findElement(locatorClass.kpi_to_DealList);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorClass.kpi_to_DealList));
	  
	  WebElement RodmapWSRKStdealsummary = driver.findElement(locatorClass.kpi_DL_Header);
	  String RodmapWSRKSt$summaryLI = RodmapWSRKStdealsummary.getText().replaceAll("[^0-9.]", "");
	  
	  
	  
	  Double dif=0.0;
	  dif=Math.abs(Double.parseDouble(RodmapWSRKSt$Value)-Double.parseDouble(RodmapWSRKSt$summaryLI));
	  
	 
	  if(dif<=1) {
	    	 System.out.println("RodmapSolidAtRisk summary ("+RodmapWSRKSt$Value+") vs deals LI values ("+RodmapWSRKSt$summaryLI+") are partially matched(True) : Diff Val  " +dif);
//	    	 Assert.assertTrue(dif<=1, "RodmapSolidAtRisk summary ("+RodmapWSRKSt$Value+") vs deals LI values ("+RodmapWSRKSt$summaryLI+") are partially matched(True) : Diff Val  " +dif );
	    	 softassert.assertTrue(dif<=1, "RodmapSolidAtRisk summary ("+RodmapWSRKSt$Value+") vs deals LI values ("+RodmapWSRKSt$summaryLI+") are partially matched(True) : Diff Val  " +dif );
	    	 softassert.assertAll();
	     }
	     
	  else {
	    	 System.out.println("RodmapSolidAtRisk summary  ("+RodmapWSRKSt$Value+") vs deals LI values ("+RodmapWSRKSt$summaryLI+") are not matched(False): Diff Val  "   +dif);
//	    	 Assert.assertFalse(dif>1, "RodmapSolidAtRisk summary ("+RodmapWSRKSt$Value+") vs deals LI values ("+RodmapWSRKSt$summaryLI+") are NOT Matching(True) : Diff Val  " +dif );
	    	 softassert.assertFalse(dif>1, "RodmapSolidAtRisk summary ("+RodmapWSRKSt$Value+") vs deals LI values ("+RodmapWSRKSt$summaryLI+") are NOT Matching(True) : Diff Val  " +dif );
	    	 softassert.assertAll();
	     }
	  System.out.println("*************************To compare summary vs detail for the deal list click*************************/n");
	  java.util.List<WebElement> Deallistlis = driver.findElements(locatorClass.kpi_DL_LiCol);
		System.out.println(driver.findElement(locatorClass.kpi_DL_LiCol).getSize());
		
		Double AllLineItemssum=0.0;
		for(int i=0; i<Deallistlis.size(); i++) {
			
			System.out.println(Deallistlis.get(i).getText());
			System.out.println(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
			AllLineItemssum+=Double.parseDouble(Deallistlis.get(i).getText().replaceAll("[^-0-9.]", ""));
}
		System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
		System.out.println("*******SummaryLI********");
		
		java.util.List<WebElement> SummaryLIcount = driver.findElements(locatorClass.kpi_DL_Header);
		Double Summarysum=0.0;

		for(int i=0; i<SummaryLIcount.size(); i++) {
			
			System.out.println(SummaryLIcount.get(i).getText());
			
			System.out.println(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
			Summarysum+=Double.parseDouble(SummaryLIcount.get(i).getText().replaceAll("[^0-9.]", ""));
	
			
}
		System.out.println("SummaryLineItemsSum:::"+Summarysum);	
		
		Double diff=Math.abs(AllLineItemssum-Summarysum);
		
		
		 WebElement xclick= driver.findElement(locatorClass.kpi_DL_CloseIcon1);
		 actions.moveToElement(xclick).build().perform();
		 wait.until(ExpectedConditions.elementToBeClickable(xclick)).click();
		
		 DecimalFormat df = new DecimalFormat("###.#######");
	     System.out.println("Diff Val  : "+df.format(diff));

	    System.out.println("*************************************************************"); 
	     if(diff<1) {
	    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff) );
//	    	 Assert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + diff);
	    	 softassert.assertTrue(diff<1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") : Diff Val  " + df.format(diff));
	    	 softassert.assertAll();
	     }
	     
	     else {
	    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
//	    	 Assert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   +  diff  );
	    	 softassert.assertFalse(diff>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matched(False): Diff Val"   + df.format(diff)  );
	    	 softassert.assertAll();
	     }
	     System.out.println("*************************Comparision of summary vs detail in deal list was ended*****************************************************\n");
	 
}


}

