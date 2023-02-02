@Regression
Feature: Filter other parts components

  @OtherPartsComponentDB
  @FilterOtherParts
  Scenario: Test verifies a otherpart component can be filtered with PartNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    Then verify user can filter otherpart based on property 'PartNumber'

  @OtherPartsComponentDB
  @FilterOtherParts
  Scenario: Test verifies a otherpart component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    Then verify user can filter otherpart based on property 'Description'

  @OtherPartsComponentDB
  @FilterOtherParts
  Scenario: Test verifies a otherpart component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    Then verify user can filter otherpart based on property 'Family'

  @OtherPartsComponentDB
  @FilterOtherParts
  Scenario: Test verifies a otherpart component can be filtered with Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    Then verify user can filter otherpart based on property 'Status'

  @OtherPartsComponentDB
  @FilterOtherParts
  Scenario: Test verifies a otherpart component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    Then verify user can filter otherpart based on property 'Usage'

  @OtherPartsComponentDB
  @FilterOtherParts
  Scenario: Test verifies a otherpart component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    Then verify user can filter otherpart based on property 'Supplier'

  @OtherPartsComponentDB
  @FilterOtherParts
  Scenario: Test verifies a otherpart component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    Then verify user can filter otherpart based on property 'SupplierPN'

  @OtherPartsComponentDB
  @FilterOtherParts
  Scenario: Test verifies a otherpart component can be filtered with Colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'otherpart' from componentDB
    Then verify user can filter otherpart based on property 'Colour'