Feature: Filter harness parts

  @SearchParts
  Scenario: Test verifies a connector can be filtered using partnumber while creating bundles
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    #steps to navigated to harness to be done by Arpit
    And get the all the options for connector with id 'c90990c9927a11ed908802de8e05bcf8'
    And User try operation 'delete' for connector with id 'c90990c9927a11ed908802de8e05bcf8'