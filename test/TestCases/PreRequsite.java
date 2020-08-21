package TestCases;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.LoginPage;


public class PreRequsite extends ProjectMethods {

	@BeforeClass
	public void setData() {
		excelName = "RegressionTestData";
		dataSheetName = "data";
		test = startTestCase("Browser Invoked", "TC Execuion");
		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData")
	public void login(String iteration, String userName, String passWord, String code, String fName, String lName,
			String eMail, String uName, String pwd, String confirmPassword, String levelName, String prefix,
			String reviewDue, String searchCriteria, String subLevelName, String subPrefix, String subReviewDue,
			String groupName, String position, String desc, String routeName, String routedesc,
			String minNumofApproversReqd, String startingNumber, String incrementalUnit, String existingDocRouteName)
			throws Throwable {

		int iteration1 = Integer.parseInt(iteration);

        /*
         * if(iteration1<=6) {
         * 
         * //Create Multiple Users startApp(browserName); new LoginPage(driver, test).
         * login(userName,passWord) .clickOnUsersTab() .clickOnUsersMenu().
         * addUsers(code, fName, lName, eMail, uName, pwd, confirmPassword);
         * 
         * }
         * 
         * 
         * else if(iteration1>6 && iteration1<=12) {
         * 
         * //Set Landing Page as Doc Pro startApp(browserName); new LoginPage(driver,
         * test) .login(userName, passWord) .clickOnUsersTab()
         * .clickOnUserPrefrencesMenu() .setDocProasLandingPage(); }
         * 
         * 
         * if(iteration1>12 && iteration1<=17) { //Create Multiple parent levels
         * startApp(browserName); new LoginPage(driver,test) .login(userName, passWord)
         * .clickOnLevelsMenu() .createParentLevels( levelName, prefix, reviewDue);
         * 
         * }
         * 
         * if(iteration1>17 && iteration1<=25) { //Create Multiple sub levels
         * startApp(browserName); new LoginPage(driver,test) .login(userName, passWord)
         * .clickOnLevelsMenu() .createSubLevels(searchCriteria, levelName,subLevelName,
         * subPrefix,subReviewDue); }
         * 
         * if(iteration1>26 && iteration1<=29) { startApp(browserName); //Create
         * multiple groups new LoginPage(driver,test) new LoginPage(driver,test)
         * .moduleLandingPageLogin(userName, passWord) .clickOnGroupsMenu()
         * .createGroup(groupName, code);
         * 
         * }
         */
		 

		if (iteration1 == 30) {
		    startApp(browserName);
			// Create a position

			System.out.println(position + desc + code);
			new LoginPage(driver, test).login(userName, passWord).clickOnSystemTab().clickOnPositionsMenu()

					.createPosition(position, desc, code);

		}

		else if (iteration1 > 30 && iteration1 <= 33) {
		    startApp(browserName);
			// Create multiple routes
			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnRoutesMenu()
					.createRoute(routeName, routedesc, code, minNumofApproversReqd, position);

		}

		else if (iteration1 > 33 && iteration1 <= 39) {
		    startApp(browserName);
			// Activate the created levels

			new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnFolderManagement()
					.inUsepreRequsiteDataLevels(searchCriteria, startingNumber, incrementalUnit, routeName,
							existingDocRouteName);

		}

	}

}
