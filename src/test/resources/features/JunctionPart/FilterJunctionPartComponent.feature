@Regression
Feature: Filter junction part components

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with PartNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'PartNumber'

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'Description'

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'Family'

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'Status'

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'Usage'

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'Supplier'

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'SupplierPN'

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with Colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'Colour'

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with ControlType
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'ControlType'

  @JunctionPartComponentDB
  @FilterJunctionPart
  Scenario: Test verifies a junctionpart component can be filtered with Material
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'junctionpart' from componentDB
    Then verify user can filter junctionpart based on property 'Material'