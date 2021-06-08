package pages;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utility.SuperTestNG;

public class ShoppingPage extends SuperTestNG {

	@FindBy(xpath = "//*[@text = '']")
	private AndroidElement Shopping;

	@FindBy(xpath = "//*[@text = 'SHOPPING']")
	private AndroidElement shoppingheader;

	@FindBy(xpath = "//*[@text = '']")
	private AndroidElement search;

	@FindBy(xpath = "//*[@text = 'All Products']")
	private AndroidElement AllProducts;

	@FindBy(xpath = "//*[@text = 'Products']")
	private AndroidElement Products;

	@FindBy(xpath = "//*[@text = 'Accessories']")
	private AndroidElement Accessories;

	@FindBy(xpath = "//*[@text = 'Edit']")
	private AndroidElement edit;

	@FindBy(xpath = "//*[contains(@text, 'You are currently')]")
	private AndroidElement productsviewstate;

	@FindBy(xpath = "//*[@text = 'Select State']")
	private AndroidElement selectstate;

	@FindBy(id = "android:id/text1")
	private AndroidElement statedropdown;

	@FindBys(@FindBy(id = "android:id/text1"))
	List<AndroidElement> states;

	public ShoppingPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void shopping() {

		ChildTest.log(Status.INFO, "<b><font color=407899>" + "Shopping" + "</font></b>");

		TouchAction tap = new TouchAction(driver);
		tap.tap(tapOptions().withElement(element(Shopping))).perform();

		Assert.assertEquals(shoppingheader.getText(), "SHOPPING");
		ChildTest.log(Status.INFO, "Shopping Header");

		Assert.assertEquals(search.isDisplayed(), true);
		ChildTest.log(Status.INFO, "Search is Displaying");

		Assert.assertEquals(AllProducts.getText(), "All Products");
		Assert.assertEquals(Products.getText(), "Products");
		Assert.assertEquals(Accessories.getText(), "Accessories");
		ChildTest.log(Status.INFO, "All Products, Products & Accessories");

		Assert.assertEquals(productsviewstate.getText(), "You are currently viewing product in KA");
		ChildTest.log(Status.INFO, "You are currently viewing product in KA");

		Assert.assertEquals(edit.getText(), "Edit");
		ChildTest.log(Status.INFO, "Edit Option is available");

	}

	public void edit() throws InterruptedException {
		
		ChildTest.log(Status.INFO, "<b><font color=407899>" + "State Edit" + "</font></b>");

		TouchAction tap = new TouchAction(driver);

		Set<String> A = new HashSet<String>();
		
		String[] B = { "Bihar", "Delhi", "Assam", "Daman and Diu", "Gujarat", "Telangana", "Andhra Pradesh",
				"Madhya Pradesh", "Jammu and Kashmir", "Tamil Nadu", "Dadra and Nagar Haveli", "Chhattisgarh",
				"Karnataka", "Mizoram", "Andaman and Nicobar Islands", "Uttaranchal", "Goa", "West Bengal",
				"Maharashtra", "Kerala", "Chandigarh", "Lakshadweep", "Sikkim", "Meghalaya", "Punjab", "Rajasthan",
				"Tripura", "Uttar Pradesh", "Jharkhand", "Haryana", "Himachal Pradesh", "Arunachal Pradesh",
				"Pondicherry", "Manipur", "Nagaland", "Orissa", };
		Set<String> C = new HashSet<String>();
		C.addAll(Arrays.asList(B));
		

		tap.tap(tapOptions().withElement(element(edit))).perform();
		Assert.assertEquals(selectstate.getText(), "Select State");

		tap.tap(tapOptions().withElement(element(statedropdown))).perform();
		Thread.sleep(2000);
		Dimension dimension = driver.manage().window().getSize();
		for (int i = 0; i < 3; i++) {

			int start_x = (int) (dimension.width * 0.2);
			int start_y = (int) (dimension.height * 0.2);

			int end_x = (int) (dimension.width * 0.5);
			int end_y = (int) (dimension.height * 0.8);

			tap.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(end_x, end_y)).release().perform();

		}

		Thread.sleep(5000);

		dimension = driver.manage().window().getSize();
		for (int j = 0; j < 3; j++) {

			for (AndroidElement X : states) {
				A.add(X.getAttribute("text"));
			}

			int start_x = (int) (dimension.width * 0.5);
			int start_y = (int) (dimension.height * 0.8);

			int end_x = (int) (dimension.width * 0.2);
			int end_y = (int) (dimension.height * 0.2);

			tap.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(end_x, end_y)).release().perform();

			Thread.sleep(2000);
		}
		
		ChildTest.log(Status.INFO, "All India States is displaying");
		System.out.println(A);
		Assert.assertEquals(A, C);

	}

}
