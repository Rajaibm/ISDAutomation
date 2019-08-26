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


public class NAUSIND extends TestBase {
	
	
@Test
public void initialpagelogin() throws Exception{
		 	
ISDLoginPage loginpage = PageFactory.initElements(driver, ISDLoginPage.class);

	loginpage.setEmail("rajagre@in.ibm.com");
	loginpage.setPassword("test2020@123456789");
	loginpage.clickOnLoginButton();
		 
/*ProfileNA  ProfileNA= PageFactory.initElements(driver, ProfileNA.class); 
	SoftAssert softAssert = new SoftAssert();
	Thread.sleep(1000);  
	ProfileNA.profilepic();
	Thread.sleep(1000);
	ProfileNA.Profiledropdown();
	Thread.sleep(500);
	ProfileNA.modifyprofile();
	Thread.sleep(500);
	ProfileNA.ClickOnUserRole();
	Thread.sleep(500);
	ProfileNA.SelectBusinessUnitsSVPGM();
	Thread.sleep(500);
	ProfileNA.ClickOnUserRole1();
	Thread.sleep(500);
	ProfileNA.SelectBusinessUnits();
	Thread.sleep(500);
	ProfileNA.SelectRole();
	Thread.sleep(500);
	//ProfileNA.SelectBU();
	//Thread.sleep(500);
	ProfileNA.promptclear();
	Thread.sleep(500);
	ProfileNA.ClickLevel10PropmtDropdown();
	Thread.sleep(500);
	ProfileNA.SelectGBS();
	Thread.sleep(500);
	ProfileNA.ClickGeo0PropmtDropdown();
	Thread.sleep(500);
	//ProfileNA.SelectNA();
	Thread.sleep(500);
	ProfileNA.NAGBS2ndLevel();
	Thread.sleep(500);
	ProfileNA.GBSBusinessUnitUSIND();
	Thread.sleep(500);
	ProfileNA.GBSBusinessUnit();
	Thread.sleep(500);
	ProfileNA.BussinessUnit();
	Thread.sleep(500);
	ProfileNA.nodeprompt();
	Thread.sleep(500);
	ProfileNA.ClickonupdateProfile();
	Thread.sleep(500);
	ProfileNA.ClickonSavebutton();
	Thread.sleep(500);
	ProfileNA.EStopnavclicking();
	Thread.sleep(500);
	ProfileNA.APtopnavclicking();
	Thread.sleep(500);
	ProfileNA.sptopnavclicking();
	Thread.sleep(500);
	ProfileNA.RMtopnavclicking();
	Thread.sleep(500);
	ProfileNA.KDtopnavclicking();
	Thread.sleep(500);
	ProfileNA.Milestonetopnavclicking();
	softAssert.assertAll();
*/
	
	
KPISummaryDetail  KPISummaryDetail = PageFactory.initElements(driver, KPISummaryDetail.class); 
    Thread.sleep(1000);
    KPISummaryDetail.es_VPdata();
    Thread.sleep(1000);
    KPISummaryDetail.es_WSR();
    Thread.sleep(1000);
    KPISummaryDetail.es_Won();
    Thread.sleep(1000);
    KPISummaryDetail.agg_VP();
    Thread.sleep(1000);
    KPISummaryDetail.agg_QP();
    Thread.sleep(1000);
    KPISummaryDetail.agg_WON();
    Thread.sleep(1000);
    KPISummaryDetail.segmented_QP();
    Thread.sleep(1000);
    KPISummaryDetail.segmented_VP();
    Thread.sleep(1000);
    KPISummaryDetail.segmented_WON();
    Thread.sleep(1000);
    KPISummaryDetail.roadMap_WSR();
    Thread.sleep(1000);
    KPISummaryDetail.roadMap_WON();
    Thread.sleep(1000);
    KPISummaryDetail.roadMap_SolidAtRisk();
    Thread.sleep(1000);
    KPISummaryDetail.roadMap_WsrKeyStretch();
    
KDAllviewsComparison KDAllviewsComparison = PageFactory.initElements(driver, KDAllviewsComparison.class);     
    
    KDAllviewsComparison.views_SummaryDtl();
    
 KDTwistydata KDTwistydata = PageFactory.initElements(driver, KDTwistydata.class);   
    KDTwistydata.kd_TWisty();
    KDTwistydata.plusmiustwistie();
    KDTwistydata.dealsmatchtwistie();
    KDTwistydata.twistypagination();
	
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
		

    

    
    //KDlayout KDlayout = PageFactory.initElements(driver, KDlayout.class); 
    //KDlayout.gearIcon();
    
 Logoutprofile  landingpage= PageFactory.initElements(driver, Logoutprofile.class); 
    Thread.sleep(1000);
	landingpage.lOGINbackAndOutchecking();    
    
	
	}

}
