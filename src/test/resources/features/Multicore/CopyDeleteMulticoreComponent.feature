@Regression
Feature: Copy and Delete multicore components

  @MulticoreComponentDB
  @CloneMulticoreComponent
  Scenario: Test verifies a multicore component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    And 'multicore' component with status 'IN REVIEW' is created successfully
    And User selected 'multicore' from componentDB
    And User searches 'multicore' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'multicore' component using 'partnumber'
    Then User verified the component 'multicore' is added successfully

  @MulticoreComponentDB
  @DeleteMulticoreComponent
  Scenario: Test verifies a multicore component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    And 'multicore' component with status 'IN REVIEW' is created successfully
    And User selected 'multicore' from componentDB
    And User searches 'multicore' component using 'partnumber'
    Then User verified the component 'multicore' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @MulticoreComponentDB
  @CloneMulticoreComponent
  Scenario: Test verifies a multicore component can be copied
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    And 'multicore' component with status 'IN REVIEW' is created successfully
    And User selected 'multicore' from componentDB
    And User searches 'multicore' component using 'partnumber'
    Then User verified the component 'multicore' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'multicore' is copied successfully