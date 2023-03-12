@Bundle
Feature: Bundle harness Context Menu

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies Bundle Harness radius can be bend from drawing page
    Given I'm on Arcadia test environment
    And Navigated to Harness Bundle Default Display Settings page
    And harness bundle default display settings are updated
    And test data config loaded for test identifier test13
    And Navigated to quickstart project
    And harness with name 'BundleValidator' is launched successfully
    And based on drawing orchestrator components are created
    And User set the bundle radius from drawing page
    Then User verifies the bundle details window is opened successfully

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies Bundle Harness radius can be bend from inspect bundle page
    Given I'm on Arcadia test environment
    And Navigated to Harness Bundle Default Display Settings page
    And harness bundle default display settings are updated
    And test data config loaded for test identifier test13
    And Navigated to quickstart project
    And harness with name 'BundleValidator' is launched successfully
    And based on drawing orchestrator components are created
    And User try operation 'inspect' for bundle
    And User set the bundle radius from inspect bundle page
    Then User verifies the bundle details window is opened successfully

  @VerifyBundleHarness @VerifyBundleContextMenu
  Scenario: Test verifies Bundle Harness radius can be bend from default setting page of bundle harness
    Given I'm on Arcadia test environment
    And Navigated to Harness Bundle Default Display Settings page
    And harness bundle default bend radius settings are updated
    And test data config loaded for test identifier test13
    And Navigated to quickstart project
    And harness with name 'BundleValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user validate the default bend radius of the bundle
    Then User verifies the bundle details window is opened successfully

  @VerifyBundleHarness
  Scenario: Test verifies bundle fonts updates in profile are reflected on bundle harness
    Given I'm on Arcadia test environment
    And Navigated to Harness Bundle Default Font Settings page
    And harness bundle font settings are updated
    And test data config loaded for test identifier test12
    And Navigated to quickstart project
    And harness with name 'BundleValidator' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify font size displayed in bundle harness matches profile

