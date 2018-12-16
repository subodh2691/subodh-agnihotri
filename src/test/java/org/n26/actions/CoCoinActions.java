package org.n26.actions;

import java.time.Duration;

import org.n26.objectrepo.CoCoinMobileObjects;
import org.n26.resources.PrePostSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CoCoinActions {

	private PrePostSteps prePostSteps;
	private MobileDriver driver;
	private WebDriverWait wait;

	public CoCoinActions(PrePostSteps obj) {
		prePostSteps = obj;
		driver = obj.driver;
		wait = obj.wait;
		// this.test=testReport.test;
	}
	
	public boolean launch_app() {
		try {
			for(int i=0; i<4; i++)
    		{
    			System.out.println("Performing swipe operation");
    			TouchAction action = new TouchAction(driver);
    			action.press(PointOption.point(1300, 400)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300))).moveTo(PointOption.point(100, 400)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)));
                Thread.sleep(3000);
    		}
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean enter_and_confirm_passcode(String passcode) {
		CoCoinMobileObjects mobileObj = new CoCoinMobileObjects(driver);
		try {
			for(int i=0;i<=1;i++)
			{
				String[] passcodes = passcode.split("");
		        for(String password : passcodes)
		        {
		        	System.out.println("First letter for password is "+password);
		        	mobileObj.btnCatOrNum(password).click();
		        }
		        Thread.sleep(3000);
			}
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean check_main_page() {
		CoCoinMobileObjects mobileObj = new CoCoinMobileObjects(driver);
		try {
			mobileObj.lnkMenu.isDisplayed();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			PrePostSteps.capture();
			return false;
		}
	}
	
	public boolean add_transaction(String category, String Amount)
	{
		CoCoinMobileObjects mobileObj = new CoCoinMobileObjects(driver);
		try {
			mobileObj.btnCatOrNum(category).click();
			Thread.sleep(2000);
			String[] amt = Amount.split("");
		    for(String number : amt)
		    {
		      	mobileObj.btnCatOrNum(number).click();
		    }
			mobileObj.btnSubmit.click();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean click_menu_with_password(String password)
	{
		CoCoinMobileObjects mobileObj = new CoCoinMobileObjects(driver);
		try {
			
			mobileObj.lnkMenu.click();
			Thread.sleep(2000);
			String[] passcodes = password.split("");
	        for(String passwd : passcodes)
	        {
	        	System.out.println("First letter for password is "+passwd);
	        	mobileObj.btnCatOrNum(passwd).click();
	        }
	        Thread.sleep(5000);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean verify_total(String total)
	{
		CoCoinMobileObjects mobileObj = new CoCoinMobileObjects(driver);
		try {
//			wait.until(ExpectedConditions.visibilityOf(mobileObj.lblTotal));
			String actualTotal = mobileObj.lblTotal.getText();
			actualTotal=actualTotal.trim();
			System.out.println("Expected value is "+total+" and actual is "+actualTotal);
			if(actualTotal.equalsIgnoreCase(total)){
				return true;
			}
			else {
				PrePostSteps.capture();
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean select_tab(String tile)
	{
		CoCoinMobileObjects mobileObj = new CoCoinMobileObjects(driver);
		try {
			mobileObj.btnCatOrNum(tile).click();
			Thread.sleep(3000);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean verify_msg(String msg)
	{
		CoCoinMobileObjects mobileObj = new CoCoinMobileObjects(driver);
		try {
			String actualMsg = mobileObj.lblSpendMsg.getText();
			if(actualMsg.equalsIgnoreCase(msg)){
				return true;
			}
			else {
				PrePostSteps.capture();
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
