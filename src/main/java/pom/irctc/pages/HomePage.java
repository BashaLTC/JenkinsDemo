package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers{
	
	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	
	
	public HomePage clickOnPopUp() {
		clickByXpath("(//button[@type='submit'])[1]");
		return this;
	}

	
	
	
	public HomePage clickOnLogin() {
		clickByXpath("//button[contains(text(),'LOGIN')]");
		return this;
	}
	
	public HomePage clickOnSideMenu() {
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[1]/div[3]/a/i");
		return this;
	}
	
	public HomePage clickOnAlert() {
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div[2]/div/form/div[2]/button");
		return this;
	}
	public RegistrationPage clickOnRegister() {
	clickByXpath("//div[@class='multibutton']//a[contains(text(),'REGISTER')]");
	return new RegistrationPage(driver, test);	
}
	public HomePage mouseOverOnStays(){
		mouseOver("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[5]/a");
		return this;
	}
	public AccomodationPage clickOnLounge() {
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[5]/ul/li[3]/a/span");
		return new AccomodationPage();
	}
	
}
