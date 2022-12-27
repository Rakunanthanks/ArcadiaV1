Feature: Filter wire components

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Status'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with PartNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'PartNumber'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Description'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Family'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Usage'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Supplier'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'SupplierPN'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Colour'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with AwgSize
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'AwgSize'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Gauge
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Gauge'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with WireCsa
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'WireCsa' with value '1.20-8.20'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with WireCsa - search pattern greater than
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data is greater than value '1.0' for filter 'WireCsa'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with outsidediameter - search pattern greater than
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data is greater than value '1.0' for filter 'OutsideDia'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with MinimumBendRadius - search pattern greater than
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data is greater than value '1.0' for filter 'MinimumBendRadius'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with MaxCurrent - search pattern greater than
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data is greater than value '1.0' for filter 'MaxCurrent'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Resistance - search pattern greater than
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data is greater than value '1.0' for filter 'Resistance'


  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with outsidediameter
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'OutsideDia' with value '2.80-5.0'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Material
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Material' with value 'TPE-S'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with MinimumBendRadius
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'MinimumBendRadius' with value '0.00-2.50'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with MaxCurrent
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'MaxCurrent' with value '0-24.5'

  @WireComponentDB
  @FilterWire
  Scenario: Test verifies a wire component can be filtered with Resistance
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Resistance' with value '0.00-1.00'