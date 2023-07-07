@E2E
Feature: Verify schematics harness
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test15
    And Navigated to 'Aut_Integration' project

  @VerifySchematicHarness @fix123
  Scenario: Verifies that bundle skeleton can be created, moved relatively
    And User imports harness 'drawskeleton'
    And user navigated to newly created harness
    And based on drawing orchestrator components are created
    And User move the skeleton relatively
    And user set length and verifies it
    And user drawn length and verified it


  @VerifySchematicHarness
  Scenario: Verifies that in Harness parts can be linked to node by searching, filtering connector or splices
    And User imports schematic harness
    And user navigated to newly created harness
#    And based on drawing orchestrator components are created
    And user sets label 'bundle' to "Show"
    And user sets label 'node' to "Show"
    And user add nodes to schematic harness
    And user selects footer snap "Minor"
    And user select the 'node10' to add the part "SP-BK"
    And user verifies the 'search' filter to link part "SP-BK"
    And user select the 'node9' to add the part "SP-001"
    And user verifies the 'splices' filter to link part "SP-001"
    And user select the 'node8' to add the part "SP-GN"
    And user verifies the 'search' filter to link part "SP-GN"
    And user select the 'node6' to add the part "C1"
    And user verifies the 'connector' filter to link part "C1"
    And user select the 'node5' to add the part "C2"
    And user verifies the 'connector' filter to link part "C2"
    And user select the 'node3' to add the part "C3"
    And user verifies the 'connector' filter to link part "C3"
    And user select the 'node2' to add the part "C4"
    And user verifies the 'connector' filter to link part "C4"
    And user click on part 'C6' to drag and drop to 'node1'
    And user click on part 'C5' to drag and drop to 'node0'

