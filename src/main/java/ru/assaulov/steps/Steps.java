package ru.assaulov.steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.assaulov.autotesttraining.SearchResultAutomationPractice;
import ru.assaulov.utils.Utils;

import java.io.ByteArrayInputStream;

public class Steps {

    @Step
    public static void searchItem(SearchResultAutomationPractice searchResultPage, String itemToSearch, String buttonName){
        searchResultPage.search(itemToSearch);
        Allure.addAttachment("screenSearch", new ByteArrayInputStream(((TakesScreenshot) searchResultPage.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
        searchResultPage.clickSpanButton(buttonName);
    }

    @Step
    public static void checkSearchResult(SearchResultAutomationPractice searchResultPage, String item){
        String itemActualName = searchResultPage.getCardWithItem(item).getText();
        Utils.getScreen(searchResultPage.getChromeDriver(), searchResultPage.getChromeDriver().findElement(By.xpath("//ul[@class='product_list grid row']")));
        Assertions.assertEquals(searchResultPage.getItemToSearch(), itemActualName);
    }

}
