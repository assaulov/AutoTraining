package ru.assaulov.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private static WebDriver chromeDriver;
    private static WebDriverWait webDriverWait;

    public static WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public static WebDriver getChromeDriver() {
        return chromeDriver;
    }

    @Before
    public void settings() throws IOException {

        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(chromeDriver,30);
    }


    @After
    public void laptopsTearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            Allure.addAttachment("Failed!", new ByteArrayInputStream(((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES)));
        }
        chromeDriver.quit();
    }

}
