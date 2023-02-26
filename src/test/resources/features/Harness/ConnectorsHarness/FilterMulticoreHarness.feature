@Regression
Feature: Filter multicore harness
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with status 'APPROVED' is created successfully
    When User selected 'multicore' from componentDB
    And User searches 'multicore' component using 'partnumber'
    Then User verified the component 'multicore' is added successfully
    And test data config loaded for test identifier test10
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened

  @FilterMulticoreHarness
  Scenario: Test verifies a multicore can be filtered using partnumber while creating connectors
    And User opens searchwire window
    Then Verify user filters multicore using 'partNumber' successfully

  @FilterMulticoreHarness
  Scenario: Test verifies a multicore can be filtered using primarycolour while creating connectors
    And User opens searchwire window
    Then Verify user filters multicore using 'primarycolour' successfully
