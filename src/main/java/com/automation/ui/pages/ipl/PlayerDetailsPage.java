package com.automation.ui.pages.ipl;

import com.automation.ui.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayerDetailsPage extends BasePage {

    @FindBy(xpath = "//div[@class='plyr-name-nationality']/h1")
    private WebElement playerNameElement;

    public boolean isPlayerNameDisplayed(String playerName) {
        return playerNameElement.getText().equals(playerName);
    }
}
