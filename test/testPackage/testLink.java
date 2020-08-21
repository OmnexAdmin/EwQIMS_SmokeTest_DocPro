package testPackage;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.LoginPage;


public class testLink extends ProjectMethods {

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

        startApp(browserName);
        driver.findElementById("tl_login").sendKeys("bhuvana");
        driver.findElementById("tl_password").sendKeys("omnex123");
        driver.findElementByXPath("//input[@value='Log in']").click();
        driver.switchTo().frame("mainframe");
        driver.findElementByXPath("//div[@id='testspecification_topics']//following::a").click();
        driver.switchTo().frame("treeframe");
        driver.findElementByXPath("Select an Option").click();
        
        
       

    }

}
