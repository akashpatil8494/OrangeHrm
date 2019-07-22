package com.jbk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.FindsByXPath;

public class PropertiesFile {
	public static void main(String[] args) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("E:\\Java By Kiran\\Selenium\\config.properties");
		prop.load(fis);
		WebDriver driver= new ChromeDriver();
		
		if(prop.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","E:\\Java By Kiran\\Selenium\\chromedriver.exe" );
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
		}else {
			
			System.setProperty("webdriver.gecko.driver","E:\\Java By Kiran\\Selenium\\geckodriver.exe" );
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
		}

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(prop.getProperty("id"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@href='users.html']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']")).click();
		
		
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
