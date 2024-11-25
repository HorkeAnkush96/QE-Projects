Feature: Create Booking API
  As a user of the booking system
  I want to create a new booking
  So that I can verify the booking has been successfully created

  @SmokeTest
  Scenario: Verify Successfully create a new booking
    Given the base URI is "https://restful-booker.herokuapp.com"
    And the endpoint is "/booking"
    And the content type is "application/json"
    And the booking data is provided as:
      | firstname | lastname | totalprice | depositpaid | bookingdates.from | bookingdates.to | additionalneeds |
      | Shiva     | Test        | 150        | true        | 2024-11-25        | 2024-11-30      | Breakfast       |
    When I send a "POST" request to create the booking
    Then the response status code should be 200
    And the response body should contain a booking id


  Scenario: Verify Successfully create a new booking using json file
    Given the base URI is "https://restful-booker.herokuapp.com"
    And the endpoint is "/booking"
    And the content type is "application/json"
    And the booking json payload data
    When I send a "POST" request to create the booking
    Then the response status code should be 200
    And the response body should contain a booking id