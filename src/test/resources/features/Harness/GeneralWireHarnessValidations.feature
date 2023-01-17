Feature: General WireHarness Validations
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