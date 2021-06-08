package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.SuperTestNG;

public class BusinessPage extends SuperTestNG {
	
	@FindBy(xpath = "//*[@text = 'BUSINESS']")
	private AndroidElement business;
	
	@FindBy(xpath = "//*[@text = 'India Training']")
	private AndroidElement username;
	
	@FindBy(xpath = "//*[@text = 'MANAGER']")
	private AndroidElement level;
	
	@FindBy(xpath = "//*[@text = '#108639101']")
	private AndroidElement customerid;
	
	@FindBy(xpath = "//*[@text = 'Unity Plan Qualifications']")
	private AndroidElement unityPlan;
	
	@FindBy(xpath = "//android.widget.TextView[@text = '']")
	private AndroidElement unityPlanDropDown;
	
	@FindBy(xpath = "//*[@text = 'Downline']")
	private AndroidElement downline;
	
	@FindBy(xpath = "//android.widget.TextView[@text = '']")
	private AndroidElement downlineDropDown;
	
	@FindBy(xpath = "//*[@text = '']")
	private AndroidElement Shopping;
	
	public BusinessPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void businesspageui() {
		
		ChildTest.log(Status.INFO, "<b><font color=407899>" + "Business Page" + "</font></b>");
		
		Assert.assertEquals(business.getText(), "BUSINESS");
		
		WebDriverWait wait = new WebDriverWait(driver, 40000);		
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//android.widget.ProgressBar")));
		
		Assert.assertEquals(username.getText(), "India Training");
		Assert.assertEquals(level.getText(), "MANAGER");
		Assert.assertEquals(customerid.getText(), "#108639101");
		ChildTest.log(Status.INFO, username.getText() +" "+ level.getText() +" "+customerid.getText());
		
		Assert.assertEquals(unityPlan.getText(), "Unity Plan Qualifications");
		Assert.assertEquals(unityPlanDropDown.isDisplayed(), true);
		ChildTest.log(Status.INFO, "Unity Plan & Dropdown");
		
		Assert.assertEquals(downline.getText(), "Downline");
		Assert.assertEquals(downlineDropDown.isDisplayed(), true);
		ChildTest.log(Status.INFO, "Downline & Dropdown");
		
	}
	

	

}
