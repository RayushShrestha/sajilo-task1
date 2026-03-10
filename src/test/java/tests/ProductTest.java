package tests;

import java.util.Random;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductPage;
import pages.SignUpPage;

public class ProductTest extends BaseTest {
	
@Test(description = "Verify that user can add a product to the cart")
public void item() throws InterruptedException {
	SignUpPage sign=new SignUpPage(driver);
	sign.signUp("rayush shrestha", mail);
	sign.fillAccountInformation("Password@12", "31", "December", "2008");
	sign.fillAddressInformation("Rayush", "Shrestha", "Sajilo", "chabhil", "saraswati nagar", "Canada", "Bagmati","Kathmandu", "123456", "1234567890");
	sign.createAccount();
	
	ProductPage pro=new ProductPage(driver);
	
	pro.addProducts();
	pro.payment();
	pro.logout();
}
}
