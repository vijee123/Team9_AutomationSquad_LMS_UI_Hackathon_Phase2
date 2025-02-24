package driverSetup;

import pageObjects.ClassPage;
import pageObjects.LoginPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestContextSetup {

    private WebDriver driver;
    private LoginPage loginPage;
    private ClassPage classPage;
    private Properties properties;
    
    private static TestContextSetup instance = null;
    private static String browser;

   
    
    public TestContextSetup() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static TestContextSetup getInstance() {
    	
        if (instance == null) {
            instance = new TestContextSetup();
        }
        return instance;
    }  
   

    // Method to initialize the WebDriver based on the properties file
    private void initializeDriver() {
        //String browser = properties.getProperty("browser", "chrome").toLowerCase();

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
    }


    // Method to load properties from a file
    private void loadProperties() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new FileNotFoundException("Property file 'config.properties' not found in the classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getter methods to access the properties
    

    public String getUrl() {
        return properties.getProperty("url"); // Ensure properties is not null
    }

    public String getUsername() {
        return properties.getProperty("Username");
    }

    public String getPassword() {
        return properties.getProperty("Password");
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
    public ClassPage getClassPage() {
    	if (classPage == null) {
            classPage = new ClassPage(driver);  // Ensures classPage is not null before returning
        }
        return classPage;
    
    }

    // Method to launch the browser (if required, use for setup)
    public WebDriver launchBrowser() throws FileNotFoundException {    	
    	
    	if (driver == null) {    		
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }    	
        return driver;
    }
    public WebDriver getDriver() {
        if (driver == null) {
            initializeDriver(); // Ensure driver is initialized before use
        }
        return driver;
    }

 
 
 public void setBrowserName(String browserName) {
     TestContextSetup.browser = browserName; // Store browser name
 }
}