Feature: Copy and Delete components

  @ComponentDB
  @CloneComponent
  Scenario: Test verifies a component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    And 'component' component with status 'IN REVIEW' is created successfully
    And User selected 'component' from componentDB
    And User searches 'component' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'component' component using 'partnumber'
    Then User verified the component 'component' is added successfully

  @ComponentDB
  @DeleteComponent
  Scenario: Test verifies a component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    And 'component' component with status 'IN REVIEW' is created successfully
    And User selected 'component' from componentDB
    And User searches 'component' component using 'partnumber'
    Then User verified the component 'component' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @ComponentDB
  @CloneComponent
  Scenario: Test verifies a component can be copied
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    And 'component' component with status 'IN REVIEW' is created successfully
    And User selected 'component' from componentDB
    And User searches 'component' component using 'partnumber'
    Then User verified the component 'component' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'component' is copied successfully