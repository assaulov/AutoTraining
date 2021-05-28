package ru.assaulov.autotesttraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BasePageAutomationPractice {



    public AuthenticationPage(WebDriver chromeDriver, int waitSeconds) {
        super(chromeDriver, waitSeconds);
    }




    public WebElement getNamePage() {
        String namePageSelector = "//h1[@class='page-heading']";
        WebElement namePage =new WebDriverWait(chromeDriver, 30).until(ExpectedConditions.visibilityOf((chromeDriver.findElement(By.xpath(namePageSelector)))));
        if(namePage.isDisplayed())
            return namePage;
        return null;
    }

    public void inputDataInField(String formName, String fieldName, String data){
        String selectorField = String.format("//form[contains(*,'%s')]//label[contains(text(), '%s')]/following-sibling::input", formName, fieldName);
        WebElement inputField = chromeDriver.findElement(By.xpath(selectorField));
        inputField.sendKeys(data);
        inputField.click();
    }

}
