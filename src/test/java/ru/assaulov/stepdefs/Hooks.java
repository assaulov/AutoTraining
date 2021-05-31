package ru.assaulov.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        Files.walk(Paths.get("D:\\Education\\Test Automation\\AutoTraining\\allure-report"))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(File::delete);

        Files.walk(Paths.get("D:\\Education\\Test Automation\\AutoTraining\\allure-results"))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(File::delete);

        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        chromeDriver= new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(chromeDriver,30);
    }

   /* @After
    public void laptopsTearDown()
    {
        chromeDriver.quit();
    }*/
}
