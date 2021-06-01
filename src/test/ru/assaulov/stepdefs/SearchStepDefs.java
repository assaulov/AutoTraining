package ru.assaulov.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.assaulov.autotesttraining.SearchResultAutomationPractice;
import ru.assaulov.utils.Utils;

import java.io.ByteArrayInputStream;

public class SearchStepDefs {

    SearchResultAutomationPractice searchResultPage = new SearchResultAutomationPractice(Hooks.getChromeDriver(), 30);

    @Given("Главная страница сайта {string}")
    public void mainPage(String URL) {
        Hooks.getChromeDriver().get(URL);

    }

    @When("Ввести в строку поиска {string} и нажать кнопку {string} в виде лупы")
    public void enterRequestInSearchBar(String itemToSearch, String buttonName) {
        searchResultPage.search(itemToSearch);
        Allure.addAttachment("screenSearch", new ByteArrayInputStream(((TakesScreenshot) searchResultPage.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
        searchResultPage.clickSubmitButton(buttonName);    }

    @Then("Появилась карточка с именем {string}")
    public void isFoundItemCorrect(String itemName) {
        String itemActualName = searchResultPage.getCardWithItem(itemName).getText();
        Utils.getScreen(searchResultPage.getChromeDriver(), searchResultPage.getChromeDriver().findElement(By.xpath("//ul[@class='product_list grid row']")));
        Assertions.assertEquals(searchResultPage.getItemToSearch(), itemActualName);    }

}
