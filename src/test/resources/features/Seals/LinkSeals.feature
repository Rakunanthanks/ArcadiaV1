@Regression
Feature: Link Seals

  @SealsComponentDB
  @LinkSealsComponent
  Scenario: Test verifies components can be linked with Seals successfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with status 'IN REVIEW' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    And User selects the first component
    And User edits the first component
    And User links 'cavity' from componentDB
    And User links 'part' from componentDB
    And User links 'applicator' from componentDB
    And User links 'equivalents' from componentDB
    And User links 'tags' from componentDB