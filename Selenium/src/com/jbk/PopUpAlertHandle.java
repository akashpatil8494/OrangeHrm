package com.jbk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PopUpAlertHandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Java By Kiran\\Selenium\\config.properties");
		prop.load(fis);
		
		
		if(prop.getProperty("browser").equals("chrome")) {
			
			driver= new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "E:\\Java By Kiran\\Selenium\\chromedriver.exe");
			
		}else {
			System.setProperty("webdriver.gecko.driver","E:\\Java By Kiran\\Selenium\\geckodriver.exe" );
			driver=new FirefoxDriver();
			
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("file:///D:/java/Offline%20Website/pages/examples/add_user.html");
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Akash");
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9890499266");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("akashpatil8494@gmail.com");
		driver.findElement(By.xpath("//input[@name='gender']")).click();      
		
		Select select = new Select(driver.findElement(By.xpath("//select")));
		select.selectByVisibleText("Maharashtra");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();
		driver.close();
		
		
		
		
	
	}
}
