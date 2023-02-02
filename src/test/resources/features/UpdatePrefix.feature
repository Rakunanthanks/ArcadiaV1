@Regression
Feature: Update Prefix

  @FilterComponent
  Scenario: Test verifies a to update the prefix
  Given I'm on Arcadia test environment
  And Navigated to Profiles setting for profile 'quickstart'
  And User selected 'COMPONENT PREFIX EDITOR' from General panel
  Then User capture the Identifier and Prefix from the UI
  And click on Edit button to edit the Identifier 'battery' and Prefix 'BAT'


