@Bundle
Feature: Bundle harness Context Menu

  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test12
    And Navigated to quickstart project
    And harness with name 'BundleValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'bundle' list is initialized

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies Bundle Harness can be inspected
    And User try operation 'inspect' for bundle
    Then User verifies the bundle details window is opened successfully

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies Bundle Harness can be deleted
    And User try operation 'delete' for bundle
    Then User verifies the bundle '0' is deleted successfully

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies SetLength input functionality on Bundle Harness
    Then user verifies setLength functionality from context menu