@Bundle
Feature: Bundle harness Context Menu

  Background: User is Logged In
    Given I'm on Arcadia test environment
    And Navigated to Harness Bundle Default Display Settings page
    And harness bundle default display settings are updated
    And test data config loaded for test identifier test13
    And Navigated to quickstart project
    And harness with name 'BundleValidator' is launched successfully
    And based on drawing orchestrator components are created

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies Bundle Harness radius can be bend from drawing page
    And User set the bundle radius from drawing page
    Then User verifies the bundle details window is opened successfully

#  @VerifyBundleHarness @VerifyBundleContextMenu
#  Scenario: Test verifies Bundle Harness can be inspected
#    And User try operation 'inspect' for bundle
#    Then User verifies the bundle details window is opened successfully
