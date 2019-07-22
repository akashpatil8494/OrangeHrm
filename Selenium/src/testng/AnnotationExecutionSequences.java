package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationExecutionSequences {
 
  
  @BeforeMethod
  public void beforeMethod() {
	System.out.println("Before Method");  
  }
  
  @Test(priority=0)
  public void test0() {
  System.out.println("test 0");
  }
  
  @Test(priority=0)
  public void test00() {
  System.out.println("test 00");
  }
  
  @Test(priority=1)
  public void test1() {
  System.out.println("test1");
  }
  
  @Test(priority=2)
  public void test2() {
  System.out.println("test2");
  }
  
  @Test(priority=2)
  public void test3() {
  System.out.println("test3");
  }
  
  @Test
  public void test4() {
  System.out.println("test4");
  }
  
 
  
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suit");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suit");
  }

}
