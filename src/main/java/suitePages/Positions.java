package main.java.suitePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;


public class Positions extends ProjectMethods {

	@FindBy(how = How.XPATH, using = "//iframe[@id='Detailview']")
	private WebElement eleFrame;

	@FindBy(how = How.XPATH, using = "//input[@value='Add']")
	private WebElement eleClickOnAdd;

	@FindBy(how = How.ID, using = "txtPosition")
	private WebElement eleEnterPosition;

	@FindBy(how = How.ID, using = "txtDescription")
	private WebElement eleEnterDesc;

	@FindBy(how = How.ID, using = "btnAdduser")
	private WebElement eleClickOnAddUserButton;

	@FindBy(how = How.XPATH, using = "//iframe[@id='ifrUsers']")
	private WebElement eleUserFrame;

	@FindBy(how = How.XPATH, using = "//iframe[@id='ifr-user']")
	private WebElement eleUserFrame1;

	@FindBy(how = How.ID, using = "gs_Empcode")
	private WebElement eleEnterCode;

	@FindBy(how = How.ID, using = "cb_userListingGridControl")
	private WebElement eleClickOnCheckAllCheckbox;

	@FindBy(how = How.XPATH, using = "//input[@value='Done']")
	private WebElement eleClickOnDone;

	@FindBy(how = How.ID, using = "btnSave")
	private WebElement eleClickOnSave;

	@FindBy(how = How.ID, using = "popup_ok")
	private WebElement eleClickOnOktoAlertMsg;

	@FindBy(how = How.ID, using = "gs_Position")
	private WebElement eleEnterPositionToSearch;

	public Positions(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);

	}

	public Positions createPosition(String position, String desc, String code) throws Throwable {

		switchToFrame(eleFrame);

		click(eleClickOnAdd, "Add button");
		Thread.sleep(2000);
		type(eleEnterPosition, position);
		type(eleEnterDesc, desc);
		click(eleClickOnAddUserButton, "Add Users button");
		switchToFrame(eleUserFrame);
		// Thread.sleep(5000);
		switchToFrame(eleUserFrame1);
		// Thread.sleep(5000);
		type(eleEnterCode, code);
		pressEnterKey(eleEnterCode);
		click(eleClickOnCheckAllCheckbox, "Select user checkbox");
		click(eleClickOnDone, "Done button");
		switchToFrame(eleFrame);
		// Thread.sleep(5000);
		click(eleClickOnSave, "Save button");
		Thread.sleep(2000);
		click(eleClickOnOktoAlertMsg, "Ok button in alert message");
		Thread.sleep(5000);
		type(eleEnterPositionToSearch, position);
		pressEnterKey(eleEnterPositionToSearch);
		verifyDisplayed(eleEnterPositionToSearch,"Created Position");
		return this;

	}
}
