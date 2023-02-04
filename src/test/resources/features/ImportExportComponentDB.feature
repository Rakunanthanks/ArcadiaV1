@Regression
Feature: Import Export Data for all components

  @ImportExportDB
  Scenario: Test verifies components data can be import and export succesfully
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User delete all old files from the default download folder
    And User selected 'connector' from componentDB
    And User export the data for 'connector'
    And User selected 'terminal' from componentDB
    And User export the data for 'terminal'
    And User selected 'seal' from componentDB
    And User export the data for 'seal'
    And User selected 'splice' from componentDB
    And User export the data for 'splice'
    And User selected 'otherpart' from componentDB
    And User export the data for 'otherpart'
    And User selected 'junctionpart' from componentDB
    And User export the data for 'junctionpart'
    And User selected 'multicore' from componentDB
    And User export the data for 'multicore'
    And User selected 'wire' from componentDB
    And User export the data for 'wire'
    And User selected 'applicator' from componentDB
    And User export the data for 'applicator'
    And User selected 'component' from componentDB
    And User export the data for 'component'
    And User navigated to componentDB
    And User create new DB with name 'TestAutomationDB'
    And User selected 'connector' from componentDB
    And User import data for 'connector'
    And User selected 'connector' from componentDB
    And User selected 'terminal' from componentDB
    And User import data for 'terminal'
    And User selected 'terminal' from componentDB
    And User selected 'seal' from componentDB
    And User import data for 'seal'
    And User selected 'seal' from componentDB
    And User selected 'splice' from componentDB
    And User import data for 'splice'
    And User selected 'splice' from componentDB
    And User selected 'otherpart' from componentDB
    And User import data for 'otherpart'
    And User selected 'otherpart' from componentDB
    And User selected 'junctionpart' from componentDB
    And User import data for 'junctionpart'
    And User selected 'junctionpart' from componentDB
    And User selected 'multicore' from componentDB
    And User import data for 'multicore'
    And User selected 'multicore' from componentDB
    And User selected 'wire' from componentDB
    And User import data for 'wire'
    And User selected 'wire' from componentDB
    And User selected 'applicator' from componentDB
    And User import data for 'applicator'
    And User selected 'applicator' from componentDB
    And User selected 'component' from componentDB
    And User import data for 'component'
    And User selected 'component' from componentDB
    And User navigated to componentDB
    And User delete the new DB created
