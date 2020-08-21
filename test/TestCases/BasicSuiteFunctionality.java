package TestCases;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.LoginPage;



public class BasicSuiteFunctionality extends ProjectMethods {

	@BeforeClass
	public void setData() {
		excelName = "DocProTestData";
		dataSheetName = "TC001to5";
		test = startTestCase("SmokeTest_Suite", "Basic Suite Functionality(6TCs)");
		category = "Smoke";
		authors = "Bhuvana";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData")

	public void login(String TestcaseNumber, String Runmode, String Scenario, String userName, String passWord,
			String userCount,String code, String fName, String lName, String eMail, String uName, String pwd, String confirmPassword)
			throws Throwable {
	
	//public void login(String TestcaseNumber, String Runmode, String Scenario, String userName, String passWord) {

		testCaseName = Scenario;
		testDescription = TestcaseNumber;
		test = startTestCase(testCaseName, testDescription);

		if (!Runmode.contains("Y")) {
			throw new SkipException("Run mode set as No");
		}

		switch (TestcaseNumber) {

		case "TC001":
		    startApp(browserName);
           
			new LoginPage(driver, test)
			.login(userName, passWord);
			break;

		case "TC002":
		    startApp(browserName);
	          
			new LoginPage(driver, test)
			.invalidLogin(userName, passWord);
			break;

		
		  case "TC003":
	            
		      startApp(browserName);
		  
		  new LoginPage(driver, test)
		  .login(userName, passWord)
		  .clickOnUsersTab()
		  .clickOnUsersMenu()
		  .addUsers(userCount,code, fName, lName, eMail, uName, pwd, confirmPassword); 
		  break;
		  
		  
		  case "TC004": 
		      
		      startApp(browserName);
		  new LoginPage(driver, test)
		  .login(userName,
		  passWord).clickOnModuleAdminMenu().setUserAsModuleAdmin(code); break;
		  
		  case "TC004A":
		      startApp(browserName);
		      new LoginPage(driver, test).login(userName,
		  passWord).clickOnSuiteAdminMenu().setUserAsSuiteAdmin(code); break;
		  
		  case "TC005": 
		      startApp(browserName);
		      new LoginPage(driver, test).login(userName,
		  passWord).clickOnUsersTab().clickOnUserPrefrencesMenu()
		  .setDocProasLandingPage(); break;
		 

		default:
			break;

		}

	}

}
