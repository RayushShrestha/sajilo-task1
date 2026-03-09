package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	WebDriver driver;
	WebDriverWait wait;
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(name = "name")
	WebElement userName;

	@FindBy(xpath = "(//input[@name='email'])[2]")
	WebElement userEmail;

	@FindBy(xpath = "//button[.='Signup']")
	WebElement signupButton;

	@FindBy(id = "id_gender1")
	WebElement gender;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "days")
	WebElement day;

	@FindBy(name = "months")
	WebElement month;

	@FindBy(name = "years")
	WebElement year;

	@FindBy(xpath = "//label[.='Sign up for our newsletter!']")
	WebElement newsletter;

	@FindBy(xpath = "//label[.='Receive special offers from our partners!']")
	WebElement offers;

	// Address information
	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(name = "company")
	WebElement company;

	@FindBy(name = "address1")
	WebElement address1;

	@FindBy(name = "address2")
	WebElement address2;

	@FindBy(name = "country")
	WebElement country;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(name = "zipcode")
	WebElement zipcode;

	@FindBy(name = "mobile_number")
	WebElement mobile;

	@FindBy(xpath = "//button[.='Create Account']")
	WebElement createAccount;

	@FindBy(xpath = "//a[.='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//a[.=' Logout']")
	WebElement logout;

	public void signUp(String name, String email) {
		userName.sendKeys(name);
		userEmail.sendKeys(email);
		signupButton.click();
	}

	public void fillAccountInformation(String pass, String dayValue, String monthValue, String yearValue) {
		gender.click();
		password.sendKeys(pass);
		new Select(day).selectByVisibleText(dayValue);
		new Select(month).selectByVisibleText(monthValue);
		new Select(year).selectByVisibleText(yearValue);
		newsletter.click();
		offers.click();
	}

	public void fillAddressInformation(String fName, String lName, String comp, String addr1, String addr2,
			String countryName, String stateName, String cityName, String zip, String mobileNo) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		address1.sendKeys(addr1);
		address2.sendKeys(addr2);
		new Select(country).selectByVisibleText(countryName);
		state.sendKeys(stateName);
		city.sendKeys(cityName);
		zipcode.sendKeys(zip);
		mobile.sendKeys(mobileNo);
	}

	public void createAccount() {
		createAccount.click();
		continueBtn.click();
	}

}