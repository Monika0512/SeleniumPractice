import org.testng.annotations.Test;
import config.MenuItems_Main;
import util.Utility;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.relevantcodes.extentreports.ExtentReports;
import java.awt.AWTException;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class MenuItems_Test extends MenuItems_Main {	
	ExtentReports report;
	ExtentTest logger;
	/*
	 * Description :- This method is initialized to set up and instantiate the
	 * driver
	 */
	 @BeforeTest
	  public void beforeTest() throws InterruptedException,AWTException, IOException {
		 
		 setupmethod();
		 report = new ExtentReports("./Test_Report.html", true);
		 logger = report.startTest("Verify Setup Method", "Setup Method")
					.assignCategory("Functional");			
		 logger.log(LogStatus.PASS,
					"Setup Method Tested successfully");
	  }	
	 /*
	  * Description :- This method is to test Jobs sub menu of navigation header menu. 
	  */
  @Test(priority = 1)
     public void Menu_Items() throws Exception {
	 			
	       Menu_Jobs();
	  		logger = report.startTest("Verify Navigation Menu -Jobs", "Menu_Items Method")
				.assignCategory("Functional");			
		    logger.log(LogStatus.PASS,
				"Navigation Menu-Jobs Tested successfully");
	  
  }
	 /*
	  * Description :- This method is to capture screenshot of test cases 
	  */
  
  @AfterMethod
	public void tearDown(ITestResult result) throws Exception {
	
		try
		{
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(
					LogStatus.INFO,
					"Snapshot below: "+logger.addScreenCapture(Utility
							.captureScreenShot(driver, result.getName()))
							);
		} else {
				
			logger.log(LogStatus.FAIL, result.getName()
					+ "_failed and error is '" + result.getThrowable() + "'");
			logger.log(
					LogStatus.INFO,
					"Snapshot below: "+ logger.addScreenCapture(Utility
							.captureScreenShot(driver, result.getName()
									+ "_failed")));
		}																
		
		}
		catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Null Pointer");
		}
		
			}
	 /*
	  * Description :- This method is perform steps before end of the automation execution 
	  */ 
  @AfterTest
  public void afterTest() throws Exception {
		  
	  report.endTest(logger);
	  report.flush();
	  //SendEmail();
	  driver.quit();
  }
	}

