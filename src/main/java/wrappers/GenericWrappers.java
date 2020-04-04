package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.Select;

import utils.Reporting;



public class GenericWrappers extends Reporting implements Wrappers{
	
	public RemoteWebDriver driver;
	int i;
	

	public void invokeApp(String browser, String url) {
		
		try {
			if(browser.equalsIgnoreCase("chrome"))	{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			 driver=new ChromeDriver();
			}else if(browser.equalsIgnoreCase("Firefox"))
			{
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			 driver=new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("IE"))
			{
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			reportStep("The browser "+browser+" is launched with url "+url+" successfully", "pass");
			
			
			} catch (SessionNotCreatedException e) {
				
				reportStep("The browser: "+browser+" is not launched due to session not created error", "fail");
		
			
			}
			catch (WebDriverException e) {
				
				reportStep("The browser: "+browser+" is not launched due to unknown error", "fail");
			
		}
		}
		

	public void enterById(String idValue, String data) {
		
		try {
			driver.findElementById(idValue).sendKeys(data);
			reportStep("The element with id "+idValue+" is entered with data "+data,"Pass");
			
		} catch (NoSuchElementException e) {
			reportStep("The element with id"+idValue+"is not found in DOM","fail");
			
		}
		
		catch (ElementNotVisibleException e) {
			reportStep("The element with id"+idValue+"is not Visible in Application","fail");
			
		}
		
		catch (ElementNotInteractableException e) {
			reportStep("The element with id"+idValue+"is not Interactable in the Application","fail");
			
		}
		
		catch (StaleElementReferenceException e) {
			reportStep("The element with id"+idValue+"is not Stable","fail");
			
		}
		
		catch (WebDriverException e) {
			reportStep("The element with id"+idValue+"is not found due to unknow error ","fail");
			
		}
		
		}


	public void enterByName(String nameValue, String data) {
		
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			reportStep("The element with name "+nameValue+" is entered with data "+data,"Pass");
			
		}
		catch (NoSuchElementException e) {
			reportStep("The element with name"+nameValue+"is not found in DOM","fail");
			
		}
		
		catch (ElementNotVisibleException e) {
			reportStep("The element with name"+nameValue+"is not Visible in Application","fail");
			
		}
		
		catch (ElementNotInteractableException e) {
			reportStep("The element with name"+nameValue+"is not Interactable in the Application","fail");
			
		}
		
		catch (StaleElementReferenceException e) {
			reportStep("The element with name"+nameValue+"is not Stable","fail");
			
		}
		
		catch (WebDriverException e) {
			reportStep("The element with name"+nameValue+"is not found due to unknow error ","fail");
			
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			reportStep("The element with xpath "+xpathValue+" is entered with data "+data,"Pass");
			
		} catch (NoSuchElementException e) {
			reportStep("The element with xpath"+xpathValue+"is not found in DOM","fail");
			
		}
		
		catch (ElementNotVisibleException e) {
			reportStep("The element with xpath"+xpathValue+"is not Visible in Application","fail");
			
		}
		
		catch (ElementNotInteractableException e) {
			reportStep("The element with xpath"+xpathValue+"is not Interactable in the Application","fail");
			
		}
		
		catch (StaleElementReferenceException e) {
			reportStep("The element with xpath"+xpathValue+"is not Stable","fail");
			
		}
		
		catch (WebDriverException e) {
			reportStep("The element with xpath"+xpathValue+"is not found due to unknow error ","fail");
			
		}
	}

	public void verifyTitle(String title) {
		
		try {
			String Titlename=driver.getTitle();
			
			if(Titlename.equalsIgnoreCase(title)){
				reportStep("The Title of Browser  is : " +Titlename+ " matched with" +title+ " successfully","Pass");
			}else
				reportStep("The Title of Browser is : " +Titlename+ " is not matched " +title,"Pass");
					
		} catch (NoSuchElementException e) {
			
			reportStep("The element with title "+title+" is not found in the DOM","Fail");
		}catch (ElementNotVisibleException e) {
			
			reportStep("The element with title "+title+" is not visible in the application","Fail");
			
		}catch (ElementNotInteractableException e) {
			
			reportStep("The element with title "+title+" is not interactable in the application","Fail");
		
		}	
		catch (NotFoundException e) {
			
			reportStep("The element with title "+title+" is not found in the DOM","Fail");
		}
		catch (WebDriverException e) {

			reportStep("The element with title "+title+" is not found in the application due to unknown error","Fail");
		}
	}

