package pages;

import config.Browser;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Supplier;

public abstract class AbstractPage {
    protected static final long DEFAULT_TIMEOUT_TO_WAIT = 10;

    protected AbstractPage() {
        PageFactory.initElements(Browser.getDriver(), this);
        waitUntilLoaded();
    }

    protected abstract void waitUntilLoaded();

    protected WebDriverWait getWebDriverWait() {
        return getWebDriverWait(DEFAULT_TIMEOUT_TO_WAIT);
    }

    protected WebDriverWait getWebDriverWait(long timeoutInSeconds) {
        return (WebDriverWait) new WebDriverWait(Browser.getDriver(), DEFAULT_TIMEOUT_TO_WAIT)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    protected boolean waitUntilElementIsVisible(WebElement element) {
        return getWebDriverWait().until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
    }
}
