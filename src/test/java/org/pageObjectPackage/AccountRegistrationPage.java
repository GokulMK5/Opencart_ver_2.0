package org.pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage  extends BasePage{

	
	WebDriver driver;

    // Constructor
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstname;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastname;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    // Action Methods

    public void setFirstName(String fname) {
        txtFirstname.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastname.sendKeys(lname);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String phone) {
        txtTelephone.sendKeys(phone);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPassword(String cpwd) {
        txtConfirmPassword.sendKeys(cpwd);
    }

    public void clickPolicy() {
        chkPolicy.click();
    }

    public void clickContinue() {
        btnContinue.click();
        

        // 🔁 Alternative 1: submit
        // btnContinue.submit();

        // 🔁 Alternative 2: Actions class
        /*
        Actions act = new Actions(driver);
        act.moveToElement(btnContinue).click().perform();
        */

        // 🔁 Alternative 3: JavaScript click
        /*
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnContinue);
        */

        // 🔁 Alternative 4: Send ENTER key
        // btnContinue.sendKeys(Keys.RETURN);

        // 🔁 Alternative 5: Explicit Wait + Click
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
        */
        
        
    }
    
    
    

    public String getConfirmationMessage() {
        try {
            return msgConfirmation.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
	
	
	
	
	

