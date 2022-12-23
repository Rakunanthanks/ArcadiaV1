Feature: Create components

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with InReview Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Status' with value 'IN REVIEW'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with PartNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'PartNumber' with value 'AUTOMATIONTEST1'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Description' with value 'AutomationTestDescription'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Family' with value 'AutomationTestFamily'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Usage' with value 'PREFERRED'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Supplier' with value 'AutomationTestCompany'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'SupplierPN' with value 'AUTOMATIONTEST1'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Colour' with value 'RED-ORANGE-BLUE'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with AwgSize
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'AwgSize' with value '16'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with Gauge
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Gauge' with value '10-20'

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
  Scenario: Test verifies a wire component can be filtered with gauge
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
    Then Verify component data on the basis of filter 'Resistance' with value '5.2-14.7'

