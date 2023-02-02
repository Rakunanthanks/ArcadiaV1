@Regression
Feature: Copy and Delete splice components

  @SpliceComponentDB
  @CloneSpliceComponent
  Scenario: Test verifies a splice component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    And 'splice' component with status 'IN REVIEW' is created successfully
    And User selected 'splice' from componentDB
    And User searches 'splice' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'splice' component using 'partnumber'
    Then User verified the component 'splice' is added successfully

  @SpliceComponentDB
  @DeleteSpliceComponent
  Scenario: Test verifies a splice component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    And 'splice' component with status 'IN REVIEW' is created successfully
    And User selected 'splice' from componentDB
    And User searches 'splice' component using 'partnumber'
    Then User verified the component 'splice' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @SpliceComponentDB
  @CloneSpliceComponent
  Scenario: Test verifies a splice component can be copied
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    And 'splice' component with status 'IN REVIEW' is created successfully
    And User selected 'splice' from componentDB
    And User searches 'splice' component using 'partnumber'
    Then User verified the component 'splice' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'splice' is copied successfully