package main.java.docProPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;


public class FolderManagement extends ProjectMethods {

	@FindBy(how = How.ID, using = "txtSearchTree_TOCDoclvl")
	private WebElement eleEnterSearchCriteria;

	// @FindBy(name="txtSearchTree_TOCDoclvl") WebElement eleEnterSearchCriteria;

	@FindBy(how = How.ID, using = "dpSearch'")
	private WebElement eleClickOnSearch;

	// @FindBy(how=How.XPATH,using="//span[text()='01.QCL']")
	// private WebElement eleClickOnLevel;

	@FindBy(how = How.ID, using = "chkInUse")
	private WebElement eleClickOnInUse;

	@FindBy(how = How.XPATH, using = "//iframe[@id='iframeTree']")
	private WebElement eleRHSFrame;

	@FindBy(how = How.XPATH, using = "//iframe[@id='Detailview']")
	private static WebElement eleLHSFrame;

	/*
	 * @FindBy(how=How.ID,using="drpDocNumOpt") private WebElement
	 * eleSelectDocNumOption;
	 */

	@FindBy(how = How.ID, using = "drpDocNumOpt_chzn_o_1")
	private static WebElement eleClickOnDocNumAutoInc;

	@FindBy(how = How.ID, using = "drpDocNumOpt_chzn")
	private WebElement eleClickOnDocNumOptionDropdown;

	@FindBy(how = How.ID, using = "txtAutoDocNumStart")
	private WebElement eleEnterStartingDocNum;

	@FindBy(how = How.ID, using = "txtAutoDocNumUnit")
	private WebElement eleEnterIncUnitofDocNum;

	@FindBy(how = How.XPATH, using = "//span[text()='OK']")
	private WebElement eleClickOnOkButtoninDocNumPopup;

	@FindBy(how = How.ID, using = "drpDocNumOpt_chzn_o_2")
	private WebElement eleClickUseInternalidasDocNUMOption;

	@FindBy(how = How.XPATH, using = "//span[text()='DocPro automatically increments by 1']")
	private WebElement eleSelectRevisionNumberOption;

	@FindBy(how = How.ID, using = "drpRevOpt_chzn_o_2")
	private WebElement eleSelectCustomRevision;

	@FindBy(how = How.ID, using = "drpRevOpt_chzn_o_0")
	private WebElement eleClickOnUserDefinedRev;

	@FindBy(how = How.ID, using = "drpRevSegOptions")
	private WebElement eleClickOnNumOfSegDropdown;

	@FindBy(how = How.XPATH, using = "//select[@id='drpRevSegOptions']//following::option[1]")
	private WebElement eleClickSeg1;

	@FindBy(how = How.ID, using = "drpRevSegMajor")
	private WebElement eleSelectMajorRevision;

	@FindBy(how = How.XPATH, using = "//option[text()='A']")
	private WebElement eleSelectAasMajorRevision;

	@FindBy(how = How.ID, using = "drpRevSegMinor")
	private WebElement eleSelectMinorRevision;

	@FindBy(how = How.XPATH, using = "(//option[text()='I'])[2]")
	private WebElement eleSelectIasMinorRevision;

	@FindBy(how = How.XPATH, using = "//span[text()='OK']")
	private WebElement eleclickOKtoCusRevPopup;

	@FindBy(how = How.ID, using = "popup_ok")
	private WebElement eleclickOktoAlertMessage;

	@FindBy(how = How.ID, using = "chkRevByInherit")
	private WebElement eleClickonInheritfromParentCheckbox;

	@FindBy(how = How.ID, using = "drpRevDateOpt_chzn")
	private WebElement eleClickOnRevDateOptionDropdown;

	@FindBy(how = How.ID, using = "drpRevDateOpt_chzn_o_1")
	private WebElement eleClickOnUserIPDate;

	@FindBy(how = How.ID, using = "btnSave")
	private WebElement eleClickOnSavetoActivateFolder;

	@FindBy(how = How.ID, using = "aSiterights")
	private WebElement eleClickOnAccessforSites;

//	@FindBy(how=How.XPATH,using="//td[@aria-describedby='DPLevelgrid_noaccess']/input")
	// private WebElement eleCLickOnNoAccessForFolder;
	
