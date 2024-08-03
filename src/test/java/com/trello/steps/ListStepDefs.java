package com.trello.steps;

import com.trello.pages.ListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ListStepDefs {


    ListPage listPage = new ListPage();


    @Given("user is inside the created board named as {string}")
    public void user_is_inside_the_created_board_named_as(String boardTitleName) {
        listPage.createNewBoard(boardTitleName);
    }


    @When("user adds a list and enters the title of the list as {string}")
    public void user_adds_a_list_and_enters_the_title_of_the_list_as(String listName) {
        listPage.inputField.sendKeys(listName);
    }

    @When("user clicks on add list button")
    public void user_clicks_on_add_list_button() {
        listPage.addListButton.click();
    }

    @Then("user should see the latest created list with the name {string}")
    public void user_should_see_the_latest_created_list_with_the_name(String expectedListName) {
        listPage.verifyListName(expectedListName);
    }




}
