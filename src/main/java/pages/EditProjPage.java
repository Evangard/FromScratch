package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProjPage extends AbstractPage {

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textBox;

    @FindBy(xpath = "//button//span[text()='Commit changes...']")
    private WebElement commitChangesButton;

    @FindBy(xpath = "//input[@value='pr']")
    private WebElement createNewBranchButton;

    @FindBy(xpath = "//button//span[text()='Propose changes']")
    private WebElement proposeChangesButton;

    @Override
    protected void waitUntilLoaded() {
//        waitUntilElementIsVisible(personAccountLink);
    }

    public EditProjPage setText(String text) {
        waitUntilElementIsVisible(textBox, 60);
        textBox.clear();
        textBox.sendKeys(text);
        return this;
    }

    public EditProjPage clickCommitChangesButton() {
        waitUntilElementIsVisible(commitChangesButton);
        commitChangesButton.click();
        return this;
    }

    public EditProjPage clickCreateNewBranchButton() {
        waitUntilElementIsVisible(createNewBranchButton);
        createNewBranchButton.click();
        return this;
    }

    public OpenPullRequestPage clickProposeChangesButton() {
        waitUntilElementIsVisible(proposeChangesButton);
        proposeChangesButton.click();
        return new OpenPullRequestPage();
    }
}
