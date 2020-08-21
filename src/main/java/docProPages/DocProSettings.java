package main.java.docProPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;



public class DocProSettings extends ProjectMethods {

	@FindBy(how = How.XPATH, using = "//iframe[@id='Detailview']")
	private static WebElement eleLHSFrame;

	@FindBy(how = How.ID, using = "chkbSecPwdDisabled")
	private WebElement eleClickOnDisable2ndPwd;

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement eleClickOnDPSettingsSave;

	@FindBy(how = How.ID, using = "popup_ok")
	private WebElement eleClickOktoAlert;

	public DocProSettings(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);

	}

	public DocProSettings disable2ndPwd() {

		switchToFrame(eleLHSFrame);

		boolean checkbox = eleClickOnDisable2ndPwd.isSelected();

		if (checkbox == false) {

			click(eleClickOnDisable2ndPwd, "Disable 2nd pwd checkbox");

		} else {
			click(eleClickOnDisable2ndPwd, "Enable 2nd pwd checkbox");
		}

		click(eleClickOnDPSettingsSave, "Doc Pro settings save button");

		click(eleClickOktoAlert, "Ok button");
		switchToDefaultFrame();

		return this;

	}

}
