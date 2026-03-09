package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public void addproducts() {
		navProduct.click();
		System.out.println(product.getText());
		if(product.getText().contains("Add to cart")) {
			product.click();
		}
	}
}
