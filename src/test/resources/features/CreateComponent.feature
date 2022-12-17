Feature: Create components

  @CreateComponent
#  Scenario: Test verifies a component can be created
#    Given User opens add component page
#    When User enters data on Add Component Page
#    And User submits the component details


  Scenario: Test verifies a component can be created
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    And User opens add component page
    And User enters data on Add Component Page
    And User submits the component details
