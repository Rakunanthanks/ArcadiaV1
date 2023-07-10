@updateImageViews @Regression
  Feature: Update Image Views
    Background: User is Logged In
      Given I'm on Arcadia test environment
      And Navigated to quickstart project
      And harness with name 'Update image views and scale' is launched successfully

    Scenario: Test verifies to update connector image views and image scale for connector
      And test data config loaded for test identifier test107
      And based on drawing orchestrator components are created
      And Image view is opened
      And click checkbox of views and scale
      And user select checkbox image 'loading' and sets image scale size as '3'
      Then Check whether image view and image scale of '3' of connector
      And Image view is opened
      And user select checkbox image 'mating' and sets image scale size as '4'
      Then Check whether image view and image scale of '4' of connector
      And Image view is opened
      And user select checkbox image 'top' and sets image scale size as '5'
      Then Check whether image view and image scale of '5' of connector
      And Image view is opened
      And user select checkbox image 'isometric' and sets image scale size as '6'
      Then Check whether image view and image scale of '6' of connector
      And Image view is opened
      And user select checkbox image 'catalogue' and sets image scale size as '7'
      Then Check whether image view and image scale of '7' of connector
      And Image view is opened
      And user select checkbox image 'side' and sets image scale size as '8'
      Then Check whether image view and image scale of '8' of connector
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Update image views and scale' successfully

    Scenario: Test verifies to update terminal image views and image scale for connector
      And test data config loaded for test identifier test107
      And based on drawing orchestrator components are created
      And 'connectorplug' component with index '0' is opened
      And user add terminal to the placed connector and terminal image display
      And Image view is opened
      And click checkbox of views and scale
      And user select checkbox terminal image 'top' view and image scale as '3'
      Then check whether terminal image is matching as per the expected image scale '3' or not
      And Image view is opened
      And user select checkbox terminal image 'isometric' view and image scale as '4'
      Then check whether terminal image is matching as per the expected image scale '4' or not
      And Image view is opened
      And user select checkbox terminal image 'catalogue' view and image scale as '5'
      Then check whether terminal image is matching as per the expected image scale '5' or not
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Update image views and scale' successfully

    Scenario: Test verifies to update splice image scale
      And test data config loaded for test identifier test11
      And based on drawing orchestrator components are created
      And 'splice' component with index '0' is opened
      And assign part number to splice as '19164-0044'
      And Image view is opened
      And click checkbox of views and scale
      And user select checkbox for default splice view 'top' and image scale as '3'
      And check whether splice view and image scale as '3'
      And Image view is opened
      And user select checkbox for default splice view 'isometric' and image scale as '4'
      And check whether splice view and image scale as '4'
      And Image view is opened
      And user select checkbox for default splice view 'catalogue' and image scale as '5'
      And check whether splice view and image scale as '5'
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Update image views and scale' successfully

    Scenario: Test verifies to update seal image scale
      And test data config loaded for test identifier test108
      And based on drawing orchestrator components are created
      And 'connectorplug' component with index '0' is opened
      And user add seal to the placed connector and terminal image display
      And Image view is opened
      And click checkbox of views and scale
      And user select checkbox for default seal view 'top' and image scale as '3'
      And check whether seal view and image scale as '3'
      And Image view is opened
      And user select checkbox for default seal view 'isometric' and image scale as '4'
      And check whether seal view and image scale as '4'
      And Image view is opened
      And user select checkbox for default seal view 'catalogue' and image scale as '5'
      And check whether seal view and image scale as '5'
      And Image view is opened
      And user select checkbox for default seal view 'none' and image scale as 'none'
      And check whether seal view and image scale as 'none'
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Update image views and scale' successfully




