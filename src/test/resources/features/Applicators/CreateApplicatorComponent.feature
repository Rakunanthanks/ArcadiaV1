Feature: Create applicator components

 @ApplicatorsComponentDB
 @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with InReview status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with status 'IN REVIEW' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with Approved status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with status 'APPROVED' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with UnApproved status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with status 'UNAPPROVED' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with Included billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with billtype 'INCLUDED' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with Excluded billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with billtype 'EXCLUDED' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with Consumable billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with billtype 'CONSUMABLE' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with Investment billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with billtype 'INVESTMENT' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created when we enter mandatory details only
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with referencepartnumber 'RandomUniqueNumber' and referencecompany 'TestCompany' only is created

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component cannot be created when we donot enter mandatory details referencepartnumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with referencepartnumber '' and referencecompany 'TestCompany' only is created
    Then Verify error message is displayed for mandatory field 'referencepartnumber' for component 'applicator'

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component cannot be created when we donot enter mandatory details referencecompany
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with referencepartnumber 'RandomUniqueNumber' and referencecompany '' only is created
    Then Verify error message is displayed for mandatory field 'referencecompany' for component 'applicator'

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with refrencetype manufacturer
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with additionalreferencetype 'Manufacturer' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with refrencetype supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with additionalreferencetype 'Supplier' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with refrencetype crossref
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with additionalreferencetype 'CrossRef' is created successfully

  @ApplicatorsComponentDB
  @CreateApplicatorComponent
  Scenario: Test verifies a applicator component can be created with all refrencetype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'applicator' from componentDB
    Then 'applicator' component with additionalreferencetype 'Manufacturer,Supplier,CrossRef' is created successfully