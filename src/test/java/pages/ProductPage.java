package pages;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ProductPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions; 

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(.,'Products')]")
	WebElement navProduct;
	@FindBy(xpath = "//a[.=' Cart']")
	WebElement cart;
	@FindBy(xpath = "(//a[@data-product-id='1'])[1]")
	WebElement product;
	@FindBy(xpath = "//u")
	WebElement popUp;
	@FindBy(xpath = "//tr[@id='product-1']")
	WebElement productInCart;
	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
	WebElement checkoutButton;
	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
	WebElement orderButton;
	@FindBy(xpath = "//button[.='Pay and Confirm Order']")
	WebElement confirmButton;
	@FindBy(xpath = "//a[.='Continue']")
	WebElement continueBtn;
	@FindBy(xpath = "//a[.=' Logout']")
	WebElement signout;

	public void addProducts() {
		cart.click();
		String intialCount = cart.findElement(By.xpath("//b")).getText();
		navProduct.click();
		
		if (product.getText().contains("Add to cart")) {
			product.click();
		}
		popUp.click();
		String finalCount = popUp.findElement(By.xpath("//tr[@id=\"product-1\"]")).getText();
		if (intialCount.equals(finalCount)) {
			System.out.println("the count isnot updated");
		} else {
			System.out.println("Count is updated");

		}
		boolean isDisplayed = productInCart.isDisplayed();
		if (isDisplayed) {
			Reporter.log("Product is visible in the cart", true);
		} else {
			Reporter.log("Product is NOT visible in the cart", true);
		}
		checkoutButton.click();
		WebElement checkoutContainer = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='container'])[2]")));
		if (checkoutContainer.isDisplayed()) {
			System.out.println("The checkout page is loaded sucessfully.");

		} else {
			System.out.println("The checkout page is not loaded");
		}
		orderButton.click();

	}

	public void payment() {
		confirmButton.click();
		actions.sendKeys("Hello World").perform();
		confirmButton.click();
	
		actions.sendKeys("Hello World").perform();
		
		confirmButton.click();

		actions.sendKeys("3656").perform();
		confirmButton.click();
		actions.sendKeys("2026").perform();
		confirmButton.click();
		actions.sendKeys("2026").perform();
		confirmButton.click();
		continueBtn.click();
	}
	public void logout() {
		signout.click();
	}
}
