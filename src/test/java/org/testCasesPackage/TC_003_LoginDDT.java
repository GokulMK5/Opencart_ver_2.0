package org.testCasesPackage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.pageObjectPackage.HomePage;
import org.pageObjectPackage.LoginPage;
import org.pageObjectPackage.MyAccountPage;
import org.testBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;



// valid data - login successful - testcase passed - ( need to logout )
//              login unsucessful - testcase failed 

// invalid data - login successful - testcase failed - ( need to logout )
//                login unsuccessful - testcase passed 

public class TC_003_LoginDDT  extends BaseClass{

	
	@Test(dataProvider = "LoginData",dataProviderClass = org.utilityPackage.DataProviders.class,groups = {"datadriven"})
	private void verify_loginDDT(String email , String password , String expResult) {
		// TODO Auto-generated method stub

		logger.info(" **** login DDT testcase started ******  ");
		try {
			
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklinklogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean myaccmsg = macc.isMyAccountPageExists();
		
		
		
		if (expResult.equalsIgnoreCase("valid")) {
			
			if (myaccmsg==true) {
				macc.clicklogout();
				AssertJUnit.assertTrue(true);
				
			
			}
			else {
				AssertJUnit.assertTrue(false);
				
			}
			
		
		}
		
		if (expResult.equalsIgnoreCase("invalid")) {
			
			if (myaccmsg==true) {
				macc.clicklogout();
				AssertJUnit.assertTrue(false);
				
			
			}
			else {
				AssertJUnit.assertTrue(true);
				
			}
			
			
		}
		
		
		} catch (Exception e) {
			AssertJUnit.fail();
		}
		
		finally {
			logger.info(" **** login DDT testcase finished *****");
		}
		
	}
	
	
	
	
	
}
