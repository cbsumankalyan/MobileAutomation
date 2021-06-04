package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	@FindBy(xpath = "//*[@text = '.']")
	private AndroidElement remembermecheckbox;
	
	
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void Login() {
		username.sendKeys("108639101");
		password.sendKeys("1234");
		
		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(login))).perform();
	}
	
	public void LoginError() {
		
		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(login))).perform();
		Assert.assertEquals(loginerror.getText(), "Username and Password Required");
	}
	
	public void forgotPassword() throws InterruptedException {
		
		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(forgorpassword))).perform();
		
		Thread.sleep(10000);
		
		Set <String> context = driver.getContextHandles();
		for(String contextname : context) {
			System.out.println(contextname);
		}
		
		driver.context("WEBVIEW_chrome");
		Assert.assertEquals(driver.getCurrentUrl(), "https://office.unicity.com/pwupdate/#/account");
		
	}
	
	public void Register() throws InterruptedException {
		
		Assert.assertEquals(rememberme.getText(), "Remember me");
		Assert.assertEquals(remembermecheckbox.isSelected(), true);
		
		remembermecheckbox.click();
		Assert.assertEquals(remembermecheckbox.isSelected(), false);
		
		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(register))).perform();
		
		Thread.sleep(10000);
		
		Set <String> context = driver.getContextHandles();
		for (String contextname : context) {
			System.out.println(contextname);
		}
		
		driver.context("WEBVIEW_chrome");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.unicity.com/ind/");		
	}
	

}
