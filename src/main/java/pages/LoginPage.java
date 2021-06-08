package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.util.Set;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.SuperTestNG;

public class LoginPage extends SuperTestNG {
	
	@FindBy(xpath = "//*[@text = 'Username']")
	private AndroidElement username;
	
	@FindBy(xpath = "//*[@text = 'Password']")
	private AndroidElement password;
	
	@FindBy(xpath = "//*[@text = 'Login']")
	private AndroidElement login;
	
	@FindBy(xpath = "//*[contains(@text, 'Required')]")
	private AndroidElement loginerror;
	
	@FindBy(xpath = "//*[@text = 'Forgot Password']")
	private AndroidElement forgorpassword;
	
	@FindBy(xpath = "//*[@text = 'Register']")
	private AndroidElement register;
	
	@FindBy(xpath = "//*[@text = 'Remember me']")
	private AndroidElement rememberme;
	
	@FindBy(xpath = "//android.widget.TextView[@text = '']")
	private AndroidElement remembermecheckbox;
	
	@FindBy(xpath = "//android.widget.TextView[@text = '']")
	private AndroidElement remembermecheckbox1;
	
	@FindBy(xpath = "//android.widget.ProgressBar")
	private WebElement ProgressBar;
	
	@FindBy(xpath = "//*[@text = 'Allow']")
	private AndroidElement Allow;
	
	
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void Login() throws InterruptedException {
		
		ChildTest.log(Status.INFO, "<b><font color=407899>" + "Login Page" + "</font></b>");
		
		username.sendKeys("108639101");
		password.sendKeys("1234");
		
		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(login))).perform();
		
		ChildTest.log(Status.INFO, "Username : 108639101");
		ChildTest.log(Status.INFO, "password : 1234");
		
		Thread.sleep(3000);
		
		tap.tap(tapOptions().withElement(element(Allow))).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 20000);		
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//android.widget.ProgressBar")));
		
		
	}
	
	public void LoginError() {
		
		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(login))).perform();
		Assert.assertEquals(loginerror.getText(), "Username and Password Required");
		
		ChildTest.log(Status.INFO, "Dont Enter Username & Password");
	}
	
	public void forgotPassword() throws InterruptedException {
		
		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(forgorpassword))).perform();
		
		ChildTest.log(Status.INFO, "Click on Forgot Password");
		
		Thread.sleep(10000);
		
		Set <String> context = driver.getContextHandles();
		for(String contextname : context) {
			System.out.println(contextname);
		}
		
		driver.context("WEBVIEW_chrome");
		Assert.assertEquals(driver.getCurrentUrl(), "https://office.unicity.com/pwupdate/#/account");
		
		ChildTest.log(Status.INFO, driver.getCurrentUrl());
		
	}
	
	public void Register() throws InterruptedException {
				
		ChildTest.log(Status.INFO, "Click on Register");
		
		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(register))).perform();
		
		Thread.sleep(10000);
		
		Set <String> context = driver.getContextHandles();
		for (String contextname : context) {
			System.out.println(contextname);
		}
		
		driver.context("WEBVIEW_chrome");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.unicity.com/ind/");		
		
		
		ChildTest.log(Status.INFO, driver.getCurrentUrl());
		
	}
	
	public void Rememberme() throws InterruptedException {
		
		Thread.sleep(3000);
		Assert.assertEquals(rememberme.getText(), "Remember me");
		
		
		ChildTest.log(Status.INFO, "Remember me check box should check");
		
		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(remembermecheckbox))).perform();
		
		Thread.sleep(10000);
		tap.tap(tapOptions().withElement(element(remembermecheckbox1))).perform();
		
	}
	

}
