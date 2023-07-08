package com.automation.ui.pages.ipl;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.ElementName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatsPage extends BasePage {

    @ElementName("Stats - Record Tabs")
    @FindBy(xpath = "//div[@class='np-recordTab--title']")
    private WebElement recordTab;

    @ElementName("Stats - Type Filter")
    @FindBy(xpath = "//div[@class='customSelecBox statsTypeFilter']")
    private WebElement typeFilterDropdown;

}
