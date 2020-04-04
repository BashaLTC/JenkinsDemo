package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting {
	
	public static ExtentReports report;
	public ExtentTest test;
	
	public String testCaseName,testCaseDescription;
	public String author, category;
	
	public void startReport() {
		
		long time=System.currentTimeMillis();
		
		 report = new ExtentReports("./reports/Result_"+time+".html",false);
	}
	
	public void startTest(String testName, String description) {
		 test=report.startTest(testName, description);
		 test.assignAuthor(author);
		 test.assignCategory(category);
	}
	
	public void reportStep(String details, String status) {
		if(status.equalsIgnoreCase("pass")) {
		test.log(LogStatus.PASS, details);
		}else if(status.equalsIgnoreCase("fail")) {
			test.log(LogStatus.FAIL, details);
		}else if(status.equalsIgnoreCase("info")) {
			test.log(LogStatus.INFO, details);
		}else if(status.equalsIgnoreCase("warning")) {
			test.log(LogStatus.WARNING, details);
		}
	}
	
	public void endTest() {
		report.endTest(test);
	}
	
	public void endReport() {
		report.flush();
	}
	
}
