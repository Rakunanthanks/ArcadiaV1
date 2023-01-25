Feature: Filter wires harness
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    And 'wire' details are extracted successfully

  @FilterWiresHarness
  Scenario: Test verifies a wire can be filtered using partnumber while creating connectors
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And connector plug '0' is opened
    And User opens searchwire window
    Then Verify user filters wire using 'partNumber' successfully

  @FilterWiresHarness
  Scenario: Test verifies a wire can be filtered using material while creating connectors
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And connector plug '0' is opened
    And User opens searchwire window
    Then Verify user filters wire using 'material' successfully

  @FilterWiresHarness
  Scenario: Test verifies a wire can be filtered using gauge while creating connectors
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And connector plug '0' is opened
    And User opens searchwire window
    Then Verify user filters wire using 'gauge' successfully

  @FilterWiresHarness
  Scenario: Test verifies a wire can be filtered using csa while creating connectors
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And connector plug '0' is opened
    And User opens searchwire window
    Then Verify user filters wire using 'csa' successfully

  @FilterWiresHarness
  Scenario: Test verifies a wire can be filtered using OuterDia while creating connectors
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And connector plug '0' is opened
    And User opens searchwire window
    Then Verify user filters wire using 'outerdia' successfully

  @FilterWiresHarness
  Scenario: Test verifies a wire can be filtered using multiple filters while creating connectors
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And connector plug '0' is opened
    And User opens searchwire window
    Then Verify user filters wire using 'partNumber' and 'material' successfully

  @UpdateWirePN
  Scenario: Test verifies a wire can be filtered using material and gauge in wiretable
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And connector plug '0' is opened
    And wire is added to cavity
    Then Verify updateWirePN functionality in wiretable successfully
