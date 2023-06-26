@E2E
Feature: Verify schematics
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And User navigated to projects
    And Created Project 'Aut_Integration'
    And test data config loaded for test identifier test14

  @VerifySchematic @fix
  Scenario: Test verifies wire label can be removed for schematic
    And Navigated to 'Aut_Integration' project
    And schematic with name 'Aut_Integration' is launched successfully
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
  Scenario: Test verifies wire label properties can be updated from profile and inherited on schematic drawing
    And Navigated to 'Aut_Integration' project
    And schematic with name 'Aut_Integration' is launched successfully
    And Navigated to Schematic wire properties page
    And User updates the schematic wire properties
    And Navigated to 'Aut_Integration' project
    And user navigated to newly created schematic
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And draw wires between connectors
    And makes the wire labels inline
    And change the wire settings from wire editor
    And go to drawing from wire editor
    Then verify the wire label on drawing matches wire properties

  @VerifySchematic
  Scenario: Test verifies wire label can be hidden and shown  for some specific wires
    And Navigated to 'Aut_Integration' project
    And schematic with name 'Aut_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And draw wires between connectors
    And validate the wire labels before removing
    And validate the wire labels after removing
    And add the wire label for few of the wire and verify

  @VerifySchematic
  Scenario: Test verifies font settings and colour can be updated for schematic
    And Navigated to Schematic wire properties page
    And User updates the schematic wire properties
    And Navigated to 'Aut_Integration' project
    And schematic with name 'Aut_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And draw wires between connectors
    And makes the wire labels inline
    And updated the font settings for the schematic
    And switch on the colour of the wires
    And Verify the colour of the wires

  @VerifySchematic
  Scenario: Test verifies harness can be created from schematic
    And Navigated to Schematic wire properties page
    And User updates the schematic wire properties
    And Navigated to 'Aut_Integration' project
    And schematic with name 'Aut_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And draw wires between connectors
    And makes the wire labels inline
    And change the wire settings from wire editor
    And go to drawing from wire editor
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And pin display type and partnumber is updated
    Then verify partnumbers are added for connectors
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And user create the harness from schematic
    And user verify the harness created from schematic

  @VerifySchematic
  Scenario: Test verifies wire bend can be removed successfully
    And Navigated to Schematic wire properties page
    And User updates the schematic wire properties
    And Navigated to 'Aut_Integration' project
    And schematic with name 'Aut_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And wires with bend are added between connectors
    Then verify wire bend can be removed successfully

  @VerifySchematic
  Scenario: Test verifies functionality on schematic tree view
    And Navigated to Schematic wire properties page
    And User updates the schematic wire properties
    And Navigated to 'Aut_Integration' project
    And schematic with name 'Aut_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic
    And wires with bend are added between connectors
    Then User verifies schematic tree can be expanded
    And User verifies schematic tree can be collapsed
    And user verifies search view functionality on schematic tree view
