package com.jbk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateBrowser {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\\\Java By Kiran\\\\Selenium\\\\config.properties");
		prop.load(fis);
		
		if(prop.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "E:\\Java By Kiran\\Selenium\\chromedriver.exe");
			driver= new ChromeDriver();
			
		} else if(prop.getProperty("browser").equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "E:\\Java By Kiran\\Selenium\\geckodriver.exe");
			driver= new FirefoxDriver();
		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		String title= driver.getTitle();
		System.out.println(title);
		
		driver.navigate().to("file:///D:/java/Offline%20Website/pages/examples/add_user.html");
		String title1= driver.getTitle();
		System.out.println(title1);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().back();
		
		driver.navigate().refresh();
		
		driver.close();
		
	}
}