	//Access for sites --New document creation Web elements
	//========================================================

	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_Inherit']/input")
	WebElement eleclickOnInheritForFolder;

	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_Requestright']/input")
	WebElement eleClickOnReqRightsForFolder;

	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_noaccess']/input")
	WebElement eleClickOnNoAccessForFolder;

	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_Attachright']/input")
	WebElement eleClickOnAttachRightForFolder;

	// @FindBy(how=How.XPATH,using="//td[@aria-describedby='DPLevelgrid_noaccess_Doc']/input")
	// private WebElement eleCLickOnNoAccessForDocument;


    //Access for sites --New document access Web elements
    //========================================================
	
	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_Inherit_Doc']/input")
	WebElement eleClickOnInheritForDocument;

	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_Fullaccess']/input")
	WebElement eleClickOnFullAccessForDocument;

	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_Requestright_doc']/input")
	WebElement eleClickOnReqRightsForDocument;

	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_viewhistory']/input")
	WebElement eleClickOnViewHistoryForDocument;

	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_viewonly']/input")
	WebElement eleClickOnViewOnlyForDocument;

	@FindBy(xpath = "//td[@aria-describedby='DPLevelgrid_noaccess_Doc']/input")
	WebElement eleClickOnNoAccessForDocument;

	@FindBy(how = How.ID, using = "aGrouprights")
	private WebElement eleClickOnAccessforGroups;

	// @FindBy(how=How.XPATH,using="//td[@aria-describedby='DPLevelgrid_Inherit']/input")
	// private WebElement eleUncheckInheritOptionForFolder;

	// @FindBy(how=How.XPATH,using="//td[@aria-describedby='DPLevelgrid_Attachright']/input")
	// private WebElement eleClickOnAttachRightForFolder;

	@FindBy(id = "DPLevelgridsearchevent")
	WebElement eleClickOnSearchButtoninAccessforUsers;

	@FindBy(xpath = "//input[@class='input-elm']")
	WebElement eleEnterusernameinSearchPopup;

	@FindBy(id = "fbox_DPLevelgrid_search")
	WebElement eleClickOnFindButtoninSearchPopup;

	@FindBy(how = How.ID, using = "aEditRoute")
	private WebElement eleClickOnEditRouteOptionLink;

	@FindBy(how = How.XPATH, using = "//iframe[@id='iframeActions_top']")
	private WebElement eleRouteFrame1;

	@FindBy(how = How.XPATH, using = "//div[@id='tddrpdownNewRoute_chzn']")
	private WebElement eleClickOnRouteDropdownforNew;

	@FindBy(how = How.XPATH, using = "//div[@id='tddrpdownNewRoute_chzn']/div/div/input")
	private WebElement eleClickOnRouteDropdownForNew1;

	@FindBy(how = How.XPATH, using = "//div[@id='tddrpdownExistingRoute_chzn']")
	private WebElement eleClickOnRouteDropdownforExisting;

	@FindBy(how = How.XPATH, using = "//div[@id='tddrpdownExistingRoute_chzn']/div/div/input")
	private WebElement eleClickOnRouteDropdownForExisting1;

	@FindBy(how = How.XPATH, using = "//iframe[@id='iframeRoutes']")
	private WebElement eleRouteFrame2;

	@FindBy(how = How.XPATH, using = "//iframe[@id='iframediv']")
	private WebElement eleRouteFrame3;

	@FindBy(how = How.XPATH, using = "//iframe[@id='iframeRoute']")
	private WebElement eleRouteFrame4;

	@FindBy(how = How.XPATH, using = "//input[@id='resetlevel']")
	private WebElement eleCheckResetDocumentRouting;

	@FindBy(how = How.XPATH, using = "//input[@id='resetsublevel']")
	private WebElement eleCheckResetSubLevelRouting;

	// Rights for the group-- Hard coded with Group name
	// ===================================================
	// Group name: Doc Pro Admin Group
	@FindBy(xpath = "//td[text()='Doc Pro Admin Group']//following::td[1]")
	WebElement eleUncheckGroupInheritforNewdocCreation;
	@FindBy(xpath = "//td[text()='Doc Pro Admin Group']//following::td[3]")
	WebElement eleCheckAttachRightsforNewdocCreation;
	@FindBy(xpath = "//td[text()='Doc Pro Admin Group']//following::td[6]")
	WebElement eleUncheckGroupInheritforNewdocAccess;
	@FindBy(xpath = "//td[text()='Doc Pro Admin Group']//following::td[8]")
	WebElement eleCheckFullAccessforNewdocAccess;

