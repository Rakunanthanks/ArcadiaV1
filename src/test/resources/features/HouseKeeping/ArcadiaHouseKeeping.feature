@HouseKeeping
Feature: House Keeping
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10

  Scenario: Initiate Component DB House keeping
    And Navigated to selected componentDB
    Then House keeping invoked for 'ComponentDB'

  Scenario: Initiate Harness House keeping
    And Navigated to quickstart project
    Then House keeping invoked for 'Harness'