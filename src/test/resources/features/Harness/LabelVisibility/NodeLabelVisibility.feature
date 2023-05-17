@Regression @NodeLabelVisibility
Feature: Node Label Visibility
  Background: User is Logged In
    Given I'm on Arcadia test environment

  Scenario:To verify node child element show and hide
    And Navigated to quickstart project
    And harness with name 'Node label Visibility' is launched successfully
    And test data config loaded for test identifier test103
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'node child element' to "Show"
    Then Verify 'child element' label is 'visible' or not
    And user sets label 'node child element' to "Hide"
    Then Verify 'child element' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node label Visibility' successfully

  Scenario:To verify node name show and hide
    And Navigated to quickstart project
    And harness with name 'Node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'node name' to "Show"
    Then Verify 'name' label is 'visible' or not
    And user sets label 'node name' to "Hide"
    Then Verify 'name' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node label Visibility' successfully

  Scenario:To verify node functional description show and hide
    And Navigated to quickstart project
    And harness with name 'Node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'node functional description' to "Show"
    Then Verify 'functional description' label is 'visible' or not
    And user sets label 'node functional description' to "Hide"
    Then Verify 'functional description' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node label Visibility' successfully

  Scenario:To verify node attached parts show and hide
    And Navigated to quickstart project
    And harness with name 'Node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'node attached parts' to "Show"
    Then Verify 'attached parts' label is 'visible' or not
    And user sets label 'node attached parts' to "Hide"
    Then Verify 'attached parts' label is 'hide attached parts' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node label Visibility' successfully

  Scenario:To verify node attached parts name show and hide
    And Navigated to quickstart project
    And harness with name 'Node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "hide"
    And user sets label 'node attached parts name' to "Show"
    Then Verify 'attached parts name' label is 'visible' or not
    And user sets label 'node attached parts name' to "Hide"
    Then Verify 'attached parts name' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node label Visibility' successfully

  Scenario:To verify node attached parts description show and hide
    And Navigated to quickstart project
    And harness with name 'Node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label "node" to "Hide"
    And user sets label 'node attached parts description' to "Show"
    Then Verify 'attached parts description' label is 'visible' or not
    And user sets label 'node attached parts description' to "Hide"
    Then Verify 'attached parts description' label is 'hide attached parts details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node label Visibility' successfully

  Scenario:To verify node attached parts variants show and hide
    And Navigated to quickstart project
    And harness with name 'Node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label "node" to "Hide"
    And user sets label 'node attached parts variants' to "Show"
    Then Verify 'attached parts variants' label is 'visible' or not
    And user sets label 'node attached parts variants' to "Hide"
    Then Verify 'attached parts variants' label is 'hide attached parts details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node label Visibility' successfully

    Scenario:To verify node in a task show and hide for all labels
    And Navigated to quickstart project
    And harness with name 'Node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "Show"
    Then Verify 'all node option visibility' label is 'visible' or not
    And user sets label 'node' to "Hide"
    Then Verify 'all node option visibility' label is 'hide all node details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node label Visibility' successfully

    Scenario:To verify in profile node visible  for all labels
      And Navigated to Label visibility in profile page
      And user sets label in profile 'node' to 'show'
      And Navigated to quickstart project
      And harness with name 'Node label Visibility' is launched successfully
      And test data config loaded for test identifier test104
      And based on drawing orchestrator components are created
      Then Verify 'all node option visibility' label is 'visible' or not
      And user sets label 'node' to "Hide"
      Then Verify 'all node option visibility' label is 'hide all node details' or not
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Node label Visibility' successfully

  Scenario:To verify in profile node hide for all labels
    And Navigated to Label visibility in profile page
    And user sets label in profile 'node' to 'hide'
    And Navigated to quickstart project
    And harness with name 'Node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    Then Verify 'all node option hide' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node label Visibility' successfully