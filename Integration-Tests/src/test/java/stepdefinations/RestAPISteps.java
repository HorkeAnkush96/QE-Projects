package stepdefinations;

import base.RestUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class RestAPISteps {

    RestUtil restUtil = new RestUtil();


    private Response response;

    // Given steps for Base URI, Endpoint, Content Type, and Data Input
    @Given("the base URI is {string}")
    public void setBaseURI(String baseUri) {
        restUtil.setBaseURI(baseUri);
    }

    @Given("the endpoint is {string}")
    public void setEndpoint(String endpoint) {
        restUtil.setEndpoint(endpoint);
    }

    @Given("the content type is {string}")
    public void setContentType(String contentType) {
        restUtil.setHeader("Content-type", contentType);
    }


//    public static void main(String[] args) {
//        String json="{\n" +
//                "    \"firstname\" : %b,\n" +
//                "    \"lastname\" : \"%d\",\n" +
//                "    \"additionalneeds\" : \"%s\"\n" +
//                "}";
//        System.out.println(String.format(json, 12365,"Lunch","Shiva"));
//    }

    @Given("the booking data is provided as:")
    public void setBookingData(DataTable dataTable) {
        // Extract data directly from DataTable
        String firstname = dataTable.cell(1, 0);
        String lastname = dataTable.cell(1, 1);
        int totalprice = Integer.parseInt(dataTable.cell(1, 2));
        boolean depositpaid = Boolean.parseBoolean(dataTable.cell(1, 3));
        String fromDate = dataTable.cell(1, 4);
        String toDate = dataTable.cell(1, 5);
        String additionalneeds = dataTable.cell(1, 6);

        // Creating a reusable JSON request body
        String requestBody = String.format("{\n" +
                "  \"firstname\": \"%s\",\n" +
                "  \"lastname\": \"%s\",\n" +
                "  \"totalprice\": %d,\n" +
                "  \"depositpaid\": %b,\n" +
                "  \"bookingdates\": {\n" +
                "    \"from\": \"%s\",\n" +
                "    \"to\": \"%s\"\n" +
                "  },\n" +
                "  \"additionalneeds\": \"%s\"\n" +
                "}", firstname, lastname, totalprice, depositpaid, fromDate, toDate, additionalneeds);

        System.out.println(requestBody);
        restUtil.setRequestBody(requestBody);
    }

    // When step for sending POST request
    @When("I send a {string} request to create the booking")
    public void userHitAPIRequest(String method) {
        restUtil.hitEndpoint(method);
    }

    // Then steps for validating the response
    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        restUtil.verifyStatusCodeAs(statusCode);
    }

    @Then("the response body should contain a booking id")
    public void verifyBookingId() {

    }
}
