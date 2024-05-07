package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Background {

	@Given("Student complete hsc")
	public void student_complete_hsc() {
		System.out.println("Student complete hsc");
	}

	@Given("Student complete school studies")
	public void student_complete_school_studies() {
		System.out.println("Student complete school studies");

	}

	@Given("Student applied for medicine course")
	public void student_applied_for_medicine_course() {
		System.out.println("Student applied for medicine course");
	}

	@When("Student cleared exam")
	public void student_cleared_exam() {
		System.out.println("Student cleared exam");
	}

	@Then("Student joins the college")
	public void student_joins_the_college() {
		System.out.println("Student joins the college");
	}

	@Given("Student applied for engineering course")
	public void student_applied_for_engineering_course() {
		System.out.println("Student applied for engineering course");
	}

	@When("Student has cut off")
	public void student_has_cut_off() {
		System.out.println("Student has cut off");
	}

	@Then("Student joins the engineering college")
	public void student_joins_the_engineering_college() {
		System.out.println("Student joins the engineering college");
	}

}
