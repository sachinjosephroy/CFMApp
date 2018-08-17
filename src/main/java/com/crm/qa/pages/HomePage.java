package com.crm.qa.pages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	TestUtil util = new TestUtil();

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[text()='no company loaded']")
	WebElement noCompLoad;
	
	@FindBy(xpath = "//a[contains(text(), 'Add Boxes')]")
	WebElement addBoxesBtn;
	
	@FindBy(xpath = "//input[@title='Add New Box']")
	WebElement addBtn;
	
	@FindBy(xpath = "//div[@id='handle_CALENDAR']")
	WebElement calendar;
	
	@FindBy(xpath = "//input[@title='Remove']")
	WebElement removeBtn;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	/*public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}*/
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	public boolean validateNoCompDisp() {
		util.switchToFrame();
		boolean flag = noCompLoad.isDisplayed();
		return flag;
	}
	
	public boolean validateCalDisp() throws InterruptedException {
		boolean flag = false;
		util.switchToFrame();
		Boolean isPresent = driver.findElements(By.xpath("//div[@id='handle_CALENDAR']")).size() > 0;
		if(isPresent) {
			removeBtn.click();
			addBoxesBtn.click();
			addBtn.click();
			Thread.sleep(3000);
			flag = calendar.isDisplayed();
		}
		else {
			addBoxesBtn.click();
			addBtn.click();
			Thread.sleep(3000);
			flag = calendar.isDisplayed();
		}
		
		return flag;
	}
}