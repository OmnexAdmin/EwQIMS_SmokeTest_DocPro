package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.LoginPage;


public class DummyTestcase extends ProjectMethods {

	@BeforeClass
	public void setData() {

		excelName = "MultipleTestData";
		dataSheetName = "Sheet1";

		test = startTestCase("Smoketesttarts", "Browser launched successfully");

		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData")

	public void requestDraft(String userName, String passWord) throws Throwable {

		testCaseName = "Dummy ";
		testDescription = "Dummy testcase";
		test = startTestCase(testCaseName, testDescription);
System.out.println("code enteres");
startApp(browserName);
		new LoginPage(driver, test)
		.login(userName, passWord) 
		.logOut();

	}

}
