package driverSetup;

import pageObjects.BatchPage;
import pageObjects.ClassPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.ProgramPage;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import lombok.Data;

@Data
public class TestContextSetup {
    private WebDriver driver;
    private LoginPage loginPage;
    private ClassPage classPage;
    private Properties properties;
    private DashboardPage dashboardPage;
    private ProgramPage programPage;
    private BatchPage batchPage;
    private LogoutPage logoutPage;

    private static TestContextSetup instance = null;
    
    public TestContextSetup() {
        // No need to call initializeDriver() here
        this.driver = BaseClass.getDriver(); // Get the WebDriver instance

        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/Config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public TestContextSetup() {
//        // No need to instantiate BaseClass, just use its static methods
//        BaseClass.initializeDriver();
//        this.driver = BaseClass.getDriver(); // Get the WebDriver instance
//
//        properties = new Properties();
//        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
//            properties.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static TestContextSetup getInstance() {
        if (instance == null) {
            instance = new TestContextSetup();
        }
        return instance;
    }
//    public void launchBrowser() {
//        String browser = properties.getProperty("browser"); // Fetch browser from config.properties
//        BaseClass.setBrowser(browser); // Set the browser in BaseClass
//        BaseClass.initializeDriver(); // Initialize WebDriver
//        this.driver = BaseClass.getDriver(); // Get the WebDriver instance
//    }
    public void launchBrowser() {
        if (this.driver == null) { // Prevent multiple initializations
            String browser = properties.getProperty("browser"); // Fetch browser from config.properties
            BaseClass.setBrowser(browser);
            BaseClass.initializeDriver();
            this.driver = BaseClass.getDriver();
        }
    }
    public void launchUrl() {
        driver.get(properties.getProperty("url")); // Fetch URL from config.properties
    }

    public String getPropUsername() {
        return properties.getProperty("Username");
    }

    public String getPropPassword() {
        return properties.getProperty("Password");
    }

    public String getPropRole() {
        return properties.getProperty("Role");
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

    public void quitDriver() {
        BaseClass.quitDriver();
    }
}
