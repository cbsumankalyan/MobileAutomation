package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utility.SuperTestNG;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuPage extends SuperTestNG {

	@FindBy(xpath = "//android.widget.TextView[@text = '']")
	private AndroidElement menu;

	@FindBy(xpath = "//*[@text = 'India Training']")
	private AndroidElement username;

	@FindBy(xpath = "//*[@text = 'MANAGER']")
	private AndroidElement level;

	@FindBy(xpath = "//*[@text = '#108639101']")
	private AndroidElement customerid;

	@FindBy(xpath = "//*[@text = 'Library']")
	private AndroidElement library;

	@FindBy(xpath = "//*[@text = 'Upload KYC']")
	private AndroidElement UploadKYC;

	@FindBy(xpath = "//*[@text = 'Language']")
	private AndroidElement Language;

	@FindBy(xpath = "//*[@text = 'Sign Out']")
	private AndroidElement signout;

	@FindBy(xpath = "//*[@text = 'Filter']")
	private AndroidElement Filter;

	@FindBy(xpath = "//android.widget.TextView[@text = '']")
	private AndroidElement filterClick;

	@FindBy(xpath = "//*[@text = 'Documents']")
	private AndroidElement Documents;

	@FindBy(xpath = "//*[@text = 'Videos']")
	private AndroidElement Videos;

	@FindBy(xpath = "//*[@text = 'Product resources']")
	private AndroidElement productResources;

	@FindBy(xpath = "//*[@text = 'Search']")
	private AndroidElement search;

	@FindBy(id = "android:id/text1")
	private AndroidElement countrydropdown;

	@FindBys(@FindBy(id = "android:id/text1"))
	List<AndroidElement> countries;

	@FindBy(xpath = "//*[@text = 'KYC Documents portal']")
	private AndroidElement kycdocumentportal;

	@FindBy(xpath = "//*[@text = 'KYC Uploader Distributor ID']")
	private AndroidElement KYCUploaderDistributorID;

	@FindBy(xpath = "//*[@text = '108639101']")
	private AndroidElement id;

	@FindBy(xpath = "//*[@text = 'KYC Uploader Name']")
	private AndroidElement KYCUploaderName;

	@FindBy(xpath = "//*[@text = 'India Training']")
	private AndroidElement name;

	@FindBy(xpath = "//*[@text = 'Select Language']")
	private AndroidElement selectlanguage;

	@FindBy(xpath = "//*[@text =  'English - India']")
	private AndroidElement India;

	@FindBys(@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"))
	List<AndroidElement> states;

	@FindBys(@FindBy(xpath = "//[@class='android.widget.TextView']"))
	List<AndroidElement> ghn;

	public MenuPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void Menu() {

		ChildTest.log(Status.INFO, "<b><font color=407899>" + "Menu Page" + "</font></b>");

		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(menu))).perform();

		Assert.assertEquals(username.getText(), "India Training");
		Assert.assertEquals(level.getText(), "MANAGER");
		Assert.assertEquals(customerid.getText(), "#108639101");
		ChildTest.log(Status.INFO, username.getText() + " " + level.getText() + " " + customerid.getText());

		Assert.assertEquals(library.getText(), "Library");
		Assert.assertEquals(UploadKYC.getText(), "Upload KYC");
		Assert.assertEquals(Language.getText(), "Language");
		ChildTest.log(Status.INFO, "Library, UploadKYC, Language is Displaying");

		Assert.assertEquals(signout.isDisplayed(), true);
	}

	public void Library() {

		String[] markets = { "AT", "AU", "BE", "CA", "CH", "CO", "DE", "DO", "FR", "GB", "IN", "JM", "MX", "NZ", "US",

		};

		ChildTest.log(Status.INFO, "<b><font color=407899>" + "Library" + "</font></b>");

		TouchAction tap = new TouchAction(driver);

		tap.tap(tapOptions().withElement(element(menu))).perform();
		tap.tap(tapOptions().withElement(element(library))).perform();

		Assert.assertEquals(Filter.getText(), "Filter");
		tap.tap(tapOptions().withElement(element(filterClick))).perform();
		ChildTest.log(Status.INFO, "Click on Filter");

		Assert.assertEquals(Documents.getText(), "Documents");
		Assert.assertEquals(Videos.getText(), "Videos");
		Assert.assertEquals(productResources.getText(), "Product resources");
		ChildTest.log(Status.INFO, Documents.getText() + " " + Videos.getText() + " " + productResources.getText());

		Assert.assertEquals(search.isDisplayed(), true);

		tap.tap(tapOptions().withElement(element(Documents))).perform();

		tap.tap(tapOptions().withElement(element(Videos))).perform();
		tap.tap(tapOptions().withElement(element(productResources))).perform();

		tap.tap(tapOptions().withElement(element(countrydropdown))).perform();

		for (int i = 0; i < markets.length; i++) {

			Assert.assertEquals(countries.get(i).getText(), markets[i]);

		}

		ChildTest.log(Status.INFO, "Filter Drop down all markets is displaying");

	}

	public void UploadKYC() {

		ChildTest.log(Status.INFO, "<b><font color=407899>" + "Upload KYC" + "</font></b>");

		TouchAction tap = new TouchAction(driver);

		tap.tap(tapOptions().withElement(element(menu))).perform();
		tap.tap(tapOptions().withElement(element(UploadKYC))).perform();

		ChildTest.log(Status.INFO, "Kyc upload portal");

		Assert.assertEquals(kycdocumentportal.getText(), "KYC Documents portal");
		Assert.assertEquals(KYCUploaderDistributorID.getText(), "KYC Uploader Distributor ID");
		Assert.assertEquals(id.getText(), "108639101");

		Assert.assertEquals(KYCUploaderName.getText(), "KYC Uploader Name");
		Assert.assertEquals(name.getText(), "India Training");

		ChildTest.log(Status.INFO, "Default Username & customer id");

	}

	public void language() throws InterruptedException {
		

		ChildTest.log(Status.INFO, "<b><font color=407899>" + "Language" + "</font></b>");

		Set<String> A = new HashSet<String>();
		
		String[] B = { "Italian", "Russian", "Korean - South Korea", "English - US", "Spanish - Colombia",
				"German", "Swedish", "Spanish - Mexico", "ru-RU", "French", "English - India", "es-US", "Thai", "Dutch",
				"French - Canada", };
		Set<String> C = new HashSet<String>();
		C.addAll(Arrays.asList(B));
		

		TouchAction tap = new TouchAction(driver);

		tap.tap(tapOptions().withElement(element(menu))).perform();
		tap.tap(tapOptions().withElement(element(Language))).perform();
		
		Assert.assertEquals(India.getText(), "English - India");
		ChildTest.log(Status.INFO, "English - India Language is selected");

		Dimension dimension = driver.manage().window().getSize();

		Thread.sleep(5000);

		for (int i = 0; i < states.size(); i++) {
			A.add(states.get(i).getAttribute("text"));
		}

		dimension = driver.manage().window().getSize();
		int start_x = (int) (dimension.width * 0.5);
		int start_y = (int) (dimension.height * 0.8);

		int end_x = (int) (dimension.width * 0.2);
		int end_y = (int) (dimension.height * 0.2);

		tap.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(end_x, end_y)).release().perform();

		for (int i = 0; i < states.size(); i++) {
			A.add(states.get(i).getAttribute("text"));
		}

		Assert.assertEquals(A, C);
		ChildTest.log(Status.INFO, "All languages are displaying in DropDown");

		String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		ChildTest.log(Status.INFO, "<b><font color=green>" + "Screenshot" + "</font></b>",
				MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

	}

}
