Feature: Link Applicators

  @ApplicatorsComponentDB
  @LinkApplicatorsComponent
  Scenario: Test verifies components can be linked with connector successfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with status 'IN REVIEW' is created successfully
    When User selected 'applicator' from componentDB
    And User searches 'applicator' component using 'partnumber'
    And User selects the first component
    And User edits the first component
    And User links 'terminal' from componentDB
    And User links 'seal' from componentDB
    And User links 'tags' from componentDB