package com.trello.steps;

import com.trello.pages.BoardsPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class BoardStepDefs {

    BoardsPage boardsPage = new BoardsPage();


    @When("the user clicks the {string} tab")
    public void the_user_clicks_the_tab(String string) {
        boardsPage.createBoardOrWorkspace.click();
    }

    @When("selects {string} from the dropdown")
    public void selects_from_the_dropdown(String string) {
        boardsPage.createBoardButton.click();
    }

    @Then("the {string} window should be visible")
    public void the_window_should_be_visible(String str) {
        Assert.assertTrue("Create board window is not displayed!", boardsPage.createBoardWindow.isDisplayed());
    }

    @When("the user enters {string} in the Board title input field")
    public void the_user_enters_in_the_board_title_input_field(String boardTitleName) {
        boardTitleName = "TrelloAutomationTests";
        boardsPage.createBoardInput.sendKeys(boardTitleName);
    }

    @When("the {string} button should be active")
    public void the_button_should_be_active(String string) {
        Assert.assertTrue(boardsPage.createBoardButton.isEnabled());
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        boardsPage.createBoardButton.click();
    }

    @Then("the user should be redirected to the new board page")
    public void the_user_should_be_redirected_to_the_new_board_page() {
        boardsPage.BoardElement.isDisplayed();
    }

    @Then("the created board {string} should be visible")
    public void the_created_board_should_be_visible(String string) {
        Assert.assertTrue(boardsPage.yourBoardsBoardElement.isDisplayed());
    }
}
