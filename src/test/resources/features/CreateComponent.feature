Feature: Create components

  @CreateComponent
  Scenario: Test verifies a component can be created
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with status 'IN REVIEW' is created successfully
