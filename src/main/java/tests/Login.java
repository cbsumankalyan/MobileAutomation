package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utility.SuperTestNG;

public class Login extends SuperTestNG {
	
	@Test
	public void LoginTest() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Login In to APP" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		login.Login();
		
	}
	
	@Test
	public void LoginError() {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Login Error" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		login.LoginError();
	}
	
	@Test
	public void ForgorPassword() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Forgot Password" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		login.forgotPassword();
	}
	
	@Test
	public void Register() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Register" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		login.Register();
		
	}
	
	@Test
	public void Rememberme() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Remember Me" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		login.Rememberme();
		
	}	

}
