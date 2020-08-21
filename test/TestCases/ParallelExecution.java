package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.LoginPage;


public class ParallelExecution extends ProjectMethods {

	@BeforeClass
	public void setData() {
		excelName = "MultipleTestData";
		dataSheetName = "paralleltest";

		test = startTestCase("Smoketesttarts", "Browser launched successfully");

		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData", groups = "regression")

	public void multipleUsers(String iteration, String userName, String passWord, String userCount,String code, String fName,
			String lName, String eMail, String uName, String pwd, String confirmPassword) throws Throwable {
		testCaseName = "TC0 ";
		testDescription = "New doc set route";
		test = startTestCase(testCaseName, testDescription);
		int iteration1 = Integer.parseInt(iteration);

		if (iteration1 <= 11) {
			// Create Multiple Users
			new LoginPage(driver, test).login(userName, passWord).clickOnUsersTab().clickOnUsersMenu().addUsers(userCount,code,
					fName, lName, eMail, uName, pwd, confirmPassword);
		}

	}

}
