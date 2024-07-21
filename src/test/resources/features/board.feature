@wip
Feature: Creating a new board on Trello

  Background:
    Given User logged in with valid credentials and is on the Trello home page


  Scenario: Successfully create a new board
    When the user clicks the "+ or Create" tab
    And selects "Create Board" from the dropdown
    Then the "Create Board" window should be visible
    When the user enters "Board Title" in the Board title input field
    And the "Create" button should be active
    When the user clicks the "Create" button
    Then the user should be redirected to the new board page
    And the created board "Created Board" should be visible






