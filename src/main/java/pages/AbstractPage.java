package pages;

import config.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Supplier;

public abstract class AbstractPage {
    protected static final int DEFAULT_TIMEOUT_TO_WAIT = 10;

    protected AbstractPage() {
        PageFactory.initElements(Browser.getDriver(), this);
        waitUntilLoaded();
    }

    protected abstract void waitUntilLoaded();

//    protected WebDriverWait getWebDriverWait() {
//        return getWebDriverWait(DEFAULT_TIMEOUT_TO_WAIT);
//    }
//
//    protected WebDriverWait getWebDriverWait(long timeoutInSeconds) {
//        return (WebDriverWait) new WebDriverWait(Browser.getDriver(), DEFAULT_TIMEOUT_TO_WAIT)
//                .pollingEvery(Duration.ofMillis(500))
//                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(StaleElementReferenceException.class);
//    }

    public static FluentWait<WebDriver> getWebDriverWait() {
        return getWebDriverWait(DEFAULT_TIMEOUT_TO_WAIT);
    }

    public static FluentWait<WebDriver> getWebDriverWait(int timeInSeconds) {
        return new FluentWait<>(Browser.getDriver()).withTimeout(Duration.ofSeconds(timeInSeconds))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    protected boolean waitUntilElementIsVisible(WebElement element) {
        return getWebDriverWait().until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
    }

    protected boolean waitUntilElementIsVisible(WebElement element, int timeout) {
        return getWebDriverWait(timeout).until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
    }

    public final void refreshCurrentPage() {
        Browser.getDriver().navigate().refresh();
    }

    public static void waitForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
