package pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/*
 * Description :- This class contain Xpath locators of web elelments 
 */ 
public class UserRoleElements {
	
@FindBy(xpath = "//div[@id='hs-en-cookie-confirmation-buttons-area']//a[contains(text(),'Accept')]")
public WebElement AcceptCookies;

public WebElement getAcceptCookies() {
	return AcceptCookies;
}	

@FindBy(xpath = "//li//span[contains(text(),'Jobs')]")
public WebElement Clickmenu_Job;

public WebElement getClickMenuJob() {
	return Clickmenu_Job;
	}

@FindBy(xpath = "//li//a[contains(text(),'Job Board')]")
public WebElement ClickMenuJobBoard;

public WebElement getClickMenuJobBoard() {
	return ClickMenuJobBoard;
	}

@FindBy(xpath = "//li//span[contains(text(),'Destinations')]")
public WebElement ClickMenuJobDestinations;

public WebElement getClickMenuJobDestinations() {
	return ClickMenuJobDestinations;
	}

@FindBy(xpath = "//h2[contains(text(),'Countries')]")
public WebElement CheckCountriesTitle;

public WebElement getCheckCountriesTitle() {
	return CheckCountriesTitle;
	}
}
