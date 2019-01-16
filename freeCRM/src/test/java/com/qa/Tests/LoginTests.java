package com.qa.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;

public class LoginTests extends TestBase{

	
	WebDriver driver;
	
	@Test
	public void Login() throws Exception {
		driver = initBrowser(driver);
		driver.get("https://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("freecrmqa");
		driver.findElement(By.name("password")).sendKeys("test123");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.quit();
	}
	
}
