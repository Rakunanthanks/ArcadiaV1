Feature: Link components

  @ComponentDB
  @LinkComponents
  Scenario: Test verifies components can be linked successfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then 'component' component with status 'IN REVIEW' is created successfully
    When User selected 'component' from componentDB
    And User searches 'component' component using 'partnumber'
    And User selects the first component
    And User edits the first component
    And User links 'connectors' from componentDB
    And User links 'part' from componentDB
    And User links 'equivalents' from componentDB
    And User links 'tags' from componentDB