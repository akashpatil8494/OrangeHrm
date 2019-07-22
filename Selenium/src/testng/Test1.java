package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Test1 {
 
  @BeforeMethod
  public void beforeMethod() {
  }
  
  @Test
  public void a() {
	  System.out.println("1");
  }
  
  @Test
  public void c() {
	  System.out.println("2");
  }
  
  @Test
  public void b() {
	  System.out.println("3");
  }

  @AfterMethod
  public void afterMethod() {
  }

}
