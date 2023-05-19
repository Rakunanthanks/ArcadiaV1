@Regression
Feature: Bundle Tolerance

  @BundleTolerance
  Scenario Outline: To create a Harness to check the Bundle Tolerance in Metric Units
    Given I'm on Arcadia test environment
    And  test data config loaded for test identifier <string>
    And  Navigated to General task units
    And  Changing General units to <units>
    And  Navigated to quickstart project
    And  harness with name <taskDescription> is launched successfully
    And  Turning Visibility on for Bundle Tolerance
    And  Navigating to Company profile page
    And  Navigating to created Project
    And  Checking the Bundle Tolerance Value
    Then Check the Bundle Tolerance Value as per the Company Profile
    And  Place the Frame
    And  Bundles are drawn
    And  Inspecting Bundle
    Then Check outside focus changes lower tolerance and Upper tolerance
    Then Bundles are Deleted
    And  Bundles are drawn
    And  Inspecting Bundle Tolerance Value
    Then Check Bundle Tolerance Value By Inspecting Bundle
    Then Bundles are Deleted
    And  Bundles are drawn
    And user sets label 'node' to "hide"
    And  Getting the Values of Component Label
    Then Check the component label value
    Then Check by printing the drawing in Metric Task units
    And User exits the drawing page
    And User deletes Harness <taskDescription> successfully
    Examples:
      | string | taskDescription   | units  |
      | test4  | 'BundleTolerance' |'metric'|
  @BundleTolerance
  Scenario Outline: To create a Harness to check the Bundle Tolerance in Imperial Units
    Given I'm on Arcadia test environment
    And  test data config loaded for test identifier <string>
    And  Navigated to General task units
    And  Changing General units to <units>
    And  Navigated to quickstart project
    And  harness with name <taskDescription> is launched successfully
    And  Turning Visibility on for Bundle Tolerance
    And  Navigating to Company profile page
    And  Navigating to created Project
    And  Checking the Bundle Tolerance Value
    Then Check the Bundle Tolerance Value as per the Company Profile
    And  Place the Frame
    And  Bundles are drawn
    And  Inspecting Bundle Tolerance Value for Imperial task
    Then Check outside focus changes lower tolerance and Upper tolerance for Imperial task
    Then Bundles are Deleted
    And  Bundles are drawn
    And  Inspecting Bundle Tolerance Value
    Then Check Bundle Tolerance Value By Inspecting Bundle for Imperial task
    Then Bundles are Deleted
    And  Bundles are drawn
    And user sets label 'node' to "hide"
    And  Getting the Values of Component Label
    Then Check the component label value for Imperial task
    Then Check by printing the drawing in Imperial Task units
    And User exits the drawing page
    And User deletes Harness <taskDescription> successfully
    Examples:
      | string | taskDescription   | units    |
      | test4  | 'BundleTolerance' |'imperial'|

  @BundleTolerance
  Scenario Outline: To create a Harness to check the Bundle Tolerance by generating Formboard for Metric Task
    Given I'm on Arcadia test environment
    And  test data config loaded for test identifier <string>
    And  Navigated to General task units
    And  Changing General units to <units>
    And  Navigated to quickstart project
    And  harness with name <taskDescription> is launched successfully
    And  Turning Visibility on for Bundle Tolerance
    And  Navigating to Company profile page
    And  Navigating to created Project
    And Place the Frame
    And  Bundles are drawn
    And User exits the drawing page
    And Generating Formboard
    And  Turning visibility on for Bundle tolerance in formboard
    And  Getting the Values of Component Label
    Then Check the component label value
    And User exits the drawing page
    And Accept alert
    And User deletes Harness <taskDescription> successfully
    Examples:
      | string | taskDescription   | units  |
      | test4  | 'BundleTolerance' |'metric'|

  @BundleTolerance
  Scenario Outline: To create a Harness to check the Bundle Tolerance by generating Formboard for Imperial Task
    Given I'm on Arcadia test environment
    And  test data config loaded for test identifier <string>
    And  Navigated to General task units
    And  Changing General units to <units>
    And  Navigated to quickstart project
    And  harness with name <taskDescription> is launched successfully
    And  Turning Visibility on for Bundle Tolerance
    And  Navigating to Company profile page
    And  Navigating to created Project
    And Place the Frame
    And  Bundles are drawn
    And User exits the drawing page
    And Generating Formboard
    And  Turning visibility on for Bundle tolerance in formboard
    And Place the Frame
    And  Getting the Values of Component Label
    Then Check the component label value for Imperial task
    Then Check by printing the drawing in Imperial Task units
    And User exits the drawing page
    And Accept alert
    And User deletes Harness <taskDescription> successfully
    Examples:
      | string | taskDescription   | units    |
      | test4  | 'BundleTolerance' |'imperial'|