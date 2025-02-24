package driverSetup;

import org.openqa.selenium.WebDriver;
import lombok.Data;
import pageObjects.BatchPage;
import pageObjects.ClassPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.ProgramPage;
@Data
public class TestContextSetup {
	
	private BaseClass baseClass;// pico
	private WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private ProgramPage programPage;
	private BatchPage batchPage;
	private ClassPage classPage;
	private LogoutPage logoutPage;
	
	public TestContextSetup(BaseClass baseClass) {
		this.baseClass = baseClass;
		this.driver = (WebDriver) baseClass.WebDriverManager();
	}	
	
	public void launchUrl() {
		driver.get(baseClass.getStringProperty("url"));
	}
	public void launchBrowser() {
		baseClass.getStringProperty("browser");
	}
	
	public String getPropUsername() {
		String UserName = baseClass.getStringProperty("Username");
		return UserName;
	}
	
	public String getPropPassword() {
		String Password =baseClass.getStringProperty("Password");
		return Password;
	}
	
	public String getPropRole() {
		String Role = baseClass.getStringProperty("Role");
		return Role;
	}
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
	
	public DashboardPage getDashboardPage() {
		return (dashboardPage == null) ? dashboardPage = new DashboardPage(driver) : dashboardPage;
	}
	
	public ProgramPage getProgramPage() {
		return (programPage == null) ? programPage = new ProgramPage(driver) : programPage;
	}
	
	public BatchPage getBatchPage() {
		return (batchPage == null) ? batchPage = new BatchPage(driver) : batchPage;
	}
	
	public ClassPage getClassPage() {
		return (classPage == null) ? classPage = new ClassPage(driver) : classPage;
	}
	
	public LogoutPage getLogoutPage() {
		return (logoutPage == null) ? logoutPage = new LogoutPage(driver) : logoutPage;
	}
	public String getprogramURL() {
		String programURL = baseClass.getStringProperty("ProgramUrl");
		return programURL;
	}
	
	public String getbatchURL() {
		String batchURL = baseClass.getStringProperty("batchUrl");
		return batchURL;
	}
	public String getClassURL() {
		String classURL = baseClass.getStringProperty("classUrl");
		return classURL;
	}
	
	
}