	// Group name: Doc Pro Request Rights Group
	@FindBy(xpath = "//td[text()='Doc Pro Request Rights Group']//following::td[1]")
	WebElement eleUncheckGroupInheritforNewdocCreation1;
	@FindBy(xpath = "//td[text()='Doc Pro Request Rights Group']//following::td[4]")
	WebElement eleCheckRequestRightsforNewdocCreation;
	@FindBy(xpath = "//td[text()='Doc Pro Request Rights Group']//following::td[6]")
	WebElement eleUncheckGroupInheritforNewdocAccess1;
	@FindBy(xpath = "//td[text()='Doc Pro Request Rights Group']//following::td[9]")
	WebElement eleCheckRequestRightsforNewdocAccess;

	// Group name:Doc Pro Approvers view History
	@FindBy(xpath = "//td[text()='Doc Pro Approvers']//following::td[6]")
	WebElement eleUncheckGroupInheritforNewdocAccess2;
	@FindBy(xpath = "//td[text()='Doc Pro Approvers']//following::td[10]")
	WebElement eleCheckViewHistoryRightsforNewdocAccess;

	// Group name:Doc Pro view only Group

	@FindBy(xpath = "//td[text()='Doc Pro view only Group']//following::td[1]")
	WebElement eleUncheckGroupInheritforNewdocCreation2;
	@FindBy(xpath = "//td[text()='Doc Pro view only Group']//following::td[5]")
	WebElement eleCheckNoAccessforNewdocCreation;
	@FindBy(xpath = "//td[text()='Doc Pro view only Group']//following::td[6]")
	WebElement eleUncheckGroupInheritforNewdocAccess3;
	@FindBy(xpath = "//td[text()='Doc Pro view only Group']//following::td[11]")
	WebElement eleCheckViewOnlyRightsforNewdocAccess;
	
	
	
	
	
	

	/*
	 * WebElement eleUncheckGroupInheritforNewdocCreation=driver.
	 * findElementByXPath("//td[text()='Doc Pro Admin Group']//following::td[1]");
	 * WebElement eleCheckAttachRightsforNewdocCreation=driver.
	 * findElementByXPath("//td[text()='Doc Pro Admin Group']//following::td[3]");
	 * WebElement eleUncheckGroupInheritforNewdocAccess=driver.
	 * findElementByXPath("//td[text()='Doc Pro Admin Group']//following::td[6]");
	 * WebElement eleCheckAttachRightsforNewdocAccess=driver.
	 * findElementByXPath("//td[text()='Doc Pro Admin Group']//following::td[8]");
	 */

