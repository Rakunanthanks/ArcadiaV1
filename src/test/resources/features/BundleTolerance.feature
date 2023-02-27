@Regression
Feature: Bundle Tolerance

  @BundleTolerance
  Scenario Outline: To create a Harness to check the Bundle Tolerance
    Given I'm on Arcadia test environment
    And  test data config loaded for test identifier <string>
    And  Navigated to quickstart project
    And  harness with name <connectorDescription> is launched successfully
    And  Turning Visibility on for Bundle Tolerance
    And  Navigating to Company profile page
    And  Navigating to created Project
    And  Checking the Bundle Tolerance Value
    Then Check the Bundle Tolerance Value as per the Company Profile
    And  Bundles are drawn
    And  Inspecting Bundle
    Then Check outside focus changes lower tolerance and Upper tolerance
    Then Bundles are Deleted
    And  Bundles are drawn
    And  Inspecting Bundle Tolerance Value
    Then Check Bundle Tolerance Value By Inspecting Bundle
    Then Bundles are Deleted
    And  Bundles are drawn
    And  Getting the Values of Component Label
    Then Check the component label value
    Then Bundles are Deleted
    Examples:
      | string | connectorDescription |
      | test4  | 'BundleTolerance'    |
