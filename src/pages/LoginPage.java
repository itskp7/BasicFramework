package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;  // this is global
	
	/*public WebElement email = driver.findElement(By.id("login-username"));
	public WebElement emailNext = driver.findElement(By.id("login-signin"));
	public WebElement password = driver.findElement(By.id("login-passwd"));
	public WebElement passwordNext = driver.findElement(By.name("verifyPassword"));   // we cannot write like this bcz driver is null at this time so null pointer exception
	public WebElement passwordErr = driver.findElement(By.className("error-msg"));
	public WebElement emailErr = driver.findElement(By.id("username-error"));*/
	
	@FindBy(id = "login-username")         // these lines 28 to 44 bcz of DRIVER.
	public static WebElement email;         // dont forget Pagefactory line else will get error
	
	@FindBy(id = "login-signin")         // as there is no driver in lines 28 to 44 we have to initialize the driver so pagefactory line
	public static WebElement emailNext;
	
	@FindBy(id = "login-passwd")
	public static WebElement password;
	
	@FindBy(name = "verifyPassword")
	public static WebElement passwordNext;
	
	@FindBy(className = "error-msg")
	public static WebElement passwordErr;
	
	@FindBy(id = "username-error")
	public static WebElement emailErr;
	
	
	public void openBrowser() throws IOException {
		
		FileInputStream kp = new FileInputStream("C:\\testing\\MultipleBrowserPropFile.properties");   // for reading from data file
		Properties prop = new Properties();  // can put this line in class
		prop.load(kp);   
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe" );
			driver = new FirefoxDriver();	
		}else {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe" );
			driver = new ChromeDriver();
		}
		PageFactory.initElements(driver, this);
		
		//System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe"); 
		//driver = new FirefoxDriver();
	}

	public void openYahoo() {
		driver.get("https://login.yahoo.com/?.src=ym&.partner=none&.lang=en-CA&.intl=ca&.done=https%3A%2F%2Fmail.yahoo.com%2Fd%3F.intl%3Dca%26.lang%3Den-CA%26.partner%3Dnone%26.src%3Dfp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		 driver.quit();
	}
	
	public void enterEmail(String a) throws InterruptedException {
		email.sendKeys(a);   // a used see
		emailNext.click();
		Thread.sleep(3000);
	}
		
	public void enterPassword(String b) throws InterruptedException {
		password.sendKeys(b);
		passwordNext.click();
		Thread.sleep(3000);
	}
	
	public String readPasswordError() {
		String actualErrMsg = passwordErr.getText();
		System.out.println(actualErrMsg);
		return actualErrMsg;   // due to this changed to string
	}
	
	public String readEmailError() {
		String actualErrMsg = emailErr.getText();
		System.out.println(actualErrMsg);
		return actualErrMsg;
	}
	
}
