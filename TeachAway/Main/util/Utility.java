package util;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

/*
 * Description :- This class contains code to capture screenshot 
 */ 
public class Utility {
	public static Date date; 
	ExtentTest logger;
	WebDriver driver;
	public static String captureScreenShot(WebDriver ldriver,String screenShotName)
	{   date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(" dd-MMM-YYYY h.mma");
        String date1= dateFormat.format(date);
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		String path=".\\Screenshots\\" + screenShotName + date1 +".png";
		
		try {
			
			FileUtils.copyFile(src, new File(path));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return path;
	}

}
