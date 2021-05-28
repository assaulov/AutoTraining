package ru.assaulov.autotesttraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage extends BasePageAutomationPractice {

    private final String namePageSelector = "//span[contains(text(),'Authentication')]";

    private final WebElement namePage;
    private WebElement inputField;

    public AuthenticationPage(WebDriver chromeDriver, int waitSeconds) {
        super(chromeDriver, waitSeconds);
        this.namePage = chromeDriver.findElement(By.xpath(namePageSelector));
    }

    public WebElement getNamePage() {
        return namePage;
    }

    public void inputDataInField(String formName, String fieldName, String data){
        String selectorField = String.format("//form[contains(*,'%s')]//label[contains(text(), '%s')]/following-sibling::input", formName, fieldName);
        inputField = chromeDriver.findElement(By.xpath(selectorField));
        inputField.sendKeys(data);
    }

}
