
Feature: Verify schematics harness
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test15
    And Navigated to 'Aut_Integration' project
    And user navigated to newly created harness

  @VerifySchematicHarness
  Scenario: Test schematic harness properties
    And based on drawing orchestrator components are created
    And user sets label 'bundle' to "Show"
    And user sets label 'node' to "Show"
    And user add nodes to schematic harness