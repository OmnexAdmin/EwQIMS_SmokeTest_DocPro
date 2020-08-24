package main.java.suitePages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;


public class UserCreationPage extends ProjectMethods {

    @FindBy(how = How.XPATH, using = "//iframe[@id='Detailview']")
    private WebElement eleUsersFrame;

    @FindBy(how = How.XPATH, using = "//td[@id='SuUsers_iladd']/div/input")
    private WebElement eleClickOnAddButton;
    
    //td[@id='SuUsers_iladd']/div/input

    @FindBy(how = How.ID, using = "txtcode")
    private WebElement eleEnterCode;

    @FindBy(how = How.ID, using = "txtfirstname")
    private WebElement eleEnterFirstName;

    @FindBy(how = How.ID, using = "txtlastname")
    private WebElement eleEnterLastName;

    @FindBy(how = How.ID, using = "txtbusinessmail")
    private WebElement eleEnterEmail;

    @FindBy(how = How.ID, using = "txtusername")
    private WebElement eleEnterUserName;

    @FindBy(how = How.ID, using = "txtpassword")
    private WebElement eleEnterPassword;

    @FindBy(how = How.ID, using = "txtconfirmpassword")
    private WebElement eleEnterConfirmPassword;

    @FindBy(how = How.ID, using = "Changelogin")
    private WebElement eleClickUserChgPwdatNextLoginCheckbox;

    @FindBy(how = How.ID, using = "btnSaveval")
    private WebElement eleClickOnSaveButton;

    @FindBy(how = How.ID, using = "popup_ok")
    private WebElement eleClickOktoAlertMessage;

    @FindBy(how = How.ID, using = "gs_empcode")
    private WebElement eleEntertheCodetoVerify;

    public UserCreationPage(RemoteWebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    public UserCreationPage addUsers(String userCount, String code, String fName, String lName, String eMail, String uName,
            String pwd, String confirmPassword) throws Throwable {
        int userCount1 = Integer.parseInt(userCount);
       
        
        for (int i = 0; i < userCount1; i++) {

            
            String[] userCode = code.split("\\|");
            String[] userFname = fName.split("\\|");
            String[] userLname = lName.split("\\|");
            String[] userEmail = eMail.split("\\|");
            String[] userName = uName.split("\\|");
           System.out.println("code enters");
            switchToFrame(eleUsersFrame);
            Thread.sleep(2000);
            click(eleClickOnAddButton, "Add button");
            // Thread.sleep(6000);
            type(eleEnterCode, userCode[i]);
            type(eleEnterFirstName, userFname[i]);
            type(eleEnterLastName, userLname[i]);
            type(eleEnterEmail, userEmail[i]);
            type(eleEnterUserName, userName[i]);
            type(eleEnterPassword, pwd);
            type(eleEnterConfirmPassword, confirmPassword);
            click(eleClickUserChgPwdatNextLoginCheckbox, "User change password at next login checkbox");
            click(eleClickOnSaveButton, "Save button");
            click(eleClickOktoAlertMessage, "OK button ");
            type(eleEntertheCodetoVerify, userCode[i]);
            eleEntertheCodetoVerify.sendKeys(Keys.ENTER);
            try {
            WebElement eleVerifyUser = driver.findElementByXPath("//td[text()='" + userCode[i] + "']");
            verifyDisplayed(eleVerifyUser, "Created user");
            }catch (WebDriverException e) {
                reportStep("WebDriverException : " + e.getMessage(), "FAIL");
                
            }
         
           switchToDefaultFrame();
        }
      
        return this;
    }

}
