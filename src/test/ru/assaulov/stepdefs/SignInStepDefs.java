package ru.assaulov.stepdefs;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.assaulov.autotesttraining.AuthenticationPage;

import java.io.ByteArrayInputStream;
import java.util.List;

public class SignInStepDefs {

    AuthenticationPage authenticationPage = new AuthenticationPage(Hooks.getChromeDriver(),30);

    @When("В поля формы {string} ввести ввести данные из таблицы:")
    public void enterDataSignInForm(String formName, DataTable data) {
        List<List<String>> rows = data.asLists();
        for (int i = 0, j = 0; (i <= rows.get(0).size() - 1 && j <= rows.get(1).size() - 1); i++, j++) {
            String field = rows.get(0).get(i);
            authenticationPage.inputDataInField(formName, field, rows.get(1).get(j));
        }
        Allure.addAttachment("SignInFields", new ByteArrayInputStream(((TakesScreenshot) Hooks.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));

    }
}
