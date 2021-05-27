package ru.assaulov.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.assaulov.autotesttraining.SearchResultAutomationPractice;
import ru.assaulov.steps.Steps;

public class MyStepdefs {

    SearchResultAutomationPractice searchResultAutomationPractice = new SearchResultAutomationPractice(Hooks.getChromeDriver(), 30);

    @Given("Главная страница сайта {string}")
    public void главнаяСтраницаСайтаHttpAutomationpracticeCom(String URL) {
        Hooks.getChromeDriver().get(URL);

    }

    @When("Ввести в строку поиска {string} и нажать кнопку {string} в виде лупы")
    public void ввестиВСтрокуПоискаBlouseИНажатьКнопкуSearchВВидеЛупы(String item, String button) {
        Steps.searchItem(searchResultAutomationPractice, item, button);
    }

    @Then("Появилась карточка с именем {string}")
    public void появиласьКарточкаСИменемBlouse(String item) {
        Steps.checkSearchResult(searchResultAutomationPractice, item);
    }

}