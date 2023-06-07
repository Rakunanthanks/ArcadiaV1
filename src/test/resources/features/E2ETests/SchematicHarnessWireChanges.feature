@E2Evv
Feature: Verify harness created from schematic can be restructured
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test15
    And Navigated to 'Aut_Integration' project
    And User imports harness 'NewScenarioHarness'
    And user navigated to newly created harness

  @SchematicToHarness
  Scenario: Verifies that Harness Cavity can be restructured
    And user verifies that empty columns are 'visible' in table
    And user move to connector cavity table Harness page and enable hide empty column and make some column visible
    And user verifies that empty columns are 'not visible' in table
    And user add the terminal part number to check if new column is coming on adding the details
  @SchematicToHarness
  Scenario: Verifies that terminal in harness cavity can be updated
    And user verifies terminal in harness cavity is updated with default db hierarchy
    And user verifies if error is coming if updated with invalid part number



