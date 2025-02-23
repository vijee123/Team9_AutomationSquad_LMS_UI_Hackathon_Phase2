package pageObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.openqa.selenium.support.Color;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import utilities.LoggerLoad;

public class LoginPage extends BasePage {

		public LoginPage(WebDriver driver) {

			super(driver);
		}
	
	public String actualColor;
	public String invalid_url="https://feb-ui-hackathon-bbfd38d67ea9.heroapp.com/";
	public String dashboard_page="https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/";

	//--------------------WebElements-------------------------------
	
	@FindBy (xpath = "//span[text()='This site can’t be reached']") 
	WebElement siteUnreachable;
	
	@FindBy (xpath = "//img[@src='assets/img/LMS-logo.jpg']")
	WebElement LMSLoginPageImage;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameTextBox;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath="//div[@id='mat-select-value-1']/span[text()='Select the role']")
	private WebElement selectRoleDropdownBox;
	
	@FindBy(xpath="//div[@class='mat-select-arrow ng-tns-c161-22']")
	private WebElement selectRoleDropdownArrow;
	
	@FindBy(xpath="//span[text()=' Admin ']")
	private WebElement selectAdminRole;
	
	@FindBy(xpath="//span[normalize-space(text())='Staff']")
	private WebElement  selectStaffRole;
	
	@FindBy(xpath="//span[normalize-space(text())='Student']")
	private WebElement  selectStudentRole;
	
	@FindBy(xpath = "//button[@id='login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[normalize-space(text())='Dashboard']")
	private WebElement dashboardLabel;
	
	@FindBy(xpath = "//span[normalize-space(text())='Home']")
	private WebElement HomeMenuLink;
	
	@FindBy(xpath = "//mat-error[normalize-space(text())='Please enter your user name']")
	private WebElement enterUsernameErrMsg;
	
	@FindBy(xpath = "//mat-error[normalize-space(text())='Please enter your password']")
	private WebElement enterPwdErrMsg;
	
	@FindBy (xpath = "//link")
	public static List<WebElement> LoginPageLinks;
	
	@FindBy (xpath = "//input[@id='username' or @id='password']")
	public static List<WebElement> textBoxesList;
	
	@FindBy (xpath = "//span[text()='User' or text()='Password']")
	public List<WebElement> textBoxtextList;
	
	@FindBy (xpath = "//span[text()='User']/following-sibling::span[text()=' *']")
	public WebElement userAsteriskMark;
	
	@FindBy (xpath = "//span[text()='Password']/following-sibling::span[text()=' *']")
	public WebElement passwordAsteriskMark;
	
	@FindBy (xpath = "class='mat-select-arrow-wrapper ng-tns-c161-3'")
	public WebElement roleDropDown;
	
	@FindBy (xpath = "//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c161-3 ng-star-inserted']")
	public WebElement selectRolePlaceholder;
	
	@FindBy (xpath = "//mat-option[@role='option']/span[@class='mat-option-text']")
	public List<WebElement> roleOptionsList;
	
	@FindBy (xpath = "//span[contains(text(), 'Invalid')]")
	public WebElement loginErrorMsg;
	
	@FindBy (xpath = "//p[text()='Please login to LMS application']") 
	WebElement plsLoginTextElement;
	
	@FindBy (xpath = "//img[@class='images']") 
	WebElement image;
	
	

	//-------------------------------Methods------------------------------------
	
	
	public boolean invalidUrlmsg(){
		return siteUnreachable.isDisplayed();
	}
	
	public void Login(String username, String password){
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		selectRoleDropdownBox.click();
		selectAdminRole.click();
		loginBtn.click();
	}
	
	public boolean dashboardLabelVisibility() {
		return true;
	}
	
	
	public void assignValueAndLogin(String user, String pwd, String Role) {
		userNameTextBox.sendKeys(user);
		passwordTextBox.sendKeys(pwd);
		selectRoleDropdownBox.click();
		
		switch(Role){
		case "Admin": selectAdminRole.click();break;
		case "Student": selectStudentRole.click();break;
		case "Staff": selectStaffRole.click();break;
		default: System.out.println("No such Roles available....");
			}
		
		loginBtn.click();
		
	}
	
	public void assignValue(String user, String pwd, String Role) {
		userNameTextBox.sendKeys(user);
		passwordTextBox.sendKeys(pwd);
		selectRoleDropdownBox.click();
		switch(Role){
		case "Admin": selectAdminRole.click();break;
		case "Student": selectStudentRole.click();break;
		case "Staff": selectStaffRole.click();break;
		default: System.out.println("No such Roles available....");
			}
				
	}
	
	public void loginActionUsingKeyboard(String username, String password, String role) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(userNameTextBox).click()
		.sendKeys(userNameTextBox, "sdetnumpyninja@gmail.com").build().perform();
	   
		action.moveToElement(passwordTextBox).click()
		.sendKeys(passwordTextBox, "Feb@2025").build().perform();
	
		selectRoleDropdownBox.click();
		selectAdminRole.click();
		action.moveToElement(loginBtn).click().perform();
	}
	
	
	public void loginActionUsingMouse() {
		Actions action = new Actions(driver);
		action.moveToElement(loginBtn).click().perform();
	}
	
	public boolean verifyImageText(String exp){
		boolean found=false;
		String[] allExtractedLines=appTextExtract();
		for (String singleLine : allExtractedLines) {
			if(singleLine.contains(exp)){
			   LoggerLoad.info("Expected text is "+exp);
			    found=true;
				return found;}
		   }
		if(!found){
			return false; }
		return found;
	}
	

	
	public String[] appTextExtract(){
		try {
			Tesseract tesseract = new Tesseract();
			String imageURL=image.getAttribute("src");
			URL url=null;
			url=new URL(imageURL);
			String datapath ="C:\\Program Files\\Tesseract-OCR\\tessdata";
			tesseract.setDatapath(datapath);
			tesseract.setLanguage("eng");
			BufferedImage image1=ImageIO.read(url);
			String fullLogoText = tesseract.doOCR(image1);
			System.out.println("Full Logo Text is: "+fullLogoText);
			String sp[]=fullLogoText.split("\n");
			return sp;
		    } catch (Exception e) {
		    	e.printStackTrace();
		          }
		return null;
	}
	
	
	public boolean verifyPleaseLogInToLMSTextDisplay() {
		boolean displayed = false;
		
		if(plsLoginTextElement.isDisplayed()) {
			displayed =true;
			return displayed;
		}
		else {
			return displayed;
		}
		
	}
	
	
	public int countOfTextboxes()
	{
		int txtBoxCount= textBoxesList.size();
		return txtBoxCount;	
	}
	
	public int positionOfText(String textName) {
		int position=0;
		int textCount = textBoxtextList.size();
		System.out.println("text list count is "+textCount);
		
		for(int i=0; i<textCount; i++){
			String text = textBoxtextList.get(i).getText();
			System.out.println("The "+i+" element of text is: "+text);
			if(text.equalsIgnoreCase(textName)) {
				System.out.println("The position of "+textName+" text is "+(i+1));
				position = i+1;
				return position;
			}
		}
		
		return position;		
	}
	
	
	public boolean asteriskMarkWithText(String text) {
		switch(text) {
		case "User": return userAsteriskMark.isDisplayed();
		case "Password": return passwordAsteriskMark.isDisplayed();
		default: System.out.println("No such text exists....");
		}
		return false;		
	 }
	
	
	public boolean roleDropdownVisibility() {
		return roleDropDown.isDisplayed();
	}
	
	
	public boolean rolePlaceholderVisibility() {
		return selectRolePlaceholder.isDisplayed();
	}
	
	public boolean checkAllRoleOptionsAvailability() {
		List<String> expectedRoles = new ArrayList<>(Arrays.asList("Admin","Staff","Student"));
		selectRoleDropdownBox.click();
		List<String> optionsList = roleOptionsList
					                .stream()
					                .map(WebElement::getText)
					                .collect(Collectors.toList());
		System.out.println("The Actual Role options are: "+optionsList);
		System.out.println("The Expected Role options are: "+expectedRoles);
		if (optionsList.equals(expectedRoles)){
				return true;}
		else {
			return false;}		
	}
	
	
	public boolean loginBtnVisibility() {
		return loginBtn.isDisplayed();
	}
	
	
	public boolean login_ErrorMsg_Display(){
		return loginErrorMsg.isDisplayed();
	}
	
	
	public boolean enterUsernameErrMsg_Display() {
		return enterUsernameErrMsg.isDisplayed();
	}
	
	
	public boolean enterPwdErrMsg_Display() {
		return enterPwdErrMsg.isDisplayed();
	}
	
	public boolean loginResponse(String scenario){
		System.out.println("Testing the "+scenario+" scenario");
		switch (scenario){
		case "validLogin": return driver.findElement(By.xpath("//span[normalize-space(text())='Home']")).isDisplayed();
		case "invalidUser":return login_ErrorMsg_Display();
		case "invalidPwd":return login_ErrorMsg_Display();
		case "invalidRole":return login_ErrorMsg_Display();
			
		case "withoutUser":return enterUsernameErrMsg_Display();
		case "withoutPwd":return enterPwdErrMsg_Display();
		case "withoutRole":return selectRolePlaceholder.isDisplayed();
		default:System.out.println("No such Scenario exists...."); 	
		}
		
		return false;     
		
	}
	
	public void verifyUserFieldColor() {
		String textColor = userNameTextBox.getCssValue("color");
		String userFieldColor = findTextColor(textColor);  
		System.out.println("The rgba value of User Field is: "+textColor);
		System.out.println("The HEX value of User Field is: "+userFieldColor);
	}

	public void verifyPasswordFieldColor() {
		String textColor = passwordTextBox.getCssValue("color");
		String passwordFieldColor = findTextColor(textColor);  
		System.out.println("The rgba value of Password Field is: "+textColor);
		System.out.println("The HEX value of Password Field is: "+passwordFieldColor);
	}
	

	public String findTextColor(String textColor){
		Color color = Color.fromString(textColor);
		actualColor = color.asHex();
		System.out.println("Converted HEX value is = " +actualColor);
		return actualColor;
	}

	
	
	
	
	
	
}