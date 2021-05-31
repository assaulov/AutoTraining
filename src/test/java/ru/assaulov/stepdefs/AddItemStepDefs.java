package ru.assaulov.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import ru.assaulov.autotesttraining.BasePageAutomationPractice;

public class AddItemStepDefs {

  BasePageAutomationPractice basePageAutomationPractice = new BasePageAutomationPractice(Hooks.getChromeDriver(), 30);

   @When("Навести курсор на карточку с товаром {string} и нажать на кнопку {string}")
    public void навестиКурсорНаКарточкуСТоваромBlouseИНажатьНаКнопкуAddToCart(String itemName, String buttonName) {
    basePageAutomationPractice.chooseItemToCard(itemName,buttonName);
    }

    @Then("Появится сообщение {string}")
    public void появитсяСообщениеProductSuccessfullyAddedToYourShoppingCart(String message) {
    WebElement cart = basePageAutomationPractice.itemSuccessAddedToCart();
    Assertions.assertTrue(cart.getText().contains(message));
    }
}
