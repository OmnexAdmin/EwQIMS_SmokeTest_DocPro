package main.java.CommonMethods;


import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;


public class DocProSpecificMethods extends ProjectMethods  {

    public DocProSpecificMethods(RemoteWebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(driver, this);

    }
    
    public void clickOnSpecifiLevel(String levelName ) {
        
        System.out.println("Method execute");
        try {
            //WebElement eleClickOnLevel=locateElement("xpath", "//span[text()='" + levelName + "']");

            System.out.println("*****The message is"+driver.getTitle());
            
            WebElement eleClickOnLevel=driver.findElementByXPath("//span[text()='" + levelName + "']");
            eleClickOnLevel.click();
            /*
             * WebElement eleClickOnLevel; eleClickOnLevel
             * =driver.findElementByXPath("//span[text()='" + levelName + "']");
             */
                 
         logger.info("The specific level : " + levelName + " is clicked ");
         reportStep("The specific level : " + levelName + " is clicked ", "PASS");
        } catch (InvalidElementStateException e) {
            logger.debug("The specific level  : " + levelName + " is not interactable " );
            reportStep("The specific level : " + levelName + " is not interactable", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific level  : " + levelName + " is not interactable " );
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }
        
        
    }
    
    
    public void ValidateDocumentNumberLink(String prefix, String documentNumber) {
        
        try {
            
            
            WebElement documentNumberLink =locateElement("xpath", "//a[text()='"+prefix+""+ documentNumber+"']");
            
            verifyExactText(documentNumberLink, prefix+documentNumber);
            logger.info("The specific document number   : " +prefix+documentNumber+" is validated");
            reportStep("The specific document number   : " +prefix+documentNumber+" is validated", "PASS");
            
        } catch (InvalidElementStateException e) {
            logger.debug("The specific document number   : " + prefix+documentNumber + " is not validated " );
            reportStep("The specific document number : " + prefix+documentNumber + " is not validated", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific document number  : " + prefix+documentNumber + " is not validated " );
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }
            
    
    }
    
    
    public void ValidateDocumentName(String documentName) {
        
        try {
            WebElement eleValidateDocumentName = locateElement("xpath", "//td[text()='" + documentName + "']");
            verifyExactText(eleValidateDocumentName, documentName);
            
            logger.info("The specific document name   : " +documentName+" is validated");
            reportStep("The specific document name   : " +documentName+" is validated", "PASS");
            
        } catch (InvalidElementStateException e) {
            logger.debug("The specific document name   : " + documentName + " is not validated " );
            reportStep("The specific document name : " + documentName + " is not validated", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific document name  : " + documentName + " is not validated " );
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }
            
    
    }
    
  public void ValidateRevNum(String revision) {
        
        try {

            WebElement eleValidateRevNum = locateElement("xpath", "//td[text()='"+revision+"']");
            verifyExactText(eleValidateRevNum, revision);
            
            logger.info("The specific revision number   : " +revision+" is validated");
            reportStep("The specific revision number  : " +revision+" is validated", "PASS");
            
        } catch (InvalidElementStateException e) {
            logger.debug("The specific revision number   : " + revision + " is not validated " );
            reportStep("The specific revision number : " + revision + " is not validated", "FAIL");
        } catch (WebDriverException e) {
            logger.debug("The specific revision number  : " + revision + " is not validated " );
            reportStep("WebDriverException" + e.getMessage(), "FAIL");
        }
            
    
    }
    
  
  
public void ValidateDocOwner(String docOwner) {
      
      try {

          WebElement eleValidateDocOwner =locateElement("xpath", "//td[text()='" +docOwner+"']");
          verifyExactText(eleValidateDocOwner, docOwner);
          
          logger.info("The specific document owner   : " +docOwner+" is validated");
          reportStep("The specific document owner   : " +docOwner+" is validated", "PASS");
          
      } catch (InvalidElementStateException e) {
          logger.debug("The specific document owner   : " + docOwner + " is not validated " );
          reportStep("The specific document owner : " + docOwner + " is not validated", "FAIL");
      } catch (WebDriverException e) {
          logger.debug("The specific document owner  : " + docOwner + " is not validated " );
          reportStep("WebDriverException" + e.getMessage(), "FAIL");
      }
          
  
  }
    
    
    
    
 
    }

