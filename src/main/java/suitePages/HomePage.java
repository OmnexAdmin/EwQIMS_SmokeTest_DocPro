package main.java.suitePages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;
import main.java.docProPages.DocProAdminHomePage;


public class HomePage extends ProjectMethods {

	@FindBy(how = How.XPATH, using = "(//a[text()='Users'])[1]")
	private WebElement eleClickOnUsersTab;

	@FindBy(how = How.XPATH, using = "//img[@title='Create Users']")
	private WebElement eleClickOnUsersMenu;

	@FindBy(how = How.XPATH, using = "//img[@title='Levels']")
	private WebElement eleClickOnLevelsMenu;

	@FindBy(how = How.ID, using = "imglistModules")
	private WebElement eleClickOnModulesIcon;

	@FindBy(how = How.XPATH, using = "//a[@onclick='loadModule(4)']")
	private WebElement eleClickOnDocProModule;

	// @FindBy(how=How.XPATH,using="//img[@id='docpro']/following-sibling::img[1]")
	// private WebElement eleClickOnDocProModule;

	@FindBy(how = How.XPATH, using = "(//img[@title='Document Pro'])[1]")
	private WebElement eleClickOnDocProModule1;

	@FindBy(how = How.LINK_TEXT, using = "Preferences")
	private WebElement eleClickOnUserPrefrences;

	@FindBy(how = How.LINK_TEXT, using = "Modules")
	private WebElement eleClickOnModAdmMenu;

	@FindBy(how = How.LINK_TEXT, using = "Suite Administrator")
	private WebElement eleClickOnSuiteAdmMenu;

	@FindBy(how = How.LINK_TEXT, using = "System")
	private WebElement eleClickOnSystemsTab;

	@FindBy(how = How.LINK_TEXT, using = "Positions")
	private WebElement eleclickOnPositionsMenu;

	// @FindBy(how=How.XPATH,using="(//img[@title='Document Pro'])[2]")
	// private WebElement eleClickOnDocProModule1;
	
	@FindBy(xpath="//a[text()='Setup']") WebElement eleclickOnSetupTab;
	
	@FindBy(id="imgRefresh") WebElement eleclickOnRefreshIcon;
    
	@FindBy(xpath="//img[@class='round_img']") WebElement eleclickOnUserProfileDropdown;
	
	@FindBy(xpath="//a[@id='logout']") WebElement eleclickOnLogOut;
	
	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);

	}

	// Click on users tab
	public HomePage clickOnUsersTab() throws Throwable {

		// WebDriverWait wait=new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOf(eleClickOnUsersTab));
		explicitWait(eleClickOnUsersTab);
		click(eleClickOnUsersTab, "Clicked on users tab");
		// Thread.sleep(2000);
		return this;
	}
	// Click on users menu

	public UserCreationPage clickOnUsersMenu() throws Throwable {

		click(eleClickOnUsersMenu, "User menu");
		// Thread.sleep(2000);
		return new UserCreationPage(driver, test);
	}

	public UserPreferencePage clickOnUserPrefrencesMenu() {

		click(eleClickOnUserPrefrences, "User preference menu");
		return new UserPreferencePage(driver, test);

	}

	public ModuleAdmin clickOnModuleAdminMenu() {
		click(eleClickOnModAdmMenu, "Module Admin menu");
		return new ModuleAdmin(driver, test);
	}

	public SuiteAdmin clickOnSuiteAdminMenu() {
		click(eleClickOnSuiteAdmMenu, "Suite Admin menu");
		return new SuiteAdmin(driver, test);
	}

	public LevelCreationPage clickOnLevelsMenu() throws Throwable {

		click(eleClickOnLevelsMenu, "Levles menu");
		// Thread.sleep(2000);
		return new LevelCreationPage(driver, test);
	}

	public DocProAdminHomePage goToDocProModule() throws Throwable {
		// Thread.sleep(5000);
		click(eleClickOnModulesIcon, "Modules icon");
		// Thread.sleep(5000);
		click(eleClickOnDocProModule1, "Doc pro module admin menu");
		// click(eleClickOnDocProModule);
		return new DocProAdminHomePage(driver, test);

	}

	public HomePage clickOnSystemTab() throws Throwable {
		click(eleClickOnSystemsTab, "System Tab");

		return this;
	}
	
	public HomePage refresh() {
	    click(eleclickOnRefreshIcon,"Refresh Icon");
	    return this;
	}

	public Positions clickOnPositionsMenu() {
		click(eleclickOnPositionsMenu, "Positions menu");
		return new Positions(driver, test);

	}
	
	//Click on setup tab
	
	public HomePage clickOnSetupTab() {
	    driver.switchTo().defaultContent();
        click(eleclickOnSetupTab, "Setup Tab");
        return this;

    }

    public LoginPage logOut() throws Throwable {

        click(eleclickOnUserProfileDropdown, "User Profile Dropdown");

        try {
          WebElement  eleclickOnLogOut=driver.findElementByXPath("//a[@id='logout']");
    System.out.println("found element");
           eleclickOnLogOut.click();
            
            System.out.println("clicked logout");
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert(); // Thread.sleep(2000);
            System.out.println("Alert message is" + alert.getText());
            alert.accept();
            System.out.println("accepted alert0");

        } catch (Exception e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }

        return new LoginPage(driver, test);
    }

}
