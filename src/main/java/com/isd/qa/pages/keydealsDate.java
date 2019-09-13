package com.isd.qa.pages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;





public class keydealsDate   {
	
WebDriver driver;
	
	public  keydealsDate(WebDriver driver) {
		this.driver = driver;
		
		}

	public static final String DATA_AS_OF = "Data as of ";
	
	
 @Test(priority=0,description="Keydeals date")
public void BudgetKPIdateComparison() throws InterruptedException {
	 
	 System.out.println("keydeals Date Comparison");
	 
//Key deals------------------------------	 
	 driver.findElement(By.xpath("//*[@id='keydeals']")).click();
	 String Keydeals= driver.findElement(By.xpath("//span[text()='KEY DEALS']")).getText();  
	 System.out.println("TabName :"+Keydeals);
	 Thread.sleep(2000);
	 
	 //Budget KPI Date------------------
	 WebElement KDdataasof = driver.findElement(By.xpath("//span[@class='headertext']"));
	 String KEYDEALdate = KDdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "").replace(" ", "");
	 System.out.println("KEY DEALS Currentweekdate:" +KEYDEALdate);
	 
	 String yesterdayDate = getyesterdayDate();
	 System.out.println("Yesterday:"+ yesterdayDate);
	Assert.assertTrue(KEYDEALdate.contains(yesterdayDate));
	
 } 
 
 
 public String getyesterdayDate() {
		
		DateFormat dateFormat = new SimpleDateFormat("MMMdd,YYYY");
        Date date = new Date();
        date .setTime(date.getTime()-24*60*60*1000);  // Subtract 24*60*60*1000 milliseconds
        return dateFormat.format(date);
		 
} }



	  


