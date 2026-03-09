package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class ProductPage {
	WebDriver driver;
	WebDriverWait wait;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(.,'Products')]")
	WebElement navProduct;
	@FindBy(xpath = "//a[.=' Cart']")
	WebElement cart;
	@FindBy(xpath = "(//a[@data-product-id='1'])[1]")
	WebElement product;
	@FindBy (xpath ="//u")
	WebElement popUp;
	@FindBy(xpath="//tr[@id='product-1']")
	WebElement productInCart;

	public void addProducts() {
		cart.click();
		String intialCount=cart.findElement(By.xpath("//b")).getText();
		navProduct.click();
		System.out.println(product.getText());
		if(product.getText().contains("Add to cart")) {
			product.click();
		}
		popUp.click();
		String finalCount=popUp.findElement(By.xpath("//tr[@id=\"product-1\"]")).getText();
		if(intialCount.equals(finalCount)) {
			System.out.println("the count isnot updated");
		}
		else {
			System.out.println("Count is updated");
		
		}
		boolean isDisplayed = productInCart.isDisplayed();
		if(isDisplayed) {
			Reporter.log("Product is visible in the cart", true);
		}else {
			Reporter.log("Product is NOT visible in the cart", true);
		}
	}
}
