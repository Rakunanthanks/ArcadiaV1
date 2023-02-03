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

#  @VerifyConnector
#  Scenario: Test verifies ResetLabels functionality on connector
#    And connector plug '0' is opened
#    And user enters description in connector details
#    And Submit connector
#    Then User verifies the connectordescription is added successfully
#    When User moves the label 'connectordescription' to a different position
#    And User try operation 'reset labels' for connector
#    Then User verifies reset label works as expected


