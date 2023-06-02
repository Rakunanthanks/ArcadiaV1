@Regression @Nodeformboardlabelvisibility
Feature: Form board node label visibility
  Background: User is Logged In
    Given I'm on Arcadia test environment

    Scenario: To set the formboard label visibility in profile
      And Navigated to Label visibility in profile page for formboard
      And Accept alert
      And user sets label in profile 'node' to 'hide'
      And Navigated to Label visibility in profile page for formboard
      And user sets label in profile 'bundle' to 'hide'
      And Navigated to Label visibility in profile page for formboard
      And user sets label in profile 'connector cavity table' to 'hide'
      And Navigated to Label visibility in profile page for formboard
      And user sets label in profile 'splice cavity table' to 'hide'

    Scenario: To verify node name label visibility in form board
      And Navigated to quickstart project
      And harness with name 'Formboard node label Visibility' is launched successfully
      And test data config loaded for test identifier test104
      And based on drawing orchestrator components are created
      And user sets label 'node' to "Show"
      Then Verify 'all node option visibility' label is 'visible' or not
      And User exits the drawing page
      And Accept alert
      And Generating Formboard
      And user sets label 'node name' to "Show" in formboard
      Then Verify 'name' label is 'visible' or not
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Formboard node label Visibility' successfully

  Scenario: To verify node functional description label visibility in form board
    And Navigated to quickstart project
    And harness with name 'Formboard node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "Show"
    Then Verify 'all node option visibility' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'node' to "hide" in formboard
    And user sets label 'node functional description' to "Show" in formboard
    Then Verify 'formboard node functional description' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Formboard node label Visibility' successfully

  Scenario: To verify node attached parts label visibility in form board
    And Navigated to quickstart project
    And harness with name 'Formboard node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "Show"
    Then Verify 'all node option visibility' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'node' to "hide" in formboard
    And user sets label 'node attached parts' to "Show" in formboard
    Then Verify 'formboard attached parts' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Formboard node label Visibility' successfully

  Scenario: To verify node attached parts name label visibility in form board
    And Navigated to quickstart project
    And harness with name 'Formboard node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "Show"
    Then Verify 'all node option visibility' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'node' to "hide" in formboard
    And user sets label 'node attached parts name' to "Show" in formboard
    Then Verify 'formboard attached parts name' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Formboard node label Visibility' successfully

  Scenario: To verify node attached parts description label visibility in form board
    And Navigated to quickstart project
    And harness with name 'Formboard node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "Show"
    Then Verify 'all node option visibility' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'node' to "hide" in formboard
    And user sets label 'node attached parts description' to "Show" in formboard
    Then Verify 'formboard attached parts description' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Formboard node label Visibility' successfully

  Scenario: To verify node attached parts variants label visibility in form board
    And Navigated to quickstart project
    And harness with name 'Formboard node label Visibility' is launched successfully
    And test data config loaded for test identifier test104
    And based on drawing orchestrator components are created
    And user sets label 'node' to "Show"
    Then Verify 'all node option visibility' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'node' to "hide" in formboard
    And user sets label 'node attached parts variants' to "Show" in formboard
    Then Verify 'formboard attached part variants' label is 'visible' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Formboard node label Visibility' successfully