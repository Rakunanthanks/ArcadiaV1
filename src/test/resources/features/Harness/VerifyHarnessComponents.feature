Feature: Verify Harness Components

  @VerifyConnector
  Scenario: Test verifies a description can be added to a connector
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    And harness connectorvalidator is opened
    And user sets label 'connector cavity table' to "Show"
    And connector plug '0' is opened
    And user enters description in connector details
    And Submit connector
    Then User verifies the connectordescription is added successfully