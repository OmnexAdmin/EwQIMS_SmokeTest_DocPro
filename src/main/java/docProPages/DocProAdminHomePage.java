package main.java.docProPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.CommonMethods.ProjectMethods;
import main.java.suitePages.UserCreationPage;

public class DocProAdminHomePage extends ProjectMethods {

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Folder Management')]")
	WebElement eleClickOnFolderMgmt;

	@FindBy(how = How.XPATH, using = "(//a[text()='Documents'])[1]")
	private WebElement eleClickOnDocumentsTab;

	@FindBy(how = How.LINK_TEXT, using = "New Document Request")
	private WebElement eleClickOnNewDocumentRequestMenu;

	@FindBy(how = How.LINK_TEXT, using = "New Document Draft")
	private WebElement eleClickOnDocumentDraftMenu;

	@FindBy(how = How.LINK_TEXT, using = "Actions")
	private WebElement eleClickOnActionsMenu;

	// @FindBy(how=How.XPATH,using="//img[@src='http://192.168.100.249/EwQIMS_Inst3//App_Themes/EwQIMS-Theme//images/docpro/icon-docpro-user-toc.png']")
	@FindBy(how = How.XPATH, using = "(//a[text()='Documents'])[2]")
	private WebElement eleClickOnDocumentsMenu;

	@FindBy(how = How.LINK_TEXT, using = "Groups")
	private WebElement eleclickOnGroupsMenu;

	@FindBy(how = How.LINK_TEXT, using = "Routes")
	private WebElement eleClickOnRoutesMenu;

	@FindBy(how = How.LINK_TEXT, using = "DocPro Settings")
	private WebElement eleClickOnDocProSettingsMenu;

	@FindBy(how = How.XPATH, using = "//img[@title='Users']")
	private WebElement eleClickOnDocProUsersMenu;
	
	public DocProAdminHomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(driver, this);

	}

	public FolderManagement clickOnFolderManagement() throws Throwable {
		Thread.sleep(5000);
		click(eleClickOnFolderMgmt, "Folder management menu");
		System.out.println("test");
		return new FolderManagement(driver, test);
	}

	public DocProAdminHomePage clickonDocumentstab() {

		click(eleClickOnDocumentsTab, "Documents tab");
		return this;

	}

	public NewDocumentsRequest clickonNewDocumentRequestmenu() {

		click(eleClickOnNewDocumentRequestMenu, "New document request menu");
		return new NewDocumentsRequest(driver, test);

	}

	public NewDocumentDraft clickOnNewDocDraftmenu() {

		click(eleClickOnDocumentDraftMenu, "New document draft menu");
		return new NewDocumentDraft(driver, test);

	}

	public Actions clickOnActionsMenu() {
		click(eleClickOnActionsMenu, "Actions menu");
		return new Actions(driver, test);

	}

	public TOC clickOnDocumentsMenu() {
		click(eleClickOnDocumentsMenu, "Documents menu");
		return new TOC(driver, test);

	}

	public DocProGroups clickOnGroupsMenu() {
		click(eleclickOnGroupsMenu, "Groups menu");

		return new DocProGroups(driver, test);

	}

	public Routes clickOnRoutesMenu() {
		click(eleClickOnRoutesMenu, "Routes menu");
		return new Routes(driver, test);

	}

	public DocProSettings clickOnDocProSettingsMenu() {

		click(eleClickOnDocProSettingsMenu, "Doc Pro Settings menu");
		return new DocProSettings(driver, test);

	}
	
	
	public UserCreationPage clickOnDocProUsersMenu() throws Throwable {

        click(eleClickOnDocProUsersMenu, "User menu");
        // Thread.sleep(2000);
        return new UserCreationPage(driver,test);
    }


}
