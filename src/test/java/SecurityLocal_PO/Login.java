package SecurityLocal_PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
@FindBy(xpath="/html/body/app-root/div/app-layout/div/app-login/div[2]/div/form/div/div[1]/input")
WebElement username;
@FindBy(xpath="/html/body/app-root/div/app-layout/div/app-login/div[2]/div/form/div/div[2]/input")
WebElement password;
@FindBy(xpath="/html/body/app-root/div/app-layout/div/app-login/div[2]/div/form/div/button")
WebElement loginbutton;

public void loginepd(WebDriver driver,String user,String pass) throws InterruptedException {
	username.sendKeys(user);
	password.sendKeys(pass);
}
}
