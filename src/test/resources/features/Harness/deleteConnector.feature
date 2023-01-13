Feature: Delete connector

  @DeleteConnector
  Scenario: Test verifies a connector can be deleted using 'Delete' operation
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test9
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    And User try operation 'delete' for connector

