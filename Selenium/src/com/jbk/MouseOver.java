package com.jbk;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {
		
		public static WebDriver driver;
		public static Properties prop; 
		
		public static void main(String[] args) throws Exception {
			
			prop = new Properties();
			FileInputStream fis  = new FileInputStream("E:\\Java By Kiran\\Selenium\\config.properties");
			prop.load(fis);
			
			if(prop.getProperty("browser").equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "E:\\Java By Kiran\\Selenium\\chromedriver.exe");
				driver= new ChromeDriver();
				
			} else if(prop.getProperty("browser").equals("FireFox")){
				
				System.setProperty("webdriver.gecko.driver","E:\\Java By Kiran\\Selenium\\geckodriver.exe" );
				driver=new FirefoxDriver();
				
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.spicejet.com/");
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//span[@class='burger-bread']"))).build().perform();
		
		
		
	}
}
