package com.isd.qa.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.isd.qa.base.TestBase;
import com.isd.qa.pages.ISDLoginPage;
import com.isd.qa.pages.Logoutprofile;

public class LogoutProfile extends TestBase {
	
	
@Test
public void Modifyprofilepage() throws InterruptedException {
		
		
ISDLoginPage loginpage = PageFactory.initElements(driver, ISDLoginPage.class);

		loginpage.setEmail("rajagre@in.ibm.com");
		loginpage.setPassword("test2020@123456789");
		loginpage.clickOnLoginButton();
			 
Logoutprofile  landingpage= PageFactory.initElements(driver, Logoutprofile.class); 
        Thread.sleep(1000);
		landingpage.lOGINbackAndOutchecking();
		
		
		}

}
