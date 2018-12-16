package org.n26.resources;


import org.junit.runner.RunWith;
import org.n26.resources.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;
import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        features = {"src/test/resources/org/n26/features/"},
        glue = {"org.n26.stepdefs"},
        plugin = {"org.n26.resources.ExtentCucumberFormatter:test-output/N26AutomationReport.html"}
)
public class N26AutomationRunner extends AbstractTestNGCucumberTests{
	
	@BeforeSuite
	public static void start(){
		System.out.println("Starting");
	}
	
	@BeforeMethod
	public static void beforeMethod(){
		System.out.println("Before Method");
		Reporter.setupEnv("Mobile");
	}
	
	@AfterMethod
	public static void afterMethod() throws IOException{
		Reporter.tearDownEnv();
	}
	
    @AfterSuite
    public static void setup() throws IOException {
    	System.out.println("In After Suite");
        Reporter.loadXMLConfig(new File("src/test/java/org/n26/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows 10");
        Reporter.setTestRunnerOutput("Sample test runner output message");
        System.out.println("Report file kept at: "+System.getProperty("user.dir")+"/test-output/N26AutomationReport.html");
    }
}
