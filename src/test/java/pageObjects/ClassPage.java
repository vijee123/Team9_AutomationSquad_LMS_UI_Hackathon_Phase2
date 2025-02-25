package pageObjects;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public   class ClassPage extends BasePage   {
	
	public ClassPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']//span[contains(text(),'Class')]")
	private WebElement classButton;
	@FindBy(xpath="//span[@class='p-input-icon-left']//input[@id='filterGlobal']")
	private WebElement searchBar;
	@FindBy(xpath=("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]"))
	private WebElement  checkboxName;
	@FindBy(xpath="//*[@id=\"batchName\"]")
	private WebElement   batchnamefield;
	@FindBy(xpath = "//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]")
	private WebElement checkbox;
	@FindBy(xpath="//p-dropdown[@id='batchName']")	
	private WebElement batchname;
	@FindBy(xpath="//input[@id='classDescription']")
	private WebElement  classdesriptiontextbox;
	@FindBy(xpath="//input[@placeholder='Select a Staff Name']")
	private WebElement staffname;
	@FindBy(xpath = "//tbody/tr[1]/td[8]/div[1]/span[1]/button[1]/span[1]")
	private WebElement editIcon;
	@FindBy(xpath ="//input[@id='classTopic']")
     private WebElement  classtopicfield;
	@FindBy(xpath ="//span[@class='p-button-icon p-button-icon-left pi pi-check']")
	private WebElement savebutton;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']//span[contains(text(),'Class')]")
	private WebElement classButton1;
	@FindBy(xpath="///button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']//span[contains(text(),'Class')]")
	private WebElement batchlink;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']//span[contains(text(),'Class')]")
	private WebElement logoutlink;
	@FindBy(xpath="//tbody/tr[1]/td[8]/div[1]/span[1]/button[2]")
	private WebElement delete;
private void login() {
	// TODO Auto-generated method stub
			 String url = "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/";

	public void clickClassButton() {
					login();
					JavascriptExecutor  js= (JavascriptExecutor ) driver;
		            js.executeScript("window.scrollBy(0,-300);");
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		            wait.until(ExpectedConditions.visibilityOf(classButton)).click();
	
}
			public boolean ismanageClassTextDisplayed() {
		
			    return manageClassText.isDisplayed();
		}
		
		public void  clickonediticon () {
			clickClassButton(); // will be removed
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 20 seconds pause
// Create a WebDriverWait instance with a timeout of 10 seconds
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  
			WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxName));

			Actions actions = new Actions(driver);
			actions.moveToElement(checkbox).click().perform();

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
			//WebElement editIcon = wait1.until(ExpectedConditions.elementToBeClickable(editIcon));

			Actions actions1 = new Actions(driver);
			actions1.moveToElement(editIcon).click().perform();
			}
		public boolean  batchnameisdisabled() {
			 boolean isDisabled = batchnameisdisabled();
		        if (isDisabled) {
		            System.out.println("Batch Name field is disabled.");
		        } else {
		            System.out.println("Batch Name field is NOT disabled.");
		        }
				return isDisabled;
		}
		public  void isClassTopicFieldDisabled() {
			editIcon.click();
			System.out.println("class topic field is disabled");
	    }
		public void updateFieldsWithValidData(String staffName, String classDescription) {
			
			clickonediticon (); 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(classdesriptiontextbox)).clear();
			classdesriptiontextbox.sendKeys(classDescription);
            
	      // staffNameTextbox.sendKeys(staffName);

	        //wait.until(ExpectedConditions.visibilityOf(classdesriptiontextbox)).clear();
	       //classdesriptiontextbox.sendKeys(classdesription);

	       wait.until(ExpectedConditions.visibilityOf(staffname)).clear();
	       staffname.sendKeys(staffName);
	        
	    }
          public void clickSaveButton() {
	        savebutton.click();
	        System.out.println("Admin should see succesfully saved");
	    }
		
		public void fieldswithinvalidvalues() {
			clickonediticon (); 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(classdesriptiontextbox)).clear();
	        classdesriptiontextbox.sendKeys("");

	        wait.until(ExpectedConditions.visibilityOf(staffname)).clear();
	        staffname.sendKeys("123InvalidTopic!");
	        //savebutton.click();
		}
		public void clickSaveButton1() {
	        savebutton.click();
	        System.out.println("Admin should see succesfully saved");
	    }
		
		public void updatemandatoryfieldWithValidData() {
			clickonediticon ();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(staffname)).clear();
	        staffname.sendKeys("sami");
	        //savebutton.click();
		}
		public void clickSaveButton2() {
	        savebutton.click();
	        System.out.println("Admin should see succesfully saved");
	    }
		public void updateoptionalfield() {
			clickonediticon (); // will be removed
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(classdesriptiontextbox)).clear();
			classdesriptiontextbox.sendKeys("python");
	        //savebutton.click();
		}
		public void clickSaveButton3() {
	        savebutton.click();
	        System.out.println("Admin should see succesfully saved");
	    }
		public void cancelbutton() {
			clickonediticon (); 
			cancel.click();
			System.out.println("Admin should see details");
		}
		
		public void cliclclasslink() {
			clickClassButton(); // will be removed
			JavascriptExecutor  js= (JavascriptExecutor ) driver;
            js.executeScript("window.scrollBy(0,-300);");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  
			WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(classButton1));
             Actions actions = new Actions(driver);
			actions.moveToElement(classButton1).click().perform();
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
            //wait.until(ExpectedConditions.visibilityOf(classbuttonlink)).click();
		}
		public void clicklogoutlink() {
			clickClassButton(); // will be removed
			JavascriptExecutor  js= (JavascriptExecutor ) driver;
            js.executeScript("window.scrollBy(0,-300);");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  
			WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(logoutlink));
		}
		public  void clicksearchBar() {
			clickClassButton(); // will be removed
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		        wait.until(ExpectedConditions.visibilityOf(searchBar)).clear();
		        searchBar.sendKeys("Micro service-01");
		
		}
		public  void searchclastopic() {
			clickClassButton(); // will be removed
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.visibilityOf(searchBar)).clear();
	        searchBar.sendKeys("core java");
		}
		public void deleteicon() {
			clickClassButton(); // will be removed
	       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        //wait.until(ExpectedConditions.visibilityOf(delete)).click()
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement deleteElement = wait1.until(ExpectedConditions.elementToBeClickable(delete));

			Actions actions1 = new Actions(driver);
			actions1.moveToElement(deleteElement).click().perform();
	        System.out.println("Admin should see alert open ");
		}
		public void checkbox() {
			clickClassButton(); // will be removed
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  
			WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxName));

			Actions actions = new Actions(driver);
			actions.moveToElement(checkbox).click().perform();
			
		}
		public void clickyes() {
			deleteicon();
	        System.out.println("Admin should confirm deletion alert ");
		}
}
