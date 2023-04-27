@Regression
Feature: Update Cavities
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test101
  @UpdateCavities
  Scenario: To check componentDB listed in the componentDB or not
    And Navigate to component DB Page
    And Getting componentDB from list
    And Navigated to quickstart project
    And harness with name 'UpdateCavities' is launched successfully
    And based on drawing orchestrator components are created
    And Get componentDB name from UpdateCavities form
    Then Check componentDB name matches to the UpdateCavities form componentDB name or not
  @UpdateCavities
  Scenario: To Check Update cavities form Company values as per ComponentDB
    And Navigated to selected componentDB
    And Getting componentDB company name options
    And Navigated to quickstart project
    And harness with name 'UpdateCavities' is launched successfully
    And Selecting update cavities option
    And User selected componentDB from Update cavities form
    And Getting cavities form company name values
    Then Checking the Company name as per the componentDB
  @UpdateCavities
    Scenario: To Check Update cavities form values are as per the componentDB
      And Getting terminal values from componentDB
      And Navigated to quickstart project
      And harness with name 'UpdateCavities' is launched successfully
      And Selecting update cavities option
      And User selected componentDB from Update cavities form
      And Getting update cavities form Family,Type,Finish,Material values
      Then Checking The values are matching as per componentDB
  @UpdateCavities
  Scenario: To Check wire od and csa matches to the componentDB
    And Navigated to quickstart project
    And harness with name 'UpdateCavities' is launched successfully
    And based on drawing orchestrator components are created
    And user selects the options in the update cavity form 1
    And select the wires to be updated
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then Check the selected properties
  @UpdateCavities
  Scenario: To Check wire od and csa matches to the componentDB
    And Navigated to quickstart project
    And harness with name 'UpdateCavities' is launched successfully
    And based on drawing orchestrator components are created
    And user selects the options in the update cavity form 2
    And select the wires to be updated
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then Check the selected properties
  @UpdateCavities
  Scenario: To Check wire od and csa matches to the componentDB
    And Navigated to quickstart project
    And harness with name 'UpdateCavities' is launched successfully
    And based on drawing orchestrator components are created
    And user selects the options in the update cavity form 3
    And select the wires to be updated
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then Check the selected properties
  @UpdateCavities
  Scenario: To Check wire od and csa matches to the componentDB
    And Navigated to quickstart project
    And harness with name 'UpdateCavities' is launched successfully
    And based on drawing orchestrator components are created
    And user selects the options in the update cavity form 4
    And select the wires to be updated
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then Check the selected properties
  @UpdateCavities
  Scenario: To Check wire od and csa matches to the componentDB
    And Navigated to quickstart project
    And harness with name 'UpdateCavities' is launched successfully
    And based on drawing orchestrator components are created
    And user selects the options in the update cavity form 5
    And select the wires to be updated
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then Check the selected properties
  @UpdateCavities
  Scenario: To check manual update type by uploading CSV
    And Navigated to quickstart project
    And harness with name 'UpdateCavities' is launched successfully
    And based on drawing orchestrator components are created
    And user selects the options in the update cavity form 6
    And User delete all old files from the default download folder
    And user selects the options in the update cavity form 7
    Then Check the validation without submitting csv
    And user selects the options in the update cavity form 8
    And Get the validation and errors
    And Check the value updated or not in connector properties