	public void verifyTextById(String id, String text) {
		
		try {
			String VerifyText = driver.findElementById(id).getText();
			if(VerifyText.equalsIgnoreCase(text)){
				reportStep("The element with id of text: " +text+ " is matched with " +VerifyText+ " successfully","Pass");
			}else
				reportStep("The element with id of text: " +text+ " is not  matched with " +VerifyText,"Pass");
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with id of text"+text+"is not found in DOM","Fail");
			
		}
		
		catch (ElementNotVisibleException e) {
			reportStep("The element with id of text"+text+"is not Visible in Application","Fail");
			
		}
		
		catch (ElementNotInteractableException e) {
			reportStep("The element with id"+text+"is not Interactable in the Application","Fail");
			
		}
		
		catch (StaleElementReferenceException e) {
			reportStep("The element with id"+text+"is not Stable","Fail");
			
		}
		
		catch (WebDriverException e) {
			reportStep("The element with id"+text+"is not found due to unknow error ","fail");
			
		}	
	}

	public void verifyTextByXpath(String xpath, String text) {
		

		try {
			String VerifyText = driver.findElementByXPath(xpath).getText();
			if(VerifyText.equalsIgnoreCase(text)){
				reportStep("The element with xpath of text: " +text+ " is matched with " +VerifyText+ " successfully","Pass");
			}else
				reportStep("The element with xpath of text: " +text+ " is not  matched with " +VerifyText,"Pass");
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath of text"+text+"is not found in DOM","Fail");
			
		}
		
		catch (ElementNotVisibleException e) {
			reportStep("The element with xpath of text"+text+"is not Visible in Application","Fail");
			
		}
		
		catch (ElementNotInteractableException e) {
			reportStep("The element with xpath"+text+"is not Interactable in the Application","Fail");
			
		}
		
		catch (StaleElementReferenceException e) {
			reportStep("The element with xpath"+text+"is not Stable","Fail");
			
		}
		
		catch (WebDriverException e) {
			reportStep("The element with xpath"+text+"is not found due to unknow error ","Fail");
			
		}	
	}
	public void verifyTextContainsByXpath(String xpath, String text) {
		
		
		try {
			String xpathtext= driver.findElementByXPath(xpath).getText();
			if (xpathtext.contains(text)){
				reportStep("The element with Xpath:"+xpath+"with the value: "+xpathtext+" is matched with the given text:"+text+" ","Pass");
			}
			else{
				reportStep("The element with Xpath: " +xpath+ " with the value: "+xpathtext+" is not matched with the given text:"+text+"","Pass");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with Xpath:"+xpath+ " is not found in the DOM","Fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element with Xpath:"+xpath+ " is not visible in the application","fail");
		} catch (StaleElementReferenceException e){
			reportStep("The element with  Xpath:"+xpath+ " is not stable","fail");
		} catch (WebDriverException e){
			reportStep("The element with  Xpath:"+xpath+ " is not matched with the text: "+text+" due to some unknown error","fail");
		}
	}
	public void clickById(String id) {
		
		try {
			driver.findElementById(id).click(); 
			reportStep("The element with id: " +id+ " got clicked successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element with id: " +id+ " is not found in the DOM","fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element with id: " +id+ " is not visible in the application","fail");
		} catch (ElementClickInterceptedException e){
			reportStep("The element with id: " +id+ " is not in clickable form","fail");
		} catch (StaleElementReferenceException e){
			reportStep("The element with id: " +id+ " is not stable","fail");
		} catch (WebDriverException e){
			reportStep("The element with id: " +id+ " is not clicked due to some unknown error","fail");
		}
			
	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			reportStep("The element with Classname: " +classVal+ " got clicked successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element with classname: " +classVal+ " is not found in DOM" ,"fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element with classname: " +classVal+ " is not visible in the application","fail");
		} catch (ElementClickInterceptedException e){
			reportStep("The element with classname: " +classVal+ " is not clickable in the application","fail");
		}catch(StaleElementReferenceException e) {
			reportStep("The element with classname: " +classVal+ " is not stable","fail");
		}catch(WebDriverException e){
			reportStep("The element with classname: " +classVal+ " is not clicked due to unknown error","fail");
		}
	}

	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			reportStep("The element with name: " +name+ " is clickable successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element with name: " +name+ " is not found in the DOM","fail");
		} catch(ElementNotVisibleException e){
			reportStep("The element with name: " +name+ " is not visible in the application","fail");
		} catch (ElementClickInterceptedException e){
			reportStep("The element with name: " +name+ " is not clickable in the application","fail");
		} catch (StaleElementReferenceException e){
			reportStep("The element with name: " +name+ " is not stable","fail");
		}catch (WebDriverException e){
			reportStep("The element with name: " +name+ " is not clicked due to unknown error","fail");
		}
	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			reportStep("The element with Linktext: " +name+ " is got clicked successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element with Linktext: " +name+ " is not found in DOM","fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element with Linktext: " +name+ " is not visible in the application","fail");
		} catch (ElementClickInterceptedException e){
			reportStep("The element with Linktext: " +name+ " is not in clickable format","fail");
		} catch(StaleElementReferenceException e){
			reportStep("The element with Linktext: " +name+ " is not stable","fail");
		} catch(WebDriverException e){
			reportStep("The element with Linktext: " +name+ " is not clicked due to unknown error","fail");
		}
		
	}

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByXPath(name).click();
			reportStep("the element xpath "+name+" is clicked successfully","Pass");

		} 
		catch (NoSuchElementException e) {
			reportStep("the element xpath "+name+" is not found in this DOM","fail");	
		}

		catch(ElementClickInterceptedException e){
			reportStep("the element xpath "+name+" is not clickable in the Application","fail");
		}

		catch(ElementNotInteractableException e){
			reportStep("the element xpath "+name+" is not interactable in the Application","fail");
		}
		catch(StaleElementReferenceException e){
			reportStep("the element Xpath "+name+" is not stable in the Application","fail");
		}
		catch(WebDriverException e){
			reportStep("the element xpath "+name+" is not found due to unknown error","fail");
		}
		
	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			reportStep("The element with XPath: " +xpathVal+ " is clicked successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element with XPath: " +xpathVal+ " is not found in DOM","fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element with XPath: " +xpathVal+ " is not visible in the application","fail");
		} catch (ElementClickInterceptedException e){
			reportStep("The element with XPath: " +xpathVal+ " is not in clickable format","fail");
		} catch (StaleElementReferenceException e){
			reportStep("The element with XPath: " +xpathVal+ " is not stable","fail");
		} catch (WebDriverException e){
			reportStep("The element with XPath: " +xpathVal+ " is not clicked due to unknown error","fail");
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			reportStep("The element with XPath: " +xpathVal+ " is clicked successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element with XPath: " +xpathVal+ " is not found in DOM","fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element with XPath: " +xpathVal+ " is not visible in the application","fail");
		} catch (StaleElementReferenceException e){
			reportStep("The element with XPath: " +xpathVal+ " is not stable","fail");
		} catch (WebDriverException e){
			reportStep("The element with XPath: " +xpathVal+ " is not clicked due to unknown error","fail");
		}
		
	}

	public String getTextById(String idVal) {
		
		String xpathtext=null;
		try {
			xpathtext = driver.findElementById(idVal).getText();
			reportStep("The text value of the element id: " +idVal+ " is " +xpathtext+ " using gettext method successfully","Pass");
			
		} catch (NoSuchElementException e) {
			reportStep("The element id: " +idVal+ " is not found in DOM ","fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element id: " +idVal+ " is not visible in the application","fail");
		}catch (StaleElementReferenceException e){
			reportStep("The element id: " +idVal+ " is not stable","fail");
		} catch (WebDriverException e){
			reportStep("The element id: " +idVal+ " is not returned text due to unknown error","fail");
		} 
		return xpathtext;
	}

	public String getTextByXpath(String xpathVal) {
		String TxtXpath=null;
		try {
			TxtXpath = driver.findElementByXPath(xpathVal).getText();
			reportStep("The element with Xpath: " +xpathVal+ " having a value: " +TxtXpath+ " has run successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element with Xpath: " +xpathVal+ " is not found in DOM","fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element with Xpath: " +xpathVal+ " is not visible in the application","fail");
		} catch (StaleElementReferenceException e){
			reportStep("The element with XPath: " +xpathVal+ " is not stable","fail");
		} catch (WebDriverException e){
			reportStep("The element with Xpath: " +xpathVal+ " is not returned the text due to unknown error","fail");
		} 
			
		return TxtXpath;
	}

	public void selectVisibileTextById(String id, String value) {
		try {
			WebElement Sel = driver.findElementById(id);
			Select sl = new Select(Sel);
			sl.selectByVisibleText(value);
			reportStep("The element id: " +id+ " With the visible text value: " +value+ " got selected from dropdown successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element id: " +id+ " not found in the DOM","fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element id: " +id+ " is not visible in the application","fail" );
		} catch (ElementNotSelectableException e){
			reportStep("The element id: " +id+ " with the value: " +value+ " is not selectable from the dropdown","fail");
		} catch (StaleElementReferenceException e){
			reportStep("The element id: " +id+ " is not stable","fail");
		} catch (WebDriverException e){
			reportStep("The element id: " +id+ " with the visible text value: " +value+ " is not selected due to unknown error","fail");
		}
	}

	public void selectIndexById(String id, int value) {
		try {
			WebElement Indexvalue=driver.findElementById(id);
			Select scindex=new Select(Indexvalue);
			scindex.selectByIndex(value);
			reportStep("The element id: " +id+ " with the index value: " +value+ " got selected from dropdown successfully","Pass");

		}catch (NoSuchElementException e) {
			reportStep("The element with "+id+" and the value "+value+" is not found in DOM","fail");
		}
		catch(ElementNotSelectableException e){
			reportStep("The element with "+id+" is not selectable in the Application","fail");
		}
		catch(ElementNotVisibleException e){
			reportStep("The element with "+id+" is not visible in the APPlication","fail");

		}
		catch(StaleElementReferenceException e){
			reportStep("The element with "+id+" is not stable in the Application","fail");	
		}
		catch(WebDriverException e){
			reportStep("The element with the "+id+" and "+value+" is not found due to unknown error","fail");
		}
	}
	
	public void selectVisibleTextByXpath(String id, String value) {
		try {
			WebElement Indexvalue=driver.findElementByXPath(id);
			Select scindex=new Select(Indexvalue);
			scindex.selectByVisibleText(value);
			reportStep("The element id: " +id+ " with the index value: " +value+ " got selected from dropdown successfully","Pass");

		}catch (NoSuchElementException e) {
			reportStep("The element with "+id+" and the value "+value+" is not found in DOM","fail");
		}
		catch(ElementNotSelectableException e){
			reportStep("The element with "+id+" is not selectable in the Application","fail");
		}
		catch(ElementNotVisibleException e){
			reportStep("The element with "+id+" is not visible in the APPlication","fail");

		}
		catch(StaleElementReferenceException e){
			reportStep("The element with "+id+" is not stable in the Application","fail");	
		}
		catch(WebDriverException e){
			reportStep("The element with the "+id+" and "+value+" is not found due to unknown error","fail");
		}
	}

	public void switchToParentWindow() {
		try {
			Set<String> firstwindow=driver.getWindowHandles();
			reportStep("The opened sessions are "+firstwindow,"Pass");
			for(String eachid: firstwindow) {
				driver.switchTo().window(eachid);
				break;
			}
			reportStep("The driver has been successfully switched to parent Window ID "+firstwindow+" ","fail");			

		}   catch (SessionNotCreatedException e) {
			reportStep("the current window is with session not displayed","fail");
		}
		catch(WebDriverException e){
			reportStep("unable to find the parentwindow due to unknown error","fail");

		}		
	}

	public void switchToLastWindow() {
		try {
			Set<String> nextwindow=driver.getWindowHandles();
			reportStep("The opened sessions are "+nextwindow,"Pass");
			for(String eachid: nextwindow) {
				driver.switchTo().window(eachid);
			}
			reportStep(" driver moved to last window in all opened sessions","fail");
		} catch (SessionNotCreatedException e) {
			reportStep("Only one session is found currently","fail");
		}
		catch (NoSuchElementException e) {
			reportStep("child window doesnot found","fail");
		}catch (WebDriverException e) {

			reportStep("unable to switch the window due to unknown error","fail");
		}
		
	}

	public void acceptAlert() {

		try {
			driver.switchTo().alert().accept();
			reportStep("the alert has been accepted","Pass");
		} 
		catch(UnhandledAlertException e){
			reportStep("unhandled this alert","fail");            				
		}
		catch (NoAlertPresentException e) {
			reportStep("there is no alert presently","fail");
		}
		catch(WebDriverException e){
			reportStep("alert not handled due to unknown error","fail");
		}
		
		
	}

	public void dismissAlert() {
		
		try {
			driver.switchTo().alert().dismiss();
			reportStep("the alert has been dismissed","fail");
		} catch(UnhandledAlertException e){
			reportStep("unhandled this alert","fail");            				
		}
		catch (NoAlertPresentException e) {
			reportStep("there is no alert presently","fail");
		}
		catch(WebDriverException e){
			reportStep("alert not handled due to unknown error","fail");
		}
	}

	public String getAlertText() {
		String Alerttext=null;
		
			try {
			Alerttext= driver.switchTo().alert().getText();
			reportStep("The message from alert is:"+Alerttext+"got successfully","Pass");

		} catch (UnhandledAlertException e) {
			reportStep("the alert is not hnadled","fail");
		}
		catch(WebDriverException e){
			reportStep("the alert is not found due to unknown error","fail");
		}
		
		
		return Alerttext;
	}

	public void takeSnap() {
		
		try {
			File scr= driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("./ScreenShots/snap"+i+".png");
		FileUtils.copyFile(scr, dest);
			i++;
			
		} catch (IOException e) {
			reportStep("Issue in Input and Output Operation","fail");
		} catch (ScreenshotException e){
			reportStep("It is impossible to capture a screen","fail");
		} catch (WebDriverException e) {
			reportStep("The screenshot is not captured due to unknown error","fail");
		} 
		
	}

	public void closeBrowser() {
		try {
			driver.quit();
			reportStep("All Browser tabs are closed successfully","pass");
		} catch (UnreachableBrowserException e) {
			reportStep("The browser is not opened or already closed by user","fail");
		} catch(SessionNotCreatedException e){
			reportStep("The browser is not launched so sessionid is not created","fail");
		} catch(WebDriverException e){
			reportStep("The all browsers are not closed due to unknown error","fail");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("All Browser tabs are closed successfully","pass");
		} catch (UnreachableBrowserException e) {
			reportStep("The browser is not opened or already closed by user","fail");
		} catch(SessionNotCreatedException e){
			reportStep("The browser is not launched so sessionid is not created","fail");
		} catch(WebDriverException e){
			reportStep("The all browsers are not closed due to unknown error","fail");
		}
		
	}


	public void mouseOver(String xpath) {
		WebElement mouseover;
		try {
		mouseover = driver.findElementByXPath(xpath);
		mouseover.click();
			Actions acc = new Actions(driver);
			acc.moveToElement(mouseover).perform();
			reportStep("Mouseover Action successfully","Pass");
		}catch (NoSuchElementException e) {
			reportStep("The element with xpath "+xpath+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			reportStep("The element with xpath "+xpath+" is not visible in the application","fail");
		}catch (ElementClickInterceptedException e) {
			reportStep("The elememt with xpath "+xpath+" is not clickable in the application","fail");
		}catch (ElementNotInteractableException e) {
			reportStep("The element with xpath "+xpath+" is not interactable","fail");
		}catch (StaleElementReferenceException e) {
			reportStep("The element with xpath "+xpath+ " is not stable in the application","fail");
		}catch (InvalidElementStateException e) {
			reportStep("the element with xpath "+xpath+ " is inavlid and Selenium is unable to perfor any operatio on that element","fail");
		}catch (NotFoundException e) {
			reportStep("The element with xpath "+xpath+" is not found in the DOM","fail");
		}catch (WebDriverException e) {
			reportStep("The element with xpath "+xpath+" is not clicked due to unknown error","fail");
		}finally {
			
		}
		}

	public void thread(int data) {
		try {
			Thread.sleep(data);
			reportStep("thread has been taken successfully and waited for the given time", "pass");
		} catch (InterruptedException e) {
			reportStep("The element interuppeted with the application", "fail");
		} catch (WebDriverException e) {
			reportStep("The element in select class is not displayed due to an unknown error", "fail");
		}
		 
	}


	public void selectVisibleTextByName(String name, String value) {
		try {
			WebElement namevalue=driver.findElementByName(name);
			Select scindex=new Select(namevalue);
			scindex.selectByVisibleText(value);
			reportStep("The element name: " +name+ " with the index value: " +value+ " got selected from dropdown successfully","Pass");

		}catch (NoSuchElementException e) {
			reportStep("The element with name "+name+" and the value "+value+" is not found in DOM","fail");
		}
		catch(ElementNotSelectableException e){
			reportStep("The element with "+name+" is not selectable in the Application","fail");
		}
		catch(ElementNotVisibleException e){
			reportStep("The element with "+name+" is not visible in the APPlication","fail");

		}
		catch(StaleElementReferenceException e){
			reportStep("The element with "+name+" is not stable in the Application","fail");	
		}
		catch(WebDriverException e){
			reportStep("The element with the "+name+" and "+value+" is not found due to unknown error","fail");
		}
		finally{
			takeSnap();
		} 
		
	}


	public void selectVisibileTextByXpath(String xpath, String value) {
		try {
			WebElement Sel = driver.findElementByXPath(xpath);
			Select sl = new Select(Sel);
			sl.selectByVisibleText(value);
			reportStep("The element id: " +xpath+ " With the visible text value: " +value+ " got selected from dropdown successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element id: " +xpath+ " not found in the DOM","fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element id: " +xpath+ " is not visible in the application" ,"fail");
		} catch (ElementNotSelectableException e){
			reportStep("The element id: " +xpath+ " with the value: " +value+ " is not selectable from the dropdown","fail");
		} catch (StaleElementReferenceException e){
			reportStep("The element id: " +xpath+ " is not stable","fail");
		} catch (WebDriverException e){
			reportStep("The element id: " +xpath+ " with the visible text value: " +value+ " is not selected due to unknown error","fail");
		}	
	}


	public void keyBoardOperationXpath(String xpath, String action) {
		try {
			if(action.equalsIgnoreCase("pagedown")) {
				driver.findElementByXPath(xpath).sendKeys(Keys.PAGE_DOWN);
				reportStep("The corresponding action is performed","Pass");
			}
			else {
				reportStep("The coressponding action is not performed","Pass");
			}
			}
			catch (NoSuchElementException e) {
				reportStep("The element with xpath "+xpath+" is not found in the DOM","fail");
			}catch (ElementNotVisibleException e) {
				reportStep("The element with xpath " +xpath+ " is not visible in the application","fail");
			}catch (ElementNotInteractableException e) {
				reportStep("The element with xpath "+xpath+" is not interactable in the application","fail");
			}catch (StaleElementReferenceException e) {
				reportStep("The elemnet with xpath "+xpath+ " is not stable in the application","fail");
			}catch (InvalidElementStateException e) {
				reportStep("The element with xpath " +xpath+ " is invalid and driver is unable to perform any operation on that element","fail");
			}catch (NotFoundException e) {
			}catch (WebDriverException e) {
				reportStep("The element with xpath "+xpath+" is not handled due to unknown error","fail");
			}
				
	}


	public void selectIndexByXpath(String xpath, int value) {
	
		try {
			WebElement Sel = driver.findElementByXPath(xpath);
			Select sl = new Select(Sel);
			sl.selectByIndex(value);
			reportStep("The element id: " +xpath+ " With the visible text value: " +value+ " got selected from dropdown successfully","Pass");
		} catch (NoSuchElementException e) {
			reportStep("The element id: " +xpath+ " not found in the DOM","fail");
		} catch (ElementNotVisibleException e){
			reportStep("The element id: " +xpath+ " is not visible in the application" ,"fail");
		} catch (ElementNotSelectableException e){
			reportStep("The element id: " +xpath+ " with the value: " +value+ " is not selectable from the dropdown","fail");
		} catch (StaleElementReferenceException e){
			reportStep("The element id: " +xpath+ " is not stable","fail");
		} catch (WebDriverException e){
			reportStep("The element id: " +xpath+ " with the visible text value: " +value+ " is not selected due to unknown error","fail");
		}
		
	} 
	
		
	}


	
	
		

