package tests;

import utility.SuperTestNG;
import org.testng.annotations.Test;
import pages.BusinessPage;
import pages.LoginPage;
import pages.MenuPage;

public class Business extends SuperTestNG {
	
	@Test
	public void businessui() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Business UI" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		BusinessPage business = new BusinessPage(driver);
		
		login.Login();
		business.businesspageui();
	}
	
	@Test
	public void menu() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Menu" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		MenuPage menuui = new MenuPage(driver);
		
		login.Login();
		menuui.Menu();
		
	}
	
	@Test
	public void library() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Library" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		MenuPage menuui = new MenuPage(driver);
		
		login.Login();
		menuui.Library();
		
	}
	
	@Test
	public void uploadkyc() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "UPLoad KYC" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		MenuPage menuui = new MenuPage(driver);
		
		login.Login();
		menuui.UploadKYC();
		
	}
	
	@Test
	public void language() throws InterruptedException {
		
		ChildTest = Test.createNode("<b><font color=407899>" + "Language" + "</font></b>");
		
		LoginPage login = new LoginPage(driver);
		MenuPage menuui = new MenuPage(driver);
		
		login.Login();
		menuui.language();
		
	}
	
}
