package com.trello.pages;

import com.trello.utility.BrowserUtilities;
import com.trello.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListPage {


    public ListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    BoardsPage boardsPage = new BoardsPage();
    private static final Logger LOG = LoggerFactory.getLogger(ListPage.class);



    @FindBy(xpath = "//button[@data-testid= 'list-composer-button']")
    public WebElement addAnotherListButton;

    @FindBy(xpath = "//textarea[@data-testid='list-name-textarea']")
    public WebElement inputField;

    @FindBy(xpath = "//button[@data-testid='list-composer-add-list-button']")
    public WebElement addListButton;

    @FindBy(xpath = "//button[@data-testid='list-composer-cancel-button']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@data-testid='list-header']//h2[@data-testid='list-name']")
    public WebElement listName;


    public void verifyListName(String expectedListName) {
        String actualListName = listName.getText();
        try {
            Assert.assertEquals(expectedListName, actualListName);
            LOG.info("List name verification passed: " + actualListName);
        } catch (AssertionError e) {
            LOG.error("List name verification failed: Expected " + expectedListName + " but found " + actualListName);
            throw e; // rethrow to ensure the test fails
        }
    }

    public void createNewBoard(String boardTitleName) {
        try {
            BrowserUtilities.waitForVisibility(boardsPage.createBoardOrWorkspace, 2).click();
            BrowserUtilities.waitForVisibility(boardsPage.createBoardButton, 2).click();
            BrowserUtilities.waitForVisibility(boardsPage.createBoardInput, 2).sendKeys(boardTitleName);
            boardsPage.createButton.click();
            LOG.info("Board creation steps completed.");
        } catch (Exception e) {
            LOG.error("Failed to create a new board", e);
            throw e; // rethrow to ensure the test fails
        }
    }

}
