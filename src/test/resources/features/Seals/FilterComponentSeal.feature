Feature: Create components

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with Part Number
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'PartNumber'

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'Description'

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'Family'

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'Status'

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'Usage'

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'Supplier'

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'SupplierPN'

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with Colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'Colour'

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with CavityPlug
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'CavityPlug'

  @FilterComponent
  Scenario: Test verifies a seal component can be filtered with InsulationOD
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then verify user can filter seals based on property 'InsulationOD'



