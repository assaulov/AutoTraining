package ru.assaulov.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.assaulov.autotesttraining.BasePageAutomationPractice;
import ru.assaulov.steps.AddItemSteps;

public class AddItemStepDefs {

  BasePageAutomationPractice basePageAutomationPractice = new BasePageAutomationPractice(Hooks.getChromeDriver(), 30);

   @When("Навести курсор на карточку с товаром {string} и нажать на кнопку {string}")
    public void навестиКурсорНаКарточкуСТоваромBlouseИНажатьНаКнопкуAddToCart(String itemName, String buttonName) {
    basePageAutomationPractice.chooseItemToCard(itemName,buttonName);
    }

    @Then("Появится сообщение {string}")
    public void появитсяСообщениеProductSuccessfullyAddedToYourShoppingCart() {
    }
}
