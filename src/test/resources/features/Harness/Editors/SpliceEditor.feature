@SpliceEditor
Feature: Splice Editor
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test11
    And Navigated to quickstart project
    And harness with name 'Splice Editor' is launched successfully
    And based on drawing orchestrator components are created
    And splice editor is opened

  Scenario:To Validate Splice Editor Header Names(VERIFIED)
    And Get default headers name
    Then Check default headers name
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate Splice ID Auto populated or not(VERIFIED)
    And get spliceID from Editor page from splice ID drop down
    Then check splice ID populated or not correctly
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate Clear all option(VERIFIED)
    And Perform Clear all operation
    Then check in editor whether all values are disappeared or not
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate Download Template is working or not(VERIFIED)
    And User delete all old files from the default download folder
    And click Download Template button in editor
    Then check able to download template or not
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate Remove row,Undo,Redo(VERIFIED THERE IS ISSUE IN UNDO)
    And Perform remove row Operation
    Then Check editor detail that remove row has been performed or not
    And Perform undo operation
    Then Check editor detail that undo has been performed or not
    And Perform redo operation
    Then Check editor detail that redo operation has been performed or not
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate Export to CSV(VERIFIED)
    And User delete all old files from the default download folder
    And Enter possible values in the splice editor
    And click export to csv
    Then Check able to export csv and the entered values are present in the exported csv or not
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate by entering Splice Part Number check auto populating Part Description(ISSUES ONLY IN AUTOMATION)
    And Enter values in the splice editor
    Then Check part description
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate by duplicating some mandatory fields ,save editor and check validation message(VERIFIED)
    And Enter duplicate splice ID
    Then check validation message by saving form
    And go to drawing
    Then User exits the drawing page
    Then User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate by sorting columns(VERIFIED)
    And Get values of Splice ID from editor before sorting
    And Sort Splice ID column in descending order
    Then Check the Value of Splice ID after sorted
    And Get values of Splice Part number from editor before sorting
    And Sort Part Number column in descending order
    Then Check the value of Splice part number after sorted
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario: To Validate by selecting componentDB and part type check connector part number listed or not(VERIFIED)
    And Selecting spliceID,ComponentDB
    Then Check all Splice partnumber listed or not
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate Import CSV option(VERIFIED)
    And Importing CSV by adding some values to the CSV
    Then Check whether able to save or not without any errors
    Then Check check all values are updated in editors as expected or not
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Splice Editor' successfully

  Scenario:To Validate Splice Editor Options in Profile by hiding some headers(VERIFIED)
    And  Navigated to Harness Splice editor setting page
    And  Hiding some headers in profile
    And  Navigating to created Project
    And  splice editor is opened
    And  Check editor headers after hiding from profile
    And Navigated to Harness Splice editor setting page
    And Turning on all Splice editor headers visibility