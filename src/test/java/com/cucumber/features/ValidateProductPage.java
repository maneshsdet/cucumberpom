package com.cucumber.features;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.cucumber.base.TestBase;
import com.cucumber.pageobjects.HomePage;
import com.cucumber.pageobjects.ProductsPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ValidateProductPage extends TestBase {
	HomePage homepage;
	ProductsPage productpage;

	public ValidateProductPage() {
		super();
	}
	
	
	@Before
	public void setUp() throws InterruptedException {
		try {
			intialization();
		} catch (IOException e) {
			e.printStackTrace();
		}
		homepage = new HomePage();
	}
	
	@When("^Im on HomePage$")
	public void im_on_HomePage() throws Throwable {
		System.out.println(homepage.HomepageButton.getText());
		isElementPresent(homepage.HomepageButton, 160);
	    throw new PendingException();
	}

	@Then("^Click Products Link$")
	public void click_Products_Link() throws Throwable {
		productpage = homepage.ClickProduct();
	    throw new PendingException();
	}

	@Then("^Validate we are in Products Page$")
	public void validate_we_are_in_Products_Page() throws Throwable {
		String Productstext = productpage.validateProductsText();
		assertEquals(Productstext,"PRODUCTS");
	    throw new PendingException();
	}
	
//	@After
//	public void tearDown() {
//		driver.quit();
//	}
}
