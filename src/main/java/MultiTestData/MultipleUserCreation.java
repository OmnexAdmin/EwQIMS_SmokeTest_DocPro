package main.java.MultiTestData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.LoginPage;


public class MultipleUserCreation extends ProjectMethods {

	@BeforeClass
	public void setData() {
		excelName = "MultipleTestData";
		dataSheetName = "MultipleUsers";

		test = startTestCase("Smoketesttarts", "Brower launched successfully");

		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData")

	public void addUsers(String userName, String passWord, String userCount,String code, String fName, String lName, String eMail,
			String uName, String pwd, String confirmPassword) throws Throwable {

		testCaseName = "Multiple User creation";
		testDescription = "Create Users";

		new LoginPage(driver, test).login(userName, passWord).clickOnUsersTab().clickOnUsersMenu().addUsers(userCount,code, fName,
				lName, eMail, uName, pwd, confirmPassword);

	}

}
