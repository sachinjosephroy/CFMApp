package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	HomePage hp;
	LoginPage lp;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		hp = new HomePage();
		lp = new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void isNoCompanyDispTest() {
		boolean noCompFlag = hp.validateNoCompDisp();
		Assert.assertTrue(noCompFlag);
	}
	
	@Test(priority=2)
	public void iscalendarDispTest() throws InterruptedException {
		boolean calFlag = hp.validateCalDisp();
		Assert.assertTrue(calFlag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
