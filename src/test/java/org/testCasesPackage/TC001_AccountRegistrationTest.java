package org.testCasesPackage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.pageObjectPackage.AccountRegistrationPage;
import org.pageObjectPackage.HomePage;
import org.testBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups = {"regression"  , "master",  "sanity"}) 
	public void verify_account_registration() throws InterruptedException {
		
		logger.info("  ***** Started  TC001_AccountRegistrationTest  *****  "  );
		
		
	try {
			
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();	
		logger.info("    ' clicked on  'My account' ' "  );
		hp.clickRegister();
	    logger.info("  ' clicked on 'Register' '  "  );
		  

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		
	    logger.info("  Providing all customer details "  );
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEmail(randomString() +"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		
		regpage.setPassword( password);
		regpage.setConfirmPassword(password);
		
		Thread.sleep(3000);
		regpage.clickPolicy();
		regpage.clickContinue();
		
		
 
	    logger.info("  ' validating expected message '  "  );
		String confirmationMessage = regpage.getConfirmationMessage();
		
		if (confirmationMessage.equals("Your Account Has Been Created!")) {
			
			AssertJUnit.assertTrue(true);

		    logger.info("  ' TEST PASSED '  "  );
			
			
		} else {
            
			logger.error(" TEST FAILED ");
			logger.debug("debug logs");
			AssertJUnit.assertTrue(false);
			
		}
		
		  }
	
	
		  
  catch (Exception e) {
		
		AssertJUnit.fail();
		
			}
		
	logger.info("  ***** Finished  TC001_AccountRegistrationTest  *****  "  );
	
	}
	
	
	

}
