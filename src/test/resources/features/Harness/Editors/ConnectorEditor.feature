@Regression
@ConnectorEditor
Feature: Connector Editor
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to Harness Advanced setting page
    And Turning 'on' Connector ID Group
    And Navigated to quickstart project
    And harness with name 'Connector Editor' is launched successfully
    And based on drawing orchestrator components are created
    And connector editor is opened

  Scenario:To Validate Connector Editor Header Names
    And Get default headers name in connector editor
    Then Check default headers name in connector editor
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate Connector ID Auto populated or not
   And get connectorID from Editor page from con ID drop down
   Then check connector ID populated or not correctly
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate Part type is listed or not in dropdown
    And get parttype from Editor from part type dropdown
    Then check parttype is populating correctly or not
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate Import CSV option
   And Importing CSV by adding some values to the CSV in connector editor
   Then Check whether able to save or not without any errors in connector editor
    Then Check check all values are updated in editors as expected or not in connector editor
   And go to drawing
   And User exits the drawing page
   And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate Clear all option
    And Perform Clear all operation in connector editor
    Then check in editor whether all values are disappeared or not in connector editor
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate Download Template is working or not
    And User delete all old files from the default download folder
    And click Download Template button in connector editor
    Then check able to download template or not in connector editor
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate Remove row,Undo,Redo
    And Perform remove row Operation in connector editor
    Then Check editor detail that remove row has been performed or not in connector editor
    And Perform undo operation in connector editor
    Then Check editor detail that undo has been performed or not in connector editor
    And Perform redo operation in connector editor
    Then Check editor detail that redo operation has been performed or not in connector editor
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate Export to CSV
    And User delete all old files from the default download folder
    And Enter possible values in the connector editor
    And click export to csv in connector editor
    Then Check able to export csv and the entered values are present in the exported csv or not in connector editor
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate by entering Connector Part Number check auto populating Part Description and cavities or not
    And Enter values in the connector editor
    Then Check part description and cavities
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario: To Validate by selecting componentDB and part type check connector part number listed or not
    And Selecting ConnectorID,ComponentDB,partype as 'connector'
    Then Check all Connector partnumber listed or not
    And Selecting ConnectorID,ComponentDB,partype as 'terminal'
    Then Check all terminal partnumber listed or not
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate by entering all the possible fields check able save editor not
    And Enter possible values in the connector editor
    Then Check all entered possible values are saved or not
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate by duplicating some mandatory fields ,save editor and check validation message
    And Enter duplicate connector ID
    Then check validation message by saving form in connector editor
    And go to drawing
    Then User exits the drawing page
    Then User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate by sorting columns
    And Get values of Connector ID from editor before sorting
    And Sort Connector ID column in descending order
    Then Check the Value of connector ID after sorted
    And Get values of Connector Part number from editor before sorting
    And Sort Part Number column in descending order in connector editor
    Then Check the value of connector part number after sorted
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate the connector groupID in connector editor
    And Enter duplicate connector ID,component DB,cavities in editor
    And Enter group ID editor
    Then Check able to save editor or not
    And go to drawing
    Then Whether new connectors are added or not
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate by entering connector id and cavity number check whether connector part number populates correctly or not
    And Enter Connector ID,Component DB,Cavities in Editor
    And Get Connector partnumber response from editor
    Then Check whether partnumber is suggesting as per cavities
    And go to drawing
    And User exits the drawing page
    And User deletes Harness 'Connector Editor' successfully

  Scenario:To Validate Connector Editor Options in Profile by hiding some headers
    And  Navigated to Harness Connector editor setting page
    And  Hiding some headers in profile in connector editor
    And  Navigating to created Project
    And  connector editor is opened
    And  Check editor headers after hiding from profile in connector editor
    And Navigated to Harness Connector editor setting page
    And Turning on all connector editor headers visibility