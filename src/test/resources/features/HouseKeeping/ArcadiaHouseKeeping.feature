@HouseKeeping
Feature: House Keeping
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to selected componentDB

  Scenario: Initiate Component DB House keeping
    Then House keeping invoked for 'ComponentDB'