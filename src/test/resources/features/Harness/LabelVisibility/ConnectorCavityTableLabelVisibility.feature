@Regression @ConnectorCavityTableLabelVisibility
Feature: Connector Cavity Table Label Visibility
  Background:  Background: User is Logged In
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    And harness with name 'Connector Cavity label Visibility' is launched successfully
    And test data config loaded for test identifier test9
    And based on drawing orchestrator components are created

  Scenario: To set profile settings for below scenarios
    And Navigated to Label visibility in profile page
    And Accept alert
    And user sets label in profile 'node' to 'hide'
    And Navigated to Label visibility in profile page
    And user sets label in profile 'bundle' to 'hide'
    And Navigated to Label visibility in profile page
    And user sets label in profile 'connector cavity table' to 'hide'
    And Navigated to harness update font in profile page
    And Change font size in profile and capture the font size in 'connector' 'harness'
    And Save the profile settings
    And Navigated to form board update font in profile page
    And Change font size in profile and capture the font size in 'connector' 'formboard'
    And Save the profile settings

  Scenario: To verify connector cavity name label visibility
    And user sets label 'connector cavity table name' to "show"
    Then Verify connector cavity 'name' label is 'visible' or not
    And click Update fonts
    Then check the font size is as per the profile or not in connector
    And Change font size and colour in the task for 'connector name'
    Then Check 'connector name' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table name' to "hide name"
    Then Verify connector cavity 'name' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table name' to "show" in formboard
    Then Verify connector cavity 'name' label is 'visible' or not
    Then Check 'connector name' is as per updated font size and font colour in the formboard
    And user sets label 'connector cavity name' to "hide name" in formboard
    Then Verify connector cavity 'name' label is 'hide' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario: To verify connector cavity functional description label visibility
    And user sets label 'connector cavity table functional description' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'functional description' label is 'visible' or not
    And click Update fonts
    And Change font size and colour in the task for 'connector functional description'
    Then Check 'connector functional description' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table functional description' to "hide"
    Then Verify connector cavity 'functional description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table functional description' to "show" in formboard
    Then Check 'connector functional description' is as per updated font size and font colour in the formboard
    Then Verify connector cavity 'formboard functional description' label is 'visible' or not
    And user sets label 'connector cavity table functional description' to "hide" in formboard
    Then Verify connector cavity 'formboard functional description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario: To verify connector cavity part number label visibility
    And user sets label 'connector cavity table part number' to "show"
    Then Verify connector cavity 'part number' label is 'visible' or not
    And click Update fonts
    And Change font size and colour in the task for 'connector part number'
    Then Check 'connector part number' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table part number' to "hide"
    Then Verify connector cavity 'part number' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table part number' to "show" in formboard
    Then Verify connector cavity 'part number' label is 'visible' or not
    Then Check 'connector part number' is as per updated font size and font colour in the formboard
    And user sets label 'connector cavity table part number' to "hide" in formboard
    Then Verify connector cavity 'part number' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario: To verify connector cavity part number description label visibility
    And user sets label 'connector cavity table part number description' to "show"
    Then Verify connector cavity 'part number description' label is 'visible' or not
    And user sets label 'connector cavity table part number description' to "hide"
    Then Verify connector cavity 'part number description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table part number description' to "show" in formboard
    Then Verify connector cavity 'part number description' label is 'visible' or not
    And user sets label 'connector cavity table part number description' to "hide" in formboard
    Then Verify connector cavity 'part number description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario: To verify connector cavity company name label visibility
    And user sets label 'connector cavity table company name' to "show"
    Then Verify connector cavity 'company name' label is 'visible' or not
    And user sets label 'connector cavity table company name' to "hide"
    Then Verify connector cavity 'company name' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table company name' to "show" in formboard
    Then Verify connector cavity 'company name' label is 'visible' or not
    And user sets label 'connector cavity table company name' to "hide" in formboard
    Then Verify connector cavity 'company name' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario: To verify connector cavity variants label visibility
    And user sets label 'connector cavity table variant' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'variants' label is 'visible' or not
    And user sets label 'connector cavity table variant' to "hide"
    Then Verify connector cavity 'variants' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table variant' to "show" in formboard
    Then Verify connector cavity 'formboard variants' label is 'visible' or not
    And user sets label 'connector cavity table variant' to "hide" in formboard
    Then Verify connector cavity 'formboard variants' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario: To verify connector cavity attach parts label visibility
    And user sets label 'connector cavity table attach parts' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'attach parts' label is 'visible' or not
    And click Update fonts
    And Change font size and colour in the task for 'connector attached parts'
    Then Check 'connector attached parts' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table attach parts' to "hide"
    Then Verify connector cavity 'attach parts' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table attach parts' to "show" in formboard
    Then Verify connector cavity 'formboard attach parts' label is 'visible' or not
    Then Check 'connector attached parts' is as per updated font size and font colour in the formboard
    And user sets label 'connector cavity table attach parts' to "hide" in formboard
    Then Verify connector cavity 'formboard attach parts' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario: To verify connector cavity attach parts description label visibility
    And user sets label 'connector cavity table attach parts description' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'attach parts description' label is 'visible' or not
    And user sets label 'connector cavity table attach parts description' to "hide"
    Then Verify connector cavity 'attach parts description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table attach parts description' to "show" in formboard
    Then Verify connector cavity 'formboard attach parts description' label is 'visible' or not
    And user sets label 'connector cavity table attach parts description' to "hide" in formboard
    Then Verify connector cavity 'formboard attach parts description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario: To verify connector cavity attach parts variants label visibility
    And user sets label 'connector cavity table attach parts variants' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'attach parts variants' label is 'visible' or not
    And user sets label 'connector cavity table attach parts variants' to "hide"
    Then Verify connector cavity 'attach parts variants' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table attach parts variants' to "show" in formboard
    Then Verify connector cavity 'formboard attach parts variants' label is 'visible' or not
    And user sets label 'connector cavity table attach parts variants' to "hide" in formboard
    Then Verify connector cavity 'formboard attach parts variants' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario: To verify connector cavity terminal label visibility
    And user sets label 'connector cavity table terminal' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'terminal' label is 'visible' or not
    And user sets label 'connector cavity table terminal' to "hide"
    Then Verify connector cavity 'terminal' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table terminal' to "show" in formboard
    Then Verify connector cavity 'formboard terminal' label is 'visible' or not
    And user sets label 'connector cavity table terminal' to "hide" in formboard
    Then Verify connector cavity 'formboard terminal' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario:To verify connector cavity terminal description label visibility
    And user sets label 'connector cavity table terminal description' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'terminal description' label is 'visible' or not
    And click Update fonts
    And Change font size and colour in the task for 'connector terminals'
    Then Check 'connector terminals' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table terminal description' to "hide"
    Then Verify connector cavity 'terminal description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table terminal description' to "show" in formboard
    Then Verify connector cavity 'formboard terminal description' label is 'visible' or not
    Then Check 'connector terminals' is as per updated font size and font colour in the formboard
    And user sets label 'connector cavity table terminal description' to "hide" in formboard
    Then Verify connector cavity 'formboard terminal description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario:To verify connector cavity seal part number description label visibility
    And user sets label 'connector cavity table seal part number description' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'seal part number description' label is 'visible' or not
    And click Update fonts
    And Change font size and colour in the task for 'connector seals'
    Then Check 'connector seals' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table seal part number' to "hide"
    Then Verify connector cavity 'seal part number description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table seal part number description' to "show" in formboard
    Then Verify connector cavity 'formboard seal part number description' label is 'visible' or not
    Then Check 'connector seals' is as per updated font size and font colour in the formboard
    And user sets label 'connector cavity table seal part number' to "hide" in formboard
    Then Verify connector cavity 'formboard seal part number description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario:To verify connector cavity plug part number label visibility
    And user sets label 'connector cavity table plug part number' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'plug part number' label is 'visible' or not
    And user sets label 'connector cavity table plug part number' to "hide"
    Then Verify connector cavity 'plug part number' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table plug part number' to "show" in formboard
    Then Verify connector cavity 'formboard plug part number' label is 'visible' or not
    And user sets label 'connector cavity table plug part number' to "hide" in formboard
    Then Verify connector cavity 'formboard plug part number' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario:To verify connector cavity plug part number description label visibility
    And user sets label 'connector cavity table plug part number description' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'plug part number description' label is 'visible' or not
    And click Update fonts
    And Change font size and colour in the task for 'connector plugs'
    Then Check 'connector plugs' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table plug part number description' to "hide"
    Then Verify connector cavity 'plug part number description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table plug part number description' to "show" in formboard
    Then Verify connector cavity 'formboard plug part number description' label is 'visible' or not
    Then Check 'connector plugs' is as per updated font size and font colour in the formboard
    And user sets label 'connector cavity table plug part number description' to "hide" in formboard
    Then Verify connector cavity 'formboard plug part number description' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario:To verify connector cavity group id label visibility
    And user sets label 'connector cavity table connector group id' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'connector group id' label is 'visible' or not
    And click Update fonts
    And Change font size and colour in the task for 'connector group id'
    Then Check 'connector group id' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table connector group id' to "hide"
    Then Verify connector cavity 'connector group id' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table connector group id' to "show" in formboard
    Then Verify connector cavity 'formboard connector group id' label is 'visible' or not
    Then Check 'connector group id' is as per updated font size and font colour in the formboard
    And user sets label 'connector cavity table connector group id' to "hide" in formboard
    Then Verify connector cavity 'formboard connector group id' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario:To verify connector cavity terminal image quantity label visibility
    And user sets label 'connector cavity table terminal image quantity' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'terminal image quantity' label is 'visible' or not
    And click Update fonts
    And Change font size and colour in the task for 'connector terminal image quantity'
    Then Check 'connector terminal image quantity' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table terminal image quantity' to "hide"
    Then Verify connector cavity 'terminal image quantity' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table terminal image quantity' to "show" in formboard
    Then Verify connector cavity 'formboard terminal image quantity' label is 'visible' or not
    Then Check 'connector terminal image quantity' is as per updated font size and font colour in the formboard
    And user sets label 'connector cavity table terminal image quantity' to "hide" in formboard
    Then Verify connector cavity 'formboard terminal image quantity' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully

  Scenario:To verify connector cavity terminal image part number label visibility
    And user sets label 'connector cavity table terminal image part number' to "show"
    And 'connectorplug' component with index '0' is opened
    Then Verify connector cavity 'terminal image part number' label is 'visible' or not
    And click Update fonts
    And Change font size and colour in the task for 'connector terminal image part number'
    Then Check 'connector terminal image part number' is as per updated font size and font colour in the task
    And user sets label 'connector cavity table terminal image part number' to "hide"
    Then Verify connector cavity 'terminal image part number' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    And user sets label 'connector cavity table terminal image part number' to "show" in formboard
    Then Verify connector cavity 'formboard terminal image part number' label is 'visible' or not
    Then Check 'connector terminal image part number' is as per updated font size and font colour in the formboard
    And user sets label 'connector cavity table terminal image part number' to "hide" in formboard
    Then Verify connector cavity 'formboard terminal image part number' label is 'hide component label' or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector Cavity label Visibility' successfully