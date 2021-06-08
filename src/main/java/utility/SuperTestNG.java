package utility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class SuperTestNG {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	public static ExtentSparkReporter SparkReport;
	public static ExtentReports ExtentReport;
	public static ExtentTest Test;
	public static ExtentTest ChildTest;
	
	
	@BeforeTest
	public void StartReport() {
		
		SparkReport = new ExtentSparkReporter("D:\\Mobile\\Testing\\reports\\AutomationReport.html");
		ExtentReport = new ExtentReports();
		ExtentReport.attachReporter(SparkReport);
		Test= ExtentReport.createTest("<b><font color=407899>" + "Login Page" + "</font></b>");
		
	}
	
	@BeforeMethod
	public void PreCondition() throws IOException, InterruptedException {
		
		/*Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(10000);
		
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		Thread.sleep(6000);
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\resource\\startEmulator.bat");
		Thread.sleep(30000);*/
		
		File app = new File("apps");
		File appPath = new File(app, "fancypants.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Devices");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void PostCondition(ITestResult result) {
		
		if(result.isSuccess()) {
			
		} else if (result.getStatus() == ITestResult.FAILURE) {
			
			String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			String exceptionMessage = result.getThrowable().getMessage();
			
			ChildTest.fail("<details><summary><b><font color=red>Exception Occured click to see details:"
					+ "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
			ChildTest.fail(
					"<b><font color=red>"+"Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
			String logText = "<b>Test Method Failed</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			ChildTest.log(Status.FAIL, m);
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			
		}
		
//		driver.quit();
//		service.stop();
		
		
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentReport.flush();
	}
	
	

}
