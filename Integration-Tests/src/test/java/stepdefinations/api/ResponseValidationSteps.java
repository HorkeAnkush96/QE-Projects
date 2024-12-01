package stepdefinations.api;

import org.testng.Assert;

import base.api.APIBaseTest;
import io.cucumber.java.en.Then;

public class ResponseValidationSteps extends APIBaseTest {

	@Then("a booking ID should be generated")
	public void a_booking_ID_should_be_generated() {
		Assert.assertTrue(
				response.jsonPath().getString("bookingid") != "" || response.jsonPath().getString("bookingid") != null,
				"**** Booking ID Is Not Generated *****");
		System.out.println(response.jsonPath().getString("bookingid"));
	}

}
