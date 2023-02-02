@Regression
Feature: Link Other Parts

  @OtherPartsComponentDB
  @LinkOtherPartsComponent
  Scenario: Test verifies components can be linked with Other Parts successfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    Then 'otherpart' component with status 'IN REVIEW' is created successfully
    When User selected 'otherpart' from componentDB
    And User searches 'otherpart' component using 'partnumber'
    And User selects the first component
    And User edits the first component
    And User links 'part' from componentDB
    And User links 'equivalents' from componentDB
    And User links 'tags' from componentDB