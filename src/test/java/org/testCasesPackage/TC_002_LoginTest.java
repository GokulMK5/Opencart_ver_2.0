package org.testCasesPackage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.pageObjectPackage.HomePage;
import org.pageObjectPackage.LoginPage;
import org.pageObjectPackage.MyAccountPage;
import org.testBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC_002_LoginTest extends BaseClass {

	
	@Test(groups = {"sanity"  , "master"})
	private void verify_login() {
		// TODO Auto-generated method stub
		
		logger.info("******** strted   TC_002_LoginTest testcase ******* ");
		try {
			
	
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklinklogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail("gokul.manivannan12@gmail.com");
		lp.setPassword("user@12345");
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean myaccmsg = macc.isMyAccountPageExists();
		
		
		if (myaccmsg==true) {
			
			logger.info(" test case - verify login passed ");
			AssertJUnit.assertTrue(true);

			
		} else {

			logger.info(" test case - verify login failed ");
			AssertJUnit.fail();
		
			
		}
		
	}
 catch (Exception e) {
		// TODO: handle exception
	 AssertJUnit.fail(e.getMessage());
	}
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
