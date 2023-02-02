@Regression
Feature: Filter splice components

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with PartNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'PartNumber'

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'Description'

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'Family'

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'Status'

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'Usage'

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'Supplier'

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'SupplierPN'

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with Colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'Colour'

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with SealingType
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'SealingType'

  @SpliceComponentDB
  @FilterSplice
  Scenario: Test verifies a splice component can be filtered with Material
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'splice' from componentDB
    Then verify user can filter splice based on property 'Material'