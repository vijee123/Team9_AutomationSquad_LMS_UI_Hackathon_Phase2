package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {

		super(driver);
	}
	
	
// -------------------------------WebElements------------------------------------------
	
	@FindBy (xpath = "//span[text()='Logout']") 
	WebElement logoutButton;
	
	@FindBy (xpath ="//span[text()='Login']")
	WebElement loginButton;
	
	
	
	
//	---------------------------Methods-----------------------------
	
	
	public void clickLogout() {
		waitForElementVisibility(logoutButton);
		logoutButton.click();
	}
	
	public boolean reachedLoginPage() {
		waitForElementVisibility(loginButton);
		return loginButton.isDisplayed();
	}
	
	
	

}
