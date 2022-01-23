package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends AbstractTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void beforeActions() {
        loginPage = AbstractTest.browser.openLoginPage();
    }

    @Test
    public void testLogin() {
        homePage = loginPage.login("anton.mikolaenko@gmail.com", "FromScratch");
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login is failed.");
    }

    @Test(priority = 1)
    public void testLogin2() {
        homePage = loginPage.login("anton.mikolaenko@gmail.com", "FromScratch");
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login is failed.");
    }
}
