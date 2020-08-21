package main.java.FakerLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentTest;




public class TestDataUsingFakerClass {

	public static void main(String[] args) throws Throwable {

		Faker fake = new Faker();

		System.setProperty("webdriver.chrome.driver",
				"E:\\Bhuvana Office\\OSS Workspace Backup\\EwQIMS_POM\\drivers\\chromedriverlatestver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://ew.omnex.in:8080/");

		driver.manage().window().maximize();

		String code = "";
		String fname = "";
		String lname = "";
		String eMail = "";
		String uName = "";
		String pwd = "";
		String cpwd = "";

		code = fake.number().digit();
		System.out.println("code" + code);
		fname = fake.name().firstName();
		System.out.println("first name is" + fname);
		lname = fake.name().lastName();
		System.out.println("last name is" + lname);
		eMail = fake.internet().emailAddress();
		System.out.println("emnail is" + eMail);
		uName = fake.name().username();
		System.out.println("user name is" + uName);
		pwd = fake.internet().password();
		System.out.println("pwd is" + pwd);
		cpwd = pwd;
		System.out.println("confimr pwd is" + cpwd);

		driver.findElementById("txtUsername").sendKeys("administrator");
		driver.findElementById("txtPassword").sendKeys("admin");
		driver.findElementByXPath("//input[@value='Login']").click();
		driver.findElementByXPath("(//a[text()='Users'])[1]").click();
		driver.findElementByXPath("//div[@id='div1']/table/tbody/tr/td/table/tbody/tr/td/a").click();

		WebElement frame = driver.findElementByXPath("//iframe[@id='Detailview']");

		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		driver.findElementById("txtcode").sendKeys(code);
		driver.findElementById("txtfirstname").sendKeys(fname);
		driver.findElementById("txtlastname").sendKeys(lname);
		driver.findElementById("txtbusinessmail").sendKeys(eMail);
		driver.findElementById("txtusername").sendKeys(uName);
		driver.findElementById("txtpassword").sendKeys(pwd);
		driver.findElementById("txtconfirmpassword").sendKeys(cpwd);
		driver.findElementById("Changelogin").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@id='btnSaveval'])[1]").click();

	}

}
