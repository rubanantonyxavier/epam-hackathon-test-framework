package com.automation.ui.step_definitions.ipl;

import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.ipl.StatsPage;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.utils.RandomUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class StatsPageSteps extends BaseSteps {

    StatsPage statsPage = getPageObject(StatsPage.class);

    public StatsPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("STATS page is opened")
    public void statsPageIsOpened() {
        Assertions.assertThat(statsPage.getTitle()).isEqualTo("Players Stats and Records | IPLT20");
    }

    @When("User clicks {string} radio button in StatsType dropdown and select {string} option")
    public void userClicksRadioButtonInStatsTypeDropdownAndSelectOption(String statsType, String capOption) {

    }

    @Then("{string} is displayed in StatsType dropdown")
    public void isDisplayedInStatsTypeDropdown(String statsType) {

    }

    @When("User clicks 'View All' button")
    public void userClicksButton(String buttonText) {
        statsPage.clickElement("View All Button");
    }

    @And("User capture the Stats of Players")
    public void userCaptureTheStatsOfPlayers() {
        List<Integer> numbers = RandomUtil.getEvenNumbersFromFibonacci(40);

    }

    @And("Select a player based on the response received from API")
    public void selectAPlayerBasedOnTheResponseReceivedFromAPI() {
        String playerName = "Shubman Gill";
        getTempVariables().setPlayerName(playerName);
        statsPage.selectPlayerByName(getTempVariables().getPlayerName());
    }
}
