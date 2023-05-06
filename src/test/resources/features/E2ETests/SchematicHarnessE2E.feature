
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



  @VerifySchematicHarness
  Scenario: Test schematic harness properties
    And based on drawing orchestrator components are created
    And user sets label 'bundle' to "Show"
    And user sets label 'node' to "Show"
    And user add nodes to schematic harness


  @VerifySchematicHarness
  Scenario: Verifies that parts can be linked to node by searching, filtering connector or splices
    And based on drawing orchestrator components are created
    And user sets label 'bundle' to "Show"
    And user sets label 'node' to "Show"
    And user add nodes to schematic harness
    And user select the 'node2' to add the part "c2"
    And user verifies the 'search' filter to link part "c2"
    And user select the 'node3' to add the part "s1"
    And user verifies the 'connector' filter to link part "s1"
    And user select the 'node4' to add the part "s2"
    And user verifies the 'splices' filter to link part "s2"


