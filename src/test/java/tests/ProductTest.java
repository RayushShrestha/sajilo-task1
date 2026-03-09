package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductPage;

public class ProductTest extends BaseTest {
	
@Test
public void item() throws InterruptedException {
	Thread.sleep(2000);
	ProductPage pro=new ProductPage(driver);
	pro.addproducts();
}
}
