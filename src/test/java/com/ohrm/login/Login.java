package com.ohrm.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@Test
	public void loginTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		String loginPageTitle = driver.getTitle();
		System.out.println("Login page title: " + loginPageTitle);
		String expectedPageTitle = "OrangeHRM";
		Assert.assertEquals(loginPageTitle, expectedPageTitle);
		Thread.sleep(5000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.cssSelector("button")).click();
		
		String homePageTitle = driver.getTitle();
		System.out.println("Home page title: " + homePageTitle);
		String expectedHomePageTitle = "OrangeHRM";
		Assert.assertEquals(homePageTitle, expectedHomePageTitle);
		
		Thread.sleep(5000);
//		driver.close();
//		driver.quit();
	}
}
