@Regression
Feature: Filter connector components

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with PartNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'PartNumber'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'Description'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'Family'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'Status'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'Usage'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'Supplier'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'SupplierPN'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with Colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'Colour'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with HousingGender
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'HousingGender'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with TerminalGender
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'TerminalGender'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with ConnectorType
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'ConnectorType'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with Keyway
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then verify user can filter connector based on property 'Keyway'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with NumberOfCavities
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then Verify connector data on the basis of filter 'NumberOfCavities' with value '1-10'

  @ConnectorsComponentDB
  @FilterConnector
  Scenario: Test verifies a connector component can be filtered with NumberOfCavities - search pattern greater than
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB
    Then Verify connector component data is greater than value '0' for filter 'NumberOfCavities'