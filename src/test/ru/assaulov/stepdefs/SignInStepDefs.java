package ru.assaulov.stepdefs;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import ru.assaulov.autotesttraining.AuthenticationPage;

import java.util.List;

public class SignInStepDefs {

    AuthenticationPage authenticationPage = new AuthenticationPage(Hooks.getChromeDriver(),30);

    @When("В поля формы {string} ввести ввести данные из таблицы:")
    public void вПоляФормыALREADYREGISTEREDВвестиEmailAddressИPasswordВвестиДанные(String formName, DataTable data) {
        List<List<String>> form = data.asLists();
        List<String> field = form.get(0);
        List<String> dataInput = form.get(1);
        for (int i = 0; i <= field.size()-1; i++) {
            authenticationPage.inputDataInField(formName, field.get(i), dataInput.get(i));
        }
    }
}