package main.java.suitePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;


public class UserPreferencePage extends ProjectMethods {

	@FindBy(how = How.XPATH, using = "//iframe[@id='Detailview']")
	private WebElement eleUserPrefFrame;

	@FindBy(how = How.ID, using = "ddlListModule")
	private WebElement eleSelectDocProModule;

	@FindBy(how = How.ID, using = "btnsave")
	private WebElement eleClickOnSave;
	
	@FindBy(how = How.ID, using = "popup_ok")
    private WebElement eleclickOktoAlertMessage;

	public UserPreferencePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public UserPreferencePage setDocProasLandingPage() throws Throwable {
		// String value="Document Pro";
		switchToFrame(eleUserPrefFrame);
		Thread.sleep(5000);
		selectDropDownUsingText(eleSelectDocProModule, "Document Pro");
		click(eleClickOnSave, "Save button");
		click(eleclickOktoAlertMessage, "Ok button");
		Thread.sleep(5000);
		
		return this;

	}

}
