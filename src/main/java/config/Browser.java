package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class Browser {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static String originUrl = "https://www.butlers.ua/ua/login";

    public static WebDriver getDriver() {
        if (driver.get() != null) {
            return driver.get();
        }
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
        return driver.get();
    }

    public static String getURL() {
        return originUrl;
    }

    public LoginPage openLoginPage() {
        getDriver().get(getURL());
        return new LoginPage();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
