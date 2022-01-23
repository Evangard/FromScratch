package pages;

import org.bouncycastle.pqc.crypto.ExchangePair;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//input[@class='email']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@class='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div/input[@type='submit']")
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
