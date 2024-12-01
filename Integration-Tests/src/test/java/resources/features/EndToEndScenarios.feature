Feature: Booking Management API Tests
  As a user
  I want to manage bookings using REST API calls
  So that I can create, update, fetch, and delete bookings.

  Scenario: Generate Token
    Given the API endpoint is available for authentication
    When I send a POST request with valid credentials
    Then I should receive a 200 status code
    And a valid token should be generated

  Scenario: Create a Booking
    Given I have a valid token
    When I send a POST request to create a booking with valid details
    Then I should receive a 200 status code
    And a booking ID should be generated

  Scenario: Fetch Booking Details
    Given I have a valid booking ID
    When I send a GET request with the booking ID
    Then I should receive a 200 status code
    And the booking details should be returned

  Scenario: Update Booking Details
    Given I have a valid token and booking ID
    When I send a PUT request with updated booking details
    Then I should receive a 200 status code
    And the booking details should be updated

  Scenario: Verify Updated Booking Details
    Given I have a valid booking ID
    When I send a GET request with the updated booking ID
    Then I should receive a 200 status code
    And the updated booking details should be returned

  Scenario: Delete Booking
    Given I have a valid token and booking ID
    When I send a DELETE request with the booking ID
    Then I should receive a 200 status code
    And the booking should be deleted

  Scenario: Verify Deletion of Booking
    Given I have a deleted booking ID
    When I send a GET request with the deleted booking ID
    Then I should receive a 404 status code
    And the booking should not be found
