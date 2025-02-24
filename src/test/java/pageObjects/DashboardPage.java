package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;

import driverSetup.TestContextSetup;
import utilities.LoggerLoad;

public class DashboardPage extends BasePage {
	

	public DashboardPage(WebDriver driver) {

		super(driver);
	} 

		
	//-------------------------WEB ELEMENTS----------------------------
	
	@FindBy (xpath = "//span[contains(text(),'LMS')]") 
	private WebElement LMStitleDashboard;
	
	@FindBy (xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']")
	private WebElement LMSMainBar;
	
	@FindBy (xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']/div[1]")
	private WebElement navigationMenuBar;
	
	@FindBy (xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']/div//span[@class='mat-button-wrapper']")
	private List<WebElement> menuBarElementsList;
	
	@FindBy (xpath = "//app-doughnutchart")
	private WebElement pieChart;
	
	@FindBy (xpath = "//strong[contains(text(),'Welcome')]")
	private WebElement welcomeUserMessage;
	
	@FindBy (xpath = "//app-admindata//div[@class='bottom']")
	private WebElement roleDisplayElement;
	
	@FindBy (xpath = "(//canvas[@class=\"chartjs-render-monitor\"])[1]")
	private WebElement barChart;
	
	@FindBy (xpath = "//button[@aria-label='Previous page']")
	private WebElement prevPageIconStaffData;
	
	@FindBy (xpath = "//button[contains(@aria-label,'First page')]")
	private WebElement firstPageIconStaffData;
	
	@FindBy (xpath="//button[contains(@aria-label,'page')]")
	private List<WebElement> staffTablePageIconsList;
	
	@FindBy (xpath="//mat-row[@role='row']")
	private List<WebElement> staffTableList;
	
	@FindBy (xpath="(//div[@class='top'])[2]")
	private WebElement userCount;
	
	@FindBy (xpath="(//div[@class='top'])[3]")
	private WebElement staffCount;
	
	@FindBy (xpath="(//div[@class='top'])[4]")
	private WebElement batchCount;
	
	@FindBy (xpath="(//div[@class='top'])[5]")
	private WebElement programCount;
	
	
	//-------------------------METHODS-----------------------------------
	
	public boolean LMStitleDisplay() {
		waitForElementVisibility(LMStitleDashboard);
	    System.out.println("Dashboard title is visible: " + LMStitleDashboard.getText());
		return LMStitleDashboard.isDisplayed();
	}
	
	public boolean userCountVisibility() {
		waitForElementVisibility(userCount);
		System.out.println("User count is: "+userCount.getText());
		return userCount.isDisplayed();
	}
	
	public boolean staffCountVisibility() {
		waitForElementVisibility(staffCount);
		System.out.println("Staff count is: "+staffCount.getText());
		return staffCount.isDisplayed();
	}
	
	public boolean programCountVisibility() {
		waitForElementVisibility(programCount);
		System.out.println("Program count is: "+programCount.getText());
		return programCount.isDisplayed();
	}
	
	public boolean batchCountVisibility() {
		waitForElementVisibility(batchCount);
		System.out.println("Batch count is: "+batchCount.getText());
		return batchCount.isDisplayed();
	}
	
	public boolean pieChartVisibility() {
		waitForElementVisibility(pieChart);
		return pieChart.isDisplayed();
	}
	
	public boolean barChartVisibility() {
		waitForElementVisibility(barChart);
		return barChart.isDisplayed();
	}
	
	public boolean prevPageIconDisabled() {
		waitForElementVisibility(prevPageIconStaffData);
		if(prevPageIconStaffData.getAttribute("disabled").equals("true")){
			System.out.println("Previous page Icon of Staff Data is Disabled:");
			 return true; }
		else {System.out.println("Previous page Icon of Staff Data is NOT Disabled");
			return false; }		
	}
	
	public boolean firstPageIconDisabled() {
		waitForElementVisibility(firstPageIconStaffData);
		if(firstPageIconStaffData.getAttribute("disabled").equals("true")){
			LoggerLoad.info("First page Icon of Staff Data is Disabled:");
			 return true; }
		else {LoggerLoad.error("First page Icon of Staff Data is NOT Disabled");
			return false; }		
	}
	
	
	public boolean verifyStaffTablePageIconsDisplay() {
		waitForElementVisibility(prevPageIconStaffData);
		boolean visible = false;
		List<String> expectedIconsList = new ArrayList<>(Arrays.asList("First page", "Previous page", "Next page", "Last page"));
		List<String> actualIconsList = new ArrayList<>();
		for(WebElement icon:staffTablePageIconsList) {
			actualIconsList.add( icon.getAttribute("aria-label"));
		}
			
		LoggerLoad.info("Staff Table Page icons displayed are: "+actualIconsList);
		LoggerLoad.info("Staff Table Page icons expected are: "+expectedIconsList);
	
		if(actualIconsList.equals(expectedIconsList)){
			return true;}
		else{
		    return false;}	
	}
	
	public boolean fiveStaffDisplayVerification() {
		
		waitForElementVisibility(prevPageIconStaffData);
		if(staffTableList.size()==5) {
			return true; }
		else {
			return false;}
				
	}
	
	
	public boolean userNameDisplayVerification(String Username) {		
		waitForElementVisibility(welcomeUserMessage);	
		String[] welcomeMsg = welcomeUserMessage.getText().split(" ");
	    System.out.println("Welcome User message contains: "+Arrays.toString(welcomeMsg));
	    System.out.println("User name from prop file: "+Username);
	    
	    if(Arrays.asList(welcomeMsg).contains(Username)){
	    	  LoggerLoad.info("Welcome User message contains correct user name");
	    	  return true;}
	     else {  LoggerLoad.error("Welcome User message does not contains user name");
	    	      return false;}		
	}
	
	public boolean roleDisplayVerification(String pwd) {		
		waitForElementVisibility(roleDisplayElement);	
		String role = roleDisplayElement.getText();
	    System.out.println("Actual Role displayed is : "+ role +" as role");
	    System.out.println("Expected Role detail is: "+pwd);
	    
	    if(role.equalsIgnoreCase(pwd)){
	    	  LoggerLoad.info("Welcome User message contains proper Role detail...");
	    	  return true;}
	     else {LoggerLoad.error("Welcome User message contains INCORRECT Role detail.");
	    	      return false;}		
	}
	
	
	public boolean isLMSTitleOnTopLeftCorner() {
		waitForElementVisibility(LMStitleDashboard);
		Point TitleLocation = LMStitleDashboard.getLocation();
		int x = TitleLocation.getX();
		int y = TitleLocation.getY();
	    System.out.println("LMS Title Location -> X: " + x + ", Y: " + y);
	    
	    return(x<20 && y<20);
	}
	
	
	public boolean SpellingCheck(WebElement myElement) {
		waitForElementVisibility(myElement);
		String WholeText = myElement.getText();
		System.out.println("Navigation bar text is: "+WholeText);
		
		JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
		try {
			List<org.languagetool.rules.RuleMatch> matches = langTool.check(WholeText);
			if (matches.isEmpty()) {
				System.out.println("No spelling mistakes found.");
				return true;
			} else {
				for (org.languagetool.rules.RuleMatch match : matches) {
					System.out.println("Spelling mistakes found with word: " + match);
			    	System.out.println("Suggested correction is: "
							+ org.apache.commons.lang3.StringUtils.join(match.getSuggestedReplacements()));
			    	return false;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;				
	}
	
	
	public boolean LMSMainBarTextSpellingCheck() {
		waitForElementVisibility(LMSMainBar);
		return SpellingCheck(LMSMainBar);		
	}
	
	
	 public int getNumberOfSpaces(String text) {
	     return text.length() - text.replace(" ", "").length();
	 }
	 
	 
	 public boolean checkLMSTitleSpelling() {
		 waitForElementVisibility(LMStitleDashboard);
		 return SpellingCheck(LMStitleDashboard);
	 }
	 
	 public int checkLMSTitleSpace() {
		 waitForElementVisibility(LMStitleDashboard);
		 
		 int NoOfSpaces =getNumberOfSpaces(LMStitleDashboard.getText());
		 System.out.println("LMS Title has "+NoOfSpaces+" spaces.");
		 
		 return NoOfSpaces;
	 }
	 
	 
	 public boolean navigationBarAlignmentCheck(){
		    waitForElementVisibility(LMSMainBar);
			int TotalWidth=Math.addExact(LMSMainBar.getLocation().getX(),LMSMainBar.getRect().getWidth());
			System.out.println("Total LMS main bar Width is: "+TotalWidth);
			
			waitForElementVisibility(navigationMenuBar);
			int menuBarEndXpoint=navigationMenuBar.getRect().getX()+navigationMenuBar.getRect().getWidth();
			System.out.println("X Endpoint of menu bar is: "+menuBarEndXpoint);
			
			int menuY=navigationMenuBar.getRect().getY();
			
			System.out.println("Start of y Ofmodule "+menuBarEndXpoint);
			if(menuBarEndXpoint>=LMSMainBar.getRect().getWidth()-70 && menuY<=50)
			{
				LoggerLoad.info("The navigation menu bar is located at the right end.");
				return true;
			}
			return false;

		}
	 
	 
	 public boolean navigationMenuItemsSequenceValidation() {
		 
		 List<String> expectedMenuSequenceList = new ArrayList<>(Arrays.asList("Home","Program","Batch","Class","Logout"));
		 List<String> actualMenuSequenceList = new ArrayList<>();
		 waitForElementVisibility(navigationMenuBar);
			 for(WebElement element:menuBarElementsList) {
			 actualMenuSequenceList.add(element.getText());
		    }
		 System.out.println("The expected Menu bar item sequence is: "+expectedMenuSequenceList);
		 System.out.println("The actual Menu bar item sequence is: "+actualMenuSequenceList);
		 
		 if (expectedMenuSequenceList.equals(actualMenuSequenceList)) {
			    LoggerLoad.info("The menu sequences match exactly!");
			    return true;
			} else {
				LoggerLoad.info("The menu sequences do not match.");
			    return false;
			}
		 
		 
	 }
		
	 
		 
	
	
}
