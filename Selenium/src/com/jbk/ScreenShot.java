package com.jbk;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShot {
	public static void main(String[] args) throws Exception {
		
	System.setProperty("webdriver.geicko.driver", "D:\\java\\Setup");
	WebDriver driver =	new FirefoxDriver();
	
	
	
	
	driver.manage().window().maximize(); 
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage()
	.timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("file:///D:/java/Offline%20Website/pages/examples/add_user.html");
	System.out.println(driver.getTitle());
	
	TakesScreenshot ts= (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("D:\\java\\Screen Shot\\adminlte.png"));
	
	Thread.sleep(3000);
	driver.close();

}
}