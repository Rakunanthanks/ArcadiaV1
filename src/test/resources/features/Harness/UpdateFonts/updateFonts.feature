Feature: Update Fonts
  Background: User is Logged In
    Given I'm on Arcadia test environment
  Scenario:Test verify bundle sub dimension font amd color
    And test data config loaded for test identifier test12
    And Navigated to quickstart project
    And harness with name 'Bundle sub dimension update fonts' is launched successfully
    And based on drawing orchestrator components are created
    And 'bundle' list is initialized
    And click Update fonts
    And Change font size and colour in the task for 'bundle sub dimension'
    Then Check 'bundle sub dimension' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    Then Check 'bundle sub dimension' is as per updated font size and font colour in the formboard
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node update fonts' successfully

  Scenario:Test verify bundle break font amd colour
    And test data config loaded for test identifier test12
    And Navigated to quickstart project
    And harness with name 'Bundle break update fonts' is launched successfully
    And based on drawing orchestrator components are created
    And 'bundle' list is initialized
    And click Update fonts
    And Change font size and colour in the task for 'bundle break'
    Then Check 'bundle break' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Node update fonts' successfully

  Scenario: Test verify connector cavity table font and colour
    And test data config loaded for test identifier test9
    And Navigated to quickstart project
    And harness with name 'Connector cavity table fonts' is launched successfully
    And based on drawing orchestrator components are created
    And click Update fonts
    And Change font size and colour in the task for 'connector cavity table font'
    And 'connectorplug' component with index '0' is opened
    Then Check 'connector cavity table font' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector cavity table fonts' successfully

  Scenario: Test verify splice cavity table font and colour
    And test data config loaded for test identifier test11
    And Navigated to quickstart project
    And harness with name 'Splice cavity table fonts' is launched successfully
    And based on drawing orchestrator components are created
    And click Update fonts
    And Change font size and colour in the task for 'splice cavity table font'
    And 'splice' component with index '0' is opened
    Then Check 'splice cavity table font' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector cavity table fonts' successfully

  Scenario: Test verify connector label font and colour
    And test data config loaded for test identifier test9
    And Navigated to quickstart project
    And harness with name 'Connector Label fonts' is launched successfully
    And based on drawing orchestrator components are created
    And click Update fonts
    And Change font size and colour in the task for 'connector label'
    Then Check 'connector label' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    Then Check 'connector label' is as per updated font size and font colour in the formboard
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector cavity table fonts' successfully

  Scenario: Test verify harness label font and colour
    And test data config loaded for test identifier test9
    And Navigated to form board update font in profile page
    And change colour and font size of 'harness label' in formboard
    And Navigated to quickstart project
    And harness with name 'Harness Label fonts' is launched successfully
    And based on drawing orchestrator components are created
    And click Update fonts
    And Change font size and colour in the task for 'harness label'
    Then Check 'harness label' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    Then Check 'harness label' is as per updated font size and font colour in the formboard
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Connector cavity table fonts' successfully

  Scenario: Test verify bom table font
    And test data config loaded for test identifier test9
    And Navigated to form board update font in profile page
    And change colour and font size of 'Bom Table Font' in formboard
    And Navigated to quickstart project
    And harness with name 'bom table fonts' is launched successfully
    And based on drawing orchestrator components are created
    And Place 'bom' table in harness
    And click Update fonts
    And Change font size and colour in the task for 'bom font'
    Then Check 'bom table' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    Then Check 'bom table' is as per updated font size and font colour in the formboard
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'bom table fonts' successfully

  Scenario: Test verify manufacturing table font
    And test data config loaded for test identifier test102
    And Navigated to form board update font in profile page
    And change colour and font size of 'Manufacturing Table Font' in formboard
    And Navigated to quickstart project
    And harness with name 'Manufacturing table fonts' is launched successfully
    And based on drawing orchestrator components are created
    And Place 'manufacturing' table in harness
    And click Update fonts
    And Change font size and colour in the task for 'manufacturing table font'
    Then Check 'manufacturing table' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    Then Check 'manufacturing table' is as per updated font size and font colour in the formboard
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Manufacturing table fonts' successfully

  Scenario: Test verify wire table font
    And test data config loaded for test identifier test102
    And Navigated to form board update font in profile page
    And change colour and font size of 'Wire Table Font' in formboard
    And Navigated to quickstart project
    And harness with name 'Wire table fonts' is launched successfully
    And based on drawing orchestrator components are created
    And Place 'wire' table in harness
    And click Update fonts
    And Change font size and colour in the task for 'wire table font'
    Then Check 'wire table' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    Then Check 'wire table' is as per updated font size and font colour in the formboard
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Wire table fonts' successfully

  Scenario: Test verify revision table font
    And test data config loaded for test identifier test102
    And Navigated to harness update font in profile page
    And Change font size in profile and capture the font size in 'revision' 'harness'
    And Save the profile settings
    And Navigated to quickstart project
    And harness with name 'Revision table fonts' is launched successfully
    And based on drawing orchestrator components are created
    And Place 'revision' table in harness
    And click Update fonts
    And Change font size and colour in the task for 'revision table font'
    Then Check 'revision table' is as per updated font size and font colour in the task
    And User exits the drawing page
    And User deletes Harness 'Wire table fonts' successfully

  Scenario: Test verify variant table font
    And test data config loaded for test identifier test13
    And Navigated to form board update font in profile page
    And change colour and font size of 'Variant Table Font' in formboard
    And Save the profile settings
    And Navigated to quickstart project
    And harness with name 'Variant table fonts' is launched successfully
    And based on drawing orchestrator components are created
    And Place 'variant' table in harness
    And click Update fonts
    And Change font size and colour in the task for 'variant table font'
    Then Check 'variant table' is as per updated font size and font colour in the task
    And User exits the drawing page
    And User deletes Harness 'Variant table fonts' successfully

  Scenario:To verify connector discrete components font size and colour
    And Navigated to form board update font in profile page
    And change colour and font size of 'Discrete Components' in formboard
    And Navigated to quickstart project
    And harness with name 'connector discrete components' is launched successfully
    And test data config loaded for test identifier test10
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And update discrete components values in properties
    And click Update fonts
    And Change font size and colour in the task for 'discrete font'
    Then Check 'discrete font' is as per updated font size and font colour in the task
    And User exits the drawing page
    And Accept alert
    And Generating Formboard
    Then Check 'discrete font' is as per updated font size and font colour in the formboard
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'connector discrete components' successfully