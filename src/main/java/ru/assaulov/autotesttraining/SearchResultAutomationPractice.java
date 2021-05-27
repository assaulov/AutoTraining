package ru.assaulov.autotesttraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultAutomationPractice extends BasePageAutomationPractice {

    private String itemToSearch;

    public SearchResultAutomationPractice(WebDriver chromeDriver, int waitSeconds) {
        super(chromeDriver, waitSeconds);
    }

    public String getItemToSearch() {
        return itemToSearch;
    }

    public WebElement getCardWithItem(String itemName) {
        this.itemToSearch = itemName;
        String selectorOneCardOfSearchResult= "//div[@class='product-container']//a[contains(text(),'"+itemToSearch+"')]";
        return chromeDriver.findElement(By.xpath(selectorOneCardOfSearchResult));
    }
}

