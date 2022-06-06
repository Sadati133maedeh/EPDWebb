package bloodbank.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BloodBankCheck {
	
	////these variables is related to search in bloodbank////
	@FindBy(xpath = "//select[@name = 'UrgencyRequest']")
	WebElement foriyat;

	@FindBy(xpath = "//select[@id= 'Status']")
	WebElement status;

	@FindBy(xpath = "//button[@id= 'simpleSearch']")
	WebElement search;
	/////// the end of variales for searching in bloodbank //////
	
	
	///// these variables is related to CanselDelivery/////
	@FindBy(xpath = "//tbody//td[@data-field = 'BloodGroup']")
	WebElement bloodgroup;
	
	@FindBy(xpath = "//button[@id = 'btnProductReturn']")
	WebElement productreturn;
	
	@FindBy(xpath = "//tbody//td[@data-field= 'Status']")
	WebElement Status;
	
	
	@FindBy(xpath = "//button[text() ='بله']")
	WebElement confirm;
	
	/////////////////these variables is related to sending product /////////////
	
	@FindBy(xpath = "//tbody//td[@data-field = 'BloodGroup'][1]")
	WebElement BloodGroup;
	
	@FindBy(xpath = "//tbody//tr/td[@data-field = 'Status'][1]")
	WebElement status1;
	
	@FindBy(xpath = "//tbody//tr/td[@data-field = 'DTUse'][1]")
	WebElement DtUse;
	
	@FindBy(xpath = "//button[@id = 'btnProductDelivery']")
	WebElement SendProduct;
	
	@FindBy(xpath ="//button[@id ='ConfirmDelivery']" )
	WebElement ConfirmDelivery;
	
	
	@FindBy(xpath = "//button [text() = 'خیر']")
	WebElement cancel;
	
	
	@FindBy(xpath = "//button[@type=  'button' and @data-dismiss='modal']")
	WebElement Close;
	
	
	@FindBy(xpath = "//*[@class = 'alert-text-epd']")
	WebElement Alert;
	
	@FindBy(xpath = "//button[text() = 'بله']")
	WebElement Confirm;
	
	@FindBy(xpath = "//div[text()= 'ثبت اطلاعات ذوب فرآورده']")
	WebElement panelheading;
	
	WebDriver driver ;
	/////// the end of variables for sending product   ////// 
	
	////// these variables is related to Tahvil khoon ////
	@FindBy(xpath = "//tbody//td[@class ='text-center' ][4]")
	WebElement bloodtype;
	
	@FindBy(xpath = "//tbody//td[@data-field='Status' ][1]")
	WebElement status2;
	
	@FindBy(xpath = "//button[@id = 'RegisterBloodBankInfo']")
	WebElement SabtEtelat;
	
	////////  the end of variales for tahvil ////////////
	
	///// these variables is related to history///////
	
	@FindBy(xpath = "//button[@id = 'btnRecordsPatient']")
	WebElement savabegh;
	
	@FindBy(xpath = "//span[@class = 'advanced-search']//i") 
	WebElement AdvancedSearch;
	
	@FindBy(xpath = "//input[@id = 'BookNo']")
	WebElement BatariNo;
	
	
	
	/// this variable is related to LabResult///
	
	@FindBy(xpath = "(//td//img)[3]")
	WebElement labresult;
	
	@FindBy(id = "btnTestResult")
	WebElement TestResultbtn;
	
	@FindBy(xpath = "//tbody//td[@data-field='SysDT']")
	WebElement left;
	
	@FindBy(xpath = "(//tbody//td[@data-field='IsLock'])[10]")
	WebElement right;
	
	
	///This variables is related to reports
	
	@FindBy(id = "btnOtherReport")
	WebElement OtherReport;
	
	@FindBy(xpath = "//input[@id = \"DTReqStart\"]")
	WebElement StartDate;
	
	@FindBy(xpath = "//input[@id = \"DTReqEnd\"]")
	WebElement  EndDate;
	
	@FindBy(xpath = "//select[@id = \"ReportName\"]")
	WebElement  reporttype;
	
	@FindBy(xpath = "//select[@id = \"consumer\"]")
	WebElement selectorType1;  //gozaresh bar asas faravade
	
	
	@FindBy(xpath = "//button[@id = \"btnReport\"]")
	WebElement report;  // report button
	////////////****************************************************//////////////////////////////////
	
	
	
	
	
	
	public BloodBankCheck(WebDriver driver) {     //constructor method
		
		this.driver = driver;
	}
	//////////////  this method written for searching in bloodbank //////
	public void search(String value , String value1) throws InterruptedException {
		
		Select select = new Select(foriyat);
		select.selectByValue(value);
		
		Thread.sleep(1000);
		
		Select select1 = new Select(status);
		select1.selectByValue(value1);
		
		search.click();
		
		
	}
	////////////   ***************************////////////////////////
	
	/////// this methode is canceling delivery //////////////
public void  canceling() throws InterruptedException {
	
		Thread.sleep(2000);
	JavascriptExecutor jse = (JavascriptExecutor) driver;     
	jse.executeScript("document.querySelector('table th:last-child').scrollIntoView();");	
	
		String status = Status.getText();
		Thread.sleep(3000);
		BloodGroup.click();
		
		if (status.matches("ارسال شده")) {
			productreturn.click();
			Thread.sleep(1000);
			confirm.click();
		}
		else {
						System.out.println("check the status");
					
		}
		Thread.sleep(3000);
		
		driver.close();
	}
	/////////////////**************************////////////


public void tahvil() {                        // for tahvil khoon 
	bloodtype.click();
	if (status2.getText().matches("درخواست شده") ) {
		
		SabtEtelat.click();
	}
	else 
		System.out.println("Unavailble");
}

///////////////////******************////////////////////
public void ersal () throws InterruptedException {   /// this method  is for sending product
	
	
	
	BloodGroup.click();
	
	Thread.sleep(1000);
	
	if (status1.getText().matches("رزرو شده")) {

		SendProduct.click();

			Thread.sleep(2000);
		ConfirmDelivery.click();
		Thread.sleep(1000);
		Confirm.click();
		
}
	else {
		System.out.println("check the status");
		BloodBankCheck BC = PageFactory.initElements(driver, BloodBankCheck.class);
		BC.tahvil();
	}
	
}

/////////////////////***********************////////////////

public void History(String bastari) throws InterruptedException {
	
	AdvancedSearch.click();
	Thread.sleep(1000);
	BatariNo.sendKeys(bastari);
	Thread.sleep(1000);
	
	search.click();
	
	Thread.sleep(6000);
	
	bloodgroup.click();

	Thread.sleep(1000);
	savabegh.click();
	
	Thread.sleep(8000);
	
	Close.click();
}

public void LabResult() throws InterruptedException {
	
	Actions action = new Actions(driver);
	action.moveToElement(left).clickAndHold().moveToElement(right).build().perform();
	
	bloodgroup.click();
	Thread.sleep(2000);
	String Text = labresult.getAttribute("title");
	
	System.out.println(Text);
	System.out.println("4444");
	Thread.sleep(2000);
	
	
	if (Text == "ازمایش بدون جواب") {
		Thread.sleep(500);
		TestResultbtn.click();
		
		System.out.println("ttt");
	}



}

public void repoorts(String startdate,String enddate , String  gozaresh,String  gozaresh2) throws InterruptedException {
	OtherReport.click();
	Thread.sleep(3000);
	for(String window : driver.getWindowHandles()) {
		driver.switchTo().window(window);
	}
	StartDate.sendKeys(startdate);
	
	EndDate.sendKeys(enddate);
	Thread.sleep(2000);
	
	EndDate.sendKeys(Keys.TAB);
	
	//reporttype.click();
	Select select1 = new Select(reporttype);
	select1.selectByValue(gozaresh);
	if (	
			Integer.parseInt(gozaresh) <=2) {
		
	
	Select select2 = new Select(selectorType1);
	select2.selectByValue(gozaresh2);		
	}
	
	report.click();
}
}
