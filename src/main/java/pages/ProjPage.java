package pages;

import config.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjPage extends AbstractPage {

    @FindBy(xpath = "//span[text()='README']/ancestor::div//button[@title='Edit file']")
    private WebElement editButton;

    @Override
    protected void waitUntilLoaded() {
//        waitUntilElementIsVisible(personAccountLink);
    }

    public EditProjPage editReadMe() {
        waitUntilElementIsVisible(editButton);
        editButton.click();
        return new EditProjPage();
    }
}
