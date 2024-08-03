
@list @ui
Feature: Creating a new list on a board


  Scenario: A new list on a board
    Given User logged in with valid credentials and is on the Trello home page
    Given user is inside the created board named as "TrelloAutomationTests"
    When user adds a list and enters the title of the list as "UATInProgress"
    And user clicks on add list button
    Then user should see the latest created list with the name "UATInProgress"
