package com.isd.qa.pages;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;






public class ESKPIDailydate   {
	
	WebDriver driver;
	
	public  ESKPIDailydate(WebDriver driver) {
		this.driver = driver;
		
		}
	public static final String DATA_AS_OF = "Data as of ";
	
	
 @Test(priority=0,description="Budget date")
public  void BudgetKPIdateComparison() throws InterruptedException {
	 
//Executive summary--------------------------	 
	 String ES= driver.findElement(By.xpath("//span[text()='Executive Summary']")).getText();
	 System.out.println(ES);
	 
///Budget source------ 
	 Actions action = new Actions(driver);
	 Thread.sleep(500);
	 WebElement KPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[1]"));
	 action.moveToElement(KPIinfo).build().perform();
	 Thread.sleep(500);
     WebElement Budgettimeinfo= driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[1]"));
     String BudgetDateActualResult = Budgettimeinfo.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
     System.out.println("BudgetDateActualResult");
    
	 
	 
 //WSRKPI date-----------------------------
	 Thread.sleep(1000);
	 WebElement WSRDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[6]"));
	 action.moveToElement(WSRDateKPIinfo).build().perform();
	 Thread.sleep(500);
	 WebElement WSRdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[6]"));
	 String WSRKPIdate = WSRdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
	 System.out.println("WSR Currentweekdate:" +WSRKPIdate);
	
	 String yesterdayDate = getyesterdayDate();
	 System.out.println("Yesterday:"+ yesterdayDate);
	 Assert.assertTrue(BudgetDateActualResult.contains(yesterdayDate));
     Assert.assertTrue(WSRKPIdate.contains(yesterdayDate));
    
  }
		
public String getyesterdayDate() {
			
			DateFormat dateFormat = new SimpleDateFormat("MMM dd, YYYY");
	        Date date = new Date();
	        date .setTime(date.getTime()-24*60*60*1000);  
	        return dateFormat.format(date);
		
			 
 } 
	
}



	  


