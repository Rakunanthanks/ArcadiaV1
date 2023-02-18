@Regression
Feature: Copy and Delete applicator components

  @ApplicatorsComponentDB
  @CloneApplicatorComponent
  Scenario: Test verifies a applicator component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    And 'applicator' component with status 'IN REVIEW' is created successfully
    And User selected 'applicator' from componentDB
    And User searches 'applicator' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'applicator' component using 'partnumber'
    Then User verified the component 'applicator' is added successfully

  @ApplicatorsComponentDB
  @DeleteSpliceComponent
  Scenario: Test verifies a applicator component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    And 'applicator' component with status 'IN REVIEW' is created successfully
    And User selected 'applicator' from componentDB
    And User searches 'applicator' component using 'partnumber'
    Then User verified the component 'applicator' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @ApplicatorsComponentDB
  @CloneApplicatorComponent
  Scenario: Test verifies a applicator component can be copied
    Given I'm on Arcadia test environment
    And User navigated to componentDB
    And Created DB 'quickstartms'
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    And 'applicator' component with status 'IN REVIEW' is created successfully
    And User selected 'applicator' from componentDB
    And User searches 'applicator' component using 'partnumber'
    Then User verified the component 'applicator' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'applicator' is copied successfully