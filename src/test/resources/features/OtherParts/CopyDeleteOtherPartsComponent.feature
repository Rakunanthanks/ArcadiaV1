Feature: Copy and Delete other part components

  @OtherPartsComponentDB
  @CloneOtherPartComponent
  Scenario: Test verifies a other part component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    And 'otherpart' component with status 'IN REVIEW' is created successfully
    And User selected 'otherpart' from componentDB
    And User searches 'otherpart' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'otherpart' component using 'partnumber'
    Then User verified the component 'otherpart' is added successfully

  @OtherPartsComponentDB
  @DeleteOtherPartComponent
  Scenario: Test verifies a other part component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    And 'otherpart' component with status 'IN REVIEW' is created successfully
    And User selected 'otherpart' from componentDB
    And User searches 'otherpart' component using 'partnumber'
    Then User verified the component 'otherpart' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @OtherPartsComponentDB
  @CloneOtherPartComponent
  Scenario: Test verifies a other part component can be copied
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    And 'otherpart' component with status 'IN REVIEW' is created successfully
    And User selected 'otherpart' from componentDB
    And User searches 'otherpart' component using 'partnumber'
    Then User verified the component 'otherpart' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'otherpart' is copied successfully