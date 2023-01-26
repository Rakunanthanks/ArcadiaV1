Feature: Verify Harness Components
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user sets label 'connector cavity table' to "Show"
    And connector plug '0' is opened

  @VerifyConnector
  Scenario: Test verifies a description can be added to a connector
    And user enters description in connector details
    And Submit connector
    Then User verifies the connectordescription is added successfully

  @VerifyConnector
  Scenario: Test verifies a piped description can be added to a connector
    And user enters piped description in connector details
    And Submit connector
    Then User verifies the connectordescription is added successfully

  @VerifyConnector
  Scenario: Test verifies a cavity table can be viewed on connector
    And user sets cavitytable display to 'true'
    And Submit connector
    Then User verifies '1' cavityTable displayed

  @VerifyConnector
  Scenario: Test verifies a cavity table can be hidden on connector
    And user sets cavitytable display to 'false'
    And Submit connector
    Then User verifies '0' cavityTable displayed

  @VerifyConnector
  Scenario: Test verifies a discrete component Resistor can be added on connector
    And adds discrete component 'Resistor' with dest type 'Cavity'
    And Submit connector
    Then User verifies the discrete component is displayed
    And connector plug '0' is opened
    And user deletes the discrete component successfully

  @VerifyConnector
  Scenario: Test verifies a discrete component Capacitor can be added on connector
    And adds discrete component 'Capacitor' with dest type 'Cavity'
    And Submit connector
    Then User verifies the discrete component is displayed
    And connector plug '0' is opened
    And user deletes the discrete component successfully

  @VerifyConnector
  Scenario: Test verifies a discrete component Diode can be added on connector
    And adds discrete component 'Diode' with dest type 'Cavity'
    And Submit connector
    Then User verifies the discrete component is displayed
    And connector plug '0' is opened
    And user deletes the discrete component successfully

  @VerifyConnector
  Scenario: Test verifies a discrete component Inductor can be added on connector
    And adds discrete component 'Inductor' with dest type 'Cavity'
    And Submit connector
    Then User verifies the discrete component is displayed
    And connector plug '0' is opened
    And user deletes the discrete component successfully

  @VerifyConnector
  Scenario: Test verifies attached part on connector is checked by default
    Then Verify attached part on connector is checked

  @VerifyConnector
  Scenario: Test verifies details of attached part on connector matches componentdb
    Then Verify attached part details on connector

  @VerifyConnector
  Scenario: Test verifies imagepath of attached part on connector matches componentdb
    And User opens attachedparts details window
    Then Verify imagepath of attached part on connector