package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenPullRequestPage extends AbstractPage {

    @FindBy(xpath = "//button/span[text()='Create pull request']")
    private WebElement createPullRequestButton;

    @Override
    protected void waitUntilLoaded() {
//        waitUntilElementIsVisible(personAccountLink);
    }

    public PullRequestPage clickCreatePullRequestButton() {
        waitUntilElementIsVisible(createPullRequestButton, 60);
        createPullRequestButton.click();
        return new PullRequestPage();
    }
}
