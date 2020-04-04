package wrappers;

import org.testng.annotations.*;


public class ProjectWrappers extends GenericWrappers{
	
	public String browserName;
	public String app;
	
	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}
	
	@BeforeTest
	public void beforeTest() {
		//reserved
	}
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		startTest(testCaseName, testCaseDescription);
		switch (app) {
		case "formC":
			
			break;
		case "flipkart" :
			invokeApp(browserName, "http://www.irctc.co.in");
			break;
		default:
			invokeApp(browserName, "http://www.irctc.co.in");
			break;
		}
		
	}
	
	@AfterMethod
	public void afterMethod() {
		closeAllBrowsers();
	}
	
	@AfterClass
	public void afterClass() {
		endTest();
	}
	
	@AfterTest
	public void afterTest() {
		//reserved
	}
	
	@AfterSuite
	public void afterSuite() {
		endReport();
	}
	
	

}
