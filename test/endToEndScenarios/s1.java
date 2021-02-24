package endToEndScenarios;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import main.java.docProPages.Actions;
import main.java.docProPages.DocProAdminHomePage;
import main.java.docProPages.FolderManagement;
import main.java.suitePages.HomePage;
import main.java.suitePages.LevelCreationPage;
import main.java.suitePages.LoginPage;



public class s1 extends main.java.CommonMethods.ProjectMethods {

	@BeforeClass
	public void setData() {
		excelName = "s1";
		dataSheetName = "TC001to5";
		test = startTestCase("SmokeTest_Suite", "Basic Suite Functionality(6TCs)");
		category = "Smoke Test";
		authors = "Bhuvana B";
		browserName = "chrome";
	}

	@Test(dataProvider = "fetchData")
	

	public void login(String TestcaseNumber, String Runmode, String Scenario, String userName, String passWord,
			String userCount,String code, String fName, String lName, String eMail, String uName, String pwd, String confirmPassword,String levelName, String prefix, String reviewDue, String searchCriteria,
            String subLevelName, String subPrefix, String subReviewDue,String groupName,String documentNumber,String documentName,String attachment, String revision, String docOwner,String reasonForRequest, String changesRequired,String draftComments,
            String routeName,String routedesc,String  minNumofApproversReqd,String position,String existingDocRouteName, String approverPwd,String newApproverPwd,String confirmApproverPwd)
			throws Throwable {
	    
	    String[] userCode = code.split("\\|");
	    String[] userRouteName= routeName.split("\\|");
	    String[] approverName = userName.split("\\|");
	    
	  
	   //startApp(browserName);
		testCaseName = Scenario;
		testDescription = TestcaseNumber;
		test = startTestCase(testCaseName, testDescription);

		if (!Runmode.contains("Y")) {
			throw new SkipException("Run mode set as No");
		}

		  System.out.println("code execute after if");
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
		    
		    //Create the User into EwQIMS and validate the user is saved
		       startApp(browserName);
		       reportStep("The element : is clicked ", "PASS");
		     new LoginPage(driver, test)
			.login(userName, passWord)
			.clickOnUsersTab()
			.clickOnUsersMenu().
			addUsers(userCount,code,fName, lName, eMail, uName, pwd, confirmPassword);
			
			new HomePage(driver, test)
            .clickOnSetupTab();
			//Assign the created user as module administrator for Doc Pro

			new HomePage(driver, test)
			.clickOnModuleAdminMenu()
			.setUserAsModuleAdmin(code);
			new HomePage(driver, test)
            .clickOnSetupTab();
			
            //Assign the created user as Suite administrator 

            new HomePage(driver, test)
            .clickOnSuiteAdminMenu()
            .setUserAsSuiteAdmin(code);
            new HomePage(driver, test)
            .clickOnSetupTab();
            
            //Create the parent levels in suite

            new HomePage(driver, test)
             .clickOnLevelsMenu()
            .createParentLevels(levelName,prefix, reviewDue);
            new HomePage(driver, test)
            .clickOnSetupTab();
            
            //Create the Sub levels in suite

	         new LevelCreationPage(driver, test)
	         .createSubLevels(searchCriteria, levelName, subLevelName, subPrefix,subReviewDue);	
			break;

		case "TC004":
		  
		    startApp(browserName);
		    //Set Doc Pro as Landing Page to the created user
			new LoginPage(driver, test)
			.login(userName, passWord)
			.clickOnUsersTab()
			.clickOnUserPrefrencesMenu()
			.setDocProasLandingPage();
			
			//Refresh the page to view the Doc Pro Landing Page
			
			new HomePage(driver, test)
			.refresh();
			
			//Create Doc Pro Admin Group and assign the created user
		     new DocProAdminHomePage(driver, test)
		     .clickOnGroupsMenu()
            .createGroup(groupName, code);
		     
		    //Activate the folder from folder management in Doc Pro and set revision number as custom revision

			new DocProAdminHomePage(driver, test)
		     .clickOnFolderManagement()
			.inUseFolder(levelName);
			
			//Set No access for the site and Set Attach rights and Full access for the created group

			new HomePage(driver, test)
	         .clickOnSetupTab();
			new FolderManagement(driver, test)
            .setFolderRights(levelName, groupName);

            //Publish the document for the sub level which has auto approval route

			new DocProAdminHomePage(driver, test)
		    .clickonDocumentstab()
            .clickonNewDocumentRequestmenu()
            .uploadNewDocument(levelName, documentNumber, documentName, attachment);

			//Validate the  published document is displayed in TOC 
			 new DocProAdminHomePage(driver, test)
			.clickonDocumentstab()
            .clickOnDocumentsMenu()
            .validateDocumentPublished(levelName,prefix, documentNumber, documentName, revision, docOwner)
    
			//Initiate change request(Document Revision) for the document which has autoapproval route

            .reviseDocument(levelName,prefix, documentNumber, attachment, reasonForRequest, changesRequired);
            break;
            
		case "TC005":
		    
		    //Upload New document Draft
		    startApp(browserName);
		    new LoginPage(driver, test)
		    .moduleLandingPageLogin(userName, passWord)
		    .clickonDocumentstab()
            .clickOnNewDocDraftmenu()
            .uploadNewDraft(levelName, documentNumber, documentName, attachment, code);
		    
		    //Draft Viewer comments on the Draft
		    new Actions(driver,test)
            .draftRequestsNeedingViewing(documentName, attachment, draftComments)		   
		 
            //Change request the draft to document
            .pendingDocumentDrafts(documentName, attachment, reasonForRequest, changesRequired);
		    break; 
			
		case "TC006":  
		  
		    //Creation of users by module admin
		    startApp(browserName);
		  new LoginPage(driver, test)
		    .moduleLandingPageLogin(userName, passWord)
		      .clickOnDocProUsersMenu()
            .addUsers(userCount,code,fName, lName, eMail, uName, pwd, confirmPassword);
		   
		    //Create Doc Pro Approver Group 

            new HomePage(driver, test)
             .clickOnSetupTab();
		    
		   System.out.println("the user code is"+userCode[4]);
		    new DocProAdminHomePage(driver, test)
            .clickOnGroupsMenu()
            
            .createGroup(groupName, userCode[4]);
		   
		  //Create Route
		  
		   new DocProAdminHomePage(driver, test)
		   .clickOnRoutesMenu()
	       .createRoute(userRouteName[0], routedesc, userCode[4], minNumofApproversReqd, position);

           new HomePage(driver, test)
            .clickOnSetupTab();
		 
		   
		 //Set Route to the folder
            new DocProAdminHomePage(driver, test)
            .clickOnFolderManagement()
            .setRoute(levelName, userRouteName[1],existingDocRouteName);
           
		     new HomePage(driver, test)
            .clickOnSetupTab();
            
            //Disable Second Password 
            new DocProAdminHomePage(driver, test)
            .clickOnDocProSettingsMenu()
            .disable2ndPwd();
       
            
            //Revise the existing document for which the route has been set
            new DocProAdminHomePage(driver, test)
            .clickonDocumentstab()
            .clickOnDocumentsMenu() 
            .reviseDocument(levelName,prefix, documentNumber,attachment, reasonForRequest, changesRequired);
          
		 break;
		 
		case "TC007":
		    startApp(browserName);
		    for (int i = 0; i < 2; i++) {
		 //Set Doc Pro as Landing Page to the created user
            new LoginPage(driver, test)
            .login(approverName[i], passWord)
            .clickOnUsersTab()
            .clickOnUserPrefrencesMenu()
            .setDocProasLandingPage();
            
            //Refresh the page to view the Doc Pro Landing Page
            
            new HomePage(driver, test)
            .refresh();
            
            //Approver 1 approves the document
            
            new DocProAdminHomePage(driver, test)
           .clickOnActionsMenu()
            .requestsNeedingApproval(documentName, approverPwd, newApproverPwd, confirmApproverPwd);
		  
           if(i==0) {
               
        	   new HomePage(driver, test)
               .logOut();
               
           }else {
               
        	   new DocProAdminHomePage(driver, test)
               .clickonDocumentstab()
               .clickOnDocumentsMenu()
               .validateDocumentPublished(levelName,prefix, documentNumber, documentName, revision, docOwner);
         
           }
               
		    
		    }
		    
		   
		    break;
		    
        		default:
                break;
		}

		}

	}


