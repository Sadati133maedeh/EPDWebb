package SecurityLocal_TC;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AddRoles {
	WebDriver driver;
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://192.168.5.180:8008");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
