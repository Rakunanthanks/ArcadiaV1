@Regression
Feature: Filter components

  @ComponentDB
  @FilterComponent
  Scenario: Test verifies a multicore component can be filtered with PartNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then verify user can filter component based on property 'PartNumber'

  @ComponentDB
  @FilterComponent
  Scenario: Test verifies a multicore component can be filtered with Description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then verify user can filter component based on property 'Description'

  @ComponentDB
  @FilterComponent
  Scenario: Test verifies a multicore component can be filtered with Family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then verify user can filter component based on property 'Family'

  @ComponentDB
  @FilterComponent
  Scenario: Test verifies a multicore component can be filtered with Status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then verify user can filter component based on property 'Status'

  @ComponentDB
  @FilterComponent
  Scenario: Test verifies a multicore component can be filtered with Usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then verify user can filter component based on property 'Usage'

  @ComponentDB
  @FilterComponent
  Scenario: Test verifies a multicore component can be filtered with Supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then verify user can filter component based on property 'Supplier'

  @ComponentDB
  @FilterComponent
  Scenario: Test verifies a multicore component can be filtered with SupplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then verify user can filter component based on property 'SupplierPN'

  @ComponentDB
  @FilterComponent
  Scenario: Test verifies a multicore component can be filtered with NumberOfCavities
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then Verify component data on the basis of filter 'NumberOfCavities' with value '1-10'

  @ComponentDB
  @FilterComponent
  Scenario: Test verifies a multicore component can be filtered with NumberOfWires - search pattern greater than
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'component' from componentDB
    Then Verify component data is greater than value '0' for filter 'NumberOfCavities'