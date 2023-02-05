@Regression
Feature: Filter attached parts
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to selected componentDB


  @FilterAttachedParts
  Scenario: Test verifies connectors can be filtered in attached parts
    And User selected 'connector' from componentDB
    And 'connector' details are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And User opens attachedparts details window
    Then Verify user filters component 'connector' in attachedparts successfully

  @FilterAttachedParts
  Scenario: Test verifies splice can be filtered in attached parts
    And User selected 'splice' from componentDB
    And 'splice' details are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And User opens attachedparts details window
    Then Verify user filters component 'splice' in attachedparts successfully

  @FilterAttachedParts
  Scenario: Test verifies seal can be filtered in attached parts
    And User selected 'seal' from componentDB
    And 'seal' details are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And User opens attachedparts details window
    Then Verify user filters component 'seal' in attachedparts successfully

  @FilterAttachedParts
  Scenario: Test verifies terminals can be filtered in attached parts
    And User selected 'terminal' from componentDB
    And 'terminal' details are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And User opens attachedparts details window
    Then Verify user filters component 'terminal' in attachedparts successfully

  @FilterAttachedParts
  Scenario: Test verifies junctionparts can be filtered in attached parts
    And User selected 'junctionpart' from componentDB
    And 'junctionpart' details are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And User opens attachedparts details window
    Then Verify user filters component 'junctionpart' in attachedparts successfully

  @FilterAttachedParts
  Scenario: Test verifies components can be filtered in attached parts
    And User selected 'component' from componentDB
    And 'component' details are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And User opens attachedparts details window
    Then Verify user filters component 'component' in attachedparts successfully

  @FilterAttachedParts
  Scenario: Test verifies otherparts can be filtered in attached parts
    And User selected 'otherpart' from componentDB
    And 'otherpart' details are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And User opens attachedparts details window
    Then Verify user filters component 'otherpart' in attachedparts successfully

