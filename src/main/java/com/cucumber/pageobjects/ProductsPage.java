package com.cucumber.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.base.TestBase;

public class ProductsPage  extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	// Page Factory

		@FindBy(xpath = "//h1[@class = 'hero-heading__subheading']")
		WebElement ProdcutPagetext;
		
		@FindBy(xpath = "//a[@href = 'https://www.uptake.com/']")
		WebElement HomePageLink;		
		
		@FindBy(xpath ="//span[contains(@class,'btn__text') and contains(text(), 'Get a Demo')]")
		WebElement ProductPageButton; 

		// Intializing PageObjects
		public ProductsPage() {
			PageFactory.initElements(driver, this);
		}

		public String validateProductsText() {
			return ProdcutPagetext.getText();
		}
		
		public HomePage ClickUptake() {
			HomePageLink.click();	
			isElementPresent(ProductPageButton, 5);
			return new HomePage();
		}
		
}