	public FolderManagement(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);

	}

	public void clickOnSearchicon() {

		click(eleClickOnSearch, "Clicked on search icon");
	}

	public void switchToRHSFrame() {

		switchToFrame(eleRHSFrame);
	}

	public void switchToLHSFrame() {

		switchToFrame(eleLHSFrame);
	}

	public void docAutoIncrement(String startingNumber, String incrementalUnit) {

		click(eleClickOnDocNumOptionDropdown, "Document Number option Dropdown");
		click(eleClickOnDocNumAutoInc, "Document Number Auto Increment option");
		// switchToFrame(eleRHSFrame);
		type(eleEnterStartingDocNum, startingNumber);
		type(eleEnterIncUnitofDocNum, incrementalUnit);
		click(eleClickOnOkButtoninDocNumPopup, "Ok Button in Doc Num Option Popup");

	}

	public void useInternalIDasDocNum() {

		click(eleClickOnDocNumOptionDropdown, "Document Number option Dropdown");
		click(eleClickUseInternalidasDocNUMOption, "Use Internal id as Doc NUM Option");

	}

	public void customRevwith2Seg() {

//Set Revision number as custom revision with 2 segments (A.I)

		click(eleSelectRevisionNumberOption, "Revision Number Option");
		click(eleSelectCustomRevision, "Custom Revision Option");
		click(eleSelectMajorRevision, "Major revision");
		click(eleSelectAasMajorRevision, "A as Major revision");
		click(eleSelectMinorRevision, " Minor revision");
		click(eleSelectIasMinorRevision, "I as Major revision");
		click(eleclickOKtoCusRevPopup, "Ok button");

	}

	public void customRevwith1Seg() {
		// Set Revision number as custom revision with 1 segment A

		click(eleSelectRevisionNumberOption, "Revision Number Option");
		click(eleSelectCustomRevision, "Custom Revision Option");
		click(eleClickOnNumOfSegDropdown, "Number of Segments Dropdown");
		click(eleClickSeg1, "Number of Segments:1");
		click(eleSelectMajorRevision, "Major revision");
		click(eleSelectAasMajorRevision, "A as Major revision");
		click(eleclickOKtoCusRevPopup, "Ok button");
	}

	public void userDefinedRev() {

		// Set Revision number as User Defined Revision

		click(eleSelectRevisionNumberOption, "Revision Number Option");
		click(eleClickOnUserDefinedRev, "User defined Revision Option");
	}

	public void inheritFromParentRevNum() {
		// Set Revision number as Inherit from parent

		// verifySelected(eleClickonInheritfromParentCheckbox);
		click(eleClickonInheritfromParentCheckbox, "Rev number as Inherit from parent");
	}

	public void userIPDate() {

		// Set Revision date option as User input date
		click(eleClickOnRevDateOptionDropdown, "Revision Date Option dropdown");
		click(eleClickOnUserIPDate, "User Input Date option");
	}

	public FolderManagement inUseFolder(String levelName) throws Throwable {
		Thread.sleep(10000);

		switchToLHSFrame();

		type(eleEnterSearchCriteria, levelName);
		clickOnSearchicon();
		clickOnSpecifiLevel(levelName);
	
        /*
         * WebElement eleClickOnLevel = driver.findElementByXPath("//span[text()='" +
         * searchCriteria + "']"); click(eleClickOnLevel, "Level");
         */
		 
		switchToRHSFrame();
		Thread.sleep(5000);
		click(eleClickOnInUse, "In-use Checkbox");

		// Set Revision number as custom revision with 2 segments (A.I)

		click(eleSelectRevisionNumberOption, "Revision Number Option");
		click(eleSelectCustomRevision, "Custom Revision Option");
		click(eleSelectMajorRevision, "Major revision");
		click(eleSelectAasMajorRevision, "A as Major revision");
		click(eleSelectMinorRevision, " Minor revision");
		click(eleSelectIasMinorRevision, "I as Major revision");
		click(eleclickOKtoCusRevPopup, "Ok button");
		click(eleClickOnSavetoActivateFolder, "Save button");
		click(eleclickOktoAlertMessage, "Ok button");

		return this;
	}

	public FolderManagement setFolderRights(String levelName, String groupName) throws Throwable {

		// Access for sites

		switchToLHSFrame();
		Thread.sleep(5000);
		type(eleEnterSearchCriteria, levelName);
		clickOnSearchicon();
		rightClickOnSpecifiLevel(levelName);
        /*
         * WebElement eleClickOnLevel = null; try { eleClickOnLevel =
         * driver.findElementByXPath("//span[text()='" + searchCriteria + "']");
         * rightClickAction(eleClickOnLevel); } catch(WebDriverException e){
         * reportStep("WebDriverException : " + e.getMessage(), "FAIL");
         * 
         * }
         */
		
		// Access for sites
		click(eleClickOnAccessforSites, "Access for sites");
		switchToRHSFrame();
		Thread.sleep(5000);
		click(eleClickOnNoAccessForFolder, "No access to the folder for sites");
		click(eleClickOnNoAccessForDocument, "No access to the document for sites");
		// Access for Groups
		// Thread.sleep(5000);
		driver.switchTo().defaultContent();
		switchToLHSFrame();
		Thread.sleep(3000);
		// WebElement
		// eleClickOnLevel1=driver.findElementByXPath("//span[text()='"+searchCriteria+"']");
		//click(eleClickOnLevel, "Level");
		
		clickOnSpecifiLevel(levelName);
		//rightClickAction(eleClickOnLevel);
		rightClickOnSpecifiLevel(levelName);
		
		click(eleClickOnAccessforGroups, "Access for groups");
		switchToRHSFrame();
		Thread.sleep(5000);
		
		try {
		
		
		WebElement eleUncheckGroupInheritforNewdocCreation = driver
				.findElementByXPath("//td[text()='" + groupName + "']//following::td[1]");
		click(eleUncheckGroupInheritforNewdocCreation, "Uncheck site inherit for the group");

		WebElement eleCheckAttachRightsforNewdocCreation = driver
				.findElementByXPath("//td[text()='" + groupName + "']//following::td[3]");
		click(eleCheckAttachRightsforNewdocCreation, "Set Attach rights to the folder for groups");

		WebElement eleUncheckGroupInheritforNewdocAccess = driver
				.findElementByXPath("//td[text()='" + groupName + "']//following::td[6]");
		click(eleUncheckGroupInheritforNewdocAccess, "Uncheck  site inherit for the group");

		WebElement eleCheckAttachRightsforNewdocAccess = driver
				.findElementByXPath("//td[text()='" + groupName + "']//following::td[8]");
		click(eleCheckAttachRightsforNewdocAccess, "Set Attach rights to the folder for groups");
		
		}catch(WebDriverException e){
	    reportStep("WebDriverException : " + e.getMessage(), "FAIL");
		}
		
		
	    switchToDefaultFrame();
		return this;
	}

	public FolderManagement setRoute(String levelName, String routeName, String existingDocRouteName)
			throws Throwable {

		switchToLHSFrame();
		Thread.sleep(5000);
		type(eleEnterSearchCriteria, levelName);
		clickOnSearchicon();
		Thread.sleep(5000);
		clickOnSpecifiLevel(levelName);
        /*
         * WebElement eleClickOnLevel = driver.findElementByXPath("//span[text()='" +
         * searchCriteria + "']"); Thread.sleep(2000); click(eleClickOnLevel, "Level");
         */
		switchToRHSFrame();
		Thread.sleep(5000);
		click(eleClickOnEditRouteOptionLink, "Edit Route Options Link");
		// System.out.println("The number of frames in this pages
		// is"+driver.findElements(By.xpath("//iframe")).size());
		// String currentFrameName1 = (String)((JavascriptExecutor)
		// driver).executeScript("return window.frameElement.name");
		// System.out.println(currentFrameName1);
		// switchToFrame(eleRouteFrame1);
		Thread.sleep(5000);

		// sSystem.out.println("F1");
		switchToFrame(eleRouteFrame2);
		Thread.sleep(5000);

		System.out.println("F2");
		// switchToFrame(eleRouteFrame3);
		// Thread.sleep(5000);
		// System.out.println("F3");

		switchToFrame(eleRouteFrame4);
		System.out.println("F4");

		Thread.sleep(10000);

		// Set Route for New document
		click(eleClickOnRouteDropdownforNew, "Route Dropdown for New document");
		click(eleClickOnRouteDropdownForNew1, "Route dropdown for New Document");
		type(eleClickOnRouteDropdownForNew1, routeName);
		pressEnterKey(eleClickOnRouteDropdownForNew1);

		// Set Route for Existing document

		click(eleClickOnRouteDropdownforExisting, "Route Dropdown for Existing document");
		click(eleClickOnRouteDropdownForExisting1, "Route dropdown for Existing Document");
		type(eleClickOnRouteDropdownForExisting1, existingDocRouteName);
		pressEnterKey(eleClickOnRouteDropdownForExisting1);

		// Reset doc and sub level routing

		click(eleCheckResetDocumentRouting, "Reset Document Routing checkox");
		click(eleclickOktoAlertMessage, "Ok button");

		click(eleCheckResetSubLevelRouting, "Reset SubLevel Routing checkox");
		click(eleclickOktoAlertMessage, "Ok button");
switchToDefaultFrame();
		return this;
	}

	public FolderManagement setRouteforPrerequsitedataLevels(String routeName, String existingDocRouteName)
			throws Throwable {

		click(eleClickOnEditRouteOptionLink, "Edit Route Options Link");
		switchToFrame(eleRouteFrame2);
		Thread.sleep(3000);
		switchToFrame(eleRouteFrame4);
		Thread.sleep(5000);

		// Set Route for New document

		click(eleClickOnRouteDropdownforNew, "Route Dropdown for New document");
		click(eleClickOnRouteDropdownForNew1, "Route dropdown for New Document");
		type(eleClickOnRouteDropdownForNew1, routeName);
		pressEnterKey(eleClickOnRouteDropdownForNew1);

		// Set Route for Existing document

		click(eleClickOnRouteDropdownforExisting, "Route Dropdown for Existing document");
		click(eleClickOnRouteDropdownForExisting1, "Route dropdown for Existing Document");
		type(eleClickOnRouteDropdownForExisting1, existingDocRouteName);
		pressEnterKey(eleClickOnRouteDropdownForExisting1);

		// Reset doc and sub level routing

		click(eleCheckResetDocumentRouting, "Reset Document Routing checkox");
		click(eleclickOktoAlertMessage, "Ok button");

		click(eleCheckResetSubLevelRouting, "Reset SubLevel Routing checkox");
		click(eleclickOktoAlertMessage, "Ok button");

		return this;
	}

	public FolderManagement inUsepreRequsiteDataLevels(String searchCriteria, String startingNumber,
			String incrementalUnit, String routeName, String existingDocRouteName) throws Throwable {

		switchToLHSFrame();
		Thread.sleep(3000);
		type(eleEnterSearchCriteria, searchCriteria);
		clickOnSearchicon();
		try {
		WebElement eleClickOnLevel = driver.findElementByXPath("//span[text()='" + searchCriteria + "']");
		click(eleClickOnLevel, "Level");}
		catch (WebDriverException e){
	        
	        reportStep("WebDriverException" + e.getMessage(), "FAIL");
	    } 
		
		switchToRHSFrame();
		Thread.sleep(3000);
		click(eleClickOnInUse, "In-use Checkbox");
		switch (searchCriteria) {

		case "01.Quality Manual(R1)":
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			setRouteforPrerequsitedataLevels(routeName, existingDocRouteName);

		case "02.Quality Policy(AbA)":

			docAutoIncrement(startingNumber, incrementalUnit);
			userDefinedRev();
			userIPDate();
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			setRouteforPrerequsitedataLevels(routeName, existingDocRouteName);
			break;

		case "03.Finance Department(PbR)":

			useInternalIDasDocNum();
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			setRouteforPrerequsitedataLevels(routeName, existingDocRouteName);
			break;

		case "3.A.i Transfer Requests":

			docAutoIncrement(startingNumber, incrementalUnit);
			inheritFromParentRevNum();
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			setRouteforPrerequsitedataLevels(routeName, existingDocRouteName);
			break;

		case "4.i Core Data Procedures":

			userIPDate();
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			setRouteforPrerequsitedataLevels(routeName, existingDocRouteName);
			break;

		case "4i.iEmployee Requisitions":

			docAutoIncrement(startingNumber, incrementalUnit);
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			setRouteforPrerequsitedataLevels(routeName, existingDocRouteName);
			break;

		case "4i.iiW/C Off Work Status":

			docAutoIncrement(startingNumber, incrementalUnit);
			inheritFromParentRevNum();
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			setRouteforPrerequsitedataLevels(routeName, existingDocRouteName);
			break;

		case "5a.Consolidation/Closing of Facilities":

			customRevwith1Seg();
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			setRouteforPrerequsitedataLevels(routeName, existingDocRouteName);
			break;

		case "5b.Re-Draw Attendance Boundaries Work Instructions":

			docAutoIncrement(startingNumber, incrementalUnit);
			customRevwith2Seg();
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			setRouteforPrerequsitedataLevels(routeName, existingDocRouteName);
			break;

		default:

			/*
			 * By default: 1.Document Number option: User defined document number 2.Revision
			 * number option: Doc pro automatically increments by 1 3.Revision date option:
			 * Last Approval date 4.Inherit from parent route which is auto approval
			 */
			click(eleClickOnSavetoActivateFolder, "Save button");
			click(eleclickOktoAlertMessage, "Ok button");
			break;

		}
		// click(eleClickOnSavetoActivateFolder,"Save button");
		// click(eleclickOktoAlertMessage,"Ok button");
		return this;

	}

	public FolderManagement setPrereqsiteDataFolderRights(String searchCriteria) throws Throwable {

		switchToLHSFrame();
		type(eleEnterSearchCriteria, searchCriteria);
		clickOnSearchicon();
		WebElement eleClickOnLevel = driver.findElementByXPath("//span[text()='" + searchCriteria + "']");
		rightClickAction(eleClickOnLevel);
		// Access for sites
		click(eleClickOnAccessforSites, "Access for sites");
		switchToRHSFrame();
		Thread.sleep(5000);

		switch (searchCriteria) {

		case "01.Quality Manual(R1)":

			// Access for sites
			click(eleClickOnFullAccessForDocument, "Full access to the document for sites");
			break;

		case "02.Quality Policy(AbA)":

			// Access for sites
			click(eleClickOnNoAccessForFolder, "No access to the folder for sites");
			click(eleClickOnNoAccessForDocument, "No access to the document for sites");
			// Access for Groups, No change
			// Access for users
			click(eleClickOnSearchButtoninAccessforUsers, "Search button in Access for users");
			type(eleEnterusernameinSearchPopup, "Bhuvana");
			click(eleClickOnFindButtoninSearchPopup, "Find button in Search popup (Access for users)");
			click(eleclickOnInheritForFolder, "Uncheck Inherit in Folder access for the user");
			click(eleClickOnAttachRightForFolder, "Attach Rights for the user");
			click(eleClickOnInheritForDocument, "Uncheck Inherit in Document access for the user");
			click(eleClickOnFullAccessForDocument, "Full access for the user");
			break;

		case "03.Finance Department(PbR)":

			// Access for sites
			click(eleClickOnNoAccessForFolder, "No access to the folder for sites");
			click(eleClickOnNoAccessForDocument, "No access to the document for sites");
			// Access for Groups
			// Thread.sleep(5000);
			driver.switchTo().defaultContent();
			switchToLHSFrame();
			Thread.sleep(3000);
			click(eleClickOnLevel, "Level");
			rightClickAction(eleClickOnLevel);
			click(eleClickOnAccessforGroups, "Access for groups");
			switchToRHSFrame();

			// Set Attach right for folder and Full access for document for Doc Pro Admin
			// Group

			click(eleUncheckGroupInheritforNewdocCreation, "Uncheck site inherit for the admin group");

			click(eleCheckAttachRightsforNewdocCreation, "Set Attach rights to the folder for admin group");

			click(eleUncheckGroupInheritforNewdocAccess, "Uncheck  site inherit for admin group");

			click(eleCheckFullAccessforNewdocAccess, "Set Full access to the documents for admin group");

			// Set Request right for folder and Request right for document for Doc Pro
			// Request Rights Group

			click(eleUncheckGroupInheritforNewdocCreation1, "Uncheck site inherit for req group");

			click(eleCheckRequestRightsforNewdocCreation, "Set Request rights to the folder for req group");

			click(eleUncheckGroupInheritforNewdocAccess1, "Uncheck  site inherit for req group");

			click(eleCheckRequestRightsforNewdocAccess, "Set Request rights to the documents for req group");

			// By default Inherit for new doc creation(No access)and View History for
			// document for View only group

			click(eleUncheckGroupInheritforNewdocAccess2, "Uncheck  site inherit for View History group");

			click(eleCheckViewHistoryRightsforNewdocAccess,
					"Set View History rights to the documents for View History group");

			// Override and Set No access for folder and View Only for document for View
			// only group

			click(eleUncheckGroupInheritforNewdocCreation2, "Uncheck site inherit for view only group");

			click(eleCheckNoAccessforNewdocCreation, "Set No access rights to the folder for view only group");

			click(eleUncheckGroupInheritforNewdocAccess3, "Uncheck  site inherit for View only group");

			click(eleCheckViewOnlyRightsforNewdocAccess, "Set View only rights to the documents for view only group");

			// Rest of the groups and child folder has by default inherit from parent
			// folder.
			// Rights for parent folder will be inerited to child folder
			break;

		case "4.i Core Data Procedures":

			// Access for sites
			click(eleClickOnNoAccessForFolder, "No access to the folder for sites");
			click(eleClickOnNoAccessForDocument, "No access to the document for sites");

			// Groups and user Inherit

			break;

		case "4i.iEmployee Requisitions":
			// Set Attach right for folder and Full access for the site for the child folder

		    click(eleclickOnInheritForFolder, "Uncheck Inherit for the site in new doc creation");
		    click(eleClickOnAttachRightForFolder, "Set Attach right for sites(Site override)");
		    click(eleClickOnInheritForDocument, "Uncheck Inherit for the site in new doc access");
		    click(eleClickOnFullAccessForDocument, "Set Full access for sites(site override)");
		    
            /*
             * verifyEnabled(eleCheckAttachRightsforNewdocCreation);
             * click(eleClickOnFullAccessForDocument, "Full access to the document for sites");
             */break;

		case "4i.iiW/C Off Work Status":

			verifyEnabled(eleCheckAttachRightsforNewdocCreation);
			verifyEnabled(eleCheckFullAccessforNewdocAccess);
			click(eleUncheckGroupInheritforNewdocCreation, "Uncheck site inherit for the admin group");
			click(eleCheckNoAccessforNewdocCreation, "Set No access rights to the folder for view only group");
			click(eleUncheckGroupInheritforNewdocAccess, "Uncheck  site inherit for admin group");
			click(eleCheckViewOnlyRightsforNewdocAccess, "Set View only rights to the documents for view only group");
			
			
			
		case "5a.Consolidation/Closing of Facilities":
		    
		    click(eleClickOnNoAccessForFolder, "No access to the folder for sites");
            click(eleClickOnNoAccessForDocument, "No access to the document for sites");
            click(eleUncheckGroupInheritforNewdocCreation, "Uncheck site inherit for the admin group");
            click(eleCheckAttachRightsforNewdocCreation, "Set Attach rights to the folder for admin group");
            click(eleUncheckGroupInheritforNewdocAccess, "Uncheck  site inherit for admin group");
            click(eleCheckFullAccessforNewdocAccess, "Set Full access to the documents for admin group");
            break;
            
		case "5b.Re-Draw Attendance Boundaries Work Instructions":
		    
		    verifyEnabled(eleCheckNoAccessforNewdocCreation);
		    click(eleClickOnFullAccessForDocument, "Full access to the document for sites");
		    
		    
		    break;
		}

		return this;
	}

}

