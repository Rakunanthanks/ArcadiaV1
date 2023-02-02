@Regression
Feature: Link Splice

  @SpliceComponentDB
  @LinkSpliceComponent
  Scenario: Test verifies components can be linked with splice successfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then 'splice' component with status 'IN REVIEW' is created successfully
    When User selected 'splice' from componentDB
    And User searches 'splice' component using 'partnumber'
    And User selects the first component
    And User edits the first component
    And User links 'splice' from componentDB
    And User links 'part' from componentDB
#    And User links 'applicator' from componentDB
    And User links 'equivalents' from componentDB
    And User links 'nwf' from componentDB
    And User links 'tags' from componentDB