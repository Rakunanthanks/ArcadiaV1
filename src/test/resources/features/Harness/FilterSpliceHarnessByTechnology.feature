@FilterAttachedParts
Feature: Filter splice harness by technology

  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test11
    And Navigated to selected componentDB

  @FilterAttachedParts
  Scenario: Test verifies splice can be filtered by technology Ultrasonic
    And Navigated to quickstart project
    And harness with name 'spliceValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'splice' component with index '0' is opened
    And 'splice' can be filtered with technology 'Ultrasonic'

  @FilterAttachedParts
  Scenario: Test verifies splice can be filtered by technology Mechanical
    And Navigated to quickstart project
    And harness with name 'spliceValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'splice' component with index '0' is opened
    And 'splice' can be filtered with technology 'Mechanical'

  @FilterAttachedParts
  Scenario: Test verifies splice can be filtered by technology Weld
    And Navigated to quickstart project
    And harness with name 'spliceValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'splice' component with index '0' is opened
    And 'splice' can be filtered with technology 'Weld'