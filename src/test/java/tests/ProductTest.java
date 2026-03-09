package tests;

import java.util.Random;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductPage;
import pages.SignUpPage;

public class ProductTest extends BaseTest {
	
@Test
public void item() throws InterruptedException {
	SignUpPage sign=new SignUpPage(driver);
	sign.signUp("rayush shrestha", mail);
	ProductPage pro=new ProductPage(driver);
	
	pro.addProducts();
	
}
}
