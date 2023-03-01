@Bundle
Feature: Bundle harness Context Menu

  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test12
    And Navigated to selected componentDB

  @CreateSpliceHarness
  Scenario: Test verifies Bundle Harness can be created
    And Navigated to quickstart project
    And harness with name 'BundleValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user delete the created bundle from context menu