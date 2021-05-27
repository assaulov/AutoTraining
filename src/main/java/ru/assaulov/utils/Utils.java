package ru.assaulov.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

    @Attachment
    public static byte[] getScreen(WebDriver chromeDriver){
        File screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/main/resources/screen.png"));
            return Files.readAllBytes(Paths.get("src/main/resources/", "screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Attachment
    public static void getScreen(WebDriver chromeDriver, WebElement element){
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(element).build().perform();
        Allure.addAttachment("screen", new ByteArrayInputStream(((TakesScreenshot) element).getScreenshotAs(OutputType.BYTES)));
    }
}
