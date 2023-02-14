@CreateSpliceHarness
Feature: Create splice harness

  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test11
    And Navigated to selected componentDB

  @CreateSpliceHarness
  Scenario: Test verifies splice image can be created with all configuration
    And Navigated to quickstart project
    And harness with name 'spliceValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'splice' component with index '0' is opened
    And 'splice' can be filtered with technology 'Mechanical'
    And add configurations to create splice image
    And toggle splice image from context menu options
    And verify splice image is drawn on Harness page with above configuration
