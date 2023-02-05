@Regression
Feature: Filter attached parts Splice

  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test11
    And Navigated to selected componentDB

  @FilterAttachedParts
  Scenario: Test verifies connectors can be filtered in attached parts
    And User selected 'splice' from componentDB
    And 'splice' details are extracted successfully
    And Navigated to quickstart project
    And harness with name 'spliceValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'splice' component with index '0' is opened
    And User opens attachedparts details window
    Then Verify user filters component 'splice' in attachedparts successfully