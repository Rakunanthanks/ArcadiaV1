@Regression @BundleLabelVisibility
Feature: Bundle Label Visibility
  Background: User is Logged In
    Given I'm on Arcadia test environment

   Scenario: To verify bundle name label visibility
      And Navigated to quickstart project
      And harness with name 'Bundle label Visibility' is launched successfully
      And test data config loaded for test identifier test12
      And based on drawing orchestrator components are created
      And user sets label 'node' to "hide"
      And user sets label 'bundle' to "hide"
      And user sets label 'Bundle name' to "show"
      Then Verify bundle 'name' label is 'visible' or not
      And user sets label 'Bundle name' to "Hide"
      Then Verify bundle 'Bundle name' label is 'hide' or not
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle length label visibility in imperial task
    And Navigated to General task units
    And Changing General units to 'imperial'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And user sets label 'Bundle length' to "show"
    Then Verify bundle 'length inch' label is 'visible' or not
    And user sets label 'Bundle length' to "Hide"
    Then Verify bundle 'length inch' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle tolerance label visibility in imperial task
    And Navigated to General task units
    And Changing General units to 'imperial'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And user sets label 'Bundle tolerance' to "show"
    Then Verify bundle 'Bundle tolerance inch' label is 'visible' or not
    And user sets label 'Bundle tolerance' to "Hide"
    Then Verify bundle 'Bundle tolerance inch' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle wire diameter label visibility in imperial task
    And Navigated to General task units
    And Changing General units to 'imperial'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test105
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And user sets label 'bundle wire bundle diameter' to "show"
    Then Verify bundle 'wire bundle diameter inch' label is 'visible' or not
    And user sets label 'bundle wire bundle diameter' to "Hide"
    Then Verify bundle 'wire bundle diameter inch' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle length label visibility in metric task
    And Navigated to General task units
    And Changing General units to 'metric'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And user sets label 'Bundle length' to "show"
    Then Verify bundle 'length mm' label is 'visible' or not
    And user sets label 'Bundle length' to "Hide"
    Then Verify bundle 'length mm' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle tolerance label visibility in metric task
    And Navigated to General task units
    And Changing General units to 'metric'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And user sets label 'Bundle tolerance' to "show"
    Then Verify bundle 'Bundle tolerance mm' label is 'visible' or not
    And user sets label 'Bundle tolerance' to "Hide"
    Then Verify bundle 'Bundle tolerance mm' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle wire diameter label visibility in metric task
    And Navigated to General task units
    And Changing General units to 'metric'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test105
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And user sets label 'bundle wire bundle diameter' to "show"
    Then Verify bundle 'wire bundle diameter mm' label is 'visible' or not
    And user sets label 'bundle wire bundle diameter' to "Hide"
    Then Verify bundle 'wire bundle diameter mm' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle piece id label visibility
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And 'bundle' list is initialized
    And user sets label 'bundle pieceid' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle pieceid' label is 'visible' or not
    And user sets label 'bundle pieceid' to "Hide"
    Then Verify bundle 'bundle pieceid' label is 'hide covering details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle piece id length label visibility in metric task
    And Navigated to General task units
    And Changing General units to 'metric'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And 'bundle' list is initialized
    And user sets label 'bundle pieceid length' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle piece id length mm' label is 'visible' or not
    And user sets label 'bundle pieceid length' to "Hide"
    Then Verify bundle 'bundle piece id length mm' label is 'hide covering details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle piece id length label visibility in imperial task
    And Navigated to General task units
    And Changing General units to 'imperial'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And 'bundle' list is initialized
    And user sets label 'bundle pieceid length' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle piece id length inch' label is 'visible' or not
    And user sets label 'bundle pieceid length' to "Hide"
    Then Verify bundle 'bundle piece id length inch' label is 'hide covering details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle Covering part number label visibility
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And 'bundle' list is initialized
    And user sets label 'bundle covering pn' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle covering pn' label is 'visible' or not
    And user sets label 'bundle covering pn' to "Hide"
    Then Verify bundle 'bundle covering pn' label is 'hide covering details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle Covering part number description label visibility
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And 'bundle' list is initialized
    And user sets label 'bundle covering partdescription' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle covering partdescription' label is 'visible' or not
    And user sets label 'bundle covering partdescription' to "Hide"
    Then Verify bundle 'bundle covering partdescription' label is 'hide covering details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle Covering part variant label visibility
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And user sets label 'bundle covering part variant' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle covering part variant' label is 'visible' or not
    And user sets label 'bundle covering part variant' to "Hide"
    Then Verify bundle 'bundle covering part variant' label is 'hide covering details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle Covering part variant label visibility in metric task
    And Navigated to General task units
    And Changing General units to 'metric'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And user sets label 'bundle covering length' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle covering length mm' label is 'visible' or not
    And user sets label 'bundle covering length' to "Hide"
    Then Verify bundle 'bundle covering length mm' label is 'hide covering details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle Covering part variant label visibility in imperial task
    And Navigated to General task units
    And Changing General units to 'imperial'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "hide"
    And user sets label 'bundle covering length' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle covering length inch' label is 'visible' or not
    And user sets label 'bundle covering length' to "Hide"
    Then Verify bundle 'bundle covering length inch' label is 'hide covering details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle labels visibility in imperial task
    And Navigated to General task units
    And Changing General units to 'imperial'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle inch' label is 'visible' or not
    And user sets label 'bundle' to "Hide"
    Then Verify bundle 'bundle inch' label is 'hide all details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle labels visibility in metric task
    And Navigated to General task units
    And Changing General units to 'metric'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'bundle' to "show"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle mm' label is 'visible' or not
    And user sets label 'bundle' to "Hide"
    Then Verify bundle 'bundle mm' label is 'hide all details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully

  Scenario: To verify bundle labels visibility in metric task by turning on bundle in profile
    And Navigated to Label visibility in profile page
    And user sets label in profile 'bundle' to 'show'
    And Navigated to General task units
    And Changing General units to 'metric'
    And Navigated to quickstart project
    And harness with name 'Bundle label Visibility' is launched successfully
    And test data config loaded for test identifier test12
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    When User try operation 'Add covering' for bundle
    Then Verify bundle 'bundle mm' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle label Visibility' successfully
