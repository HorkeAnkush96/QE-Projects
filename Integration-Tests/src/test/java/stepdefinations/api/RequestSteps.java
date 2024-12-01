package stepdefinations.api;

import base.api.APIBaseTest;
import base.api.Endpoints;
import base.api.RequestJsonData;
import base.api.RestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RequestSteps extends APIBaseTest {
	
	@Given("I have valid create a booking endpoint")
	public void i_have_valid_create_a_booking_endpoint() {
		restUtil.setEndpoint(Endpoints.CREATE_USER_ENDPOINT);
	}

	@When("I provide valid content type as {string}")
	public void i_provide_valid_content_type_as(String type) {
		restUtil.setContentType(type);
	}

//	public static void main(String[] args) {
//		String payload=String.format(
//				RequestJsonData.CREATE_USER_PAYLOAD, 
//				"Shiva","Lastname","2024-01-01","2024-01-10");
//		System.out.println(payload);
//	}

	@When("I have provided valid payload")
	public void i_have_provided_valid_payload() {
		String payload = String.format(
				RequestJsonData.CREATE_USER_PAYLOAD, 
				"Shiva", "Lastname", "2024-01-01",
				"2024-01-10");
		restUtil.setRequestPayload(payload);
	}

	@When("I send a POST request to create a booking with valid details # null")
	public void i_send_a_post_request_to_create_a_booking_with_valid_details_null() {
		restUtil.hitEndpoint("POST");
	}

}
