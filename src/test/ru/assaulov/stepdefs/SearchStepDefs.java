package ru.assaulov.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.assaulov.autotesttraining.SearchResultAutomationPractice;
import ru.assaulov.steps.Steps;

public class SearchStepDefs {

    SearchResultAutomationPractice searchResultAutomationPractice = new SearchResultAutomationPractice(Hooks.getChromeDriver(), 30);

    @Given("Главная страница сайта {string}")
    public void mainPage(String URL) {
        Hooks.getChromeDriver().get(URL);

    }

    @When("Ввести в строку поиска {string} и нажать кнопку {string} в виде лупы")
    public void enterRequestInSearchBar(String item, String button) {
        Steps.searchItem(searchResultAutomationPractice, item, button);
    }

    @Then("Появилась карточка с именем {string}")
    public void isFoundItemCorrect(String item) {
        Steps.checkSearchResult(searchResultAutomationPractice, item);
    }

}
