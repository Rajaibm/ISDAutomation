package com.isd.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.isd.qa.base.TestBase;
import com.isd.qa.pages.AggregatedSAQDataComparison;
import com.isd.qa.pages.ExpandDataTable;
import com.isd.qa.pages.ISDLoginPage;
import com.isd.qa.pages.KDAllviewsComparison;
import com.isd.qa.pages.KDTwistydata;
import com.isd.qa.pages.KDlayout;
import com.isd.qa.pages.KPISummaryDetail;
import com.isd.qa.pages.Logoutprofile;


public class NAUSIND2 extends TestBase {
	
	
@Test
public void initialpagelogin() throws Exception{
		 	
ISDLoginPage loginpage = PageFactory.initElements(driver, ISDLoginPage.class);

	loginpage.setEmail("rajagre@in.ibm.com");
	loginpage.setPassword("test2020@123456789");
	loginpage.clickOnLoginButton();

ExpandDataTable expandtable= PageFactory.initElements(driver, ExpandDataTable.class);
    expandtable.ESexpandtable();
    Thread.sleep(500);
	expandtable.APexpandtable();
	Thread.sleep(500);
    expandtable.SPexpandtable();
    Thread.sleep(500);
     expandtable.RMexpandtable();
    
	
AggregatedSAQDataComparison  AggregatedSAQDataComparison= PageFactory.initElements(driver, AggregatedSAQDataComparison.class); 
    Thread.sleep(1000);
	AggregatedSAQDataComparison.aggTabClick();
	Thread.sleep(500);
	AggregatedSAQDataComparison.probe();
	Thread.sleep(500);
	AggregatedSAQDataComparison.close();
	Thread.sleep(500);
	AggregatedSAQDataComparison.Refine();
	Thread.sleep(500);
	AggregatedSAQDataComparison.Advance();
		


  KDlayout KDlayout = PageFactory.initElements(driver, KDlayout.class); 
    KDlayout.gearIcon();
    
 Logoutprofile  landingpage= PageFactory.initElements(driver, Logoutprofile.class); 
    Thread.sleep(1000);
	landingpage.lOGINbackAndOutchecking();    
    
	
	}

}
