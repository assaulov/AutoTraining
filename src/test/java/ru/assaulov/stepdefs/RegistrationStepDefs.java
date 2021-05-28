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
    public void заполнитьПоляYOURPERSONALINFORMATIONСледующимиДанными(String formName , DataTable userData) {
        user.setTitle(userData.cell(1,0));
        user.setFirstName(userData.cell(1,1));
        user.setLastName(userData.cell(1,2));
        user.setPassword(userData.cell(1,4));
        user.setDateOfBirth(userData.cell(1,5));
        RegistrationSteps.setGender(accountPage, user);
        RegistrationSteps.setFirstName(accountPage, formName,"First name" ,user);
        RegistrationSteps.setLastName(accountPage, formName, "Last name",user);
        RegistrationSteps.setPassword(accountPage, formName, "Password",user);
        RegistrationSteps.setDateOfBirth(accountPage, user);
        Allure.addAttachment("YOURPERSONALINFORMATION", new ByteArrayInputStream(((TakesScreenshot) Hooks.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @When("Ввести в поля {string} следующими данными:")
    public void заполнитьПоляYOURADDRESSСледующимиДанными(String formName, DataTable addressData) {
        address.setCompany(addressData.cell(1,0));
        address.setAddress(addressData.cell(1,1));
        address.setCity(addressData.cell(1,2));
        address.setState(addressData.cell(1,3));
        address.setZipCode(addressData.cell(1,4));
        address.setCountry(addressData.cell(1,5));
        address.setMobilePhone(addressData.cell(1,6));
        address.setAddressAlias(addressData.cell(1,7));
        RegistrationSteps.setCompany(accountPage, formName,"Company", address);
        RegistrationSteps.setAddress(accountPage, formName,"Address", address);
        RegistrationSteps.setCity(accountPage, formName,"City", address);
        RegistrationSteps.setState(accountPage,address);
        RegistrationSteps.setZipCode(accountPage, formName,"Zip/Postal Code", address);
        RegistrationSteps.setCountry(accountPage, address);
        RegistrationSteps.setMobilePhone(accountPage, formName,"Mobile phone", address);
        RegistrationSteps.setAlias(accountPage, formName,"Assign an address alias for future reference", address);
        Allure.addAttachment("YOURADDRESSС", new ByteArrayInputStream(((TakesScreenshot) Hooks.getChromeDriver()).getScreenshotAs(OutputType.BYTES)));

    }

    @Then("Открается страница {string}")
    public void откраетсяСтраницаMyAccount(String namePage) {
        RegistrationSteps.isRightPageOpen(accountPage, namePage);
    }


}
