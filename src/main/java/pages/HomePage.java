package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static config.Browser.*;

public class HomePage extends AbstractPage{

    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement personAccountLink;

    @Override
    protected void waitUntilLoaded() {
        waitUntilElementIsVisible(personAccountLink);
    }

    public boolean isUserLoggedIn() {
        return personAccountLink.isDisplayed();
    }
}
