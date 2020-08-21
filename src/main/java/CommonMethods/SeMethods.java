package main.java.CommonMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.Utilities.Reporter;



public class SeMethods extends Reporter implements WdMethods {

    Logger logger = Logger.getLogger("SeMethods");

    // PropertyConfigurator.configure("Log4j.properties");

    public static RemoteWebDriver driver;
    public String primaryWindowHandle, sHubUrl, sHubPort;
    public String sUrl = System.getProperty("URL");
    public String headlessOption = System.getProperty("headlessOption");


    public SeMethods() {
        Properties prop = new Properties();
        try {
            String path = System.getProperty("user.dir");
            // System.out.println(path);
            prop.load(new FileInputStream(new File(path + "\\data\\config.properties")));

            // prop.load(new FileInputStream(new
            // File("C:\\Users\\Omnex\\git\\EwQIMS_POM_Omnex\\EwQIMS_POM\\src\\main\\java\\data\\config.properties")));
            sHubUrl = prop.getProperty("HUB");
            sHubPort = prop.getProperty("PORT");
            // sUrl = prop.getProperty("URL");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startApp(String browser) {
        try {
            String path = System.getProperty("user.dir");
            if (browser.equalsIgnoreCase("chrome")) {

                System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriverlatest.exe");
                if (headlessOption != null) {

                    if (headlessOption.contains("Y")) {

                        ChromeOptions option = new ChromeOptions();
                        option.addArguments("--headless");
                        driver = new ChromeDriver(option);
                    }

                } else {
                    // System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                    driver = new ChromeDriver();

                }

            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", path + "\\drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", path + "\\drivers\\geckodriver_32bit.exe");
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.get(sUrl);

            driver.manage().window().maximize();

            logger.info("The browser:" + browser + " launched successfully");

            reportStep("The browser:" + browser + " launched successfully", "PASS");
        } catch (WebDriverException e) {
            logger.debug("The browser:" + browser + " could not be launched");
            reportStep("The browser:" + browser + " could not be launched", "FAIL");
        }
    }

    public WebElement locateElement(String locator, String locValue) {
        try {
            switch (locator) {

            case ("id"):
                return driver.findElementById(locValue);
            case ("link"):
                return driver.findElementByLinkText(locValue);
            case ("xpath"):
                return driver.findElementByXPath(locValue);
            case ("name"):
                return driver.findElementByName(locValue);
            case ("class"):
                return driver.findElementByClassName(locValue);
            case ("tag"):
                return driver.findElementByTagName(locValue);
            }
        } catch (NoSuchElementException e) {
            reportStep("The element with locator " + locator + " and with value " + locValue + " not found.", "FAIL");
            throw new RuntimeException();
        } catch (WebDriverException e) {
            reportStep("WebDriverException", "FAIL");
        }
        return null;
    }

    public WebElement locateElement(String locValue) {
        return driver.findElementById(locValue);
    }

    public void type(WebElement ele, String data) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(ele));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            ele.clear();
            ele.sendKeys(data);
            logger.info("The data: " + data + " entered successfully in field");
            reportStep("The data: " + data + " entered successfully in field", "PASS");
        } catch (InvalidElementStateException e) {
            logger.debug("The element: " + ele + " is not interactable");
            reportStep("The element: " + ele + " is not interactable", "FAIL");
        } catch (WebDriverException e) {
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }
    }

    public void click(WebElement ele, String text) {
        // String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOf(ele));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            // text = ele.getText();

            ele.click();

            logger.info("The element : " + text + " is clicked ");

            reportStep("The element : " + text + " is clicked ", "PASS");
        } catch (InvalidElementStateException e) {
            logger.debug("The element : " + text + " is not interactable ");
            reportStep("The element: " + text + " is not interactable", "FAIL");
        } catch (WebDriverException e) {
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void pressEnterKey(WebElement ele) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            ele.sendKeys(Keys.ENTER);
            logger.info("Enter key is pressed");
            reportStep("Enter key is pressed", "PASS");
        } catch (InvalidElementStateException e) {

            logger.debug("Enter key is not pressed");
            reportStep("Enter key is not pressed", "FAIL");
        } catch (WebDriverException e) {
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void pressTabKey(WebElement ele) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            ele.sendKeys(Keys.TAB);
            logger.info("Tab key is pressed");
            reportStep("Tab key is pressed", "PASS");
        } catch (InvalidElementStateException e) {
            logger.debug("Tab key is not pressed");
            reportStep("Tab key is not pressed", "FAIL");
        } catch (WebDriverException e) {

            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void clickWithNoSnap(WebElement ele) {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            text = ele.getText();
            ele.click();
            // switchToWindow(0);
            reportStep("The element :" + text + "  is clicked.", "PASS", false);
        } catch (InvalidElementStateException e) {
            reportStep("The element: " + text + " is not interactable", "FAIL", false);
        } catch (WebDriverException e) {
            reportStep("WebDriverException" + e.getMessage(), "FAIL", false);
        }
    }

    public String getText(WebElement ele) {
        String bReturn = "";
        try {
            bReturn = ele.getText();
        } catch (WebDriverException e) {
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }
        return bReturn;
    }

    public String getTitle() {
        String bReturn = "";
        try {
            bReturn = driver.getTitle();
        } catch (WebDriverException e) {
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }
        return bReturn;
    }

    public String getAttribute(WebElement ele, String attribute) {
        String bReturn = "";
        try {
            bReturn = ele.getAttribute(attribute);
        } catch (WebDriverException e) {
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }
        return bReturn;
    }

    public void selectDropDownUsingText(WebElement ele, String value) {
        try {
            new Select(ele).selectByVisibleText(value);
            reportStep("The dropdown is selected with text " + value, "PASS");
        } catch (WebDriverException e) {
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void selectDropDownUsingIndex(WebElement ele, int index) {
        try {
            new Select(ele).selectByIndex(index);
            reportStep("The dropdown is selected with index " + index, "PASS");
        } catch (WebDriverException e) {
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public boolean verifyTitle(String expectedTitle) {
        boolean bReturn = false;
        try {
            if (getTitle().equals(expectedTitle)) {
                logger.info("The expected title matches the actual " + expectedTitle);

                reportStep("The expected title matches the actual " + expectedTitle, "PASS");
                bReturn = true;
            } else {
                logger.debug(" The expected title doesn't matches the actual " + expectedTitle);
                reportStep(getTitle() + " The expected title doesn't matches the actual " + expectedTitle, "FAIL");
            }
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
        return bReturn;

    }

    public void verifyExactText(WebElement ele, String expectedText) {
        try {
            if (getText(ele).equals(expectedText)) {
                logger.info("The expected text matches the actual " + expectedText);
                reportStep("The expected text matches the actual " + expectedText, "PASS");
            } else {
                logger.debug(" The expected text doesn't matches the actual " + expectedText);
                reportStep("The expected text doesn't matches the actual " + expectedText, "FAIL");
            }
        } catch (WebDriverException e) {
            logger.debug(" The expected text doesn't matches the actual " + expectedText);
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }

    }

    public void verifyPartialText(WebElement ele, String expectedText) {
        try {
            if (getText(ele).contains(expectedText)) {
                logger.info("The expected text contains the actual " + expectedText);
                reportStep("The expected text contains the actual " + expectedText, "PASS");
            } else {
                reportStep("The expected text doesn't contain the actual " + expectedText, "FAIL");
            }
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void verifyExactAttribute(WebElement ele, String attribute, String value) {
        try {
            if (getAttribute(ele, attribute).equals(value)) {
                reportStep("The expected attribute :" + attribute + " value matches the actual " + value, "PASS");
            } else {
                reportStep("The expected attribute :" + attribute + " value does not matches the actual " + value,
                        "FAIL");
            }
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }

    }

    public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
        try {
            if (getAttribute(ele, attribute).contains(value)) {
                reportStep("The expected attribute :" + attribute + " value contains the actual " + value, "PASS");
            } else {
                reportStep("The expected attribute :" + attribute + " value does not contains the actual " + value,
                        "FAIL");
            }
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void verifySelected(WebElement ele) {
        try {
            if (ele.isSelected()) {

                reportStep("The element " + ele + " is selected", "PASS");
            } else {
                reportStep("The element " + ele + " is not selected", "FAIL");
            }
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void verifyDisplayed(WebElement ele, String elementName) {
        try {
            if (ele.isDisplayed()) {
                logger.info("The element " + elementName + "is displayed");
                reportStep("The element " + elementName + " is visible", "PASS");
            } else {
                logger.info("The element " + elementName + "is not displayed");
                reportStep("The element " + elementName + " is not visible", "FAIL");
            }
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public boolean VerifyIsDisplayed(WebElement ele, String elementName) {
        boolean bReturn = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(ele));
            if (ele.isDisplayed()) {
                bReturn = true;
                logger.info("The element " + elementName + "is displayed");
                reportStep("The element " + elementName + "is displayed", "PASS");

            }
        } catch (WebDriverException e) {
            bReturn = false;
            logger.info("The element " + elementName + "is not displayed");
            reportStep("The element " + elementName + "is not displayed", "PASS");
        }
        return bReturn;
    }

    public void verifyEnabled(WebElement ele) {
        try {
            if (ele.isEnabled()) {
                reportStep("The element " + ele + " is enabled", "PASS");
                logger.info("The radio button" + ele + " is enabled ");

            } else {
                reportStep("The element " + ele + " is disabled", "FAIL");
                logger.debug("The radio button" + ele + " is disabled ");
            }
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void switchToWindow(int index) {
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            List<String> allHandles = new ArrayList<>();
            allHandles.addAll(allWindowHandles);
            driver.switchTo().window(allHandles.get(index));
        } catch (NoSuchWindowException e) {
            reportStep("The driver could not move to the given window by index " + index, "PASS");
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void switchToFrame(WebElement ele) {
        try {
            // driver.switchTo().frame(ele);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));

            logger.info("switch In to the Frame");
            reportStep("switch In to the Frame ", "PASS");
        } catch (NoSuchFrameException e) {
            logger.debug("Not switched In to the Frame");
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void switchToMultipleFrames(String frame1, String frame2) {
        try {

            driver.switchTo().frame(frame1).switchTo().frame(frame2);

            logger.info("switch In to Multiple Frames");

            reportStep("switch In to the Frame ", "PASS");
        } catch (NoSuchFrameException e) {
            logger.debug("Not switched In to Multiple Frames");
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void acceptAlert() {
        String text = "";
        try {
            Alert alert = driver.switchTo().alert();
            text = alert.getText();
            alert.accept();
            reportStep("The alert " + text + " is accepted.", "PASS");
        } catch (NoAlertPresentException e) {
            reportStep("There is no alert present.", "FAIL");
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void dismissAlert() {
        String text = "";
        try {
            Alert alert = driver.switchTo().alert();
            text = alert.getText();
            alert.dismiss();
            reportStep("The alert " + text + " is dismissed.", "PASS");
        } catch (NoAlertPresentException e) {
            reportStep("There is no alert present.", "FAIL");
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }

    }

    public String getAlertText() {
        String text = "";
        try {
            Alert alert = driver.switchTo().alert();
            text = alert.getText();
        } catch (NoAlertPresentException e) {
            reportStep("There is no alert present.", "FAIL");
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
        return text;
    }

    public void rightClickAction(WebElement ele) {
        try {
            Actions action = new Actions(driver);
            action.contextClick(ele).perform();
            logger.info("Right click action is performed on the" + ele);
            reportStep("rightclick action is performed ", "PASS");
        } catch (WebDriverException e) {
            logger.debug("Right click action is not performed on the" + ele);
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void doubleClickAction(WebElement ele) {
        try {
            Actions action = new Actions(driver);

            action.doubleClick(ele).perform();
            logger.info("Double click action is performed on the" + ele);
            reportStep("DoubleClick action is performed ", "PASS");
        } catch (WebDriverException e) {
            logger.debug("Double click action is not performed on the" + ele);
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void explicitWait(WebElement ele) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(ele));

            reportStep("The element is waited for 20 secs ", "PASS");
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }
    }

    public void uploadDocument(String attachment) throws Throwable {
        try {
            String path = System.getProperty("user.dir");
            String filename = path + "\\documentstoupload\\" + attachment;
            // Setting clipboard with file location
            StringSelection stringSelection = new StringSelection(filename);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            // native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_ENTER);
            reportStep("Document from local system has been attached ", "PASS");
        } catch (WebDriverException e) {
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }

    }

    public long takeSnap() {
        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
        try {
            String path = System.getProperty("user.dir");
            FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
                    new File(path + "//reports//images//" + number + ".jpg"));

        } catch (WebDriverException e) {
            System.out.println("The browser has been closed.");
        } catch (IOException e) {
            System.out.println("The snapshot could not be taken");
        }
        return number;
    }

    public void closeBrowser() {
        try {
            driver.close();
            logger.info("The Browser is closed");
            reportStep("The browser is closed", "PASS");
        } catch (Exception e) {
            logger.debug("The browser could not be closed");
            reportStep("The browser could not be closed", "FAIL");
        }
    }

    public void scrollDownthePage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void switchToDefaultFrame() {

        try {
            driver.switchTo().defaultContent();
            logger.info("Switched to the default frame");
            reportStep("Switched to the default frame", "PASS");
        } catch (WebDriverException e) {
            logger.info("Not Switched to the default frame");
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");

        }
    }

    public void closeAllBrowsers() {
        try {
            driver.quit();
            logger.info("The opened Browsers are closed");
            reportStep("The opened browsers are closed", "PASS");
        } catch (Exception e) {
            logger.debug("The browsers could not be closed");
            reportStep("The browsers could not be closed", "FAIL");
        }
    }

    // ===============================================================================

    // *****************DOC PRO SPECIFIC
    // METHODS***************************************

    public void clickOnSpecifiLevel(String levelName) {

        System.out.println("Method execute");
        try {
            // WebElement eleClickOnLevel=locateElement("xpath", "//span[text()='" +
            // levelName + "']");

            System.out.println("*****The message is" + driver.getTitle());

            WebElement eleClickOnLevel = driver.findElementByXPath("//span[text()='" + levelName + "']");
            eleClickOnLevel.click();
            /*
             * WebElement eleClickOnLevel; eleClickOnLevel
             * =driver.findElementByXPath("//span[text()='" + levelName + "']");
             */

            logger.info("The specific level : " + levelName + " is clicked ");
            reportStep("The specific level : " + levelName + " is clicked ", "PASS");
        } catch (InvalidElementStateException e) {
            logger.debug("The specific level  : " + levelName + " is not interactable ");
            reportStep("The specific level : " + levelName + " is not interactable", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific level  : " + levelName + " is not interactable ");
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void rightClickOnSpecifiLevel(String levelName) {

        try {

            WebElement eleClickOnLevel = driver.findElementByXPath("//span[text()='" + levelName + "']");
            Actions action = new Actions(driver);
            action.contextClick(eleClickOnLevel).perform();
            logger.info("Right click action is performed on the" + levelName);
            reportStep("rightclick action is performed ", "PASS");

        } catch (WebDriverException e) {
            logger.debug("Right click action is not performed on the" + levelName);
            reportStep("WebDriverException : " + e.getMessage(), "FAIL");
        }

    }

    public void ValidateDocumentNumberLink(String prefix, String documentNumber) {

        try {

            WebElement documentNumberLink = locateElement("xpath",
                    "//a[text()='" + prefix + "" + documentNumber + "']");

            verifyExactText(documentNumberLink, prefix + documentNumber);
            logger.info("The specific document number   : " + prefix + documentNumber + " is validated");
            reportStep("The specific document number   : " + prefix + documentNumber + " is validated", "PASS");

        } catch (InvalidElementStateException e) {
            logger.debug("The specific document number   : " + prefix + documentNumber + " is not validated ");
            reportStep("The specific document number : " + prefix + documentNumber + " is not validated", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific document number  : " + prefix + documentNumber + " is not validated ");
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void ValidateDocumentName(String documentName) {

        try {
            WebElement eleValidateDocumentName = locateElement("xpath", "//td[text()='" + documentName + "']");
            verifyExactText(eleValidateDocumentName, documentName);

            logger.info("The specific document name   : " + documentName + " is validated");
            reportStep("The specific document name   : " + documentName + " is validated", "PASS");

        } catch (InvalidElementStateException e) {
            logger.debug("The specific document name   : " + documentName + " is not validated ");
            reportStep("The specific document name : " + documentName + " is not validated", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific document name  : " + documentName + " is not validated ");
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void ValidateRevNum(String revision) {

        try {

            WebElement eleValidateRevNum = locateElement("xpath", "//td[text()='" + revision + "']");
            verifyExactText(eleValidateRevNum, revision);

            logger.info("The specific revision number   : " + revision + " is validated");
            reportStep("The specific revision number  : " + revision + " is validated", "PASS");

        } catch (InvalidElementStateException e) {
            logger.debug("The specific revision number   : " + revision + " is not validated ");
            reportStep("The specific revision number : " + revision + " is not validated", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific revision number  : " + revision + " is not validated ");
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void ValidateDocOwner(String docOwner) {

        try {

            WebElement eleValidateDocOwner = locateElement("xpath", "//td[text()='" + docOwner + "']");
            verifyExactText(eleValidateDocOwner, docOwner);

            logger.info("The specific document owner   : " + docOwner + " is validated");
            reportStep("The specific document owner   : " + docOwner + " is validated", "PASS");

        } catch (InvalidElementStateException e) {
            logger.debug("The specific document owner   : " + docOwner + " is not validated ");
            reportStep("The specific document owner : " + docOwner + " is not validated", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific document owner  : " + docOwner + " is not validated ");
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void rightClickOnDocumentNumberLink(String prefix, String documentNumber) {

        try {
            WebElement elerightClickDocumentNumberLink = locateElement("xpath",
                    "//a[text()='" + prefix + "" + documentNumber + "']");

            rightClickAction(elerightClickDocumentNumberLink);

            logger.info("Right Clicked on the specific document number: " + prefix + documentNumber);
            reportStep("Right Clicked on the specific document number: " + prefix + documentNumber, "PASS");

        } catch (InvalidElementStateException e) {
            logger.debug("cant perform Right Click on the specific document number: " + prefix + documentNumber);
            reportStep("cant perform Right Click on the specific document number: " + prefix + documentNumber, "FAIL");
        } catch (WebDriverException e) {
            logger.debug("cant perform Right Click on the specific document number: " + prefix + documentNumber);
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public void clickOnDocumentNumberLink(String prefix, String documentNumber) {

        try {

            WebElement documentNumberLink = locateElement("xpath",
                    "//a[text()='" + prefix + "" + documentNumber + "']");
            click(documentNumberLink, "Document number link");

            logger.info("The specific document number   : " + prefix + documentNumber + " is clicked");
            reportStep("The specific document number   : " + prefix + documentNumber + " is clicked", "PASS");

        } catch (InvalidElementStateException e) {
            logger.debug("The specific document number   : " + prefix + documentNumber + " is not clicked ");
            reportStep("The specific document number : " + prefix + documentNumber + " is not clicked", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific document number  : " + prefix + documentNumber + " is not clicked ");
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }

    }

    public static void main(String[] args) {

        PropertyConfigurator.configure("Log4j.properties");

    }

}
