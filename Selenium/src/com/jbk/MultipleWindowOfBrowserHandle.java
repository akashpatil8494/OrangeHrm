package com.jbk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleWindowOfBrowserHandle {

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
		driver.get("http://popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("//a[@class='black']")).click();
		
		Set<String> handler= driver.getWindowHandles();
		Iterator<String> itr = handler.iterator();
		String parent =itr.next();
		System.out.println("Parent window " + parent);
		
		String child= itr.next();
		System.out.println("child"+ child);
		
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		
		
		
		
		driver.quit();// to close all winodws open
		
		
		
		
		
		
		
		
		
		
		
	}
}
