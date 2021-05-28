package ru.assaulov.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.assaulov.autotesttraining.CreateAccountPage;
import ru.assaulov.entities.UserAddress;
import ru.assaulov.entities.UserData;
import ru.assaulov.steps.RegistrationSteps;

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
        String email = tableMail.asList().get(0);
        user.setEmail(email);
        RegistrationSteps.setEmail(accountPage, formName,fieldName, user);
    }

    @When("Нажать на кнопку {string}")
    public void нажатьНаКнопкуCreateAnAccount(String buttonName) {
        RegistrationSteps.clickCreateAnAccountButton(accountPage, buttonName);
    }

    @Then("Откроется страница {string}  с полями для ввода")
    public void откроетсяСтраницаCREATEANACCOUNTСПолямиДляВвода(String namePage) {
        RegistrationSteps.isRightPageOpen(accountPage, namePage);
    }

    @When("Заполнить поля {string} следующими данными:")
    public void заполнитьПоляYOURPERSONALINFORMATIONСледующимиДанными(String formName , Map<String, String> userData) {
        user.setFirstName(userData.get("First name"));
        user.setLastName(userData.get("Last name"));
        user.setPassword(userData.get("Password"));
        user.setDateOfBirth(userData.get("Date of Birth"));
        RegistrationSteps.setFirstName(accountPage, formName,"First name" ,user);
        RegistrationSteps.setLastName(accountPage, formName, "Last name",user);
        RegistrationSteps.setPassword(accountPage, formName, "Password",user);
        RegistrationSteps.setDateOfBirth(accountPage, user);
    }

    @When("Заполнить поля {string} следующими данными:")
    public void заполнитьПоляYOURADDRESSСледующимиДанными(String formName, Map<String, String> addressData) {
        address.setCompany(addressData.get("Company"));
        address.setAddress(addressData.get("Address"));
        address.setCity(addressData.get("City"));
        address.setState(addressData.get("State"));
        address.setZipCode(addressData.get("Zip/Postal Code"));
        address.setCountry(addressData.get("Country"));
        address.setMobilePhone(addressData.get("Mobile phone"));
        address.setAddressAlias(addressData.get("Assign an address alias for future reference"));
        RegistrationSteps.setCompany(accountPage, formName,"Company", address);
        RegistrationSteps.setAddress(accountPage, formName,"Address", address);
        RegistrationSteps.setCity(accountPage, formName,"City", address);
        RegistrationSteps.setState(accountPage,address);
        RegistrationSteps.setZipCode(accountPage, formName,"Zip/Postal Code", address);
        RegistrationSteps.setCountry(accountPage, address);
        RegistrationSteps.setMobilePhone(accountPage, formName,"Mobile phone", address);
        RegistrationSteps.setAlias(accountPage, formName,"Assign an address alias for future reference", address);

    }

    @Then("Открается страница {string}")
    public void откраетсяСтраницаMyAccount(String namePage) {
        RegistrationSteps.isRightPageOpen(accountPage, namePage);
    }


}
