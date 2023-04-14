@E2E
Feature: Verify schematics
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And User navigated to projects
    And Created Project 'Demo_Integration'
    And Navigated to quickstart project
    And Navigated to 'Demo_Integration' project
    And test data config loaded for test identifier test14

  @VerifySchematic
  Scenario: Test inline connectors, splices and wire can be added to schematic
    And schematic with name 'Demo_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And draw wires between connectors

  @VerifySchematic
  Scenario: Test verifies wire settings can be edited from wire editor for schematic
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

  @VerifySchematic
  Scenario: Test verifies wire label can be removed for schematic
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
    Then verify wire label can be removed successfully

  @VerifySchematic
  Scenario: Test verifies can be hidden and shown
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