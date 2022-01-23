package tests;

import config.Browser;
import org.testng.annotations.AfterSuite;

public class AbstractTest {
    protected static final Browser browser = new Browser();

    @AfterSuite(alwaysRun = true)
    public void afterClass() {
        Browser.closeDriver();
    }
}
