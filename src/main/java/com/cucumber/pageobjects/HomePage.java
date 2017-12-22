package com.cucumber.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.base.TestBase;

public class HomePage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver,30);

	// Page Factory
	@FindBy(xpath = "//h1[@class = 'hero-heading__subheading']")
	WebElement Homepagetext;
	
	@FindBy(linkText = "PRODUCTS")
	WebElement ProductLink;
	
	@FindBy(xpath = "//span[contains(@class,'btn__text') and contains(text(), 'Put Your Data to Work')]")
	public WebElement HomepageButton;
	

	
	// Intializing PageObjects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public String validateUptakeProductstext() {
		return Homepagetext.getText();
	}
	
	public ProductsPage ClickProduct() {
		ProductLink.click();
		isElementPresent(HomepageButton, 5);
		return new ProductsPage();
		
	}
		
	}

