package com.qa.test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.MobilesPage;
import com.qa.pages.SearchResultPage;
import com.qa.util.Utilities;

public class HomePageTest extends TestBase {

	HomePage homePage;
	MobilesPage mobilesPage;
	SearchResultPage searchResultPage;
	Utilities util;
	
	public HomePageTest() throws IOException {
		
		super();
		
	}
	@DataProvider
	public Object[][] getExcelData() throws IOException {
		
		util = new Utilities();
		Object data[][] = util.excelData();
		
		return data;
	}
	@BeforeMethod
	public void setUp() throws IOException {
		initialize();
		homePage = new HomePage();
		
	}
	
	@Test(enabled=true)
	public void verifyHomePageTitle() {
		
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		System.out.println(driver.findElement(By.linkText("Mobiles")).getText());
	}
	
	@Test(enabled=true)
	public void verifyMobilesLink() {
		
		mobilesPage = homePage.clickOnMobilesLink();
	
		WebElement w = driver.findElement(By.partialLinkText("Mobiles & Accessories"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(w));
		
		Assert.assertEquals(w.getText(), "Mobiles & Accessories");
	}
	
	@Test(dataProvider="getExcelData", enabled=true)
	public void verifySearchText(String value) throws AWTException, IOException {
		
		searchResultPage = homePage.enterValuesInSearchText(value);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(searchResultPage.isSearchResultDisplayed()));
		
		List<String> list = searchResultPage.getSearchResults();
		for(String str : list) {
			
			System.out.println(str);
		}
		
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
}
