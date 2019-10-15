package config;
import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.StringTokenizer;
//import java.util.concurrent.TimeUnit;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.ConfigReader;
import pagefactory.UserRoleElements;

public class MenuItems_Main {

	protected WebDriver driver;
	Properties prop;
	UserRoleElements user_role = new UserRoleElements();
	ConfigReader conf =new ConfigReader();
	WebDriverWait wait;
	SoftAssert softAssertion = new SoftAssert();
	 /*
	  * Description :- This method instantiate the chrome driver and opens Teach Away web page 
	  */
	public void setupmethod() throws InterruptedException,AWTException, IOException {

		ChromeOptions chrome_Profile = new ChromeOptions();
		String service = conf.getservicestring();
		System.setProperty("webdriver.chrome.driver", service);
		driver = new ChromeDriver(chrome_Profile);
		user_role = PageFactory.initElements(driver,UserRoleElements.class );
		driver.get(conf.getUrl());
		System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		/*
		 * Description :- This code snippet checks if the correct url is opened and user is Navigated to Teach Away home page 
		 */	
		 String ExpectedTitle_Main = "Teach Abroad - Teach Away - Discover Where Teaching Can Take You";
		 softAssertion.assertTrue(ExpectedTitle_Main.equals(driver.getTitle()), "Title does not match");
		 softAssertion.assertAll();
						
			}
	/*
	 * Description :- This method test the Sub Menu Job of header Navigation Menu  
	 */	
	@SuppressWarnings("resource")
	public void Menu_Jobs() throws Exception{
				
		wait = new WebDriverWait(driver,50); 
		wait.until(ExpectedConditions.visibilityOf(user_role.getAcceptCookies()));
		user_role.getAcceptCookies().click();
	/*
	 * Description :- This code Snippet checks the Menu items of Header navigation Menu from Array list.  
	 */		 
		List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='tb-megamenu-nav nav level-0 items-5']/li"));
		 String[] expected = {"JOBS", "TEFL", "TEACHER CERTIFICATION", "COURSES", "HIRE TEACHERS"};
		 
			for (int i = 0; i < expected.length; i++) {
			    String elementsValue = menuItems.get(i).getText();
			    System.out.println(elementsValue);
			    if (elementsValue.equals(expected[i])) {
			        System.out.println("passed on: " + menuItems);
			    } else {
			        System.out.println("failed on: " + menuItems);
			    }
			}
	/*
	 * Description :- This code Snippet checks the Menu items of Header navigation Menu from Excel file.  
	 */		
		
		/* FileInputStream file1 = new FileInputStream("C:\\Users\\sachinsehgal2\\Downloads\\MenuItems.xlsx");
		 @SuppressWarnings("resource")
		 XSSFWorkbook wbSh1 = null;
		 wbSh1 = new XSSFWorkbook(file1);
		 XSSFSheet SheetOne = wbSh1.getSheet("Sheet1");
		 int rowCount = SheetOne.getLastRowNum()-SheetOne.getFirstRowNum();
		 
		List<WebElement> menuItemsExcel = driver.findElements(By.xpath("//ul[@class='tb-megamenu-nav nav level-0 items-5']/li"));
		  
		for (int i = 0; i < rowCount+1; i++)
		{
			Row row= SheetOne.getRow(i);
			
			for (int j = 0; j < row.getLastCellNum(); j++) {
				
				row.getCell(j).getStringCellValue();
				String elementsValue = menuItemsExcel.get(i).getText();
				
				if (elementsValue.equals(row.getCell(j).getStringCellValue())) {
			        System.out.println("passed on: " + menuItemsExcel);
			    }
				else {
			        System.out.println("failed on: " + menuItemsExcel);
			    }
				
			}
			}*/
				 
		 wait.until(ExpectedConditions.visibilityOf(user_role.getClickMenuJob()));
		 user_role.getClickMenuJob().click();
		/*
		 * Description :- This code Snippet checks the Menu items of Jobs from Array list.  
		 */			 
		 List<WebElement> menuItemsJobs = driver.findElements(By.xpath("//ul[@class='tb-megamenu-subnav mega-nav level-1 items-6']/li"));
		 String[] expectedMenu = {"Job Board", "Destinations", "Featured Programs", "Job Openings", "Teach in the US","Community"};
		  System.out.println(expectedMenu.length);
		  
		 for (int a = 0; a < expectedMenu.length; a++) {
			    String elementsValueJobs = menuItemsJobs.get(a).getText();
			    System.out.println(elementsValueJobs);
			    if (elementsValueJobs.equals(expectedMenu[a])) {
			        System.out.println("passed on: " + menuItemsJobs);
			    } else {
			        System.out.println("failed on: " + menuItemsJobs);
			    }
			}
		 
		 wait.until(ExpectedConditions.visibilityOf(user_role.getClickMenuJobBoard()));
		 user_role.getClickMenuJobBoard().click();
		
		 String ExpectedTitle = "Teaching Jobs - Teaching Jobs Abroad - Overseas Jobs - International Teaching Jobs - Page 1";
		 softAssertion.assertTrue(ExpectedTitle.equals(driver.getTitle()), "Title does not match");
		 
		 wait.until(ExpectedConditions.visibilityOf(user_role.getClickMenuJob()));
		 user_role.getClickMenuJob().click();
		 
		 wait.until(ExpectedConditions.visibilityOf(user_role.getClickMenuJobDestinations()));
		 user_role.getClickMenuJobDestinations().click();
		 
		 if (user_role.getCheckCountriesTitle().getText().toString().contains("Countries") ){
				
			 System.out.println("Countries label in Destination sub menu is present \n");
		}
		 		else{
			 
			 System.out.println("Countries label in Destination sub menu is not present \n");
		 }
		 		 
		 softAssertion.assertAll();
 
	}
	
	/*
	 * Description :- This code snippet send email after automation code is run.  
	 */	
	public void SendEmail() throws Exception {

			
		// Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setURL(new URL("file:///C:/Users/sachinsehgal2/eclipse-workspace/TeachAway/Test_Report.html"));
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Selenium Report");
		  attachment.setName("TeachAway_Menu Navigation Automation Report.html");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthentication("admin@gmail.com", "password");
			email.setSSLOnConnect(true);
		 	email.addCc("Stakeholder@accenture.com", "StakeHolder");
			email.setFrom("admin@gmail.com", "admin");
			email.setSubject("Automation Status -TeachAway Navigation Menu");
			email.setMsg("PFA the results for automation of Navigation menu for Teach Away.");
		  
		  // add the attachment
		  email.attach(attachment);
		  // send the email
		  email.send();
		System.out.println("The email Sent");
	}
	
}

