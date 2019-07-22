package com.jbk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {
	public static void main(String[] args) throws Exception {
		
		/*System.setProperty("webdriver.chrome.driver", "E:\\Java By Kiran\\Selenium\\chromedriver.exe");
		WebDriver driver =	new ChromeDriver();
		*/
		
		System.setProperty("webdriver.geicko.driver", "D:\\java\\Setup");
		WebDriver driver =	new FirefoxDriver();
		
		
		
		
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage()
		.timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		driver.close();
		
		
		
		
		
		
		
		
		
		
	}

}
