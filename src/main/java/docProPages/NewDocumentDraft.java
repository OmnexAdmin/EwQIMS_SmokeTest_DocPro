package main.java.docProPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;


public class NewDocumentDraft extends ProjectMethods {

	@FindBy(how = How.XPATH, using = "//iframe[@id='Detailview']")
	private WebElement eleFrame;

	@FindBy(how = How.XPATH, using = "//input[@id='btnSelectLevel']")
	private WebElement eleClickOnSelectLevelButton;

	@FindBy(how = How.XPATH, using = "//input[@id='txtSearchTree_tvDocument']")
	private WebElement eleEnterSearchCriteria;

	@FindBy(how = How.ID, using = "dpSearch")
	private WebElement eleClickonSearchIcon;

	// @FindBy(how=How.XPATH,using="//span[text()='01.QCL']")
	// private WebElement eleClickOnLevel;

	@FindBy(how = How.ID, using = "levelsubmit")
	private WebElement eleClickonDoneButton;

	@FindBy(how = How.ID, using = "txtDocNumberValue")
	private WebElement eleEnterDocNum;

	@FindBy(how = How.ID, using = "txtDocNameValue")
	private WebElement eleEnterDocName;

	@FindBy(how = How.ID, using = "fileUpload")
	private WebElement eleAttachDoc;

	@FindBy(how = How.ID, using = "imgSearch")
	private WebElement eleClickOnDraftViewersIcon;

	@FindBy(how = How.XPATH, using = "//iframe[@id='ifrUsers']")
	private WebElement eleUserFrame;

	@FindBy(how = How.XPATH, using = "//input[@value='userBased']")
	private WebElement eleCLickOnUserBasedSearchRadioButton;

	@FindBy(how = How.ID, using = "gs_Empcode")
	private WebElement eleEnterCode;

	@FindBy(how = How.XPATH, using = "(//a[@class='soptclass']//img[1])[1]")
	private WebElement eleCLickOnSearchFilter;

	@FindBy(how = How.XPATH, using = "//td[text()='equal']")
	private WebElement eleCLickonEqualsfilter;

	@FindBy(how = How.CLASS_NAME, using = "cbox")
	private WebElement eleClickOnUserToSelect;

	@FindBy(how = How.XPATH, using = "//input[@value='Done']")
	private WebElement eleClickOnDone;

	@FindBy(how = How.ID, using = "popup_ok")
	private WebElement eleClickOktoAlertMessage;

	@FindBy(how = How.ID, using = "ifrpopuplevel")
	private WebElement eleLevelPopupFrame;

	@FindBy(how = How.XPATH, using = "//iframe[@id='ifr-user']")
	private WebElement eleUserFrame1;

	@FindBy(how = How.ID, using = "btnContinue")
	private WebElement eleClickOnContinueButton;

	@FindBy(how = How.XPATH, using = "//button[@title='Close']")
	private WebElement eleClosePopup;

	public NewDocumentDraft(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);

	}

	public Actions uploadNewDraft(String levelName, String documentNumber, String documentName, String attachment,
			String code) throws Throwable {

		switchToFrame(eleFrame);
		Thread.sleep(10000);
		click(eleClickOnSelectLevelButton, "Select Level button");
		// Thread.sleep(5000);
		// switchToWindow(0);
		switchToFrame(eleLevelPopupFrame);
		Thread.sleep(5000);
		click(eleEnterSearchCriteria, "Search textbox ");
		type(eleEnterSearchCriteria, levelName);
		click(eleClickonSearchIcon, "Search icon");
		clickOnSpecifiLevel(levelName);
        /*
         * WebElement eleClickOnLevel = driver.findElementByXPath("//span[text()='" +
         * searchCriteria + "']"); click(eleClickOnLevel, "level");
         */
		// click(eleClickonDoneButton,"Done button");
		// switchToWindow(1);
		switchToFrame(eleFrame);
		// Thread.sleep(5000);
		type(eleEnterDocNum, documentNumber);
		type(eleEnterDocName, documentName);
		// click(eleAttachDoc);
		// uploadDocument(attachment);
		eleAttachDoc.sendKeys(attachment);

		if (code != "") {
			click(eleClickOnDraftViewersIcon, "Draft viewers icon");
			switchToMultipleFrames("ifrUsers", "ifr-user");
			// switchToFrame(eleUserFrame);
			// click(eleCLickOnUserBasedSearchRadioButton); switchToFrame(eleUserFrame1);
			// Thread.sleep(5000);
			type(eleEnterCode, code);
			click(eleCLickOnSearchFilter, "Search filter");
			click(eleCLickonEqualsfilter, " Equals filter in search criteria");
			try{
			    driver.findElementById("gs_Empcode").sendKeys(Keys.ENTER);
			}
			catch (WebDriverException e){
		        reportStep("WebDriverException" + e.getMessage(), "FAIL");
		    } 
			click(eleClickOnUserToSelect, "Select user checkbox");
			click(eleClickOnDone, "Done button");
			switchToFrame(eleFrame);
			click(eleClickOnContinueButton, "Continue button");
		} else {
			// Code for not selecting draft viewers and continue
			// click(eleClosePopup,"close popup icon");
			try {
			    driver.findElementById("btnContinue").click();
	            Alert alert = driver.switchTo().alert();
	            Thread.sleep(2000);
	            System.out.println("Alert message is" + alert.getText());
	            alert.accept();
                
            } catch (WebDriverException e) {
                reportStep("WebDriverException : " + e.getMessage(), "FAIL");
            }
		    

		}
		

		Thread.sleep(5000);
switchToDefaultFrame();
		return new Actions(driver, test);
		

	}
}
