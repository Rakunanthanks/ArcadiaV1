@Regression @SpliceCavityTableLabelVisibility
Feature: Connector Cavity Table Label Visibility
  Background:  Background: User is Logged In
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    And harness with name 'Splice Cavity label Visibility' is launched successfully
    And test data config loaded for test identifier test11
    And based on drawing orchestrator components are created

  Scenario: To set profile settings for below scenarios
    And Navigated to Label visibility in profile page
    And Accept alert
    And user sets label in profile 'node' to 'hide'
    And Navigated to Label visibility in profile page
    And user sets label in profile 'bundle' to 'hide'
    And Navigated to Label visibility in profile page
    And user sets label in profile 'connector cavity table' to 'hide'
    And Navigated to Label visibility in profile page
    And user sets label in profile 'Splice cavity table' to 'hide'

  Scenario: To verify splice cavity name label visibility
    And user sets label 'splice cavity table name' to "show"
    Then Verify splice cavity 'name' label is 'visible' or not
    And user sets label 'splice cavity table name' to "hide name"
    Then Verify splice cavity 'name' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'splice cavity table name' to "show" in formboard
    Then Verify splice cavity 'name' label is 'visible' or not
    And user sets label 'splice cavity table name' to "hide name" in formboard
    Then Verify splice cavity 'name' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Splice Cavity label Visibility' successfully

  Scenario: To verify splice cavity functional description label visibility
    And user sets label 'splice cavity table functional description' to "show"
    And 'splice' component with index '0' is opened
    Then Verify splice cavity 'functional description' label is 'visible' or not
    And user sets label 'splice cavity table functional description' to "hide name"
    Then Verify splice cavity 'functional description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'splice cavity table functional description' to "show" in formboard
    Then Verify splice cavity 'formboard functional description' label is 'visible' or not
    And user sets label 'splice cavity table functional description' to "hide name" in formboard
    Then Verify splice cavity 'formboard functional description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Splice Cavity label Visibility' successfully

  Scenario: To verify connector splice node description label visibility
    And user sets label 'splice cavity table node description' to "show"
    And 'splice' component with index '0' is opened
    Then Verify splice cavity 'node description' label is 'visible' or not
    And user sets label 'splice cavity table node description' to "hide"
    Then Verify splice cavity 'node description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'splice cavity table node description' to "show" in formboard
    Then Verify splice cavity 'formboard node description' label is 'visible' or not
    And user sets label 'splice cavity table node description' to "hide" in formboard
    Then Verify splice cavity 'formboard node description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Splice Cavity label Visibility' successfully

  Scenario: To verify connector splice part number label visibility
    And user sets label 'splice cavity table part number' to "show"
    And 'splice' component with index '0' is opened
    Then Verify splice cavity 'part number' label is 'visible' or not
    And user sets label 'splice cavity table part number' to "hide"
    Then Verify splice cavity 'part number' label is 'hide splice part number' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'splice cavity table part number' to "show" in formboard
    Then Verify splice cavity 'formboard part number' label is 'visible' or not
    And user sets label 'splice cavity table part number' to "hide" in formboard
    Then Verify splice cavity 'formboard part number' label is 'hide splice part number' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Splice Cavity label Visibility' successfully

  Scenario: To verify splice cavity part number description label visibility
    And user sets label 'splice cavity table part number description' to "show"
    And 'splice' component with index '0' is opened
    Then Verify splice cavity 'part number description' label is 'visible' or not
    And user sets label 'splice cavity table part number description' to "hide"
    Then Verify splice cavity 'part number description' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'splice cavity table part number description' to "show" in formboard
    Then Verify splice cavity 'formboard part number description' label is 'visible' or not
    And user sets label 'splice cavity table part number description' to "hide" in formboard
    Then Verify splice cavity 'formboard part number description' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Splice Cavity label Visibility' successfully

  Scenario: To verify splice cavity variants label visibility
    And user sets label 'splice cavity table variants' to "show"
    And 'splice' component with index '0' is opened
    Then Verify splice cavity 'variants' label is 'visible' or not
    And user sets label 'splice cavity table variants' to "hide"
    Then Verify splice cavity 'variants' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'splice cavity table variants' to "show" in formboard
    Then Verify splice cavity 'formboard variants' label is 'visible' or not
    And user sets label 'splice cavity table variants' to "hide" in formboard
    Then Verify splice cavity 'formboard variants' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Splice Cavity label Visibility' successfully

  Scenario: To verify splice cavity attached parts label visibility
    And user sets label 'splice cavity table attached parts' to "show"
    And 'splice' component with index '0' is opened
    Then Verify splice cavity 'attached parts' label is 'visible' or not
    And user sets label 'splice cavity table attached parts' to "hide"
    Then Verify splice cavity 'attached parts' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'splice cavity table attached parts' to "show" in formboard
    Then Verify splice cavity 'formboard attached parts' label is 'visible' or not
    And user sets label 'splice cavity table attached parts' to "hide" in formboard
    Then Verify splice cavity 'formboard attached parts' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Splice Cavity label Visibility' successfully

  Scenario: To verify splice cavity attached parts description label visibility
    And user sets label 'splice cavity table attached parts description' to "show"
    And 'splice' component with index '0' is opened
    Then Verify splice cavity 'attached parts description' label is 'visible' or not
    And user sets label 'splice cavity table attached parts description' to "hide"
    Then Verify splice cavity 'attached parts description' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'splice cavity table attached parts description' to "show" in formboard
    Then Verify splice cavity 'formboard attached parts description' label is 'visible' or not
    And user sets label 'splice cavity table attached parts description' to "hide" in formboard
    Then Verify splice cavity 'formboard attached parts description' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Splice Cavity label Visibility' successfully

  Scenario: To verify splice cavity attached parts variants label visibility
    And user sets label 'splice cavity table attached parts variants' to "show"
    And 'splice' component with index '0' is opened
    Then Verify splice cavity 'attached parts variants' label is 'visible' or not
    And user sets label 'splice cavity table attached parts variants' to "hide"
    Then Verify splice cavity 'attached parts variants' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'splice cavity table attached parts variants' to "show" in formboard
    Then Verify splice cavity 'formboard attached parts variants' label is 'visible' or not
    And user sets label 'splice cavity table attached parts variants' to "hide" in formboard
    Then Verify splice cavity 'formboard attached parts variants' label is 'hide splice details' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Splice Cavity label Visibility' successfully