Feature: Bundle Tolerance

  @BundleTolerance
    Scenario: To create a Harness to check the Bundle Tolerance
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test4
    And Navigated to quickstart project
    And harness with name 'BundleTolerance' is launched successfully
    And Turning Visibility on for Bundle Tolerance

  @BundleTolerance
  Scenario: Test verifies bundle tolerance Company profiles matches the selected project Bundle Tolerance Value
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test4
    And Navigating to Company profile page
    And Navigated to quickstart project
    And harness with name 'BundleTolerance' is launched successfully
    And Checking the Bundle Tolerance Value
    Then Check the Bundle Tolerance Value as per the Company Profile

  @BundleTolerance
  Scenario: Test Verifies the bundle tolerance by drawing Bundle,inspecting the bundle and changing the length of the bundle .
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test4
    And Navigated to quickstart project
    And harness with name 'BundleTolerance' is launched successfully
    And Bundles are drawn
    And Inspecting Bundle
    Then Check outside focus changes lower tolerance and Upper tolerance
    Then Bundles are Deleted

  @BundleTolerance
  Scenario: Test Verifies the bundle tolerance by drawing Bundle and inspecting the bundle .
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test4
    And Navigated to quickstart project
    And harness with name 'BundleTolerance' is launched successfully
    And Bundles are drawn
    And Inspecting Bundle Tolerance Value
    Then Check Bundle Tolerance Value By Inspecting Bundle
    Then Bundles are Deleted

  @BundleTolerance
  Scenario: Test Verifies the Component Label Value.
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test4
    And Navigated to quickstart project
    And harness with name 'BundleTolerance' is launched successfully
    And Bundles are drawn
    And Getting the Values of Component Label
    Then Check the component label value
    Then Bundles are Deleted