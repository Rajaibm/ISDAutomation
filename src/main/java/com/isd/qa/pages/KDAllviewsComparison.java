package com.isd.qa.pages;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;





public class KDAllviewsComparison {
	
	WebDriver driver;
	
	SoftAssert softassert = new SoftAssert();
	
	WebElement Text;
//	 Actions actions = new Actions(driver);
	
		public KDAllviewsComparison(WebDriver driver) {
			this.driver = driver;
			
		}
	
		locatorClass locatorClass = new locatorClass(driver);
		
@Test(priority=1)
public void views_SummaryDtl() throws InterruptedException {

		driver.findElement(locatorClass.tab_KeyDeals).click();
		 //driver.findElement(By.xpath("//*[@class='expand-icon']")).click();
		 driver.findElement(By.xpath("//*[@style='cursor:pointer'][2]")).click();
		 
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		/*List<WebElement> cursoricon = driver.findElements(locatorClass.topNav_ExpColl);
		System.out.println("**************");
		if (cursoricon.size()>0) {
			driver.findElement(locatorClass.topNav_ExpColl).click();	
			Thread.sleep(1000);
		}
		else {
			
			WebElement clicksomewhere= driver.findElement(locatorClass.click_Somewhere_Outside);
			clicksomewhere.click();
		}		*/
	
		WebElement viewtxt = driver.findElement(locatorClass.kd_View_Label);
		System.out.println(viewtxt.getText());
		
		Thread.sleep(1000);
		driver.findElement(locatorClass.kd_View_DropDown).click();
		
		List<WebElement> viewclck = driver.findElements(locatorClass.kd_View_Options);
		System.out.println(driver.findElements(locatorClass.kd_View_Options).size());
			
		
		for(int i=1; i<viewclck.size(); i++) {
			Thread.sleep(1000);
		
//			WebElement Allviews = driver.findElement(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//div[@role='option']["+i+"]"));
			String str_AllViews = locatorClass.kd_View_Options_Path+"["+i+"]";
			WebElement AllViews = driver.findElement(By.xpath(str_AllViews));
			String views= AllViews.getText();
			System.out.println("Followed view is :: "+AllViews.getText()+"");
			AllViews.click();
			WebDriverWait wait = new WebDriverWait(driver,300);
			Thread.sleep(2000);
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("window.scrollBy(0,10000)");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> KDlis = driver.findElements(locatorClass.allDeals_LiCol);
			System.out.println(driver.findElement(locatorClass.allDeals_LiCol).getSize());
			
			Double AllLineItemssum=0.0;
			for(int j=0; j<KDlis.size(); j++) {
				Thread.sleep(1000);
				if (KDlis.get(j).getText().equals(null)) {
					System.out.println("No Data to Display");
				}
				else {
				System.out.println(KDlis.get(j).getText());
				System.out.println(KDlis.get(j).getText().replaceAll("[^-0-9.]", ""));
				AllLineItemssum+=Double.parseDouble(KDlis.get(j).getText().replaceAll("[^-0-9.]", ""));
				}	
	  }
			System.out.println("DetailedALLlineItemsSum:::"+AllLineItemssum);
			javascriptExecutor.executeScript("window.scrollBy(0,-10000)");
			
			System.out.println("*******SummaryLI********");
			
			List<WebElement> SummaryKDLIcount = driver.findElements(locatorClass.kd_Li_Header_Value);
			
			Double Summarysum=0.0;
			for(int k=0; k<SummaryKDLIcount.size(); k++) {
				
				System.out.println(SummaryKDLIcount.get(k).getText());
				
				System.out.println(SummaryKDLIcount.get(k).getText().replaceAll("[^0-9.]", ""));
				Summarysum+=Double.parseDouble(SummaryKDLIcount.get(k).getText().replaceAll("[^0-9.]", ""));
		
				
	  }
			System.out.println("SummaryLineItemsSum:::"+Summarysum);	
			
			double dif=Math.abs(AllLineItemssum-Summarysum);
		     DecimalFormat df = new DecimalFormat("###.#######");
		     System.out.println("Diff Val  : "+df.format(dif));
		     
		    System.out.println("*************************************************************"); 
		    
		     if(dif<1) {
		    	 
		    	 System.out.println("Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+")    view is : ("+views+"): Diff Val  " + df.format( dif) );
//		    	 Assert.assertTrue(dif<=1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") view is : ("+views+") : Diff Val  " + df.format(dif));
		    	 softassert.assertTrue(dif<=1, "Line Items values are partially matched(True) for Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") view is : ("+views+") : Diff Val  " + df.format( dif));
		    	 
		     }
		     
		     else {
		    	 
		    	 System.out.println("Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matching(False)  view is : ("+views+"): Diff Val  "   +  df.format(dif)   );
//		    	 Assert.assertFalse(dif>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matching(False) view is: ("+views+") : Diff Val  "   +  df.format(dif)  );
		    	 softassert.assertFalse(dif>1, "Line Items values in Keydeals summary ("+Summarysum+") vs detailed ("+AllLineItemssum+") are not matching(False) view is: ("+views+") : Diff Val  "   +  df.format( dif) );
		    	 
		     }

			driver.findElement(locatorClass.topNav_View_ArrowWrapper).click();
	}
		
		softassert.assertAll();
	

	}
	
	


}
