package com.isd.qa.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import com.paulhammant.ngwebdriver.NgWebDriver;





public class KDlayout {
	
	
	
    WebDriver driver;
	
	
	private FluentWait<WebDriver> wait;
//	private Actions actions;
	
	
	
	String checkboxtxt = null;
	String splitfilters = null;
	String leftoptions = null;
	String options = null;
	
  public KDlayout(WebDriver driver) {
		// TODO Auto-generated constructor stub
	  this.driver = driver;
	}
  locatorClass locatorClass = new locatorClass(driver);

@SuppressWarnings("deprecation")
@Test(priority=1)
  public void gearIcon() throws InterruptedException {
	  
//	  test = extent.createTest("gearIcon");
      driver.findElement(By.xpath("//*[@id='keydeals']")).click();
	  JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
	  NgWebDriver ngWebDriver = new NgWebDriver(javascriptExecutor);
      Actions actions = new Actions(driver);
     
      driver.findElement(locatorClass.gearIcon).click();
      Thread.sleep(2000);
      driver.findElement(locatorClass.gear_NewFilterView).click();
      Thread.sleep(1000);
      List<WebElement> cBox = driver.findElements(locatorClass.kd_Gear_NewView_ChkBox);
      List<WebElement> cBoxTxt = driver.findElements(locatorClass.kd_Gear_NewView_ChkLabel);
      System.out.println(cBox.size());
      System.out.println(driver.findElement(locatorClass.kd_Gear_NewView_TitleTxt).getText());
      Thread.sleep(1000);

      String checkboxtxt = null;
     for (int i = 0; i < cBox.size(); i++) {
          actions.moveToElement(cBox.get(i)).build().perform();
          Thread.sleep(1000);

          if(cBox.get(i).isDisplayed()) {
        	  Thread.sleep(1000);
        	javascriptExecutor.executeScript("arguments[0].click();", cBox.get(i));
        	
        	System.out.println(cBoxTxt.get(i).getText());
        	if(!cBox.get(i).isSelected()) {
        		javascriptExecutor.executeScript("arguments[0].click();", cBox.get(i));
        		

        	}

          
            }
        	            
          }

      
      List<WebElement> Filterclick = driver.findElements(locatorClass.kd_Gear_NewView_FilterIcon);
      String Filterclicks[] = new String[Filterclick.size()];
      
      
      String splitfilters = null;
      for (int j = 0; j < Filterclick.size(); j++) {
          actions.moveToElement(Filterclick.get(j)).build().perform();
          Thread.sleep(1000);
          if(Filterclick.get(j).isDisplayed()) {
        	  javascriptExecutor.executeScript("arguments[0].click();", Filterclick.get(j));
        	  Filterclicks[j]=Filterclick.get(j).getText();
        	  WebElement filterdropdwontxt= driver.findElement(locatorClass.kd_Gear_NewView_Filter_DropDown);
        	  String filtersdata = filterdropdwontxt.getText();
        	  int a = filtersdata.indexOf(" ");
        	  splitfilters = filtersdata.substring (a+1);

        	  System.out.println("Filter selections :"+splitfilters+"");
        	 
        	        	  
  	} 
      

 
  
}  

       Thread.sleep(3000); 

       WebElement cancelClick = driver.findElement(locatorClass.cancel_Icon);
       actions.moveToElement(cancelClick).build().perform();
      Thread.sleep(1000);
      cancelClick.click();
  }
  


  

}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
