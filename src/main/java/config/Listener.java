package config;

import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static config.Browser.getDriver;

public class Listener extends AllureTestNg {
    @Override
    public void onTestFailure(ITestResult result) {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment(file.getName(), new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.onTestFailure(result);
    }
}
