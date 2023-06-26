@E2E
Feature: Verify harness created from schematic can be restructured
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test15
    And Navigated to 'Aut_Integration' project
    And User imports harness 'SchematicHarness_Restructuring'
    And user navigated to newly created harness

  @SchematicToHarness
  Scenario: Verifies that Harness can be restructured
    And user move the whole drawing relatively to have every component inside frame
    And User click on Auto Arrange button to arrange the components
    And User toggle on the splice images for all the splices
    And User move the splice images to restructure the harness
    And user change select the Show to locations from context menu of splice
    And user scale up the image size for some components
    And user move wire leads to restructure the wire linked to components
    And user toggle on the connector label option for all connectors
    And User add the label to connector label from config page 'macro' ''
    And user add the wire table in the new frame adjacent to existing frame
    And user updates wiretable
    And user made some changes in wires connected to components
    And changes should be visible in wire table