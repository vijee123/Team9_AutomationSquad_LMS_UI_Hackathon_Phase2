package pageObjects;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import utilities.LoggerLoad;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameTextBox;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;
	@FindBy(xpath = "//button[@id='login']")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {

		super(driver);
	}
}