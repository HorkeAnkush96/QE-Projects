package stepdefinations.api;

import org.testng.Assert;

import base.api.APIBaseTest;
import io.cucumber.java.en.Then;

public class ResponseValidationSteps extends APIBaseTest {

	@Then("a booking ID should be generated")
	public void a_booking_ID_should_be_generated() {
		Assert.assertTrue(
				String.valueOf(responseData.bookingid) != "" || String.valueOf(responseData.bookingid) != null,
				"**** Booking ID Is Not Generated *****");
		System.out.println("This is my booking id: " + responseData.bookingid);
	}

}
