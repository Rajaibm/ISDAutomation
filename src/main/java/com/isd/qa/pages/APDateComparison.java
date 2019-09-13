 package com.isd.qa.pages;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;





public class APDateComparison  {
	WebDriver driver;

	public static final String DATA_AS_OF = "Data as of ";
	
	public  APDateComparison(WebDriver driver) {
		this.driver = driver;
	
		}
	

	
@Test (priority=0,description="Weekly date comparison")
public void PPVdatecomparison() throws InterruptedException {
		
		  
//Aggregate Pipeline------------------
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@id='agg']")).click();
		String AP= driver.findElement(By.xpath("//span[text()='Aggregated Pipeline']")).getText();  
		System.out.println(AP);
		Thread.sleep(1000);		  
		  		  
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
		
//QPKPI Date------------------	
		WebElement QPDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[6]"));
		action.moveToElement(QPDateKPIinfo).build().perform();
		Thread.sleep(500);
		WebElement QPdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[6]"));
		String QPKPIdate = QPdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
		System.out.println("QP Currentweekdate:" +QPKPIdate);
		
//WONKPI Date------------------	--------------------------------
	    Thread.sleep(1000);
	    WebElement WONDateKPIinfo= driver.findElement(By.xpath("(//*[@class='infoIcon'])[7]"));
		action.moveToElement(WONDateKPIinfo).build().perform();
		Thread.sleep(500);
		WebElement WONdataasof = driver.findElement(By.xpath("(//*[@class='infoTooltipContainer'])[7]"));
		String WONKPIkdate = WONdataasof.getText().replace(DATA_AS_OF, "").replace("(", "").replace(")", "");
		System.out.println("WON Currentweekdate:" +WONKPIkdate);	
		
		String lastWedDate = getyesterDate();
		System.out.println("Lastweekdate:" + lastWedDate);
//		System.out.println("Is date exist :: "+(ppvkpidate.contains("Feb 06, 2019")?"Yes":"NO"));
//		System.out.println("Is date exist :: "+(KPIdate.contains("Feb 06, 2019")?"Yes":"NO"));
		
		Assert.assertTrue(ppvkpidate.contains(lastWedDate));
		Assert.assertTrue(KPIdate.contains(lastWedDate));
		Assert.assertTrue(QPKPIdate.contains(lastWedDate));
		Assert.assertTrue(WONKPIkdate.contains(lastWedDate));
		
		Thread.sleep(1000);
		
	}
	
	

	@SuppressWarnings("static-access") 	
	public String getyesterDate() {
		
		Calendar c = Calendar.getInstance();
		ZoneId zone = c.getTimeZone().toZoneId();
		LocalDate today = LocalDate.now(c.getTimeZone().toZoneId());
		LocalDate previousWednesday = today.with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY));

		SimpleDateFormat simpledate = new SimpleDateFormat("MMM dd, YYYY");
		Date date = (Date) Date.from(previousWednesday.atStartOfDay().atZone(zone.systemDefault()).toInstant());
		return simpledate.format(date);
		
	
	}}

		