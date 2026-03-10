package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.SignUpPage;

public class SignUptest extends BaseTest {

	@Test(description = "Verify that user can register using valid data")
	public void signup() {

		SignUpPage signup = new SignUpPage(driver);
		signup.signUp("Rayush", mail);
		signup.fillAccountInformation("Password@12", "31", "December", "2008");
		signup.fillAddressInformation("Rayush", "Shrestha", "Sajilo", "chabhil", "saraswati nagar", "Canada", "Bagmati","Kathmandu", "123456", "1234567890");
		signup.createAccount();

		
	}
}