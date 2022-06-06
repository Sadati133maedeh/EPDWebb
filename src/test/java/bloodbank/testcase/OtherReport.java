package bloodbank.testcase;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import bloodbank.pageobject.BloodBankCheck;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class OtherReport {	
	WebDriver driver;
	@DataProvider(name = "Report")
	public Iterator<Object[]> Provider() throws IOException{
		CSVReader csvreader = new CSVReader(new FileReader ("./src/test/resources/data/report.csv"),',','\'',1);
		List <Object[]> MyData = new ArrayList<Object[]>();
		String nextLine[];
		while((nextLine = csvreader.readNext())!= null) {
			MyData.add(nextLine);
		}
		csvreader.close();
		return MyData.iterator();
		
	}
  @Test(dataProvider = "Report")
  public void f(String startdate, String enddate , String gozaresh, String gozaresh2  ) throws InterruptedException {
	  BloodBankCheck Bc = PageFactory.initElements(driver, BloodBankCheck.class);
	  Bc.repoorts(startdate,enddate,gozaresh,gozaresh2);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://192.168.5.147:3000/bloodbankcheck");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
