@E2E
Feature: Verify schematics
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And User navigated to projects
    And Created Project 'Demo_Integration'
    And Navigated to quickstart project
    And Navigated to 'Demo_Integration' project
    And test data config loaded for test identifier test14

  @VerifySchematic @E2E
  Scenario: Test verifies a schematic can be created
    And schematic with name 'Demo_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And draw wires between connectors
    And change the wire settings from wire editor
    And go to drawing from wire editor

  Scenario: Test inline connectors, splices and wire can be added to schematic
    And schematic with name 'Demo_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And draw wires between connectors

  @VerifySchematic @E2E
  Scenario: Test verifies use is able to hide and show the wire label
    And schematic with name 'Demo_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And draw wires between connectors
    And validate the wire labels before removing
    And validate the wire labels after removing

  Scenario: Test verifies wire settings can be modified for schematic
    And schematic with name 'Demo_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And draw wires between connectors
    And change the wire settings from wire editor
    And go to drawing from wire editor
