package ru.assaulov.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import ru.assaulov.autotesttraining.BasePageAutomationPractice;

import java.io.ByteArrayInputStream;

public class AddItemStepDefs {

  BasePageAutomationPractice basePageAutomationPractice = new BasePageAutomationPractice(Hooks.getChromeDriver(), 30);

   @When("Навести курсор на карточку с товаром {string} и нажать на кнопку {string}")
    public void chooseItemToCart(String itemName, String buttonName) {
    basePageAutomationPractice.chooseItemToCard(itemName,buttonName);
    }

    @Then("Появится сообщение {string}")
    public void isItemAddedToCart(String message) {
    WebElement cart = basePageAutomationPractice.itemSuccessAddedToCart();
     Allure.addAttachment(cart.findElement(By.xpath("//span[@class='product-name']")).getText(), new ByteArrayInputStream(((TakesScreenshot) Hooks.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
     Assertions.assertTrue(cart.getText().contains(message));
    }
}
