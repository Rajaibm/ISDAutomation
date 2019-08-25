package com.isd.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class AggregatedSAQDataComparison {
	
	WebDriver driver;
	SoftAssert softassert = new SoftAssert();
	
	public AggregatedSAQDataComparison(WebDriver driver) {
		this.driver = driver;
		
	}
	@FindBy(how = How.XPATH, using = "//*[@id='exe']")WebElement Executivesummarytab;
	@FindBy(how = How.XPATH, using = "//*[@id='agg']")WebElement Aggtab;
	@FindBy(how = How.XPATH, using = "//*[@id='seg']")WebElement Segtab;
	@FindBy(how = How.XPATH, using = "//*[@id='roadmap']")WebElement Roadmaptab;
	@FindBy(how = How.XPATH, using = "//h4[text()='SALES ACTION QUADRANTS']")WebElement saqgraphTitle ;
	@FindBy(how = How.XPATH, using = "//h4[text()='SALES ACTION QUADRANTS']//..//*[@class='expandOrCollapseGraphIcons']")WebElement saqgraphMaximize ;
	@FindBy(how = How.XPATH, using = "(//h4[text()='SALES ACTION QUADRANTS']//..//*[text()='PROBE']/..)[1]")WebElement saqProbeTxt ;
	@FindBy(how = How.CSS, using = "atatable-body.datatable-body datatable-row-wrapper:nth-of-type(2)")WebElement saqtblProbeData;
	@FindBy(how = How.XPATH, using = "//div[text()='CLOSE']")WebElement saqClose;
	@FindBy(how = How.XPATH, using = "(//h4[text()='SALES ACTION QUADRANTS']//..//*[text()='CLOSE']/..)[1]")WebElement saqCloseTxt;
	@FindBy(how = How.CSS, using = "datatable-body.datatable-body datatable-row-wrapper:nth-of-type(1)")WebElement saqtblCloseData;
	@FindBy(how = How.XPATH, using = "(//h4[text()='SALES ACTION QUADRANTS']//..//*[text()='REFINE']/..)[1]")WebElement saqRefineTxt;
	@FindBy(how = How.XPATH, using = "datatable-body.datatable-body datatable-row-wrapper:nth-of-type(4)")WebElement saqtblRefineTxt;
	@FindBy(how = How.XPATH, using = "(//h4[text()='SALES ACTION QUADRANTS']//..//*[text()='ADVANCE']/..)[1]")WebElement saqAdvanceTxt;
	@FindBy(how = How.CSS, using = "datatable-body.datatable-body datatable-row-wrapper:nth-of-type(3)")WebElement saqtbl_AdvanceData;
	@FindBy(how = How.XPATH, using = "//*[@class='buttonShowHide']")WebElement Showtable;
	@FindBy(how = How.XPATH, using = "(//*[@class='datatable-body-cell-label'])[6]")WebElement Showtableprobevalue;
	@FindBy(how = How.XPATH, using = "(//*[@class='datatable-body-cell sort-active ng-star-inserted'])[2]")WebElement Showtableclosevalue;
	@FindBy(how = How.XPATH, using = "(//*[@class='datatable-body-cell sort-active ng-star-inserted'])[10]")WebElement ShowtableADVANCEvalue;
	@FindBy(how = How.XPATH, using = "(//*[@class='datatable-body-cell sort-active ng-star-inserted'])[14]")WebElement ShowtableRefinevalue;
	@FindBy(how = How.XPATH, using = "//*[@class='buttonShowHide']")WebElement Hidetable;

@Test(priority=1)
  public void aggTabClick() {
	
	Aggtab.click();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
}


  @Test(priority=2)
  public void probe() {
	  System.out.println("SAQ probe data comparison");
	  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	  saqgraphTitle.getText();
	 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  WebElement ExpandTable= saqgraphMaximize;
	  ExpandTable.click();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  WebElement probeData = saqProbeTxt;
	  Actions actions = new Actions(driver);
      actions.moveToElement(probeData).build().perform();
		  String Actual= saqProbeTxt.getText();

		  String Data = probeData.getText().toString().replace("$", "").replace("M","").replace("PROBE", "");
		  double PD= Double.valueOf(Data);
		  int pvalue = (int)Math.round(PD);
		  
		  System.out.println(pvalue);
		  Showtable.click();
		  String expected =Showtableprobevalue.getText();
		  
		   double d = Double.valueOf(expected);
		   int value = (int)Math.round(d);
		   System.out.println(value);
		
		   Assert.assertEquals(pvalue,value);
		  
	      softassert.assertAll();
	      ExpandTable.click();
  }
  
  @Test(priority=3)
  public void close() throws InterruptedException {
	  
	  System.out.println("SAQ close data comparison");
	  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	  saqgraphTitle.getText();
	 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  WebElement ExpandTable= saqgraphMaximize;
	  ExpandTable.click();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  WebElement CloseData = saqCloseTxt;
	  Actions actions = new Actions(driver);
      actions.moveToElement(CloseData ).build().perform();
		  String Actual= saqCloseTxt.getText();

		  String Data = CloseData.getText().toString().replace("$", "").replace("M","").replace("CLOSE", "");
		  double PD= Double.valueOf(Data);
		  int pvalue = (int)Math.round(PD);
		  
		  System.out.println(pvalue);
		  Showtable.click();
		  String expected =Showtableclosevalue.getText();
		  
		   double d = Double.valueOf(expected);
		   int value = (int)Math.round(d);
		   System.out.println(value);
		
		   Assert.assertEquals(pvalue,value);
		  
	      softassert.assertAll();
	      ExpandTable.click();
  }
	 

  
  @Test(priority=4)
 public void Refine() {
	  

	  System.out.println("SAQ Refine data comparison");
	  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	  saqgraphTitle.getText();
	 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  WebElement ExpandTable= saqgraphMaximize;
	  ExpandTable.click();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  WebElement RefineData = saqRefineTxt;
	  Actions actions = new Actions(driver);
      actions.moveToElement(RefineData).build().perform();
		  String Actual= saqRefineTxt.getText();

		  String Data = RefineData.getText().toString().replace("$", "").replace("M","").replace("REFINE", "");
		  double PD= Double.valueOf(Data);
		  int pvalue = (int)Math.round(PD);
		  
		  System.out.println(pvalue);
		  Showtable.click();
		  String expected = ShowtableRefinevalue.getText();
		  
		   double d = Double.valueOf(expected);
		   int value = (int)Math.round(d);
		   System.out.println(value);
		
		   Assert.assertEquals(pvalue,value);
		  
	      softassert.assertAll();
	      ExpandTable.click();
  }
	 
  
  @Test(priority=5)
  public void Advance() {
	  

	  System.out.println("SAQ Advance data comparison");
	  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	  saqgraphTitle.getText();
	 
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  WebElement ExpandTable= saqgraphMaximize;
	  ExpandTable.click();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  WebElement AdvanceData = saqAdvanceTxt;
	  Actions actions = new Actions(driver);
      actions.moveToElement( AdvanceData).build().perform();
		  String Actual= saqAdvanceTxt.getText();

		  String Data =  AdvanceData.getText().toString().replace("$", "").replace("M","").replace("ADVANCE", "");
		  double PD= Double.valueOf(Data);
		  int pvalue = (int)Math.round(PD);
		  
		  System.out.println(pvalue);
		  Showtable.click();
		  String expected = ShowtableADVANCEvalue.getText();
		  
		   double d = Double.valueOf(expected);
		   int value = (int)Math.round(d);
		   System.out.println(value);
		
		   Assert.assertEquals(pvalue,value);
		  
	      softassert.assertAll();
	      ExpandTable.click();
  }
	 
  

  }
		  
