Feature: General Harness Validations
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10

  @VerifyWireMacrosTag
  Scenario: Test verifies macros tag while adding wire on connector in harness
    And Navigated to GeneralMacros page
    And 'wire' macros tags are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And connector plug '0' is opened
    And wire is added to cavity
    Then User verifies the tags for 'wire'

  @VerifyConnector
  Scenario: Test verifies allterminalpn shown in cavity table searchdetails on connector matches componentdb
    And Navigated to selected componentDB
    And User selected 'terminal' from componentDB
    And 'Terminal' details are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user sets label 'connector cavity table' to "Show"
    And connector plug '0' is opened
    And GetCavityDetails window is opened
    Then Verify 'All' terminals are shown in cavity table searchdetails