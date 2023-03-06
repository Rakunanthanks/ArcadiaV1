@Bundle
Feature: Bundle harness Context Menu

  Background: User is Logged In
    Given I'm on Arcadia test environment
    And Navigated to Harness Bundle Default Display Settings page
    And harness bundle default display settings are updated
    And test data config loaded for test identifier test12
    And Navigated to quickstart project
    And harness with name 'BundleValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user sets label 'bundle' to "Show"
    And 'bundle' list is initialized

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies AddCovering contextmenu functionality on Bundle Harness
    When User try operation 'Add covering' for bundle
    Then user verifies addCovering functionality from context menu

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

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies SetAddOn contextmenu functionality on Bundle Harness
    When User try operation 'Set Addon' for bundle
    Then user verifies Addon can be configured to bundle successfully

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies BendBundle contextmenu functionality on Bundle Harness
    When User try operation 'Bend Bundle' for bundle
    Then user verifies bundle is bended successfully

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies RotateBundle contextmenu functionality on Bundle Harness
    When User try operation 'Rotate Bundle' for bundle
    Then user verifies bundle is rotated successfully

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies Content contextmenu functionality on Bundle Harness
    Then user verifies bundle content functionality works as expected