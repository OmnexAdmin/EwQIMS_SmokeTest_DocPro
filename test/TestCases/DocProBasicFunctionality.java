package TestCases;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.LoginPage;


public class DocProBasicFunctionality extends ProjectMethods {

	@BeforeClass
	public void setData() {

		

		excelName = "DocProTestData";
		dataSheetName = "TC006to23";
		test = startTestCase("SmokeTest_Suite", "DocPro Basic Functionality(17TCs)");
		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";

	}

	@Test(dataProvider = "fetchData")

	public void createParentLevels(String TestcaseNumber, String Runmode, String Scenario, String userName,
			String passWord, String levelName, String prefix, String reviewDue, String searchCriteria,
			String subLevelName, String subPrefix, String subReviewDue, String documentNumber, String documentName,
			String attachment, String code, String groupName, String draftComments, String reasonForRequest,
			String changesRequired, String revision, String docOwner, String routeName, String routedesc,
			String minNumofApproversReqd, String position, String approverPwd, String newApproverPwd,
			String confirmApproverPwd, String existingDocRouteName) throws Throwable {

		testCaseName = Scenario;
		testDescription = TestcaseNumber;

		test = startTestCase(testCaseName, testDescription);

		// if(!Runmode.contains("Y")) {
		if (Runmode.contains("N")) {
			throw new SkipException("Run mode set as No");
		}
        
          if (TestcaseNumber.contains("TC015") || TestcaseNumber.contains("TC0021")) {
          
          startApp(browserName);
          new LoginPage(driver,test)
          .moduleLandingPageLogin(userName, passWord).clickonDocumentstab()
          .clickOnDocumentsMenu() .reviseDocument(levelName,prefix, documentNumber,attachment, reasonForRequest, changesRequired);
          }
         

		switch (TestcaseNumber) {

		case "TC006":
		    startApp(browserName);

			new LoginPage(driver, test).login(userName, passWord).clickOnLevelsMenu().createParentLevels(levelName,
					prefix, reviewDue);
			/*new LevelCreationPage(driver, test).createSubLevels(searchCriteria, levelName, subLevelName, subPrefix,
					subReviewDue);
			driver.manage().deleteAllCookies();
			driver.get(sUrl);*/

			break;

		case "TC007":
		    startApp(browserName);

			new LoginPage(driver, test).login(userName, passWord).clickOnLevelsMenu().createSubLevels(searchCriteria,
					levelName, subLevelName, subPrefix, subReviewDue);
			break;

		case "TC008":
		    startApp(browserName);

			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnFolderManagement()
					.inUseFolder(levelName);
			break;

		case "TC009":
		    startApp(browserName);

			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnGroupsMenu()
					.createGroup(groupName, code);
			break;

		case "TC010":
		    startApp(browserName);

			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnFolderManagement()
					.setFolderRights(levelName, groupName);
			break;

		case "TC011":
		    startApp(browserName);

			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickonDocumentstab()
					.clickonNewDocumentRequestmenu()
					.uploadNewDocument(levelName, documentNumber, documentName, attachment);
			break;

		case "TC012":
		    startApp(browserName);

			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickonDocumentstab()
					.clickOnNewDocDraftmenu()
					.uploadNewDraft(levelName, documentNumber, documentName, attachment, code);
			break;

		case "TC013":
		    startApp(browserName);
			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickonDocumentstab()
					.clickOnActionsMenu().draftRequestsNeedingViewing(documentName, attachment, draftComments);
			break;

		case "TC014":
		    startApp(browserName);
			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickonDocumentstab()
					.clickOnActionsMenu()
					.pendingDocumentDrafts(documentName, attachment, reasonForRequest, changesRequired);
			break;

		/*
		 * case "TC015": new LoginPage(driver,test) .moduleLandingPageLogin(userName,
		 * passWord) .clickonDocumentstab() .clickOnDocumentsMenu()
		 * .reviseDocument(levelName, documentNumber, attachment, reasonForRequest,
		 * changesRequired); break;
		 */

		case "TC016":
		    startApp(browserName);
			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickonDocumentstab()
					.clickOnDocumentsMenu()
					.validateDocumentPublished(levelName,prefix, documentNumber, documentName, revision, docOwner);
			break;

		case "TC017":
		    startApp(browserName);
			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickonDocumentstab()
					.clickOnDocumentsMenu()
					.deleteDocument(levelName,prefix, documentNumber, reasonForRequest, changesRequired);
			break;

		case "TC018":
		    startApp(browserName);
			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnRoutesMenu()
					.createRoute(routeName, routedesc, code, minNumofApproversReqd, position);
			break;

		case "TC019":
		    startApp(browserName);
			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnFolderManagement()
					.setRoute(searchCriteria, routeName, existingDocRouteName);
			break;

		case "TC020":
		    startApp(browserName);

			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnDocProSettingsMenu()
					.disable2ndPwd();
			break;

		/*
		 * case "TC021":
		 * 
		 * new LoginPage(driver,test) .moduleLandingPageLogin(userName, passWord)
		 * .clickonDocumentstab() .clickOnDocumentsMenu()
		 * .reviseDocument(levelName,documentNumber, attachment, reasonForRequest,
		 * changesRequired); break;
		 */

		case "TC022":
		    startApp(browserName);
			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnActionsMenu()
					.requestsNeedingApproval(documentName, approverPwd, newApproverPwd, confirmApproverPwd);
			break;

		case "TC023":
		    startApp(browserName);
			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickonDocumentstab()
					.clickOnDocumentsMenu()
					.validateDocumentPublished(levelName,prefix ,documentNumber, documentName, revision, docOwner);
			break;

		default:
			break;

		}

	}

}
