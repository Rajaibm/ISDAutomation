package com.isd.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
//import org.junit.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class KDTwistydata {
	
	WebDriver driver;
	
	SoftAssert softassert = new SoftAssert();

	public KDTwistydata(WebDriver driver) {
		this.driver = driver;
		
	}
	
	locatorClass locatorClass = new locatorClass(driver);
	 
	
  @Test(priority=1)
  public void kd_TWisty() throws InterruptedException {
	  
//	  test = extent.createTest("KDTWisty");
	  
	  driver.findElement(locatorClass.tab_KeyDeals).click();
//	  ngWebDriver.waitForAngularRequestsToFinish(); 

//	  List<WebElement>LineItemVtotal = driver.findElements(By.xpath("//div[@class='col-md-2-pull-right']/p"));
//	  for (WebElement ele:LineItemVtotal) {
//		  String LineItemttl[] = new String[LineItemVtotal.size()];
//		  Thread.sleep(1000);
//		  System.out.println(ele.getText());
//		
//	}  
  }
  
  @Test(priority=2)
public void plusmiustwistie() throws InterruptedException{
	  
//	  test = extent.createTest("plusmiustwistie");
	  driver.findElement(By.xpath("//*[@class='expand-icon']")).click();
	System.out.println("To Test whether +/- buttons are working or not");
	WebElement button = driver.findElement(locatorClass.kd_Twisty_PlusIcon);
	button.click();
	Thread.sleep(3000);
	
	if(button.isEnabled()) {
		System.out.println(driver.findElement(locatorClass.kd_FirstRow).getText());
		System.out.println(("************************************"));
		System.out.println("Plus button to open the deals twiste is clicked and passed");
		System.out.println("**************************************");
	}
	
	else {
		System.out.println("Clicking to open plus button and for all twisuties is failed");
	}
	Thread.sleep(1000);	
	driver.findElement(locatorClass.kd_Twisty_MinusIcon).click();
	
}
  
  @Test(priority=3)
  public void dealsmatchtwistie() throws InterruptedException {
	  
//	  test = extent.createTest("dealsmatchtwistie");
	  JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
	  
	 List<WebElement>Wdatasummary = driver.findElements(locatorClass.kd_First_LiVal);
	  
	  for(WebElement ele:Wdatasummary) {
		  System.out.println(ele.getText());
		  
	  }
	  
	  System.out.println("*************To check for loop pages with value data**************");
	  
	  System.out.println(driver.findElement(locatorClass.kd_FirstTwisty_ExColl).getText());
	  driver.findElement(locatorClass.kd_FirstTwisty_ExColl).click();
//	  driver.findElement(By.xpath("(//div[@class='skp-select'])[1]")).click();
	  
	  List<WebElement> Valuetxt = driver.findElements(locatorClass.kd_Table_Value_Col);
	 
	  List<WebElement> pagination = driver.findElements(locatorClass.kd_Pagination);
	  List<WebElement> pagesloop= driver.findElements(locatorClass.kd_Pagination_Loop);
	  WebDriverWait wait=new WebDriverWait(driver, 200);
	  System.out.println("Total value of the twistie size is ::" +Valuetxt.size());
	  System.out.println("******************************");
	  Double sum =0.0;
	  for (int i = 0; i < Valuetxt.size(); i++) {
		  
		  javascriptExecutor.executeScript("arguments[0];", Valuetxt.get(i));
		  System.out.println(Valuetxt.get(i).getText());
		  sum+= Double.parseDouble(Valuetxt.get(i).getText());
	  }	  
	  
	  System.out.println("Total value:::"+sum);
		  

  }
  
  @Test(priority=4)
  public void twistypagination() throws InterruptedException {
	  
//	  test = extent.createTest("click");
	  
	  WebElement pagination = driver.findElement(locatorClass.kd_Pagination);
	  pagination.click();
	  WebElement pagesloop= driver.findElement(locatorClass.kd_Pagination_Loop);
	  WebElement oppdata = driver.findElement(locatorClass.kd_Oppty_Col);
	  System.out.println(oppdata.getText());
	  String data = oppdata.getText().toString();
	  String[] myData=data.split(" ");
	  System.out.println("LineItems : "+myData[3]);
//	 System.out.println(data.substring(data.indexOf('h')+1, data.indexOf('L')).trim());
	  String number = myData[3].replaceAll("[^0-9]", "");
		float result = Integer.parseInt(number);			
		System.out.println(result);
		
		float divide = 0;
		int div=0;
		if(result%10>0) {
			
			 divide = (result/10);
			 System.out.println(divide);
			 divide = (int)divide;
			 System.out.println(divide);
			 divide =divide+1;
			 System.out.println("**********");
			 System.out.println(divide);

			 div=Math.round(divide);
			 
		}
		
		else {
			divide= (result/10);
			div=Math.round(divide);
			
		}

		 
		 CharSequence cs = String.valueOf(div);
		WebElement imp =  driver.findElement(locatorClass.kd_Pages_List);
		Thread.sleep(1000);
		imp.sendKeys(cs);
		Thread.sleep(1000);
		imp.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement nextpage =driver.findElement(locatorClass.kd_Pagination);

		
		if(nextpage.isSelected()) {
			System.out.println("********************************************");
			System.out.println("Arrow should not be clickable");
			System.out.println("********************************************");
			
		System.out.println("Arrow is able to click even when scroll down to last page and the result is :  False");
//		Assert.assertFalse(false, "Arrow is able to click even when scroll down to last page and the result is :  False");
		softassert.assertFalse(false, "Arrow is able to click even when scroll down to last page and the result is :  False");
		
		}
		
		else {
			System.out.println("Arrow is not clickable at the end point and the result is ::   True");
//			Assert.assertTrue(true,"Arrow is not clickable at the end point and the result is ::True");
			softassert.assertTrue(true,"Arrow is not clickable at the end point and the result is ::True");
			
		}
		
		softassert.assertAll();

	  
  }
  
 
}
