package com.cucumber.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.util.Testutil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream config;
			config = new FileInputStream(
					"C:\\Users\\chinni\\Wprls[ace\\Amazon\\src\\main\\java\\com\\cucumber\\config\\config.properties");
			prop.load(config);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void intialization() throws IOException {
		String browserType = prop.getProperty("browser");
		if (browserType.equals("Firefox")) {
			// driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",
					"C:\\SeleniumDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			 options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
		} else if (browserType.equals("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.Page_Load_Timeout, TimeUnit.SECONDS);
		// Launch Url
		driver.get(prop.getProperty("url"));
	}
	
	public static boolean isElementPresent(WebElement elementName, int timeout){
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(elementName));
            return true;
        }catch(Exception e){
            return false;
        }
	}
}
