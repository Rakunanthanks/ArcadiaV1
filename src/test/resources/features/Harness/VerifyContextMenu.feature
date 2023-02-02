Feature: Verify context menu
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user sets label 'connector cavity table' to "Show"

  @VerifyConnector
  Scenario: Test verifies Inspect functionality on connector
    And User try operation 'inspect' for connector
    Then User verifies the connector details window is opened successfully

  @VerifyConnector
  Scenario: Test verifies Delete functionality on connector
    And User try operation 'delete' for connector
    Then User verifies the connector '0' is deleted successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully


  #Below scenario is in progress
#  @VerifyConnector
#  Scenario: Test verifies ResetLabels functionality on connector
#    And User try operation 'reset labels' for connector
#    Then User verifies reset label works as expected


#  @VerifyConnector
#  Scenario: Test verifies Connector Label functionality on connector
#    And Navigated to GeneralMacros page
#    And 'custom label' macros tags are extracted successfully
#    And User try operation 'connector label' for connector