// ===========================================================
/*
 * By default: 1.Document Number option: User defined document number 2.Revision
 * number option: Doc pro automatically increments by 1 3.Revision date option:
 * Last Approval date
 */
// ===========================================================

// Set Doc Number option as Auto Increment

/*
 * click(eleClickOnDocNumOptionDropdown, "Document Number option Dropdown");
 * click(eleClickOnDocNumAutoInc,"Document Number Auto Increment option");
 * //switchToFrame(eleRHSFrame); type(eleEnterStartingDocNum,"startingNumber");
 * type(eleEnterIncUnitofDocNum, "incrementalUnit");
 * click(eleClickOnOkButtoninDocNumPopup, "Ok Button in Doc Num Option Popup");
 * //===========================================================
 * 
 * //Set Doc Number option as Use Internal ID as doc number
 * 
 * click(eleClickOnDocNumOptionDropdown, "Document Number option Dropdown");
 * click(eleClickUseInternalidasDocNUMOption,"Use Internal id as Doc NUM Option"
 * );
 * 
 * //===========================================================
 * 
 * //===========================================================
 * 
 * //Set Revision number as User Defined Revision
 * 
 * click(eleSelectRevisionNumberOption,"Revision Number Option");
 * click(eleClickOnUserDefinedRev,"User defined Revision Option");
 * 
 * //=================================================================
 * 
 * //Set Revision number as Inherit from parent
 * 
 * verifySelected(eleClickonInheritfromParentCheckbox);
 * click(eleClickonInheritfromParentCheckbox,
 * "Rev number as Inherit from parent");
 * 
 * //=================================================================
 * 
 * //Set Revision date option as User input date
 * click(eleClickOnRevDateOptionDropdown, "Revision Date Option dropdown");
 * click(eleClickOnUserDefinedRev, "User defined revision option");
 * 
 * //=================================================================
 */
