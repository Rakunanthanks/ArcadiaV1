Feature: Verify schematics
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And User navigated to projects
    And Created Project 'Demo_Integration'
    And Navigated to quickstart project
    And Navigated to 'Demo_Integration' project
    And test data config loaded for test identifier test14



  @VerifySchematic @E2E
  Scenario: Test verifies a schematic
    And schematic with name 'Demo_Integration' is launched successfully
    And based on drawing orchestrator components are created
    And add inline connectors to schematic
    And add more pins to connector
    And click on Pins dropdown from the footer
    And click on Housings from the footer
    And add splices to schematic

