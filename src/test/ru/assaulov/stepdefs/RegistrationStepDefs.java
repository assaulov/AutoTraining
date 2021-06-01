package ru.assaulov.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.assaulov.autotesttraining.CreateAccountPage;
import ru.assaulov.entities.UserAddress;
import ru.assaulov.entities.UserData;
import ru.assaulov.steps.RegistrationSteps;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

public class RegistrationStepDefs {

   private final CreateAccountPage accountPage = new CreateAccountPage(Hooks.getChromeDriver(), 30);
   private final UserData user = new UserData();
   private final UserAddress address = new UserAddress();

    @When("Нажать кнопку {string}")
    public void нажатьКнопкуSignIn(String buttonName) {
        RegistrationSteps.pushSignInButton(accountPage, buttonName);
    }

    @Then("Откроется страница {string}")
    public void откроетсяСтраницаAuthentication(String namePage) {
        RegistrationSteps.isRightPageOpen(accountPage, namePage);
    }

    @When("В разделе {string} ввести e-mail в поле {string} для регистрации")
    public void вРазделеCREATEANACCOUNTВвестиEMailВПолеEmailAddressДляРегистрации(String formName, String fieldName, DataTable tableMail) {
        String email = tableMail.asList().get(1);
        user.setEmail(email);
        RegistrationSteps.setEmail(accountPage, formName,fieldName, user);
    }

    @When("Нажать на кнопку {string}")
    public void нажатьНаКнопкуCreateAnAccount(String buttonName) {
        RegistrationSteps.clickCreateAnAccountButton(accountPage, buttonName);
    }

    @Then("Откроется страница {string}  с полями для ввода")
    public void откроетсяСтраницаCREATEANACCOUNTСПолямиДляВвода(String namePage) {
        if(namePage.equals("CREATE AN ACCOUNT")) {
            RegistrationSteps.isCreatePageOpen(accountPage,namePage);
        }
        RegistrationSteps.isRightPageOpen(accountPage, namePage);
    }

    @When("Заполнить поля {string} следующими данными:")
    public void inputUserData(String formName , DataTable userData) {
        List<List<String>> rows = userData.asLists();
        for (int i = 0, j=0; (i <=rows.get(0).size()-1 && j<=rows.get(1).size()-1); i++, j++) {
           String field = rows.get(0).get(i);
            if(field.equals("Title")){
                accountPage.setGender(rows.get(1).get(0));
            } else if(field.equals("Date of Birth")){
                accountPage.setDateOfBirth(rows.get(1).get(1));
        } else {

                accountPage.inputDataInField(formName, field, rows.get(1).get(j));
            }
        }
        Allure.addAttachment("YOURPERSONALINFORMATION", new ByteArrayInputStream(((TakesScreenshot) Hooks.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @When("Ввести в поля {string} следующими данными:")
    public void заполнитьПоляYOURADDRESSСледующимиДанными(String formName, DataTable addressData) {
        List<List<String>> rows = addressData.asLists();
        for (int i = 0, j=0; (i <=rows.get(0).size()-1 && j<=rows.get(1).size()-1); i++, j++) {
            String field = rows.get(0).get(i);
            if(field.equals("State")){
                accountPage.setState(rows.get(1).get(3));
            } else if(field.equals("Country")){
                accountPage.setCountry(rows.get(1).get(5));
            } else {
                accountPage.inputDataInField(formName, field, rows.get(1).get(j));
            }
        }

        Allure.addAttachment("YOURADDRESSС", new ByteArrayInputStream(((TakesScreenshot) Hooks.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Then("Открается страница {string}")
    public void откраетсяСтраницаMyAccount(String namePage) {
        RegistrationSteps.isRightPageOpen(accountPage, namePage);
    }


}
