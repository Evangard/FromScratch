package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends AbstractTest{

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void beforeActions() {
        loginPage = AbstractTest.browser.openLoginPage();
    }

    @Test
    public void checkHomePage() {
        homePage = loginPage.login("anton.mikolaenko@gmail.com", "FromScratch");
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login is failed.");
    }
}
