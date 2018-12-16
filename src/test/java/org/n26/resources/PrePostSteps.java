package org.n26.resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.n26.resources.Reporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
@SuppressWarnings("rawtypes")
public class PrePostSteps {
	
	public static MobileDriver driver;
	public static WebDriverWait wait; 
   
	public static void setUp(String browserName){
		try {
			System.out.println("Initilizing Driver..."+ browserName);
			switch (browserName) {
//			case "Firefox":
//				if (driver == null) {
//					driver = new FirefoxDriver();
//				}
//				break;
//			case "IE":
//				if (driver == null) {
//					System.setProperty("webdriver.ie.driver","IEDriver//IEDriverServer.exe");
//					driver = new InternetExplorerDriver();
//				}
//				break;
//			case "Chrome":
//				if (driver == null) {
//					System.setProperty("webdriver.chrome.driver","ChromeDriver//chromedriver.exe");
//					driver = new ChromeDriver();
//				}
//				break;
			case "Mobile":
				if (driver == null) {
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("deviceName","Android8.0");
					capabilities.setCapability("platformName","Android");
					capabilities.setCapability("platformVersion","8.0");
					capabilities.setCapability("newCommandTimeout",600);
					capabilities.setCapability("androidInstallTimeout",300);
					capabilities.setCapability("app","C:\\CoCoin\\CoCoin.apk");
		            driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
				}
				break;
			}
//            wait = new WebDriverWait(driver, 30);
            Thread.sleep(10000);
//			driver.navigate().back();

		}
		catch(Exception e) {
			System.out.println("Exception Caught");
			e.printStackTrace();
		}
	}
	
	public static void afterMethod()
	{     
		System.out.println("in AfterMethod");
	        driver =  (AppiumDriver) getDriver();
	        if (driver == null) {
	            return;
	        }
	        driver.quit();
	        driver = null;
	        System.out.println("Closing driver");
	    }


	public static void capture() {
			// TODO Auto-generated method stub

		System.out.println("Taking and processing Screenshot");
	        try {
		    	TakesScreenshot ts = (TakesScreenshot)driver;
		        File source = ts.getScreenshotAs(OutputType.FILE);
		        String dest = System.getProperty("user.dir") +"/ErrorScreenshots/N26_"+new Date().getTime()+".png";
		        System.out.println(dest);
		        File destination = new File(dest);
				FileUtils.copyFile(source, destination);
		        Reporter.addScreenCaptureFromPath(dest,"Please review attached Screenshot");
		        System.out.println("Please review attached Screenshot");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        
	                     		
	 }
	  

	private static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
    
	
	public WebDriverWait getWebDriverWait(){
		return wait;
	}
}
