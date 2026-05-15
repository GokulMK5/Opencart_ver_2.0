
	package org.pageObjectPackage;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	public class MyAccountPage extends BasePage {

	    // Constructor
	    public MyAccountPage(WebDriver driver) {
	        super(driver);
	    }

	    // Locator

	    @FindBy(xpath = "//h2[text()='My Account']")
	    WebElement msgHeading;
	    
	    @FindBy (xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	    WebElement linklogout;

	    // Action Method

	    public boolean isMyAccountPageExists() {

	        try {
	            return (msgHeading.isDisplayed());
	            
	        } catch (Exception e) {
	            return false;
	        }
	       
	        
	    }public  void clicklogout() {
			// TODO Auto-generated method stub
	    	linklogout.click();
		}
	    
	    
	    
	    
	}
