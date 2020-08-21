package TestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.LoginPage;


public class DummyTestcase2 extends ProjectMethods {

	@BeforeClass
	public void setData() {

		excelName = "TestingExcel";
		dataSheetName = "route";

		test = startTestCase("Smoketesttarts", "Browser launched successfully");

		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData", groups = "regression")

	public void setRoute(String userName, String passWord, String routeName, String routedesc, String code,
			String minNumofApproversReqd, String position) throws Throwable {
		testCaseName = "TC0 ";
		testDescription = "New doc set route";
		test = startTestCase(testCaseName, testDescription);

		new LoginPage(driver, test).moduleLandingPageLogin(userName, passWord).clickOnRoutesMenu()
				.createRoute(routeName, routedesc, code, minNumofApproversReqd, position);

	}

}
