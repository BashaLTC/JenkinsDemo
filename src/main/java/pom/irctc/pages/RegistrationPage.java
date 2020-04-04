package pom.irctc.pages;



import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class RegistrationPage extends GenericWrappers{

	public RegistrationPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public RegistrationPage waitForRegistrationPage(int time) {
		thread(time);
		return this;
	}
	public RegistrationPage keyboardOperation(String action) {
		keyBoardOperationXpath("./html/body", action);
		return this;
	}
	public RegistrationPage enterUserName(String data) {
		enterById("userName", data);
		return this;
	}
	public RegistrationPage enterPswd(String data) {
		enterById("usrPwd", data);
		return this;
	}
	public RegistrationPage enterConPswd(String data) {
		enterById("cnfUsrPwd", data);
		return this;
	}
	public RegistrationPage selectSecurityQues(String data) {
		selectVisibleTextByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[4]/div[2]/p-dropdown/div/label", data);
		return this;
	}
	public RegistrationPage enterSecurityAns(String data) {
		enterByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[4]/div[4]/input", data);
		return this;
	}
	public RegistrationPage selectLang(int value) {
		selectIndexByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[5]/div[2]/p-dropdown/div/label", value);
		return this;
	}
	public RegistrationPage enterName(String data) {
		enterById("firstName", data);
		return this;
	}
	public RegistrationPage clickOnGender() {
		clickById("F");
		return this;
	}
	public RegistrationPage enterDob(String data) {
		enterById("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[9]/div[2]/p-calendar/span/input", data);
		return this;
	}
	public RegistrationPage selectOccupation(int value) {
		selectIndexByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[9]/div[4]/p-dropdown/div/label", value);
		return this;
	}
	public RegistrationPage clickMaritalStatus() {
		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[10]/div[2]/label[2]/input");
		return this;
	}
	public RegistrationPage selectCountry(String data) {
		selectVisibleTextByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[11]/div[2]/select", data);
		return this;
	}
	public RegistrationPage enterEmail(String data) {
		enterById("email", data);
		return this;
	}
	public RegistrationPage enterMobile(String data) {
		enterById("mobile", data);
		return this;
	}
	public RegistrationPage selectNationality(String data) {
		selectVisibleTextByXpath("//*[@id=\"divMain\"]/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[12]/div[5]/select", data);
		return this;
	}
	public RegistrationPage enterBlockNo(String data) {
		enterById("resAddress1", data);
		return this;
	}
	public RegistrationPage enterStreet(String data) {
		enterById("resAddress2", data);
		return this;
	}
	public RegistrationPage enterArea(String data) {
		enterById("resAddress3", data);
		return this;
	}
	public RegistrationPage enterPincode(String data) {
		enterByName("resPinCode", data);
		return this;
	}
	public RegistrationPage clickState() {
		clickById("resState");
		return this;
	}
	public RegistrationPage selectCity(int value) {
		selectIndexByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[16]/div[4]/select", value);
		return this;
	}
	public RegistrationPage selectPostOffice(int value) {
		selectIndexByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[17]/div[2]/select", value);
		return this;
	}
	public RegistrationPage enterPhoneNo(String data) {
		enterById("resPhone", data);
		return this;
	}
	public RegistrationPage clickCopyAddress() {
		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[18]/div[3]/input");
		return this;
	}
	public RegistrationPage clickOnTnC() {
		clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[21]/div/input");
		return this;
	}
}
