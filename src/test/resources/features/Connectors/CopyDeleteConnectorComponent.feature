@Regression
Feature: Copy and Delete connector components

  @ConnectorsComponentDB
  @CloneConnectorComponent
  Scenario: Test verifies a connector component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    And 'connector' component with status 'IN REVIEW' is created successfully
    And User selected 'connector' from componentDB
    And User searches 'connector' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'connector' component using 'partnumber'
    Then User verified the component 'connector' is added successfully

  @ConnectorsComponentDB
  @DeleteConnectorComponent
  Scenario: Test verifies a connector component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    And 'connector' component with status 'IN REVIEW' is created successfully
    And User selected 'connector' from componentDB
    And User searches 'connector' component using 'partnumber'
    Then User verified the component 'connector' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @ConnectorsComponentDB
  @CloneConnectorComponent
  Scenario: Test verifies a connector component can be copied
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    And 'connector' component with status 'IN REVIEW' is created successfully
    And User selected 'connector' from componentDB
    And User searches 'connector' component using 'partnumber'
    Then User verified the component 'connector' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'connector' is copied successfully