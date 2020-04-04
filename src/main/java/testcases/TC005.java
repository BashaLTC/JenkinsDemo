package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC005 extends ProjectWrappers{
	
	@BeforeClass
	public void setvariables(){
	     testCaseName= "TC001";
	     testCaseDescription="To verify Irctc Signup";
	     author="Kanmani";
	     category="Functional";
	     browserName="chrome";
	     app="Irctc";
	    
	}
	
	@Test
	public void irctcSignUp() {
		
		new HomePage(driver,test)
		.clickOnPopUp()
		.clickOnSideMenu()
		.clickOnLogin()
		.clickOnRegister()
		.waitForRegistrationPage(5000)
		.enterUserName("Kanmani")
		.enterPswd("Kanbilla")
		.enterConPswd("Kanbilla")
		.keyboardOperation("Pagedown")
		.waitForRegistrationPage(3000);
		//.enterSecurityAns("Kanna")
		/*.()
		.clickOnLanguageOption()
		.enterName("Kanmani")
		.clickOnGenderFemale()
		.clickOnBirthDate()
		.clickOnBirthMonth("Feb")
		.clickonBirthYear("1990")
		.clickOnOccupation()
		.clickOnOccupationOption()
		.clickOnUnmarried()
		.selectCountry("India")
		.enterEmail("Kanmaninagarajan007@gmail.com")
		.enterMobileNumber("8946028612")
		.selectNationality("India")
		.enterDoorNo("17a West Nappalaya Street")
		.enterStreetName("East Masi")
		.enterAreaName("East Masi")
		.enterPincode("626501")
		.ClickOnState()
		.selectCity("Madurai")
		.clickOnPostOffice()
		.selectPostOffice("")
		.enterPhoneNo("8946028612")
		.clickNoOnOfficeAddress()
		.clickOnIAgree();*/
		
	}

}
