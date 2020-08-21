package main.java.docProPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;


public class Actions extends ProjectMethods {

	@FindBy(how = How.ID, using = "GENpendingdftreq")
	private WebElement eleClickOnPendingDocumentDrafts;

	@FindBy(how = How.XPATH, using = "//iframe[@id='Detailview']")
	private WebElement eleLHSFrame;

	@FindBy(how = How.XPATH, using = "//iframe[@id='iframeActions']")
	private WebElement eleActionsFrame;

	@FindBy(how = How.ID, using = "gs_name")
	private WebElement eleClickOndocumentName;

	@FindBy(how = How.LINK_TEXT, using = "In Process")
	private WebElement eleClickOnInprocessLink;

	@FindBy(how = How.ID, using = "btnChangeRequest")
	private WebElement eleClickOnChangeRequestButton;

	@FindBy(how = How.ID, using = "attachdoc")
	private WebElement eleClickOnAttachDocumentButton;

	@FindBy(how = How.ID, using = "reasonforreq")
	private WebElement eleEnterReasonforRequest;

	@FindBy(how = How.ID, using = "changesrequired")
	private WebElement eleEnterChangesRequired;

	@FindBy(how = How.ID, using = "btcontinue")
	private WebElement eleClickOnSubmitButton;

	@FindBy(how = How.ID, using = "GENdftneedview")
	private WebElement eleClickOnDraftRequestNeedingViewing;

	@FindBy(how = How.ID, using = "attchcheck")
	private WebElement eleChecktheAttachDocumentCheckbox;

	@FindBy(how = How.LINK_TEXT, using = "Reply")
	private WebElement eleClickOnReply;

	@FindBy(how = How.XPATH, using = "(//input[@id='attachfile'])[1]")
	private WebElement eleclickonchooseButton;

	@FindBy(how = How.ID, using = "commentsedtr")
	private WebElement eleEnterDraftComments;

	@FindBy(how = How.ID, using = "drfsub")
	private WebElement eleClickOnSubmit;

	@FindBy(how = How.XPATH, using = "//div[@data-placeholder='Add a comment']")
	private WebElement eleclickonAddComentsTextArea;

	@FindBy(how = How.XPATH, using = "//input[@type='file']")
	private WebElement eleclickOnAttachiconlink;

	@FindBy(how = How.XPATH, using = "//span[text()='Send']")
	private WebElement eleclickOnSendButton;

	@FindBy(how = How.XPATH, using = "((//li[@data-sort-key='oldest'])[1])")
	private WebElement eleclickonOldestComments;

	@FindBy(how = How.ID, using = "GENreqneedaprv")
	private WebElement eleClickOnRequestsNeedingApproval;

	@FindBy(how = How.ID, using = "rdApprove")
	private WebElement eleCheckApproveRadioButton;

	@FindBy(how = How.LINK_TEXT, using = "Reset Second Password")
	private WebElement eleClickOnReset2ndPwdLink;

	@FindBy(how = How.XPATH, using = "//iframe[@id='ifchangepwd']")
	private WebElement eleChnagePwdFrame;

	@FindBy(how = How.ID, using = "txtPassword")
	private WebElement eleEnterPwd;

	@FindBy(how = How.ID, using = "txtNewPassword")
	private WebElement eleEnterNewPwd;

	@FindBy(how = How.ID, using = "txtConfirmPassword")
	private WebElement eleEnterConfirmPwd;

	@FindBy(how = How.XPATH, using = "(//input[@id='btnsave'])[2]")
	private WebElement eleClickOnSave;

	@FindBy(how = How.ID, using = "popup_ok")
	private WebElement eleClickOktoAlert;

	@FindBy(how = How.XPATH, using = "(//input[@id='txtsecondpwd'])[1]")
	private WebElement eleEnter2ndPwd;

	@FindBy(how = How.ID, using = "btnsubmit")
	private WebElement eleClickOnSubmitButtontoApprove;
	
	@FindBy(xpath="//iframe[@id='reqneedapppage']") WebElement eleSwitchToApproveFrame;

