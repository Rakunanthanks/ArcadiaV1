@Regression
Feature: Copy and Delete junction part components

  @JunctionPartComponentDB
  @CloneJunctionPartComponent
  Scenario: Test verifies a junction part component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    And 'junctionpart' component with status 'IN REVIEW' is created successfully
    And User selected 'junctionpart' from componentDB
    And User searches 'junctionpart' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'junctionpart' component using 'partnumber'
    Then User verified the component 'junctionpart' is added successfully

  @JunctionPartComponentDB
  @DeleteJunctionPartComponent
  Scenario: Test verifies a junction part component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    And 'junctionpart' component with status 'IN REVIEW' is created successfully
    And User selected 'junctionpart' from componentDB
    And User searches 'junctionpart' component using 'partnumber'
    Then User verified the component 'junctionpart' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @JunctionPartComponentDB
  @CloneJunctionPartComponent
  Scenario: Test verifies a junction part component can be copied
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    And 'junctionpart' component with status 'IN REVIEW' is created successfully
    And User selected 'junctionpart' from componentDB
    And User searches 'junctionpart' component using 'partnumber'
    Then User verified the component 'junctionpart' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'junctionpart' is copied successfully