@Regression
Feature: Verify context menu
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user sets label 'connector cavity table' to "Show"
    And 'connector' list is initialized

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies Inspect functionality on connector
    And User try operation 'inspect' for connector
    Then User verifies the connector details window is opened successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies Delete functionality on connector
    And User try operation 'delete' for connector
    Then User verifies the connector '0' is deleted successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

#  @VerifyConnector @VerifyConnectorContextMenu --TODO--This scenario is not complete yet
#  Scenario: Test verifies ResetLabels functionality on connector
#    And 'connectorplug' component with index '0' is opened
#    And user enters description in connector details
#    And Submit connector
#    Then User verifies the connectordescription is added successfully
#    And User verifies reset labels functionality


  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ToggleConnectorImage functionality on connector
    Then User verifies 'connector' image is visible
    When User try operation 'Toggle Connector Image' for connector
    Then User verifies the 'connector' image is toggled successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ToggleTerminalImage functionality on connector
    And 'connectorplug' component with index '0' is opened
    And GetCavityDetails window is opened
    And Cavity is updated with terminal image
    And Submit connector
    Then User verifies the 'terminal' image is toggled successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ShowToLocations functionality on connector
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And wire table data is updated
    And user sets visibility of connector table layout to "Yes"
    And Submit connector
    When User try operation 'Show To Locations' for connector
    Then User verify 'wire' destination is displayed successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ShowHideWireFan functionality on connector
    And 'connectorplug' component with index '0' is opened
    And user sets visibility of connector table layout to "Yes"
    And Submit connector
    Then User verifies the WireFan is ShownHidden successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ShowHideUnusedCavities functionality on connector
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And Submit connector
    Then User verifies the UnusedCavities are ShownHidden successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ShowHideUnusedCavities with EntryPort functionality on connector
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And user sets visibility of connector table layout to "Yes"
    And Submit connector
    Then User verifies the UnusedCavities with EntryPort are ShownHidden successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ChangeNode functionality on connector
    And User try operation 'Change Node' for connector
    Then User verifies the connector node is moved successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies AutoArrange functionality on connector
    Then User verifies the view is autoarranged successfully