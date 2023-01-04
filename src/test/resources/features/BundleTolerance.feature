Feature: Bundle Tolerance
  @BundleTolerance
  Scenario: Test verifies bundle tolerance Company profiles matches the selected project Bundle Tolerance Value
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test4
    And Navigating to Company profile page
    And Navigated to Test Project
    And Checking the Bundle Tolerance Value
    Then Check the Bundle Tolerance Value as per the Company Profile

  @BundleTolerance
  Scenario: Test Verifies the bundle tolerance by drawing Bundle,inspecting the bundle and changing the length of the bundle .
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test4
    And Navigated to Test Project
    And Bundles are drawn
    And Inspecting Bundle
    Then Check outside focus changes lower tolerance and Upper tolerance

  @BundleTolerance
  Scenario: Test Verifies the bundle tolerance by drawing Bundle and inspecting the bundle .
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test4
    And Navigated to Test Project
    And Bundles are drawn
    And Inspecting Bundle Tolerance Value
    Then Check Bundle Tolerance Value By Inspecting Bundle


