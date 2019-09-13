package com.isd.qa.pages;


import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;




public class ESPipelineDateComparison  {

WebDriver driver;
	
	public  ESPipelineDateComparison(WebDriver driver) {
		this.driver = driver;
		
		}
public static final String DATA_AS_OF = "Data as of ";
	
@Test 
public void PPVdatecomparison() throws InterruptedException {
		
		  
//Executive summary--------------------------	 
		  String ES= driver.findElement(By.xpath("//span[text()='Executive Summary']")).getText();  
		  System.out.println("Tabname :"+ES);
		  Actions action = new Actions(driver);
// PPVKPI Date--------------------------------------------	
			WebElement PPVDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[2]"));
			action.moveToElement(PPVDateKPIinfo).build().perform();
			Thread.sleep(1000);
			WebElement PPVdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[2]"));
			String ppvkpidate = PPVdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
			System.out.println("PPV Currentweekdate:" +ppvkpidate);
			Thread.sleep(500);
	//VPKPI Date--------------------------------------
			WebElement VPDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[5]"));
			action.moveToElement(VPDateKPIinfo).build().perform();
			Thread.sleep(500);
			WebElement VPdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[5]"));
			String KPIdate = VPdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
			System.out.println("VP Currentweekdate:" +KPIdate);
			Thread.sleep(500);
			
	//WONKPI Date------------------	--------------------------------
		    Thread.sleep(1000);
		    WebElement WONDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[7]"));
			action.moveToElement(WONDateKPIinfo).build().perform();
			Thread.sleep(500);
			WebElement WONdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[7]"));
			String WONKPIkdate = WONdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
			System.out.println("WON Currentweekdate:" +WONKPIkdate);	
			
		String lastWedDate = getMostRecentDate();
		System.out.println("Lastweekdate:" + lastWedDate);
		
		Assert.assertTrue(ppvkpidate.contains(lastWedDate));
		Assert.assertTrue(KPIdate.contains(lastWedDate));
		Assert.assertTrue(WONKPIkdate.contains(lastWedDate));
		Thread.sleep(1000);
		
	}
	
	

	@SuppressWarnings("static-access") 	
	public String getMostRecentDate() {
		
		Calendar c = Calendar.getInstance();
		ZoneId zone = c.getTimeZone().toZoneId();
		LocalDate today = LocalDate.now(c.getTimeZone().toZoneId());
		LocalDate previousWednesday = today.with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY));

		SimpleDateFormat simpledate = new SimpleDateFormat("MMM dd, YYYY");
		Date date = (Date) Date.from(previousWednesday.atStartOfDay().atZone(zone.systemDefault()).toInstant());
		return simpledate.format(date);
		
	}}

		