@Regression
@WireEditor
Feature: Wire Editor
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to Harness Advanced setting page
    And Turning 'on' Connector ID Group
    And Navigated to quickstart project
    And harness with name 'Wire Editor' is launched successfully
    And based on drawing orchestrator components are created
    And wire editor is opened

  Scenario:To Validate Wire Editor Header Names
    Then Check default headers name in wire editor
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario: Test verifies a wire editor Wire Material type ,Gauge values are suggesting as per componentDB
    Then Check the values are suggesting as per the connector
    And go to drawing from wire editor in harness
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario: Test verifies a wire editor from/to connector and from/to cavity values are suggesting as per connector
    Then Check the values are suggesting as per from-to connector and from-to cavity
    And go to drawing from wire editor in harness
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario: Test verifies a wire editor by entering all values and saving the form.
    And Enter all the values in the wire editor.
    Then Check all the wire editor column values are correctly populating or not after saving details
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully
#
  Scenario: Test verifies a wire editor partnumbers are suggesting as per componentDB
    And select material,gauge and get values of partnumber
    And Get part number value from componentdb
    Then Check the part number in wire editor matches ComponentDb or not
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario: Test verifies a wire editor primary colour are suggesting as per componentDB
    And select material,gauge and get values of colour code
    And Get Material,Gauge,color value from componentdb
    Then Check the colour code in wire editor matches ComponentDb or not
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario: Test verifies Redo,Undo,  Remove Row operations in the wire editor form.
    And Enter Possible Values in the form.
    Then Check Redo,Undo,Remove Row.
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario:To Validate Export to CSV
    And User delete all old files from the default download folder
    And Enter possible values in the wire editor
    And click export to csv in wire editor
    Then Check able to export csv in wire editor
    And click download template in wire editor
    And User delete all old files from the default download folder
    Then Check able to download template or not in wire editor
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario: Test verifies a wire editor by entering WireID, From Con,From Cav,TO Conn,To Cav by giving update wire part number should bring all remaining form data.
    And Enter WireID, From Con,From Cav,TO Conn,To Cav.
    Then Check Whether the value are saved Correctly or not by updating part number.
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario: Test verifies a wire editor by importing CSV
     And Importing CSV by adding some values to the CSV in wire editor
     Then Check whether able to save or not without any errors in wire editor
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario: Test verifies in the wire editor by giving values to Multi Core.
    And Fill the Wire Editor form,Save and select wire class as multicore.
    Then Check the form by not filling the CORE ID and MC ID.
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully

  Scenario: Test verifies in the wire editor by hiding some headers
   And Enter all possible values in the wire editor
    And Hide some headers in the wire editor
    And Check whether able to save without any error or not
    Then check after saving values are correctly populated or not.
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Wire Editor' successfully