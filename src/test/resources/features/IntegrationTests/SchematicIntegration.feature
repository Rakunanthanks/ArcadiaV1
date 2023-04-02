Feature: Verify schematics
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And User navigated to projects
    And Created Project 'Demo_Integration'
    And Navigated to quickstart project
    And Navigated to 'Demo_Integration' project


  @VerifySchematic
  Scenario: Test verifies a schematic
    And schematic with name 'Demo_Integration' is launched successfully