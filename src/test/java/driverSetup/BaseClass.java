package driverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import driverSetup.TestContextSetup;

public class BaseClass {
    private static BaseClass instance = null;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser; 
    
    private TestContextSetup testContextSetup = TestContextSetup.getInstance();

    private BaseClass() {}

    public static BaseClass getInstance() {
    	
        if (instance == null) {
            instance = new BaseClass();
        }
        return instance;
    }   

	public void setBrowser(String browserName) {
        this.browser = browserName; // Store browser name
    }

    public void initializeDriver() {
    	testContextSetup.setBrowserName(browser);
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",  "C:\\tools\\chromedriver-win64\\chromedriver.exe");
            driver.set(new ChromeDriver());            
        }else   if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver-v0.35.0-win64\\geckodriver.exe");
            driver.set(new FirefoxDriver());          
        }       
        
    }

    public WebDriver getDriver() {
        return driver.get();
    }
    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
