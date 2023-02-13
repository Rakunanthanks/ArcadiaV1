
Feature: Wire Editor
    Background: User is Logged In
        Given I'm on Arcadia test environment
        And test data config loaded for test identifier test10
        And Navigated to quickstart project
        And harness with name 'WireEditor' is launched successfully
        And based on drawing orchestrator components are created
        And Navigated to Wire Editor

    @WireEditor
    Scenario: Test verifies a wire editor is auto selected the component DB
        Then Check whether in the wire editor it brings the selected componentDB or not

    @WireEditor
    Scenario: Test verifies a wire editor from/to connector and from/to cavity values are suggesting as per connector
        Then Check the values are suggesting as per from-to connector and from-to cavity

    @WireEditor
    Scenario: Test verifies a wire editor Wire Material type ,Gauge values are suggesting as per componentDB
        And Get Material,Gauge value from WireEditorPage
        Then Check the values are suggesting as per the connector

    @WireEditor
        Scenario: Test verifies a wire editor primary colour are suggesting as per componentDB
        And select material,gauge and get values of colour code
        And Get Material,Gauge,color value from componentdb
        Then Check the colour code in wire editor matches ComponentDb or not

    @WireEditor
    Scenario: Test verifies a wire editor partnumbers are suggesting as per componentDB
        And select material,gauge and get values of partnumber
        And Get part number value from componentdb
        Then Check the part number in wire editor matches ComponentDb or not

    @WireEditor
    Scenario: Test verifies a wire editor by saving values are populating  in the harness or not
        And select material,gauge,color
        And get wire part number from wire editor
        Then Check the part number matches the ComponentDb or not

    @WireEditor
    Scenario: Test verifies a wire editor by entering all values and saving the form.
        And Enter all the values in the wire editor.
        Then Check all the wire editor column values are correctly populating or not after saving details

    @WireEditor
    Scenario: Test verifies a wire editor by entering WireID, From Con,From Cav,TO Conn,To Cav by giving update wire part number should bring all remaining form data.
        And Enter WireID, From Con,From Cav,TO Conn,To Cav.
        Then Check Whether the value are saved Correctly or not by updating part number.

    @WireEditor
    Scenario: Test verifies Redo,Undo,  Remove Row operations in the wire editor form.
        And Enter Possible Values in the form.
        Then Check Redo,Undo,Remove Row.

    @WireEditor
    Scenario: Test verifies in the wire editor form by unselecting some headers and saving the form.
        And unselect the headers in the wire editor and save.
        Then Check Whether Unselected headers are hided.

    @WireEditor
    Scenario: Test verifies in the wire editor by exporting CSV.
        And Fill the Wire Editor form,Save and Export csv.
        Then Check whether exported CSV matches the Expected CSV or not.

    @WireEditor
    Scenario: Test verifies in the wire editor by giving values to Multi Core.
        And Fill the Wire Editor form,Save and select wire class as multicore.
        Then Check the form by not filling the CORE ID and MC ID.

    @WireEditor
    Scenario: Test verifies in the wire editor for the wire multicore.
      And Fill the Wire Editor form,Save and select wire class as multicore.
        Then Check the form by fill all the possible values in the form.

    @WireEditor
    Scenario: Test verifies in the wire editor form to export csv and import the exported csv.
        And Fill the Wire Editor form,Save and Export csv and check for any errors.
        And Import the exported csv.
        Then Check whether the imported csv has been saved successful or not without errors.
        And Clear all the values in Wire Editor form.
        Then Check whether the imported csv has been saved successful or not without errors by clearing all the values in the from.