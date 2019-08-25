package com.isd.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.isd.qa.base.TestBase;
import com.isd.qa.pages.ExpandDataTable;
import com.isd.qa.pages.HomePage;
import com.isd.qa.pages.ISDLoginPage;
import com.isd.qa.pages.Modifyprofile;
import com.isd.qa.pages.Logoutprofile;



public class ISDLoginTest extends TestBase {

	
@Test
public void initialpagelogin() throws Exception{
	 	
ISDLoginPage loginpage = PageFactory.initElements(driver, ISDLoginPage.class);

loginpage.setEmail("rajagre@in.ibm.com");
loginpage.setPassword("test2020@123456789");
loginpage.clickOnLoginButton();
	 
HomePage  Homepage= PageFactory.initElements(driver, HomePage.class); 

Thread.sleep(1000);  
Homepage.profilepic();
Thread.sleep(1000);
Homepage.Profiledropdown();
Thread.sleep(500);
Homepage.ClckOnNewProfile();
Thread.sleep(500);
Homepage.ClickOnUserRole();
Homepage.SelectBusinessUnits();
Thread.sleep(1000);
Homepage.promptclear();
Thread.sleep(500);
Homepage.ClickLevel10PropmtDropdown();
Homepage.SelectGBS();
Thread.sleep(200);
Homepage.ClickGeo0PropmtDropdown();
Thread.sleep(200);
Homepage.SelectNA();
Thread.sleep(200);
Homepage.ClickONCreateNewProfile();
Homepage.EnterProfileName();
Thread.sleep(200);
Homepage.EnterName();
Thread.sleep(200);
Homepage.EnterJobTitle();
Thread.sleep(200);
Homepage.EnterPhoneNumber();
Thread.sleep(200);
Homepage.EnterEmailId();
Thread.sleep(500);
Homepage.uploadimage();
Thread.sleep(500);
Homepage.ClickonSavebutton();

Modifyprofile Modifyprofile= PageFactory.initElements(driver,Modifyprofile.class);
Thread.sleep(1000);
Modifyprofile.MESGearicon();
Thread.sleep(1000);
Modifyprofile.MESnewfilterviews();
Thread.sleep(1000);
Modifyprofile.MESupdate();
Thread.sleep(1000);
Modifyprofile.Profiledropdown();
Thread.sleep(2000);
Modifyprofile.modifyprofile();
Thread.sleep(1000);
Modifyprofile.ClickonupdateProfile();
Thread.sleep(1000);
Modifyprofile.ClickonSavebutton();
Thread.sleep(1000);


ExpandDataTable expandtable= PageFactory.initElements(driver, ExpandDataTable.class);
    expandtable.ESexpandtable();
    Thread.sleep(500);
	expandtable.APexpandtable();
	Thread.sleep(500);
    expandtable.SPexpandtable();
    Thread.sleep(500);
    expandtable.RMexpandtable();
    
    
Logoutprofile  landingpage= PageFactory.initElements(driver, Logoutprofile.class); 
    Thread.sleep(1000);
	landingpage.lOGINbackAndOutchecking();
	
	
	}
    
    
    }



	 
	
	
