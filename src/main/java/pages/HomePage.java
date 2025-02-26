package pages;

import config.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static config.Browser.getURL;

public class HomePage extends AbstractPage{

    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement personAccountLink;

    @Override
    protected void waitUntilLoaded() {
//        waitUntilElementIsVisible(personAccountLink);
    }

    public boolean isUserLoggedIn() {
        return personAccountLink.isDisplayed();
    }

    public boolean isPersonAccountLink() {
        return personAccountLink.isDisplayed();
    }

    public RepoPage openRepositories(String username) {
       Browser.getDriver().get(String.format("https://github.com/%s?tab=repositories", username));
       return new RepoPage();
    }

    public ProjPage openProject(String userName, String projectName) {
        Browser.getDriver().get(String.format("https://github.com/%s/%s", userName, projectName));
        return new ProjPage();
    }

    public EditProjPage editReadmeFile(String userName, String projectName) {
        Browser.getDriver().get(String.format("https://github.com/%s/%s/edit/main/README.md", userName, projectName));
        return new EditProjPage();
    }
}
