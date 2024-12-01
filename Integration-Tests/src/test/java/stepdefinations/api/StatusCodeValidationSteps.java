package stepdefinations.api;

import org.testng.Assert;

import base.api.APIBaseTest;
import io.cucumber.java.en.Then;

public class StatusCodeValidationSteps extends APIBaseTest {

	@Then("I should receive a {int} status code                           # null")
	public void i_should_receive_a_status_code_null(Integer statusCode) {
		Assert.assertTrue(response.statusCode() == statusCode, "**** User unable to creat booking *****");
	}
}
