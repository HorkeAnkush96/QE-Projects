Feature: Booking Management API Tests
  As a user
  I want to manage bookings using REST API calls
  So that I can create, update, fetch, and delete bookings.

@TestDemo
  Scenario: Create a Booking                                          # src/test/java/resources/features/features/EndToEndScenarios.feature:12
  Given I have valid create a booking endpoint
  When I provide valid content type as "application/json"
  Given I have provided valid payload
  When I send a POST request to create a booking with valid details # null
  Then I should receive a 200 status code                           # null
  And a booking ID should be generated     