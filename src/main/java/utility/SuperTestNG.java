package utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SuperTestNG {
	
	public static AndroidDriver<AndroidElement> driver;
	public static ExtentSparkReporter SparkReport;
	public static ExtentReports ExtentReport;
	public static ExtentTest Test;
	public static ExtentTest ChildTest;
	
	
	@BeforeTest
	public void StartReport() {
		
		SparkReport = new ExtentSparkReporter("D:\\Mobile\\Testing\\reports\\.AutomationReport.html");
		ExtentReport = new ExtentReports();
		ExtentReport.attachReporter(SparkReport);
		Test= ExtentReport.createTest("<b><font color=407899>" + "Franchise Partner" + "</font></b>");
		
	}
	
	@BeforeMethod
	public void PreCondition() throws MalformedURLException {
		
		File app = new File("apps");
		File appPath = new File(app, "fancypants.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
		
		URL url = new URL("127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<>(url, capabilities);
	}
	
	@AfterMethod
	public void PostCondition() {
		
		
		
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentReport.flush();
	}
	
	

}
