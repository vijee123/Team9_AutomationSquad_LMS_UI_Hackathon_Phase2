package driverSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<Properties> prop = new ThreadLocal<>();
    private static ThreadLocal<String> browser = new ThreadLocal<>();

    // Load properties if not already loaded
    private static void loadProperties() {
        if (prop.get() == null) {
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/Config.properties");
                Properties properties = new Properties();
                properties.load(fis);
                prop.set(properties);
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config properties: " + e.getMessage());
            }
        }
    }

    public static void setBrowser(String browserName) {
        browser.set(browserName);
    }

    public static String getBrowser() {
        return browser.get();
    }

    public static void initializeDriver() {
        loadProperties(); // Ensure properties are loaded before using them

        String browserType = browser.get() != null ? browser.get() : prop.get().getProperty("browser");

        if (browserType == null) {
            throw new RuntimeException("Browser type is not specified in Config.properties or set via setBrowser()");
        }

        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browserType);
        }

        // Apply common settings
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
