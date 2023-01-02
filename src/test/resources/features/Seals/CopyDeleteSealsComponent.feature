Feature: Copy and Delete seal components

  @sealComponentDB
  @ClonesealComponent
  Scenario: Test verifies a seal component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    And 'seal' component with status 'IN REVIEW' is created successfully
    And User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @sealComponentDB
  @DeletesealComponent
  Scenario: Test verifies a seal component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    And 'seal' component with status 'IN REVIEW' is created successfully
    And User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @sealComponentDB
  @ClonesealComponent
  Scenario: Test verifies a seal component can be copied
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    And 'seal' component with status 'IN REVIEW' is created successfully
    And User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'seal' is copied successfully