package org.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

    public static  WebDriver driver;
    public Logger logger;
    public Properties prop ;
    
    @BeforeClass(groups = {"sanity"  ,"master" })
    @Parameters ({"browser" , "os"})
    public void setup(String br , String  os) throws IOException , FileNotFoundException {

    	// configuration for logging purpose ( this loads the log4j2.xml file ) :
    	logger = LogManager.getLogger(this.getClass());
    	
    	//loading config.properties file :
    	
    	FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
    	prop = new Properties();
    	prop.load(file);
    	
  
//Following code checks if the executing envirionment is remote and executes accordingly(SELENIUM GRID)
    	if (prop.getProperty("exec_env").equalsIgnoreCase("remote")) {
    		DesiredCapabilities capabilities = new DesiredCapabilities();
    	
    	    // os
    	    if(os.equalsIgnoreCase("windows"))
    	    {
    	        capabilities.setPlatform(Platform.WIN11);
    	    }
    	    else if (os.equalsIgnoreCase("mac"))
    	    {
    	        capabilities.setPlatform(Platform.MAC);
    	    }
    	        else if (os.equalsIgnoreCase("linux")) {
    	        	
    	        	capabilities.setPlatform(Platform.LINUX);
					
				}
    	    
    	    else
    	    {
    	        System.out.println("No matching os");
    	        return;
    	    }

    	    // browser
    	    switch(br.toLowerCase())
    	    {
    	        case "chrome":  capabilities.setBrowserName("chromium"); break;
	            case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
    	        case "firefox" : capabilities.setBrowserName("firefox"); break;
    	            
    	        default: System.out.println("No matching browser");return;
	            
    	    }
    	    
    	    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    	}
    		
    	
    	
    	// FOR LOCAL ENVIRONMENT EXECUTION
    	
    	if (prop.getProperty("exec_env").equalsIgnoreCase("local")) {
    	switch (br.toLowerCase()) {
    	
    	
		case "chrome" :  WebDriverManager.chromedriver().setup(); driver= new ChromeDriver(); break;
		case "edge" : WebDriverManager.edgedriver().setup(); driver= new EdgeDriver(); break;
		case "firefox" : WebDriverManager.firefoxdriver().setup(); driver= new FirefoxDriver(); break;
		case "safari" : WebDriverManager.safaridriver().setup(); driver= new SafariDriver(); break;
			
		default: System.out.println("invalid browser launched "); return ;		
		}
    	
    	}
    	

        // Maximize browser
        driver.manage().window().maximize();

        // Delete all cookies
        driver.manage().deleteAllCookies();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Launch URL
        driver.get("https://tutorialsninja.com/demo/");
    }

    @AfterClass(groups = {"sanity"  ,"master" })
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    // Random alphabetic string
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    // Random numeric value
    public String randomNumber() {
        return RandomStringUtils.randomNumeric(5);
    }

    // Random alphanumeric value
    public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphabetic(3) + "@" +
               RandomStringUtils.randomNumeric(3);
    }
    
    
    // to capture screenshot and store it
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "/screenshots/"  + tname  + "_" + timeStamp
               
                + ".png";

        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
    
    
}




