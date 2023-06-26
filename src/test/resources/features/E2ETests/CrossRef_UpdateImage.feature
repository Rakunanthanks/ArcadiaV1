@E2ENew1
Feature: This feature verifies the Cross Reference Part Updation and Update Image All features
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test15
    And Navigated to 'Aut_Integration' project
    And User imports harness 'CrossRef_UpdateImage'
    And user navigated to newly created harness

  @SchematicToHarness
  Scenario: Verifies that Update Cross Ref is functional
    And User verifies the cross ref for 'manufacture'
    And user verifies the changes made for 'manufacture'
    And User verifies the cross ref for 'Supplier'
    And user verifies the changes made for 'Supplier'

  @SchematicToHarness
  Scenario: Verifies that update image all function is working properly
    And user update the images with loading and side view from image views option
    And user update the images with Mating and catalogue view from image views option
    And user update the images with Top and Isometric view from image views option