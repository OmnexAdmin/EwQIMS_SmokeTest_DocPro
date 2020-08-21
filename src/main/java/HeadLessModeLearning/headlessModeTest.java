package main.java.HeadLessModeLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.github.javafaker.Faker;

public class headlessModeTest {

	public static void main(String[] args) throws Throwable {

		Faker fake = new Faker();

		System.setProperty("webdriver.chrome.driver",
				"E:\\Bhuvana Office\\OSS Workspace Backup\\EwQIMS_POM\\drivers\\chromedriverlatestver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://ew.omnex.in:8080/");
		System.out.println("Entered URL");

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
		System.out.println("Entered user name");
		driver.findElementById("txtPassword").sendKeys("admin");
		System.out.println("Entered password");
		driver.findElementByXPath("//input[@value='Login']").click();
		System.out.println("Clicked Login");
		driver.findElementByXPath("(//a[text()='Users'])[1]").click();
		System.out.println("click users");
		driver.findElementByXPath("//div[@id='div1']/table/tbody/tr/td/table/tbody/tr/td/a").click();

		WebElement frame = driver.findElementByXPath("//iframe[@id='Detailview']");

		driver.switchTo().frame(frame);
		Thread.sleep(3000);

		System.out.println("Frame switched");
		driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		driver.findElementById("txtcode").sendKeys(code);
		System.out.println("Entered code");
		driver.findElementById("txtfirstname").sendKeys(fname);
		System.out.println("Entered User name");
		driver.findElementById("txtlastname").sendKeys(lname);
		System.out.println("Entered last name");
		driver.findElementById("txtbusinessmail").sendKeys(eMail);
		System.out.println("Entered Email");
		driver.findElementById("txtusername").sendKeys(uName);
		System.out.println("Entered User name");
		driver.findElementById("txtpassword").sendKeys(pwd);
		System.out.println("Entered password");
		driver.findElementById("txtconfirmpassword").sendKeys(cpwd);
		System.out.println("Entered confirm paswrd");
		driver.findElementById("Changelogin").click();
		System.out.println("uncheck");
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@id='btnSaveval'])[1]").click();
		System.out.println("Clicked save");
		System.out.println("Code completed");

	}

}
