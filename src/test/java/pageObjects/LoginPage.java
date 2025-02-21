package pageObjects;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import utilities.LoggerLoad;

public class LoginPage extends BasePage {


	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameTextBox;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath ="//div[@class='mat-form-field-infix ng-tns-c158-2']//mat-select[@id='mat-select-0']")
	private WebElement dropDownClick;
	
	@FindBy(xpath ="//div[@id='cdk-overlay-0']//span[@class='mat-option-text']")
	private WebElement dropDownOption;
	
	@FindBy(xpath = "//button[@id='login']")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) throws InterruptedException {

		super(driver);
	} 
	
	public void openLoginPage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void enterUsername(String username) {
		userNameTextBox.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void selectDropdownOption() {
		dropDownClick.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(dropDownOption)).click();
	}

	public void clickLoginButton() {
		loginBtn.click();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}
}
//	            //**********Class Dashboard
//	          //  WebDriver wait1=new WebDriverWait(driver, Duration.ofSeconds(5));
//	            
//	       //  WebElement classButton=wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']/span[contains(text(), 'Class')]"));
//	          Thread.sleep(2000);
//	            WebElement classButton=driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']/span[contains(text(), 'Class')]"));
//	            		classButton.click();
//	        //********Add new class****Dynamic element
//	            		Thread.sleep(5000);	
//	        WebElement addNewClass=driver.findElement(By.xpath("//button[contains(@class, 'mat-focus-indicator mat-menu-item')]"));    		
//	        addNewClass.click(); 
//	        
//	        //Addnew DropDown
//	        Thread.sleep(1000);
//	        WebElement selectBatchName=driver.findElement(By.xpath("//input[@placeholder='Select a Batch Name']"));
//	      // WebElement selectBatchName1=driver.findElement(By.xpath("//div//span[@class='p-dropdown-trigger-icon ng-tns-c88-15 pi pi-chevron-down']"));
//	        selectBatchName.click();
//	        
	      
	    
