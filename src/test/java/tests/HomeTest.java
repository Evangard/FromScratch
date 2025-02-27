package tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.HashMap;
import java.util.Map;

public class HomeTest extends AbstractTest{

    private LoginPage loginPage;
    private HomePage homePage;
    private static final String USER = "Gitguber21";
    private static final String PROJECT = "sore";
    private static final String TOKEN = "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";
    private static Map<String, String> headers = new HashMap<>();

    @BeforeClass
    public void beforeActions() {
//        loginPage = AbstractTest.browser.openLoginPage();
        headers.put("accept", "*/*");
        headers.put("Authorization", String.format("Bearer %s", TOKEN));
    }
//
//    @Test
//    public void checkHomePage() {
//        homePage = loginPage.login("anton.mikolaenko@gmail.com", "FromScratch");
//        Assert.assertTrue(homePage.isUserLoggedIn(), "Login is failed.");
//    }
//
//    @Test(dependsOnMethods = "checkHomePage")
//    public void checkPersonAccountLink() {
//        Assert.assertTrue(homePage.isPersonAccountLink(), "Person account link should be shown.");
//    }

    @Test
    public void createIssueTest() {
        for (int i = 81; i<105; i++) {
            JSONObject obj = new JSONObject();
            obj.put("title", "Test issue " + i);
            createIssue(obj, headers);
        }
    }

    @Test
    public void addStarTest() {
        for (int i = 1; i<100; i++) {
            addStar(headers);
        }
    }

    @Test
    public void createProjectTest() {
        for (int i = 1; i<100; i++) {
            JSONObject obj = new JSONObject();
            obj.put("name", String.format("My_project_%s", i));
            obj.put("description", String.format("My project %s", i));
            createProject(obj, headers);
        }
    }

    private HttpResponse<JsonNode> createIssue(JSONObject obj, Map<String, String> headers) {
        HttpResponse<JsonNode> request = null;
        try {
            request = Unirest.post(String.format("https://api.github.com/repos/%s/%s/issues", USER, PROJECT))
                    .headers(headers)
                    .body(obj)
                    .asJson();
        } catch (Exception e) {
            System.out.println(request.getStatus());
        }
        return request;
    }

    private HttpResponse<JsonNode> addStar(Map<String, String> headers) {
        HttpResponse<JsonNode> request = null;
        try {
            request = Unirest.put(String.format("https://api.github.com/user/starred/%s/%s", USER, PROJECT))
                    .headers(headers)
                    .asJson();
        } catch (Exception e) {

        }
        return request;
    }

    private HttpResponse<JsonNode> createProject(JSONObject obj, Map<String, String> headers) {
        HttpResponse<JsonNode> request = null;
        try {
            request = Unirest.post(String.format("https://api.github.com/%s/repos", USER))
                    .headers(headers)
                    .body(obj)
                    .asJson();
        } catch (Exception e) {

        }
        return request;
    }
}
