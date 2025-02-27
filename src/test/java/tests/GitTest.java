package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PullRequestPage;

public class GitTest extends AbstractTest {

    private HomePage homePage;
    private PullRequestPage pullRequestPage;
    private static final String USER = "Evangard";
    private static final String PASS = "Sal_2025";
    private static final String PROJECT_NAME = "AQACourse";

    @BeforeClass
    public void beforeActions() {
        homePage = AbstractTest.browser.openLoginPage().login(USER, PASS);
    }

//    @Test
//    public void happyPass() {
//        homePage = loginPage.login("anton.mikolaenko@gmail.com", "FromScratch");
//        Assert.assertTrue(homePage.isUserLoggedIn(), "Login is failed.");
//    }
//
//    @Test()
//    public void unHappyPass() {
//        homePage = loginPage.login("anton.mikolaenko@gmail.com", "FromScratch");
//        Assert.assertTrue(homePage.isUserLoggedIn(), "Login is failed.");
//    }

    @Test(dataProvider = "attempts")
    public void test1(int att) {
        pullRequestPage = homePage
                .editReadmeFile(USER, PROJECT_NAME)
                .setText("Text " + att)
                .clickCommitChangesButton()
                .clickCreateNewBranchButton()
                .clickProposeChangesButton()
                .clickCreatePullRequestButton()
                .merge()
                .confirmMerge()
                .deleteBranch();
        Assert.assertTrue(pullRequestPage.isRestoreBranchButtonShown(), "Restore branch button should be shown.");
    }

    @DataProvider(name = "attempts")
    public static Object[][] attempts() {

        return new Object[][]{
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10},
                {11},
                {12},
                {13},
                {14},
                {15},
                {16},
                {17},
                {18},
                {19},
                {20}
        };
    }
}
