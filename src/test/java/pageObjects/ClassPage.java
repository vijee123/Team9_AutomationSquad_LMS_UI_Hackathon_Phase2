package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassPage extends BasePage {
	
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']//span[contains(text(),'Class')]")
	private WebElement classButton;
	
	@FindBy(xpath = "//div[@class='box' and normalize-space(text())='Manage Class']")
	private WebElement manageClassText;
	
	@FindBy(xpath="//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']//span[contains(text(),' LMS - Learning Management System')]")		
	private WebElement LMSText;
	
	@FindBy(xpath="//span[@class='p-input-icon-left']//input[@id='filterGlobal']")
	private WebElement searchBar;
	
//	@FindBy(xpath="//span[@class='p-input-icon-left']//input[@id='filterGlobal']")
//	private WebElement searchBar;
	
//	@FindBy(xpath="//span[@class='p-input-icon-left']//input[@id='filterGlobal']")
//	private WebElement searchBar;
	
//	@FindBy(xpath="//span[@class='p-input-icon-left']//input[@id='filterGlobal']")
//	private WebElement searchBar;
	
	public ClassPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
		public void clickClassButton() {
			
			JavascriptExecutor  js= (JavascriptExecutor ) driver;
            js.executeScript("window.scrollBy(0,-300);");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
            wait.until(ExpectedConditions.visibilityOf(classButton)).click();;
      	
		}
		
		public void addNewClass() {
			WebElement addNewClass=driver.findElement(By.xpath("//button[contains(@class, 'mat-focus-indicator mat-menu-item')]"));    		
	        addNewClass.click(); 
		}
		
		public boolean ismanageClassTextDisplayed() {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.visibilityOf(manageClassText));
			    return manageClassText.isDisplayed();
		}	   
		public boolean isLMSTextDisplayed() {
			String ww=LMSText.getText();
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.visibilityOf(LMSText));
			    return LMSText.isDisplayed();
		}	
		public boolean isSearchBarDisplayed() {
			return searchBar.isDisplayed();
		}
		
		@FindBy(xpath = "//thead//th") 
		private List<WebElement> tableHeaders;

		public List<String> getTableHeaders() {
		    List<String> headersText = new ArrayList<>();
		    for (WebElement header : tableHeaders) {
		        headersText.add(header.getText().trim());
		    }
		    return headersText;
		}
}