	public Actions(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);

	}

	public Actions pendingDocumentDrafts(String documentName, String attachment, String reasonForRequest,
			String changesRequired) throws Throwable {

		switchToFrame(eleLHSFrame);
		click(eleClickOnPendingDocumentDrafts, "Pending Document Drafts tab");
		switchToFrame(eleActionsFrame);
		click(eleClickOndocumentName, "Document Name");
		type(eleClickOndocumentName, documentName);
		pressEnterKey(eleClickOndocumentName);
		click(eleClickOnInprocessLink, "Clicked on Inprocess Link");
		click(eleClickOnChangeRequestButton, "Change request button");
		eleClickOnAttachDocumentButton.sendKeys(attachment);
		// click(eleClickOnAttachDocumentButton);
		// uploadDocument(attachment);
		type(eleEnterReasonforRequest, reasonForRequest);
		type(eleEnterChangesRequired, changesRequired);
		click(eleClickOnSubmitButton, "Submit button");
		return this;

	}

	public Actions draftRequestsNeedingViewing(String documentName, String attachment, String draftComments)
			throws Throwable {

		switchToFrame(eleLHSFrame);
		Thread.sleep(5000);
		click(eleClickOnDraftRequestNeedingViewing, "Draft requests needing viewing Tab");
		switchToFrame(eleActionsFrame);
		Thread.sleep(3000);
		click(eleClickOndocumentName, "Document Name");
		type(eleClickOndocumentName, documentName);
		pressEnterKey(eleClickOndocumentName);
		Thread.sleep(1000);
		click(eleClickOnReply, "Reply link");
		Thread.sleep(10000);

		// System.out.println("The number of frames in this pages
		// is"+driver.findElements(By.xpath("//iframe")).size());
		// String currentFrameName = (String)((JavascriptExecutor)
		// driver).executeScript("return window.frameElement.name");
		// System.out.println(currentFrameName);

		// switchToFrame(eleCommentsFrame);
		// Thread.sleep(3000);
		/*
		 * Without pandora draft customisation
		 * click(eleChecktheAttachDocumentCheckbox,"Attach document checkbox");
		 * Thread.sleep(3000); eleclickonchooseButton.sendKeys(attachment);
		 * //click(eleclickonchooseButton); //uploadDocument(attachment);
		 * //Thread.sleep(3000); type(eleEnterDraftComments, draftComments);
		 * click(eleClickOnSubmit,"Submit button"); Thread.sleep(3000);
		 */

		// after draft customisation
		// click(eleclickonOldestComments,"Oldest");
		click(eleclickonAddComentsTextArea, "Add comments textarea");
		type(eleclickonAddComentsTextArea, draftComments);
		eleclickOnAttachiconlink.sendKeys(attachment);
		Thread.sleep(5000);
		click(eleclickOnSendButton, "Send Button");
		switchToDefaultFrame();
		return this;
	}

	public Actions requestsNeedingApproval(String documentName, String approverPwd, String newApproverPwd,
			String confirmApproverPwd) throws InterruptedException {

		switchToFrame(eleLHSFrame);
		Thread.sleep(3000);
		click(eleClickOnRequestsNeedingApproval, "Requests Needing Approval Tab");
		switchToFrame(eleActionsFrame);
		Thread.sleep(3000);
		click(eleClickOndocumentName, "Document Name");
		type(eleClickOndocumentName, documentName);
		pressEnterKey(eleClickOndocumentName);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		click(eleClickOnReply, "Reply link");
		Thread.sleep(5000);
		
		switchToFrame(eleSwitchToApproveFrame);
		Thread.sleep(5000);
		verifyEnabled(eleCheckApproveRadioButton);
		Thread.sleep(5000);

		VerifyIsDisplayed(eleClickOnReset2ndPwdLink, "Reset 2nd Password Link");

		if (VerifyIsDisplayed(eleClickOnReset2ndPwdLink, "Reset 2nd Password Link") == true) {

			click(eleClickOnReset2ndPwdLink, "Reset 2nd Password Link");
			switchToFrame(eleChnagePwdFrame);
			Thread.sleep(3000);
			// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			type(eleEnterPwd, approverPwd);
			type(eleEnterNewPwd, newApproverPwd);
			type(eleEnterConfirmPwd, confirmApproverPwd);
			click(eleClickOnSave, "Save Button");
			click(eleClickOktoAlert, "Ok button");
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().parentFrame();
			Thread.sleep(5000);
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			type(eleEnter2ndPwd, newApproverPwd);
			click(eleClickOnSubmitButtontoApprove, "Approver Submit Button");
		} else {
			click(eleClickOnSubmitButtontoApprove, "Approver Submit Button");
			Thread.sleep(3000);
		}

		/*
		 * WebElement viewdoc=
		 * driver.findElementByXPath("//a[text()='"+documentNumber+"']"); click(viewdoc,
		 * "Document Number Link");
		 */

		return this;

	}

}
