Feature: Create components

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with InReview status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Status' with value 'IN REVIEW'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with partNumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'PartNumber' with value 'AUTOMATIONTEST1'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with description
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Description' with value 'AutomationTestDescription'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with family
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Family' with value 'AutomationTestFamily'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with usage
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Usage' with value 'PREFERRED'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Supplier' with value 'AutomationTestCompany'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with supplierPN
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'SupplierPN' with value 'AUTOMATIONTEST1'

  @FilterComponent
  Scenario: Test verifies a wire component can be filtered with colour
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then Verify component data on the basis of filter 'Colour' with value 'RED-ORANGE-BLUE'