package com.isd.qa.pages;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class RMKPIcomparisiongraphs {
	
	WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	
	public RMKPIcomparisiongraphs(WebDriver driver) {
		this.driver = driver;
		
	}
 
	locatorClass locatorClass = new locatorClass(driver);
	
	//  @AfterTest
		public void loganalisys() {
			LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	        for (LogEntry entry : logEntries) {
	        	System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
	        }
	            
	            //do something useful with the data
		}
	
	String Solidalltxt = "";
	String Atriskalltxt = "";
	String wsrkystrbars = "";
	String wsrkeystkp = "";
	String SAtrsk = "";
	int concatenate = 0;
	
	@Test(priority=1)
	  public void rMtoBudgetData() throws InterruptedException {
		  
		  WebElement tab_RM= driver.findElement(locatorClass.tab_Roadmap);
		  tab_RM.click();
		  System.out.println(tab_RM.getText());
		  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			
			List<WebElement> rmBdgt = driver.findElements(locatorClass.rm_Won_Bar);
			Actions actions = new Actions(driver);

			for (int i = 0; i < rmBdgt.size(); i++) {
				actions.moveToElement(rmBdgt.get(i)).build().perform();
				Thread.sleep(1000);
				System.out.println("Budget ar text is " + rmBdgt.get(i).getText());
			} 
			
			List<WebElement> rmBdgtTxt = driver.findElements(locatorClass.rm_RM2BudgetBarsv2);
			Actions actions1 = new Actions(driver);

			for (int i = 2; i < rmBdgtTxt.size(); i++) {
				actions1.moveToElement(rmBdgtTxt.get(i)).build().perform();
				Thread.sleep(1000);
				System.out.println("Budget ar text is " + rmBdgtTxt.get(i).getText());
			} 
			
	  }
	  
	  @Test(priority=2)
	  public void woncomparisionRMKPI() {
		  
		  WebElement Wontxt= driver.findElement(locatorClass.kpi_Name_WON);
		  System.out.println(Wontxt.getText());
		  WebElement Wonvalue = driver.findElement(locatorClass.kpi_Value_WON);
		  System.out.println(Wonvalue.getText());
		  WebElement wonbar = driver.findElement(locatorClass.rm_Won_Bar);
		  System.out.println("Bar for Won data is :" + wonbar.getText());
		  
		  
		  if(Wonvalue.getText().equals(wonbar.getText())) {
			  
			  System.out.println("Roadmap for Won ("+wonbar.getText()+") and Won KPI ("+Wonvalue.getText()+") are Matching and True ");
		  Assert.assertTrue(Wonvalue.getText().equals(wonbar.getText()), "Roadmap for Won ("+wonbar.getText()+") and Won KPI ("+Wonvalue.getText()+") are Matching and True ");
		
	  }
		  
		  else {
			  
			  System.out.println("Roadmap for Won ("+wonbar.getText()+") and Won KPI ("+Wonvalue.getText()+"))");
			  Assert.assertFalse(!Wonvalue.getText().equals(wonbar.getText()), "Roadmap for Won ("+wonbar.getText()+") and Won KPI ("+Wonvalue.getText()+") are not Matching and False ");
			  
			  
		  }
	  }
	  
	  @Test(priority=3)
	  public void solidcomparision() {
		  
		  WebElement solidbartxt= driver.findElement(locatorClass.rm_Solid_Bar);	  
		  Solidalltxt= solidbartxt.getText().replaceAll("[^0-9]","");
		  System.out.println("data trimmed is " +Solidalltxt);
		  WebElement Atriskbartxt = driver.findElement(locatorClass.rm_AtRisk_Bar);
		  Atriskalltxt = Atriskbartxt.getText().replaceAll("[^0-9]", "");
		 
		  
		  int sum1 = Integer.parseInt(Solidalltxt);
		  int sum2 = Integer.parseInt(Atriskalltxt);
		  int concatenate = Integer.parseInt(Solidalltxt) + Integer.parseInt(Atriskalltxt);
		  String allvalues = Integer.toString(concatenate);
		  System.out.println(allvalues);
		  
		  
		  WebElement KPIsAtrsk = driver.findElement(locatorClass.kpi_Value_SolAR);
		  System.out.println(KPIsAtrsk.getText());
		  SAtrsk = KPIsAtrsk.getText().replaceAll("[^0-9]", "");
		  int soAtr = Integer.parseInt(SAtrsk);
		  
		  int dif = 0;
		  dif=Math.abs(Integer.parseInt(allvalues)-Integer.parseInt(SAtrsk));
		  
		  
		  if(dif< 2) {
			  System.out.println("Bar values for SolidAtrisk("+allvalues+") and KPI values SolidAtrisk("+SAtrsk+") are Equal and True" + dif);
			  Assert.assertTrue(dif< 2, "Bar values for SolidAtrisk("+allvalues+") and KPI values SolidAtrisk("+SAtrsk+") are equal and True" + dif );
		  }
		  
		  else{
			  
			  System.out.println("Bar values for SolidAtrisk("+allvalues+") and KPI values SolidAtrisk("+SAtrsk+") are Not Equal and False" + dif);
			  Assert.assertFalse(dif> 2, "Bar values for SolidAtrisk("+allvalues+") and KPI values SolidAtrisk("+SAtrsk+") are Not Equal and False" + dif );
		  }
//		  Assert.assertTrue(all.equals(anObject), message);
	  }
	  
	  @Test(priority=4)
	  public void WSRKeystretch() {
		  WebElement barwsrkeystr = driver.findElement(locatorClass.rm_KS_Bar);
		  String wsrkystrbars = barwsrkeystr.getText().replaceAll("[^0-9]", "");
		  
		  WebElement KPIwsrkeystrvalue = driver.findElement(locatorClass.kpi_Value_WsrKS);
		  System.out.println(KPIwsrkeystrvalue.getText());
		  String wsrkeystkp = KPIwsrkeystrvalue.getText().replaceAll("[^0-9]", "");
		  
		  WebElement wonbar = driver.findElement(locatorClass.rm_Won_Bar);
		  String won = wonbar.getText().replaceAll("[^0-9]", "");
		  
		  int wonvalue = Integer.parseInt(won);
		  int sum1 = Integer.parseInt(Solidalltxt);
		  int sum2 = Integer.parseInt(Atriskalltxt);
		  int sum3 = Integer.parseInt(wsrkystrbars);
		  int wsrkeykpvalue = Integer.parseInt(wsrkeystkp);
		  
		  
		  int wsrkeystretch = Integer.parseInt(won)+Integer.parseInt(Solidalltxt)+Integer.parseInt(Atriskalltxt)+Integer.parseInt(wsrkystrbars);
		  String AllwsrKeystretchdata = Integer.toString(wsrkeystretch);
		  
		  System.out.println("ALL WSR+keystretch data would be :" + wsrkeystretch);
		  
		  
		  int dif = 0;
		  dif=Math.abs(Integer.parseInt(wsrkeystkp)-Integer.parseInt(AllwsrKeystretchdata));
		  
		  if(dif < 2) {
			  System.out.println("Bar values for WSR+keystretch("+AllwsrKeystretchdata+") and KPI values WSR+keystretch("+wsrkeystkp+") are Equal and True" + dif);
			  Assert.assertTrue(dif< 2, "Bar values for SolidAtrisk("+AllwsrKeystretchdata+") and KPI values WSR+keystretch("+wsrkeystkp+") are equal and True" + dif );
		  }
		  
		  else{
			  
			  System.out.println("Bar values for WSR+keystretch("+AllwsrKeystretchdata+") and KPI values WSR+keystretch("+wsrkeystkp+") are Not Equal and False" + dif);
			  Assert.assertFalse(dif> 2, "Bar values for WSR+keystretch("+AllwsrKeystretchdata+") and KPI values WSR+keystretch("+wsrkeystkp+") are Not Equal and False" + dif );
		  }
		  
		  
	  }
}
