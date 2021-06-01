package ru.assaulov.autotesttraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePageAutomationPractice {

    protected WebDriver chromeDriver;
    protected WebDriverWait webDriverWait;

    public BasePageAutomationPractice(WebDriver chromeDriver, int waitSeconds) {
        this.chromeDriver = chromeDriver;
        this.webDriverWait = new WebDriverWait(chromeDriver, waitSeconds);
    }

    public WebDriver getChromeDriver() {
        return chromeDriver;
    }

    public void search(String itemToSearch){
        String selectorSearchBar = "//input[contains(@placeholder,'Search' )]";
        WebElement searchBar = chromeDriver.findElement(By.xpath(selectorSearchBar));
        searchBar.sendKeys(itemToSearch);
    }

    public void clickSubmitButton(String buttonName){
        String selectorButtonWithSpan = "//button[@type='submit' and contains(., '"+buttonName+"')]";
        WebElement buttonWithSpan = chromeDriver.findElement(By.xpath(selectorButtonWithSpan));
       buttonWithSpan.click();
    }

    public void clickHrefButton(String buttonName) {
        String selectorButtonWithHref = "//a[contains(text(),'"+ buttonName+"')]";
        WebElement buttonWithHref = chromeDriver.findElement(By.xpath(selectorButtonWithHref));
        buttonWithHref.click();
    }

    public void chooseItemToCard(String itemName, String buttonName){
        String selectorItemCard = "//li//div[@class='product-container' and .//a[contains(.,'"+itemName+"')]]";
        String selectorButton = "//a[@title='"+buttonName+"']";
        Actions actions = new Actions(chromeDriver);
        WebElement itemCart = chromeDriver.findElement(By.xpath(selectorItemCard));
        WebElement button = chromeDriver.findElement(By.xpath(selectorItemCard+selectorButton));
        actions.moveToElement(itemCart).moveToElement(button).click().build().perform();
    }

    public WebElement itemSuccessAddedToCart(){
        String cartSelector = "(//div[@class='clearfix'])[1]";
        return new WebDriverWait(chromeDriver,10).until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath(cartSelector))));
    }
}
