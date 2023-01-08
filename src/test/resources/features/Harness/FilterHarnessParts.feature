Feature: Filter harness parts

  @SearchParts
  Scenario: Test verifies a connector can be filtered using partnumber while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' in 'quickstart' componentdb using 'partNumber'

  @SearchParts
  Scenario: Test verifies a connector can be filtered using cavity while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' in 'quickstart' componentdb using 'cavity'

  @SearchParts
  Scenario: Test verifies a connector can be filtered using family while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' in 'quickstart' componentdb using 'family'

  @SearchParts
  Scenario: Test verifies a connector can be filtered using supplier while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' in 'quickstart' componentdb using 'supplier'

  @SearchParts
  Scenario: Test verifies a connector can be filtered using HousingGender while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' in 'quickstart' componentdb using 'housinggender'

  @SearchParts
  Scenario: Test verifies a connector can be filtered using TerminalGender while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' in 'quickstart' componentdb using 'terminalgender'