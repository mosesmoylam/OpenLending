package com.openLending.pages;

import com.openLending.utilities.Driver;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

@Getter
@Setter
public class DuplicateBlogTestPage {

    @FindBy(name = "q")
    private static WebElement searchBox;

    @FindBy(xpath = "//a[@href='https://www.openlending.com/']")
    private WebElement openLendingLink;

    @FindBy(linkText = "Resources")
    private WebElement resourcesPage;

    @FindBy(linkText = "Insights")
    private WebElement insightsPage;

    @FindBy(xpath = "//*[@id=\"featured-box-section\"]//ul//a")
    private List<WebElement> blogsList;

    public WebElement getSearchBox() {
        return searchBox;
    }

    public DuplicateBlogTestPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}




