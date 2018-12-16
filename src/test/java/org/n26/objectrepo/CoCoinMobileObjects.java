package org.n26.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

@SuppressWarnings("rawtypes")
public class CoCoinMobileObjects {

	MobileDriver driver;
	
	public CoCoinMobileObjects (MobileDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@instance=10]")
	public AndroidElement btnErase;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@instance=11]")
	public AndroidElement btnSubmit;
	
	@AndroidFindBy(id="com.nightonke.cocoin:id/content_hamburger")
	public AndroidElement lnkMenu;
	
	@AndroidFindBy(id="com.nightonke.cocoin:id/expanse")
	public AndroidElement lblTotal;
	
	@AndroidFindBy(id="com.nightonke.cocoin:id/title")
	public AndroidElement lblSpendMsg;
	
	@AndroidFindBy(id="com.nightonke.cocoin:id/buttonDefaultPositive")
	public AndroidElement btnGet;
	
	String btnNumber="//android.widget.TextView[@text='CatOrNum']"	;
	public AndroidElement btnCatOrNum(String CatOrNum) {
        return (AndroidElement) driver.findElement(By.xpath(btnNumber.replace("CatOrNum", CatOrNum)));
	}
}
