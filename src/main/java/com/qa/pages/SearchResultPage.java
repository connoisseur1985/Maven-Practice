package com.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class SearchResultPage extends TestBase{
	
	public SearchResultPage() throws IOException{
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']")
	WebElement resultText;
	@FindBy(xpath="//span[@data-component-type='s-search-results']/div[2]/div/div/span/div/div/div[2]/div[2]/div/div/div/div/div/h2/a/span")
	List<WebElement> searchResults;
	@FindBy(xpath="//a[text()='Next']")
	WebElement nextButton;
	@FindBy(xpath="//li[@class='a-disabled a-last']")
	WebElement nextButtonNotDisplayed;
	
	public List<String> getSearchResults() {
		
		List<String> list = new ArrayList<String>();
		for(WebElement w : searchResults) {
			
			list.add(w.getText());
		}
		while(true){
			try {

			WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);	
			wait.until(ExpectedConditions.visibilityOf(nextButton));
			nextButton.click();
			//list = new ArrayList<String>();
			for(WebElement w : searchResults) 
			{
				
			list.add(w.getText());
			}
				
		}catch(Exception e) {
			
			break;
			}
		}
			
			return list;
	}
	public WebElement isSearchResultDisplayed() {
		
		return resultText;
		
		
	}
	
}
