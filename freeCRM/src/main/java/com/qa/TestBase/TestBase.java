package com.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
//	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\Config\\config.properties");
			prop.load(fis);
			System.out.println("Test(s) running in : " + prop.getProperty("browserName"));
		} catch (Exception e) {
			System.out.println("===== Exception caught ===== " + e.getMessage());
		}
		
	}
	
	public WebDriver initBrowser(WebDriver driver) {
		String browser = prop.getProperty("browserName");
		if (browser.toLowerCase().contains("chr")) {
			
			System.setProperty("webdriver.chrome.driver", ".\\Resources\\WinDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser.toLowerCase().contains("fire")) {
			System.setProperty("webdriver.gecko.driver", ".\\Resources\\WinDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}
