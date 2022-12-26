Feature: Filter wire components

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Status'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with PartNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'PartNumber'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Description'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Family'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Usage'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Supplier'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'SupplierPN'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Colour'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with AwgSize
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'AwgSize'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Gauge
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then verify user can apply filter based on property 'Gauge'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with WireCsa
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'WireCsa' with value '1.20-8.20'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with outsidediameter
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'OutsideDia' with value '2.80-5.0'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Material
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Material' with value 'TPE-S'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with MinimumBendRadius
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'MinimumBendRadius' with value '0.00-2.50'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with MaxCurrent
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'MaxCurrent' with value '0-24.5'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Resistance
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Resistance' with value '0.00-1.00'