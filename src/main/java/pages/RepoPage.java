package pages;

import config.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepoPage extends AbstractPage{

    @FindBy(id = "your-repos-filter")
    private WebElement searchField;

    @Override
    protected void waitUntilLoaded() {
//        waitUntilElementIsVisible(personAccountLink);
    }

    public RepoPage searchProject(String projName) {
        searchField.sendKeys(projName);
        return this;
    }

    public ProjPage clickOnSearchedProject() {
        Browser.getDriver().findElement(By.xpath("//a[normalize-space()='eStore']")).click();
        return new ProjPage();
    }
}
