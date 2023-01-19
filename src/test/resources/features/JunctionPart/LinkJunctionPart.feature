Feature: Link Junction Parts

  @JunctionPartsComponentDB
  @LinkJunctionPartsComponent
  Scenario: Test verifies components can be linked with Junction Parts successfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then 'junctionpart' component with status 'IN REVIEW' is created successfully
    When User selected 'junctionpart' from componentDB
    And User searches 'junctionpart' component using 'partnumber'
    And User selects the first component
    And User edits the first component
    And User links 'part' from componentDB
    And User links 'equivalents' from componentDB
    And User links 'tags' from componentDB