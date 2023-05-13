
Feature: Verify schematics harness wires functionality
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And Navigated to 'Aut_Integration' project
    And user navigated to newly created harness

  @VerifySchematicHarness
  Scenario: Verifies that wires can be deleted on schematic harness
    Then user verifies wires can be deleted succesfully on schematic harness