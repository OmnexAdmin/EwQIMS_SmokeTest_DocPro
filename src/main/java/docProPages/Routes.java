package main.java.docProPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;





public class Routes extends ProjectMethods {
	
	@FindBy(how = How.XPATH, using = "//iframe[@id='Detailview']")
	private WebElement eleRoutesFrame;

	@FindBy(how = How.XPATH, using = "//input[@value='New Route']")
	private WebElement eleClickOnNewRoute;

	@FindBy(how = How.ID, using = "strRouteName")
	private WebElement eleEnterRouteName;

	@FindBy(how = How.ID, using = "strRouteDescription")
	private WebElement eleEnterRouteDescription;

	@FindBy(how = How.ID, using = "btnAdduser")
	private WebElement eleClickOnAddUsersButton;

	@FindBy(how = How.ID, using = "btnAddPositions")
	private WebElement eleClickOnAddPositionsButton;

	@FindBy(how = How.XPATH, using = "//iframe[@id='ifrUsers']")
	private WebElement eleUserFrame;

	@FindBy(how = How.ID, using = "gs_Empcode")
	private WebElement eleEnterCode;

	@FindBy(how = How.XPATH, using = "//a[@colname='Empcode']")
	private WebElement eleCLickOnSearchFilter;

	@FindBy(how = How.ID, using = "contains")
	private WebElement eleCLickonContainsfilter;

	@FindBy(how = How.ID, using = "cb_userListingGridControl")
	private WebElement eleClickOnCheckAllCheckbox;

	@FindBy(how = How.XPATH, using = "//table[@id='userListingGridControl']/tbody/tr[2]/td")
	private WebElement eleClickOnFirstUser;

	@FindBy(how = How.XPATH, using = "//table[@id='userListingGridControl']/tbody/tr[3]/td")
	private WebElement eleClickOnSecondUser;

	@FindBy(how = How.XPATH, using = "//input[@value='Done']")
	private WebElement eleClickOnDone;

	@FindBy(how = How.ID, using = "chkAllApproversReq")
	private WebElement eleClickOnAllApproversRequired;

	@FindBy(how = How.XPATH, using = "	(//input[@onclick='chkmandatorycount()'])[1]")
	private WebElement eleNonMandatoryApprover1;

	@FindBy(how = How.XPATH, using = "(//input[@onclick='chkmandatorycount()'])[2]")
	private WebElement eleNonMandatoryApprover2;

	@FindBy(how = How.XPATH, using = "	(//input[@onclick='chkmandatorycount()'])[3]")
	private WebElement eleNonMandatoryApprover3;

	@FindBy(how = How.XPATH, using = "(//input[@onclick='chkmandatorycount()'])[4]")
	private WebElement eleNonMandatoryApprover4;

	@FindBy(how = How.LINK_TEXT, using = "2")
	private WebElement eleclickOn2ndRoundLink;

	@FindBy(how = How.ID, using = "txtminApproverValue")
	private WebElement eleEnterMinNumofApproversReqd;

	@FindBy(how = How.XPATH, using = "//iframe[@id='IFrameposition']")
	private WebElement elePositionsFrame;

	@FindBy(how = How.ID, using = "gs_Position")
	private WebElement eleEnterPositionstoSearch;

	@FindBy(how = How.ID, using = "cb_DPUserposViewId")
	private WebElement eleclickOnCheckAllCheckbox;

	@FindBy(how = How.XPATH, using = "//input[@onclick='SavePosition()']")
	private WebElement eleClickOnSavePosition;

	@FindBy(how = How.ID, using = "btnSave")
	private WebElement eleClickOnSaveButton;

	@FindBy(how = How.ID, using = "popup_ok")
	private WebElement eleClickOktoAlert;

