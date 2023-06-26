@E2ENew
Feature: Verify cavity harness can be restructured, imported and exported
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test15
    And Navigated to 'Aut_Integration' project
    And User imports harness 'NewScenarioHarness'
    And user navigated to newly created harness

  @SchematicToHarness
  Scenario: Verifies that Harness Cavity can be restructured as per show and hide columns
    And user move to connector cavity table Harness page and 'disable' hide empty column and make some column visible
    And user verifies that empty columns are 'visible' in table
    And user move to connector cavity table Harness page and 'enable' hide empty column and make some column visible
    And user verifies that empty columns are 'not visible' in table
    And user add the terminal part number to check if new column is coming on adding the details
    And user validate the terminal strip length
    And user enable the label visibility and verify them

  @SchematicToHarness
  Scenario: Verifies that terminal in harness cavity can be updated, Cavity Imported and Exported
    And user verifies terminal in harness cavity is updated with default db hierarchy
    And user verifies if error is coming if updated with invalid part number
    And user export the harness cavity for the specific connector
    And user verify that harness cavity file is exported
    And user make some changes in the downloaded harness cavity table
    And user import the downloaded harness cavity file
    And user validate the changes done in file on UI