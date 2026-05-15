package org.pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	WebDriver driver ;
	
	//constructor
	public HomePage(WebDriver driver) {
		
	super(driver);
		
	
	}
	
	
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	
  WebElement linkMyaccount;
	
	@FindBy (xpath="//a[normalize-space()='Register']")
	
	WebElement linkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement linkLogin;
	
	
	// action methods
	public void clickMyAccount() {
		// TODO Auto-generated method stub
		linkMyaccount.click();
	}
	
public void clickRegister() {
	// TODO Auto-generated method stub
	linkRegister.click();
	
}

 public void clicklinklogin() {
	// TODO Auto-generated method stub
	linkLogin.click();

}



}
