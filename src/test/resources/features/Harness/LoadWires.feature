@Regression @LoadWires
Feature: Load Wires
  Background:user logged in
    Given I'm on Arcadia test environment

    Scenario:Test verifies to import schematic and get number of projects
      And Navigated to project home page
      And capture the number of projects in project folder in particular instance
      And Navigated to quickstart project
      And import base schematic task
      And user tries to read number of schematic available
      And User imports harness 'Load Wires'
      And user navigated to newly created harness
      And Load wires is opened
      Then check basic properties in load wires
      And User exits the drawing page
      And User deletes Harness 'SchematicHarness' successfully

  Scenario: Test Verifies to check remove existing wires off in load wires
    And Navigated to quickstart project
    And User import schematic 'loadwires 1' task
    And User imports harness 'Load Wires'
    And user navigated to newly created harness
    And Load wires is opened
    And user tries to load wire by removing wires by 'no'
    Then Check remove wires 'no' is working as expected
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'SchematicHarness' successfully

  Scenario: Test Verifies to check remove existing wires on in load wires
    And Navigated to quickstart project
    And User import schematic 'loadwires 1' task
    And User imports harness 'Load Wires'
    And user navigated to newly created harness
    And Load wires is opened
    And user tries to load wire by removing wires by 'yes'
    Then Check remove wires 'yes' is working as expected
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'SchematicHarness' successfully

  Scenario: Test Verifies to check tags on in load wires
    And Navigated to quickstart project
    And User import schematic 'loadwires 1' task
    And User imports harness 'Load Wires'
    And user navigated to newly created harness
    And Load wires is opened
    And user tries to load wires by inputting tag value as 'Test1'
    Then check according to the tag values wires are updated or not
    And Click remove wires
    Then check remove wires is working as expected or not
    And Load wires is opened
    And user tries to load wires by inputting tag value as 'Test2'
    Then check according to the tag values wires are updated or not
    And Click remove wires
    Then check remove wires is working as expected or not
    And Load wires is opened
    And user tries to load wires by inputting tag value as 'Test3'
    Then check according to the tag values wires are updated or not
    And Click remove wires
    Then check remove wires is working as expected or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'SchematicHarness' successfully
    And User deletes Schematic 'load wires' successfully

    Scenario: Test Verifies to check virtual wires are working as expected or not
      And Navigated to quickstart project
      And User import schematic 'loadwires 1' task
      And User imports harness 'Load Wires'
      And user navigated to newly created harness
      And Load wires is opened
      And user tries to load virtual wires 'on' and tags
      Then check according to the tag values wires are updated or not
      And Click remove wires
      Then check remove wires is working as expected or not
      And Load wires is opened
      And user tries to load virtual wires 'off' and tags
      Then check according to the tag values wires are updated or not in off state
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'SchematicHarness' successfully
      And User deletes Schematic 'load wires' successfully

  Scenario: Test verifies the schematic task and Revision number matches in load wires or not
    And Navigated to quickstart project
    And user tries to read number of schematic available
    And user tries to read the name of title and part Number in the schematic task
    And User import schematic 'loadwires 1' task
    And User imports harness 'Load Wires'
    And user navigated to newly created harness
    And Load wires is opened
    Then check schematic and revision in load wires
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'SchematicHarness' successfully
    And User deletes Schematic 'load wires' successfully

  Scenario: Test verifies the update table in load wires
    And Navigated to quickstart project
    And User import schematic 'loadwires 1' task
    And User imports harness 'Load Wires'
    And user navigated to newly created harness
    And Load wires is opened
    And user tries to select update table 'on' and input possible values
    Then check update table in 'on' is working as expected or not
    And Click remove wires
    Then check remove wires is working as expected or not
    And Load wires is opened
    And user tries to select update table 'off' and input possible values
    Then check update table in 'off' is working as expected or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'SchematicHarness' successfully
    And User deletes Schematic 'load wires' successfully

  Scenario: Test verifies the variants in load wires
    And Navigated to quickstart project
    And User import schematic 'loadwires 2' task
    And User imports harness 'Load Wires'
    And user navigated to newly created harness
    And Load wires is opened
    And user tries to load wires variants by value 'EXCLUSIVE'
    Then check load wires variants by value 'EXCLUSIVE' is update as expected or not
    And Click remove wires
    Then check remove wires is working as expected or not
    And Load wires is opened
    And user tries to load wires variants by value 'SX'
    Then check load wires variants by value 'SX' is update as expected or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'SchematicHarness' successfully
    And User deletes Schematic 'load wires' successfully

    Scenario: Test verifies load component data in load wires
      And Navigated to quickstart project
      And User import schematic 'loadwires 2' task
      And User imports harness 'Load Wires'
      And user navigated to newly created harness
      And Load wires is opened
      And user tries to load wires by turning on component data 'on'
      Then check load wires component data 'on' is working as expected or not
      And Click remove wires
      Then check remove wires is working as expected or not
      And Load wires is opened
      And user tries to load wires by turning on component data 'off'
      Then check load wires component data 'off' is working as expected or not
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'SchematicHarness' successfully
      And User deletes Schematic 'load wires' successfully

  Scenario: Test verifies load wires by mismatch splice details
    And Navigated to quickstart project
    And User import schematic 'mismatch' task
    And User imports harness 'Load Wires'
    And user navigated to newly created harness
    And Load wires is opened
    And user tries to submit load wires
    Then check mismatch inform is highlighted in update summary report or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'SchematicHarness' successfully
    And User deletes Schematic 'load wires' successfully

