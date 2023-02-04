@Regression
Feature: Link Terminals

  @TerminalsComponentDB
  @LinkTerminalsComponent
  Scenario: Test verifies components can be linked with Terminal successfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'terminal' from componentDB
    Then 'terminal' component with status 'IN REVIEW' is created successfully
    When User selected 'terminal' from componentDB
    And User searches 'terminal' component using 'partnumber'
    And User selects the first component
    And User edits the first component
    And User links 'part' from componentDB
    And User links 'applicator' from componentDB
    And User links 'equivalents' from componentDB
    And User links 'tags' from componentDB