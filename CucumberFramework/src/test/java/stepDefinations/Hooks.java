package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Hooks {

	@Given("User have credentials")
	public void user_have_credentials() {
		System.out.println("User have credentials");
	}

	@When("User entering an username with password")
	public void user_entering_an_username_with_password() {
		System.out.println("User entering an username with password");
	}

	@When("Enters the  login button action")
	public void enters_the_login_button_action() {
		System.out.println("Enters the  login button action");
	}
}
