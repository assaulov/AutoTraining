package ru.assaulov.autotesttraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageAutomationPractice {

    protected WebDriver chromeDriver;

    public WebDriver getChromeDriver() {
        return chromeDriver;
    }

    protected WebDriverWait webDriverWait;

    public BasePageAutomationPractice(WebDriver chromeDriver, int waitSeconds) {
        this.chromeDriver = chromeDriver;
        this.webDriverWait = new WebDriverWait(chromeDriver, waitSeconds);
    }

    public void search(String itemToSearch){
        String selectorSearchBar = "//input[contains(@placeholder,'Search' )]";
        WebElement searchBar = chromeDriver.findElement(By.xpath(selectorSearchBar));
        searchBar.sendKeys(itemToSearch);
    }

    public void clickButton(String buttonName){
        String selectorButtonWithSpan = "//span[text()='"+ buttonName+ "']/..";
        WebElement buttonWithSpan = chromeDriver.findElement(By.xpath(selectorButtonWithSpan));
        buttonWithSpan.click();
    }
}
