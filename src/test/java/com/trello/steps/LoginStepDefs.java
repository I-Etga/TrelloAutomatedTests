package com.trello.steps;

import com.trello.pages.BoardsPage;
import com.trello.pages.LoginPage;
import com.trello.utility.BrowserUtilities;
import com.trello.utility.ConfigurationReader;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    private static final String USERNAME = ConfigurationReader.getProperty("username");
    private static final String PASSWORD = ConfigurationReader.getProperty("password");

    @Given("User logged in with valid credentials and is on the Trello home page")
    public void user_logged_in_with_valid_credentials_and_is_on_the_trello_home_page() {

        BrowserUtilities.waitFor(3);
        loginPage.username.sendKeys(USERNAME + Keys.ENTER);

        BrowserUtilities.waitFor(1);
        loginPage.password.sendKeys(PASSWORD);
        loginPage.loginButton.click();


    }
}
