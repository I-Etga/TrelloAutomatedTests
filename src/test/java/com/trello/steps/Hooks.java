package com.trello.steps;

import com.trello.utility.ConfigurationReader;
import com.trello.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {

    private static final String URL = ConfigurationReader.getProperty("url");
    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);

    @Before("@api or @db")
    public void beforeScenario(Scenario scenario) {
        LOG.info("Scenario: " + scenario.getName() + "-> line: "+ scenario.getLine());
    }

    @Before("@ui")
    public void beforeScenarioUI(Scenario scenario) {
        LOG.info("Scenario: " + scenario.getName() + "-> line: "+ scenario.getLine());
        LOG.info(ConfigurationReader.getProperty("browser").toUpperCase() + " BROWSER OPENING");
        Driver.getDriver().get(URL);

    }

    @After("@ui")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        LOG.info("BROWSER CLOSING...");
        Driver.closeDriver();

    }
}
