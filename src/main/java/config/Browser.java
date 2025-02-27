package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

public class Browser {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static String originUrl = "https://github.com/login";

    public static WebDriver getDriver() {
        if (driver.get() != null) {
            return driver.get();
        }
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        ChromeDriver driver = new ChromeDriver(options);
        driver.set(new ChromeDriver(options));
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
