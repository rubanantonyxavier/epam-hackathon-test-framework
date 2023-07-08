package com.automation.ui.pages.ipl;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.ElementName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatsPage extends BasePage {

    @ElementName("Stats - Record Tabs")
    @FindBy(xpath = "//div[@class='np-recordTab--title']")
    private WebElement recordTab;

    @ElementName("Dropdown - Type Filter")
    @FindBy(xpath = "//div[@class='customSelecBox statsTypeFilter']")
    private WebElement typeFilterDropdown;

    @ElementName("View All Button")
    @FindBy(xpath = "//div[@class='customSelecBox statsTypeFilter']")
    private WebElement viewAllButton;

    private static final String PLAYER_NAME_XPATH = "//div[text()='<replace_value>']";

    public void selectPlayerByName(String playerName) {
        replaceValueInXpathAndGetWebElement(PLAYER_NAME_XPATH, playerName).click();
    }
}
