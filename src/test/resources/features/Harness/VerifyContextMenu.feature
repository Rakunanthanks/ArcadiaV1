Feature: Verify context menu
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user sets label 'connector cavity table' to "Show"
    And 'connector' list is initialized

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


  @VerifyConnector
  Scenario: Test verifies ToggleConnectorImage functionality on connector
    Then User verifies 'connector' image is visible
    When User try operation 'Toggle Connector Image' for connector
    Then User verifies the 'connector' image is toggled successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector
  Scenario: Test verifies ToggleTerminalImage functionality on connector
    And connector plug '0' is opened
    And GetCavityDetails window is opened
    And Cavity is updated with terminal image
    And Submit connector
    Then User verifies the 'terminal' image is toggled successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully



