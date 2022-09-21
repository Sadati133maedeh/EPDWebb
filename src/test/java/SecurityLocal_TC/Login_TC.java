package SecurityLocal_TC;

import org.testng.annotations.Test;

import SecurityLocal_PO.Login;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class Login_TC {
	WebDriver driver;
  @Test
  public void f(String user , String pass) throws InterruptedException {
	  Login Lo = PageFactory.initElements(driver, Login.class);
	  Lo.loginepd(driver, user, pass);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.sadati.PAYVAND.000\\Git\\Web\\EPDWebb\\src\\test\\resources\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://192.168.5.180:8008/");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
