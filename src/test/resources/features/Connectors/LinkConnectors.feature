@Regression
Feature: Link components

  @ConnectorsComponentDB
  @LinkConnectorsComponent
  Scenario: Test verifies components can be linked with connector successfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then 'connector' component with status 'IN REVIEW' is created successfully
    When User selected 'connector' from componentDB
    And User searches 'connector' component using 'partnumber'
    And User selects the first component
    And User edits the first component
    And User links 'terminal' from componentDB
    And User links 'seal' from componentDB
    And User links 'part' from componentDB
    And User links 'Mating_Halves' from componentDB
    And User links 'equivalents' from componentDB
    And User links 'nwf' from componentDB