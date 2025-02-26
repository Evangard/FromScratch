package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    @FindBy(id = "login_field")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    public HomePage login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        submitButton.click();
        return new HomePage();
    }

    public void enterUserName(String userName) {
        waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
    }

    @Override
    protected void waitUntilLoaded() {

    }
}
