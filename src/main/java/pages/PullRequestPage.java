package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PullRequestPage extends AbstractPage {

    @FindBy(xpath = "//button//span[text()='Merge pull request']")
    private WebElement mergePullRequestButton;

    @FindBy(xpath = "//h3[text()='No conflicts with base branch']")
    private WebElement noConflictsLabel;

    @FindBy(xpath = "//button//span[text()='Confirm merge']")
    private WebElement confirmMergeButton;

    @FindBy(xpath = "//button//span[text()='Delete branch']")
    private WebElement deleteBranchButton;

    @FindBy(xpath = "//button[normalize-space()='Restore branch']")
    private WebElement restoreBranchButton;

    @Override
    protected void waitUntilLoaded() {
//        waitUntilElementIsVisible(personAccountLink);
    }

    public PullRequestPage merge() {
        waitForSeconds(5);
        refreshCurrentPage();
        waitUntilElementIsVisible(noConflictsLabel, 60);
        waitUntilElementIsVisible(mergePullRequestButton);
        mergePullRequestButton.click();
        return this;
    }

    public PullRequestPage deleteBranch() {
        waitUntilElementIsVisible(deleteBranchButton);
        deleteBranchButton.click();
        return this;
    }

    public PullRequestPage confirmMerge() {
        waitUntilElementIsVisible(confirmMergeButton, 30);
        confirmMergeButton.click();
        return this;
    }

    public boolean isRestoreBranchButtonShown() {
        return waitUntilElementIsVisible(restoreBranchButton);
    }
}
