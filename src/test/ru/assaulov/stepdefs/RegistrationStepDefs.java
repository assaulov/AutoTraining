package ru.assaulov.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import ru.assaulov.autotesttraining.CreateAccountPage;

import java.io.ByteArrayInputStream;
import java.util.List;

public class RegistrationStepDefs {

   private final CreateAccountPage accountPage = new CreateAccountPage(Hooks.getChromeDriver(), 30);

    @When("Нажать кнопку {string}")
    public void pushSignInButton(String buttonName) {
        accountPage.clickHrefButton(buttonName);
    }

    @When("В разделе {string} ввести e-mail в поле {string} для регистрации")
    public void enterEmail(String formName, String fieldName, DataTable tableMail) {
        String email = tableMail.asList().get(1);
        accountPage.inputDataInField(formName,fieldName, email);
    }

    @When("Нажать на кнопку {string}")
    public void PushCreatAnAccountButton(String buttonName) {
        accountPage.clickSubmitButton(buttonName);
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
    public void inputAddressData(String formName, DataTable addressData) {
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

    @Then("Откроется страница {string}")
    public void pageOpen(String namePage) {
        if(namePage.equals("CREATE AN ACCOUNT")) {
            isRightPageOpen(namePage, accountPage.getCreatePage());
        }
        isRightPageOpen(namePage, accountPage.getNamePage());
    }


    private void isRightPageOpen(String expectedPage, WebElement page) {
        String actualPage = page.getText();
        Assertions.assertEquals(expectedPage.toLowerCase(), actualPage.toLowerCase());
    }


}
