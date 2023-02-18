@Regression
Feature: Copy and Delete Terminal components

  @TerminalComponentDB
  @CloneTerminalComponent
  Scenario: Test verifies a terminal component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'terminal' from componentDB
    And 'terminal' component with status 'IN REVIEW' is created successfully
    And User selected 'terminal' from componentDB
    And User searches 'terminal' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'terminal' component using 'partnumber'
    Then User verified the component 'terminal' is added successfully

  @TerminalComponentDB
  @DeleteTerminalComponent
  Scenario: Test verifies a terminal component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'terminal' from componentDB
    And 'terminal' component with status 'IN REVIEW' is created successfully
    And User selected 'terminal' from componentDB
    And User searches 'terminal' component using 'partnumber'
    Then User verified the component 'terminal' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @TerminalComponentDB
  @CloneTerminalComponent
  Scenario: Test verifies a terminal component can be copied
    Given I'm on Arcadia test environment
    And User navigated to componentDB
    And Created DB 'quickstartms'
    And Navigated to selected componentDB
    And User selected 'terminal' from componentDB
    And 'terminal' component with status 'IN REVIEW' is created successfully
    And User selected 'terminal' from componentDB
    And User searches 'terminal' component using 'partnumber'
    Then User verified the component 'terminal' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'terminal' is copied successfully