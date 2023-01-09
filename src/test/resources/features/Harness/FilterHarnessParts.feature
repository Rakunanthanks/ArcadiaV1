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
  Scenario: Test verifies a connector can be filtered with HousingGender value Male while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'housinggender' with value 'MALE'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with HousingGender value Female while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'housinggender' with value 'FEMALE'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with HousingGender value Unset while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'housinggender' with value 'UNSET'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with TerminalGender value MALE while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'terminalgender' with value 'MALE'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with TerminalGender value FEMALE while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'terminalgender' with value 'FEMALE'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Type value Sealed while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Type' with value 'SEALED'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Type value Unsealed while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Type' with value 'UNSEALED'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value BLACK while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'BLACK'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value BLUE while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'BLUE'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value BROWN while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'BROWN'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value CYAN while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'CYAN'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value GRAY while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'GRAY'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value GREEN while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'GREEN'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value LIGHTBLUE while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'LIGHT BLUE'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value NATURAL while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'NATURAL'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value ORANGE while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'ORANGE'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value PINK while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'PINK'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value PURPLE while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'PURPLE'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value RED while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'RED'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value WHITE while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'WHITE'

  @SearchParts
  Scenario: Test verifies a connector can be filtered with Colour value YELLOW while creating bundles
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Harness bundle default values are captured
    And Navigated to quickstart project
    And harness is created successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'YELLOW'


