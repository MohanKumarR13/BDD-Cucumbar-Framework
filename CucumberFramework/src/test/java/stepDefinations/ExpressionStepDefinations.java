package stepDefinations;

import io.cucumber.java.en.Given;

public class ExpressionStepDefinations {
	@Given("I have (\\d+) laptop$")
	public void i_have_laptop(Integer int1) {
		System.out.println("Laptop Count" + int1);
	}

	@Given("^I have a (\\d+.\\d+) CGPA$")
	public void i_have_a_cgpa(Double double1) {
		System.out.println("CGPA" + double1);

	}

	@Given("^\"(.*?)\" is elder than \"(.*?)\" and \"([^\"]*)\"$")
	public void is_elder_than_and(String string, String string2, String string3) {
		System.out.println(string + "is elder to" + string2 + "and " + string3);
	}

}
