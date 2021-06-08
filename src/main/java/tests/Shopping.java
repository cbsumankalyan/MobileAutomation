package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShoppingPage;
import utility.SuperTestNG;

public class Shopping extends SuperTestNG {
	
	@Test
	public void shopping() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Shopping" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		ShoppingPage shop = new ShoppingPage(driver);
		
		login.Login();
		shop.shopping();
		
	}
	
	@Test
	public void StateEdit() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Shopping" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		ShoppingPage shop = new ShoppingPage(driver);
		
		login.Login();
		shop.shopping();
		shop.edit();
		
	}

}
