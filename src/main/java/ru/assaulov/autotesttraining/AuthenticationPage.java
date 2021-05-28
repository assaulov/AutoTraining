package ru.assaulov.autotesttraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage extends BasePageAutomationPractice {


    public AuthenticationPage(WebDriver chromeDriver, int waitSeconds) {
        super(chromeDriver, waitSeconds);
    }

    public WebElement getNamePage() {
        String namePageSelector = "//h1[@class='page-heading']";
        return chromeDriver.findElement(By.xpath(namePageSelector));
    }

    public void inputDataInField(String formName, String fieldName, String data){
        String selectorField = String.format("//form[contains(*,'%s')]//label[contains(text(), '%s')]/following-sibling::input", formName, fieldName);
        WebElement inputField = chromeDriver.findElement(By.xpath(selectorField));
        inputField.sendKeys(data);
    }

}
