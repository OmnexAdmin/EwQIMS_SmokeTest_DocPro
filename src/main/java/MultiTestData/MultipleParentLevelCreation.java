package main.java.MultiTestData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.LoginPage;



public class MultipleParentLevelCreation extends ProjectMethods {

	@BeforeClass
	public void setData() {
		excelName = "MultipleTestData";
		dataSheetName = "demoparentlevel";
		test = startTestCase("Smoketesttarts", "Browser launched successfully");
		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData")

	public void createParentLevels(String userName, String passWord, String levelName, String prefix, String reviewDue)
			throws Throwable {
		
		testCaseName = "TC0 ";
		testDescription = "New doc set route";
		test = startTestCase(testCaseName, testDescription);
		startApp(browserName);
		new LoginPage(driver, test).login(userName, passWord).clickOnLevelsMenu().createParentLevels(levelName, prefix,
				reviewDue);

	}

}
