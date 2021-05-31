package ru.assaulov.steps;

import io.qameta.allure.Step;
import ru.assaulov.autotesttraining.AuthenticationPage;


public class SignInSteps {

    @Step
    public void inputData(AuthenticationPage authenticationPage, String formName, String fieldName, String data){
       authenticationPage.inputDataInField(formName,fieldName, data);
    }

}
