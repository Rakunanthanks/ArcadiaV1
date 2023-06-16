@Regression @UpdateCrossReference
  Feature: Update Cross Reference
   Scenario: Test to create a additional references
     Given I'm on Arcadia test environment
     And Navigated to selected componentDB
     And User selected 'connector' from componentDB
     And User searches 'connector' component using 'AY8193'
     And Edit Component 'connector'
     Then Create additional references for the given 'AY8193'
     And Navigated to selected componentDB
     And User searches 'terminal' component using '0-0152404-3'
     And Edit Component 'terminal'
     Then Create additional references for the given '0-0152404-3'
     And Navigated to selected componentDB
     And User searches 'seal' component using '15324980'
     And Edit Component 'editComponent'
     Then Create additional references for the given '15324980'
     And Navigated to selected componentDB
     And User searches 'otherpart' component using '1011-235-0405'
     And Edit Component 'editComponent'
     Then Create additional references for the given '1011-235-0405'

     Scenario: Test verifies update cross reference combination use manufacturer PN if company PN not in database
       Given I'm on Arcadia test environment
       And Navigated to quickstart project
       And harness with name 'Update Cross reference' is launched successfully
       And test data config loaded for test identifier test106
       And based on drawing orchestrator components are created
       And user sets label 'connector cavity table part number' to "show"
       And 'connectorplug' component with index '0' is opened
       And change connector part number as 'AY8193-SUPPLIER'
       And user update cross reference by searching combination '1'
       Then check update cross reference part number value for combination '1'
       And user sets label 'connector cavity table part number' to "hide"
       And user sets label 'connector cavity table terminal' to "show"
       And 'connectorplug' component with index '0' is opened
       And user add terminal as '0-0152404-3-Supplier' to the placed connector
       And user update cross reference by searching combination '1'
       Then check terminal update cross reference part number value for combination '1'
       And user sets label 'connector cavity table terminal' to "hide"
       And user sets label 'connector cavity table plug part number' to "show"
       And 'connectorplug' component with index '0' is opened
       And user add plug as '1011-235-0405-Supplier' to the placed connector
       And user update cross reference by searching combination '1'
       Then check plug update cross reference part number value for combination '1'
       And User exits the drawing page
       And Accept alert
       And User deletes Harness 'Update Cross reference' successfully

    Scenario: Test verifies update cross reference combination use Supplier PN if Company PN not in database
      Given I'm on Arcadia test environment
      And Navigated to quickstart project
      And harness with name 'Update Cross reference' is launched successfully
      And test data config loaded for test identifier test106
      And based on drawing orchestrator components are created
      And user sets label 'connector cavity table part number' to "show"
      And 'connectorplug' component with index '0' is opened
      And change connector part number as 'AY8193-MANUFACTURER'
      And user update cross reference by searching combination '3'
      Then check update cross reference part number value for combination '3'
      And user sets label 'connector cavity table part number' to "hide"
      And user sets label 'connector cavity table terminal' to "show"
      And 'connectorplug' component with index '0' is opened
      And user add terminal as '0-0152404-3-MANUFACTURER' to the placed connector
      And user update cross reference by searching combination '3'
      Then check terminal update cross reference part number value for combination '3'
      And user sets label 'connector cavity table terminal' to "hide"
      And user sets label 'connector cavity table plug part number' to "show"
      And 'connectorplug' component with index '0' is opened
      And user add plug as '1011-235-0405-MANUFACTURER' to the placed connector
      And user update cross reference by searching combination '3'
      Then check plug update cross reference part number value for combination '3'
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Update Cross reference' successfully

    Scenario: Test verifies update cross reference combination 	Cross Reference to Manufacturer PN Only
      Given I'm on Arcadia test environment
      And Navigated to quickstart project
      And harness with name 'Update Cross reference' is launched successfully
      And test data config loaded for test identifier test106
      And based on drawing orchestrator components are created
      And user sets label 'connector cavity table part number' to "show"
      And 'connectorplug' component with index '0' is opened
      And change connector part number as 'AY8193-CROSSREF'
      And user update cross reference by searching combination '2'
      Then check update cross reference part number value for combination '2'
      And user sets label 'connector cavity table part number' to "hide"
      And user sets label 'connector cavity table terminal' to "show"
      And 'connectorplug' component with index '0' is opened
      And user add terminal as '0-0152404-3-CROSSREF' to the placed connector
      And user update cross reference by searching combination '2'
      Then check terminal update cross reference part number value for combination '2'
      And user sets label 'connector cavity table terminal' to "hide"
      And user sets label 'connector cavity table plug part number' to "show"
      And 'connectorplug' component with index '0' is opened
      And user add plug as '1011-235-0405-CROSSREF' to the placed connector
      And user update cross reference by searching combination '2'
      Then check plug update cross reference part number value for combination '2'
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Update Cross reference' successfully

    Scenario: Test verifies update cross reference combination Cross Reference to Supplier PN Only
      Given I'm on Arcadia test environment
      And Navigated to quickstart project
      And harness with name 'Update Cross reference' is launched successfully
      And test data config loaded for test identifier test106
      And based on drawing orchestrator components are created
      And user sets label 'connector cavity table part number' to "show"
      And 'connectorplug' component with index '0' is opened
      And change connector part number as 'AY8193-CROSSREF'
      And user update cross reference by searching combination '4'
      Then check update cross reference part number value for combination '4'
      And user sets label 'connector cavity table part number' to "hide"
      And user sets label 'connector cavity table terminal' to "show"
      And 'connectorplug' component with index '0' is opened
      And user add terminal as '0-0152404-3-CROSSREF' to the placed connector
      And user update cross reference by searching combination '4'
      Then check terminal update cross reference part number value for combination '4'
      And user sets label 'connector cavity table terminal' to "hide"
      And user sets label 'connector cavity table plug part number' to "show"
      And 'connectorplug' component with index '0' is opened
      And user add plug as '1011-235-0405-CROSSREF' to the placed connector
      And user update cross reference by searching combination '4'
      Then check plug update cross reference part number value for combination '4'
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Update Cross reference' successfully