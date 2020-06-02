package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws IOException{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTextBox;
	
	
	@FindBy(xpath="//a[contains(text(),'Mobiles')]")
	WebElement mobileLink;
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement submitButton;

	
	public SearchResultPage enterValuesInSearchText(String value) throws AWTException, IOException {
		
		searchTextBox.sendKeys(value);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		
		submitButton.click();
		return new SearchResultPage();
	}
	
	public MobilesPage clickOnMobilesLink() {
		
		mobileLink.click();
		
		return new MobilesPage();
	}
}
