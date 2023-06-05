@Regression @NodeUpdateFonts
  Feature: Node Update Fonts
    Background: User is Logged In
      Given I'm on Arcadia test environment
    Scenario: To set update fonts profile settings text size
      And Navigated to harness update font in profile page
      And Change font size in profile and capture the font size 'node'
      And Save the profile settings
      And Navigated to form board update font in profile page
      And Change font size in profile and capture the font size 'node'
      And Save the profile settings

    Scenario:Test verify font size and color for node child element
      And test data config loaded for test identifier test103
      And Navigated to quickstart project
      And harness with name 'Node update fonts' is launched successfully
      And based on drawing orchestrator components are created
      And user sets label 'node child element' to "Show"
      And click Update fonts
      Then check the font size is as per the profile or not
      And Change font size and colour in the task for 'Node child element'
      Then Check 'Node child element' is as per updated font size and font colour in the task
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Node update fonts' successfully

    Scenario:Test verify font size and color for node elements
      And test data config loaded for test identifier test104
      And Navigated to quickstart project
      And harness with name 'Node update fonts' is launched successfully
      And based on drawing orchestrator components are created
      And user sets label 'node' to "hide"
      And user sets label 'node name' to "Show"
      And click Update fonts
      And Change font size and colour in the task for 'Node name'
      Then Check 'Node name' is as per updated font size and font colour in the task
      And user sets label 'node' to "hide"
      And user sets label 'node functional description' to "Show"
      And click Update fonts
      And Change font size and colour in the task for 'Node functional description'
      Then Check 'Node functional description' is as per updated font size and font colour in the task
      And user sets label 'node' to "hide"
      And user sets label 'node attached parts' to "Show"
      And click Update fonts
      And Change font size and colour in the task for 'Node attach parts'
      Then Check 'Node attach parts' is as per updated font size and font colour in the task
      And user sets label 'node' to "hide"
      And user sets label 'node attached parts name' to "Show"
      And click Update fonts
      And Change font size and colour in the task for 'node attached parts name'
      Then Check 'node attached parts name' is as per updated font size and font colour in the task
      And User exits the drawing page
      And Accept alert
      And Generating Formboard
      And click Update fonts in formboard
      Then check the font size is as per the profile or not
      And user sets label 'node' to "hide" in formboard
      And user sets label 'Node functional description' to "Show" in formboard
      Then Check 'Node functional description' is as per updated font size and font colour in the formboard
      And user sets label 'node' to "hide" in formboard
      And user sets label 'node attached parts' to "Show" in formboard
      Then Check 'node attached parts' is as per updated font size and font colour in the formboard
      And user sets label 'node' to "hide" in formboard
      And user sets label 'node attached parts name' to "Show" in formboard
      Then Check 'node attached parts name' is as per updated font size and font colour in the formboard
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Node update fonts' successfully

    Scenario:Test verify font size and color for node child element in formboard
      And test data config loaded for test identifier test103
      And Navigated to quickstart project
      And harness with name 'Node update fonts' is launched successfully
      And based on drawing orchestrator components are created
      And User exits the drawing page
      And Accept alert
      And Generating Formboard
      And user sets label 'node child element' to "Show" in formboard
      And click Update fonts in formboard
      Then check the font size is as per the profile or not
      And Change font size and colour in the task for 'Node child element'
      Then Check 'Node child element' is as per updated font size and font colour in the task
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Node update fonts' successfully

      Scenario: To Set the settings to Defaults
