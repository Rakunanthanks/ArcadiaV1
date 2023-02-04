@Regression
Feature: Link Wire

  @WireComponentDB
  @LinkWireComponent
  Scenario: Test verifies components can be linked with Wire successfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'wire' component with status 'IN REVIEW' is created successfully
    When User selected 'wire' from componentDB
    And User searches 'wire' component using 'partnumber'
    And User selects the first component
    And User edits the first component
    And User links 'part' from componentDB
    And User links 'equivalents' from componentDB
    And User links 'tags' from componentDB