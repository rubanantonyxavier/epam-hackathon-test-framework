package com.automation.ui.step_definitions.ipl;

import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.ipl.PlayerDetailsPage;
import com.automation.ui.step_definitions.common.BaseSteps;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerDetailsPageSteps extends BaseSteps {

    PlayerDetailsPage playerDetailsPage = getPageObject(PlayerDetailsPage.class);

    public PlayerDetailsPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("Selected Player details page is displayed")
    public void selectedPlayerDetailsPageIsDisplayed() {
        String playerName = "Shubman Gill";
        assertThat(playerDetailsPage.isPlayerNameDisplayed(playerName)).isTrue();
    }
}
