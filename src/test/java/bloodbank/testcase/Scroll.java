package bloodbank.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class Scroll {
	WebDriver driver ;
	
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(2000);
	  Actions action = new Actions(driver);
	  
	 // action.sendKeys(Keys.PAGE_DOWN).build().perform();      //scroll down
	  
	 // Thread.sleep(4000);
	  
//	  action.sendKeys(Keys.PAGE_UP).build().perform();     //scroll up
//	  
//	  
//	  Thread.sleep(4000);
//	  
//	  action.sendKeys(Keys.PAGE_DOWN).build().perform();      //scroll down

	  Thread.sleep(4000);

	
	//  action.sendKeys(Keys.RIGHT).clickAndHold().build().perform();
	  //action.sendKeys(Keys.ARROW_RIGHT).build().perform();
	  //JavascriptExecutor js = (JavascriptExecutor)driver;
    //  js.executeScript("window.scrollBy(500000,0)");
//	  JavascriptExecutor js = (JavascriptExecutor)driver;
//	  js.executeScript("window.scrollBy(0,966)");
	  
	  Thread.sleep(4000);
	  
	 // js.executeScript("window.scrollto(1039,966)");
	 WebElement  el1 = driver.findElement(By.xpath("//tbody//td[@data-field='SysDT']"));
	 
	 WebElement  el2  = driver.findElement(By.xpath("(//tbody//td[@data-field = 'IsLock'])[10]"));
	 
	 action.moveToElement(el1).clickAndHold().moveToElement(el2).release().perform();
	 action.sendKeys(Keys.PAGE_DOWN).build().perform();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://192.168.5.19:8020/bloodbankcheck");
	  driver.manage().window().maximize();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
