package com.automation.ui.pages.ipl;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.ElementName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @ElementName("Header - STATS")
    @FindBy(xpath = "//a[@data-element_text='STATS']")
    private WebElement statsHeaderTab;

}
