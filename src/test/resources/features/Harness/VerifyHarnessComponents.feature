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

  @VerifyConnector
  Scenario: Test verifies a piped description can be added to a connector
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    And harness connectorvalidator is opened
    And user sets label 'connector cavity table' to "Show"
    And connector plug '0' is opened
    And user enters piped description in connector details
    And Submit connector
    Then User verifies the connectordescription is added successfully

  @VerifyConnector
  Scenario: Test verifies a cavity table can be viewed on connector
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    And harness connectorvalidator is opened
    And user sets label 'connector cavity table' to "Show"
    And connector plug '0' is opened
    And user sets cavitytable display to 'true'
    And Submit connector
    Then User verifies '1' cavityTable displayed

  @VerifyConnector
  Scenario: Test verifies a cavity table can be hidden on connector
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    And harness connectorvalidator is opened
    And user sets label 'connector cavity table' to "Show"
    And connector plug '0' is opened
    And user sets cavitytable display to 'false'
    And Submit connector
    Then User verifies '0' cavityTable displayed