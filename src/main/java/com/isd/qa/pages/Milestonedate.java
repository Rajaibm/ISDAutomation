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






public class Milestonedate   {

WebDriver driver;
	
	public  Milestonedate(WebDriver driver) {
		this.driver = driver;
		
		}
	public static final String DATA_AS_OF = "Data as of ";
	
	
 @Test(priority=0,description="Milestone")
public void BudgetKPIdateComparison() throws InterruptedException {
	  
	 System.out.println("MILESTONE Date Comparison");
//Mile stone------------------------------	 
	 driver.findElement(By.xpath("//*[@id='milestone']")).click();
	 String MILESTONE= driver.findElement(By.xpath("//span[text()='MILESTONE']")).getText();  
	 System.out.println("TabName :"+MILESTONE);
	 Thread.sleep(2000);
	 
//	 MILESTONE KPI Date------------------
	 
	 WebElement Midataasof = driver.findElement(By.xpath("//span[@class='headertext milestoneDate']"));
	 String Midate = Midataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
	 System.out.println("Milestone Currentweekdate:" +Midate);
	 
	 	  
	 String yesterdayDate = getyesterdayDate();
	 System.out.println("Yesterday:"+ yesterdayDate);
	 Assert.assertTrue(Midate.contains(yesterdayDate));
	
 } 
 
 
 public String getyesterdayDate() {
		
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, YYYY");
        Date date = new Date();
        date .setTime(date.getTime()-24*60*60*1000);  // Subtract 24*60*60*1000 milliseconds
        return dateFormat.format(date);
		 
} }



	  


