package com.isd.qa.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ExpandDataTable {
	

WebDriver driver;

public ExpandDataTable(WebDriver driver) {
this.driver = driver;
		
		}
	
	@FindBy(how = How.XPATH, using = "//*[@class='expandOrCollapseGraphIcons']")WebElement Expandtable;
	@FindBy(how = How.XPATH, using = "//*[@class='buttonShowHide']") WebElement Showbutton;
	@FindBy(how = How.XPATH, using = "//*[@class='buttonShowHide']") WebElement hidebutton;
	@FindBy(how = How.XPATH, using = "//*[@class='expandOrCollapseGraphIcons']") WebElement Graphexpand;
	@FindBy(how = How.XPATH, using = "//*[@class='buttonShowHide']")WebElement Showtable;
	@FindBy(how = How.XPATH, using = "(//span[@class='ng-star-inserted'])[2]")WebElement ShowtableText;
	@FindBy(how = How.XPATH, using = "//*[@class='buttonShowHide']")WebElement Hidetable;
	@FindBy(how = How.XPATH, using = "//*[@class='buttonShowHide ng-star-inserted']")WebElement SPHidetable;
	@FindBy(how = How.XPATH, using = "//*[@class='buttonShowHide ng-star-inserted']")WebElement SPshowtable;
	@FindBy(how = How.XPATH, using = "//carbon-icon[@name='icon--minimize']/*[@class='ng-star-inserted']")WebElement closetable;
	@FindBy(how = How.XPATH, using = "//*[@id='exe']")WebElement Executivesummarytab;
	@FindBy(how = How.XPATH, using = "//*[@id='agg']")WebElement Aggtab;
	@FindBy(how = How.XPATH, using = "//*[@id='seg']")WebElement Segtab;
	@FindBy(how = How.XPATH, using = "//*[@id='roadmap']")WebElement Roadmaptab;
	@FindBy(how = How.XPATH, using = "//*[@id='keydeals']") WebElement Keydeals;
	
@Test
public void  ESexpandtable() throws InterruptedException {
System.out.println("Excutive summary");	
Thread.sleep(300);
Executivesummarytab.click();
SoftAssert softAssert = new SoftAssert();
WebDriverWait wait = new WebDriverWait(driver, 5000);
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='expandOrCollapseGraphIcons']")));
  List <WebElement> graphExpand = driver.findElements(By.xpath("//*[@class='expandOrCollapseGraphIcons']"));
  for(int i =0; i < graphExpand.size(); i++) {
		graphExpand .get(i).click();
		System.out.println("Graph Expanded");
		Thread.sleep(1000);
		Showtable.click();
		System.out.println( ShowtableText.getText());
	    Thread.sleep(300);
	    Hidetable.click();
	    Thread.sleep(300);
	    closetable.click();
	    softAssert.assertAll();
	}
  
}

@Test
public void  APexpandtable() throws InterruptedException {
				
  System.out.println("Aggregated Pipeline");
  Aggtab.click();
  WebDriverWait wait = new WebDriverWait(driver, 5000);
  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='expandOrCollapseGraphIcons']")));
  SoftAssert softAssert = new SoftAssert();
  List <WebElement> graphExpand = driver.findElements(By.xpath("//*[@class='expandOrCollapseGraphIcons']"));
  for(int i =0; i < graphExpand.size(); i++) {
		graphExpand .get(i).click();
		System.out.println("Graph Expanded");
		Thread.sleep(1000);
		Showtable.click();
		System.out.println( ShowtableText.getText());
	    Thread.sleep(300);
	    Hidetable.click();
	    Thread.sleep(300);
	    closetable.click();
	    softAssert.assertAll();
	}
}
  
  
  @Test
  public void  SPexpandtable() throws InterruptedException {
  				
    System.out.println("Segmented Pipeline");
    Segtab.click();
    WebDriverWait wait = new WebDriverWait(driver, 5000);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='expandOrCollapseGraphIcons']")));
    SoftAssert softAssert = new SoftAssert();
    List <WebElement> graphExpand = driver.findElements(By.xpath("//*[@class='expandOrCollapseGraphIcons']"));
    for(int i =0; i < graphExpand.size(); i++) {
  		graphExpand .get(i).click();
  		System.out.println("Graph Expanded");
  		Thread.sleep(1000);
  		SPshowtable.click();
  		System.out.println( ShowtableText.getText());
  	    Thread.sleep(300);
  	  SPHidetable.click();
  	    Thread.sleep(300);
  	    closetable.click();
  	    softAssert.assertAll();
  	}
}
  

  @Test
  public void  RMexpandtable() throws InterruptedException {
  				
    System.out.println("Roadmap");
    Roadmaptab.click();
    WebDriverWait wait = new WebDriverWait(driver, 5000);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='expandOrCollapseGraphIcons']")));
    SoftAssert softAssert = new SoftAssert();
    List <WebElement> graphExpand = driver.findElements(By.xpath("//*[@class='expandOrCollapseGraphIcons']"));
    for(int i =0; i < graphExpand.size(); i++) {
  		graphExpand .get(i).click();
  		System.out.println("Graph Expanded");
  		Thread.sleep(1000);
  		Showtable.click();
  		System.out.println( ShowtableText.getText());
  	    Thread.sleep(300);
  	    Hidetable.click();
  	    Thread.sleep(300);
  	    closetable.click();
  	    softAssert.assertAll();
  	}
}
  
  

}

	
	

