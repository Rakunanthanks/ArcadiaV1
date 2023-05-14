
Feature: Verify schematics harness wires functionality
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And Navigated to 'Aut_Integration' project
    And User imports base schematic
#    And User imports schematic harness
    And user navigated to newly created harness

  @VerifySchematicHarnessWires
  Scenario: Verifies that wires can be deleted on schematic harness
    Then user verifies wires can be deleted succesfully on schematic harness

  @VerifySchematicHarnessWires
  Scenario: Verifies that wires can be exported on schematic harness
    And User delete all old files from the default download folder
    Then user verifies wires can be exported succesfully on schematic harness

  @VerifySchematicHarnessWires
  Scenario: Verifies that wires can be loaded from schematic on harness
    And user loades wires from schematic on harness wireeditor
    And user verifies wires are loaded from schematic succesfully
    And go to drawing from wire editor