Feature: Filter multicore components

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with PartNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then verify user can filter multicore based on property 'PartNumber'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then verify user can filter multicore based on property 'Description'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then verify user can filter multicore based on property 'Family'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then verify user can filter multicore based on property 'Status'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then verify user can filter multicore based on property 'Usage'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then verify user can filter multicore based on property 'Supplier'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then verify user can filter multicore based on property 'SupplierPN'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with Colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then verify user can filter multicore based on property 'Colour'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with CableType
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then verify user can filter multicore based on property 'CableType'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with NumberOfWires
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then Verify multicore component data on the basis of filter 'NumberOfWires' with value '0-5'

  @MulticoreComponentDB
  @FilterMulticore
  Scenario: Test verifies a multicore component can be filtered with NumberOfWires - search pattern greater than
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then Verify multicore component data is greater than value '0' for filter 'NumberOfWires'