	public Routes(RemoteWebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);
	}

	public Routes createRoute(String routeName, String routedesc, String code, String minNumofApproversReqd,
			String position) throws Throwable {

		/*
		 * switchToFrame(eleRoutesFrame); click(eleClickOnNewRoute, "New Route button");
		 * type(eleEnterRouteName, routeName); type(eleEnterRouteDescription,
		 * routedesc); click(eleClickOnAddUsersButton, "Add users button");
		 * //switchToFrame(eleUserFrame); switchToMultipleFrames("ifrUsers","ifr-user");
		 * Thread.sleep(3000);
		 */

		// * Route has only 1 round
		// * Route has 2 approvers
		// * All the approvers are required to publish document
		switch (routeName) {

		case "R1":
			Thread.sleep(5000);
			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleClickOnNewRoute, "New Route button");
			type(eleEnterRouteName, routeName);
			type(eleEnterRouteDescription, routedesc);
			click(eleClickOnAddUsersButton, "Add users button");
			// switchToFrame(eleUserFrame);
			switchToMultipleFrames("ifrUsers", "ifr-user");
			Thread.sleep(5000);

			type(eleEnterCode, code);
			pressEnterKey(eleEnterCode);
			//click(eleClickOnCheckAllCheckbox, "Select user checkbox");
			click(eleClickOnFirstUser, "1st user in table");
            click(eleClickOnSecondUser, "2nd user in table");
			click(eleClickOnDone, "Done button");
			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleClickOnAllApproversRequired, "All Approvers required checkbox");
			click(eleClickOnSaveButton, "Save button");
			click(eleClickOktoAlert, "OK button");

			break;

		// * Route has 2 rounds
		// * 1st round has 2 approvers and both are non mandatory(if any one approves it
		// will go to another round)
		// * 2nd round has 2 approvers and both are mandatory
		case "R2":
			// else if(routeName.matches( "R2")) {
			Thread.sleep(5000);
			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleClickOnNewRoute, "New Route button");
			type(eleEnterRouteName, routeName);
			type(eleEnterRouteDescription, routedesc);
			click(eleClickOnAddUsersButton, "Add users button");
			// switchToFrame(eleUserFrame);
			switchToMultipleFrames("ifrUsers", "ifr-user");
			Thread.sleep(5000);
			// 1st round
			type(eleEnterCode, code);
			pressEnterKey(eleEnterCode);
			click(eleClickOnFirstUser, "1st user in table");
			click(eleClickOnSecondUser, "2nd user in table");
			// click(eleClickOnCheckAllCheckbox,"Select user checkbox");
			click(eleClickOnDone, "Done button");
			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleNonMandatoryApprover1, "Uncheck Is mandatory checkbox for Approver 1 ");
			click(eleNonMandatoryApprover2, "Uncheck Is mandatory checkbox for approver 2");
			click(eleClickOnSaveButton, "Save button");
			click(eleClickOktoAlert, "OK button");
			Thread.sleep(5000);
			// 2nd round
			click(eleclickOn2ndRoundLink, "2ndRound link");
			click(eleClickOnAddUsersButton, "Add users button");
			switchToMultipleFrames("ifrUsers", "ifr-user");
			Thread.sleep(5000);
			type(eleEnterCode, "(VH)");
			pressEnterKey(eleEnterCode);
			click(eleClickOnCheckAllCheckbox, "Select user checkbox");
			click(eleClickOnDone, "Done button");
			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleClickOnSaveButton, "Save button");
			click(eleClickOktoAlert, "OK button");

			break;

		// * Route has 2 rounds
		// * 1st round has 4 approvers (1 approver is mandatory and other 3 are non
		// mandatory, min number reqd to approve is 2)
		// * 2nd round has 4 approver (All are non mandatory and the requester itself is
		// one of the approver)
		case "R3":

			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleClickOnNewRoute, "New Route button");
			type(eleEnterRouteName, routeName);
			type(eleEnterRouteDescription, routedesc);
			click(eleClickOnAddUsersButton, "Add users button");
			// switchToFrame(eleUserFrame);
			switchToMultipleFrames("ifrUsers", "ifr-user");
			Thread.sleep(5000);
			// else if(routeName.matches( "R3")) {
			// 1st round
			type(eleEnterCode, code);
			pressEnterKey(eleEnterCode);
			click(eleClickOnCheckAllCheckbox, "Select user checkbox");
			click(eleClickOnDone, "Done button");
			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleNonMandatoryApprover1, "Uncheck Is mandatory checkbox for Approver 1");
			click(eleNonMandatoryApprover2, "Uncheck Is mandatory checkbox for approver 2");
			click(eleNonMandatoryApprover3, "Uncheck Is mandatory checkbox for approver 3");

			type(eleEnterMinNumofApproversReqd, minNumofApproversReqd);
			click(eleClickOnSaveButton, "Save button");
			click(eleClickOktoAlert, "OK button");

			Thread.sleep(3000);
			// 2nd round
			click(eleclickOn2ndRoundLink, "2ndRound link");
			click(eleClickOnAddUsersButton, "Add users button");
			switchToMultipleFrames("ifrUsers", "ifr-user");
			Thread.sleep(5000);
			type(eleEnterCode, "FA");
			pressEnterKey(eleEnterCode);
			click(eleClickOnCheckAllCheckbox, "Select user checkbox");
			click(eleClickOnDone, "Done button");
			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleNonMandatoryApprover1, "Uncheck Is mandatory checkbox for Approver 1");
			click(eleNonMandatoryApprover2, "Uncheck Is mandatory checkbox for approver 2");
			click(eleNonMandatoryApprover3, "Uncheck Is mandatory checkbox for approver 3");
			click(eleNonMandatoryApprover4, "Uncheck Is mandatory checkbox for approver 4");
			click(eleClickOnSaveButton, "Save button");
			click(eleClickOktoAlert, "OK button");

			break;

		// * Route has 2 rounds
		// * 1st round has 4 approvers (1 approver is mandatory and other 3 are non
		// mandatory, min number reqd to approve is 2)
		// * 2nd round has 4 approver (All are non mandatory and the requester itself is
		// one of the approver)
		case "R4":
			// else if(routeName.matches( "R4")) {

			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleClickOnNewRoute, "New Route button");
			type(eleEnterRouteName, routeName);
			type(eleEnterRouteDescription, routedesc);
			click(eleClickOnAddUsersButton, "Add users button");
			// switchToFrame(eleUserFrame);
			switchToMultipleFrames("ifrUsers", "ifr-user");
			Thread.sleep(5000);
			// 1st round
			type(eleEnterCode, code);
			pressEnterKey(eleEnterCode);
			click(eleClickOnCheckAllCheckbox, "Select user checkbox");
			click(eleClickOnDone, "Done button");
			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleNonMandatoryApprover1, "Uncheck Is mandatory checkbox for Approver 1");
			click(eleNonMandatoryApprover2, "Uncheck Is mandatory checkbox for approver 2");
			click(eleClickOnSaveButton, "Save button");
			click(eleClickOktoAlert, "OK button");
			Thread.sleep(3000);
			// 2nd round, add position based round
			click(eleclickOn2ndRoundLink, "2ndRound link");
			click(eleClickOnAddPositionsButton, "Add positions button");
			switchToFrame(elePositionsFrame);
			type(eleEnterPositionstoSearch, position);
			click(eleclickOnCheckAllCheckbox, "Checkbox");
			click(eleClickOnSavePosition, "Save Position");
			switchToFrame(eleRoutesFrame);
			Thread.sleep(5000);
			click(eleClickOnSaveButton, "Save button");
			click(eleClickOktoAlert, "OK button");

			break;

		default:
			break;
		}
switchToDefaultFrame();
		return this;
	}
}
