package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import utility.SuperTestNG;

public class Login extends SuperTestNG {
	
	@Test
	public void LoginTest() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Login In to APP" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		login.Register();
		
	}

}
