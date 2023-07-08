package com.automation.ui.step_definitions.ipl;

import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.ipl.HomePage;
import com.automation.ui.step_definitions.common.BaseSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class HomePageSteps extends BaseSteps {

    HomePage homePage = getPageObject(HomePage.class);

    public HomePageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("IPL Home page is opened")
    public void iplHomePageIsOpened() {
        Assertions.assertThat(homePage.getTitle()).isEqualTo("Indian Premier League Official Website");
    }

    @When("Navigate to STATS in Header")
    public void navigateToSTATSInHeader() {
        homePage.clickElement("Header - STATS");
    }
}
