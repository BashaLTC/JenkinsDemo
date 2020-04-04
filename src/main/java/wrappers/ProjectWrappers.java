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
			invokeApp(browserName, "http://www.irctc.co.in");
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
