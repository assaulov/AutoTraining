package ru.assaulov.steps;

import io.qameta.allure.Step;
import ru.assaulov.autotesttraining.BasePageAutomationPractice;

public class AddItemSteps {
    @Step
    public static void addItemToCart(BasePageAutomationPractice automationPractice, String itemName, String buttonName){
        automationPractice.chooseItemToCard(itemName,buttonName);
    }
}
