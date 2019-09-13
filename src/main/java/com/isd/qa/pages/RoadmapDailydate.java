package com.isd.qa.pages;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;




public class RoadmapDailydate   {
WebDriver driver;
	
	public  RoadmapDailydate(WebDriver driver) {
		this.driver = driver;
		
		}
	
	public static final String DATA_AS_OF = "Data as of ";
	
	
 @Test(priority=0,description="Budget date")
public  void BudgetKPIdateComparison() throws InterruptedException {
	 
	 
//Road map--------------------------	
	 driver.findElement(By.xpath("//*[@id='roadmap']")).click();
	 String Roadmap= driver.findElement(By.xpath("//span[text()='ROADMAP']")).getText();
	 System.out.println("Tabname :"+Roadmap);
	 
//Budget KPI Date------------------
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
	 WebElement WSRDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[2]"));
	 action.moveToElement(WSRDateKPIinfo).build().perform();
	 Thread.sleep(500);
	 WebElement WSRdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[2]"));
	 String WSRKPIdate = WSRdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
	 System.out.println("WSR Currentweekdate:" +WSRKPIdate);

	//WONKPI Date------------------	--------------------------------
	    Thread.sleep(1000);
	    WebElement WONDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[5]"));
		action.moveToElement(WONDateKPIinfo).build().perform();
		Thread.sleep(500);
		WebElement WONdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[5]"));
		String WONKPIkdate = WONdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
		System.out.println("WON Currentweekdate:" +WONKPIkdate);
		
//Solid + AT RISK Date--------------------------------------------------
	    Thread.sleep(1000);
	    WebElement SOLIDDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[6]"));
		action.moveToElement(SOLIDDateKPIinfo).build().perform();
		Thread.sleep(500);
		WebElement SOLIDdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[6]"));
		String SOLIDKPIkdate = SOLIDdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
		System.out.println("Solid + AT Risk Currentweekdate:" +SOLIDKPIkdate);
		Thread.sleep(1000);
	    
//WSR + KEY STRETCH Date--------------------------------------------------
		Thread.sleep(1000);
	    WebElement keyStretchDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[7]"));
		action.moveToElement(keyStretchDateKPIinfo).build().perform();
		Thread.sleep(500);    
        WebElement KEYSTRETCHdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[7]"));
		String KEYSTRETCHKPIkdate = KEYSTRETCHdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
		System.out.println("WSR + KEYSTRETCH Currentweekdate:" +KEYSTRETCHKPIkdate);			
		
	 
		
	 String yesterdayDate = getyesterdayDate();
	 System.out.println("Yesterday:"+ yesterdayDate);
	 Assert.assertTrue(BudgetDateActualResult.contains(yesterdayDate));
     Assert.assertTrue(WSRKPIdate.contains(yesterdayDate));
     Assert.assertTrue(WONKPIkdate.contains(yesterdayDate));
     Assert.assertTrue(SOLIDKPIkdate.contains(yesterdayDate));
     Assert.assertTrue(KEYSTRETCHKPIkdate.contains(yesterdayDate));
     
     
 }
		
public String getyesterdayDate() {
			
			DateFormat dateFormat = new SimpleDateFormat("MMM dd, YYYY");
	        Date date = new Date();
	        date .setTime(date.getTime()-24*60*60*1000);  // Subtract 24*60*60*1000 milliseconds
	        return dateFormat.format(date);
		
		
 } 

}



	  


