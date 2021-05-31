package ru.assaulov.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddItemStepDefs {

   @When("Навести курсор на карточку с товаром {string} и нажать на кнопку {string}")
    public void навестиКурсорНаКарточкуСТоваромBlouseИНажатьНаКнопкуAddToCart() {
    }

    @Then("Появится сообщение {string}")
    public void появитсяСообщениеProductSuccessfullyAddedToYourShoppingCart() {
    }
}
