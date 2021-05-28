package ru.assaulov.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ru.assaulov.autotesttraining.CreateAccountPage;
import ru.assaulov.entities.UserAddress;
import ru.assaulov.entities.UserData;

public class RegistrationSteps {

    @Step
    public static void pushSignInButton(CreateAccountPage accountPage, String buttonName){
        accountPage.clickHrefButton(buttonName);
    }


    @Step
    public static void isRightPageOpen(CreateAccountPage accountPage, String expectedPage){
        String actualPage = accountPage.getNamePage().getText();
        Assertions.assertEquals(expectedPage, actualPage);
    }

    @Step
    public static void isCreatePageOpen(CreateAccountPage accountPage, String expectedPage){
        String actualPage = accountPage.getCreatePage().getText();
        Assertions.assertEquals(expectedPage, actualPage);
    }

    @Step
    public static void clickCreateAnAccountButton(CreateAccountPage accountPage, String buttonName){
        accountPage.clickSubmitButton(buttonName);
    }

    @Step
    public static void setGender(CreateAccountPage accountPage, UserData user){
        accountPage.setGender(user.getTitle());
    }

    @Step
    public static void setFirstName(CreateAccountPage accountPage,String formName, String fieldName, UserData user){
        accountPage.inputDataInField(formName,fieldName,user.getFirstName());
    }

    @Step
    public static void setLastName(CreateAccountPage accountPage,String formName, String fieldName, UserData user){
        accountPage.inputDataInField(formName,fieldName,user.getLastName());
    }

    @Step
    public static void setEmail(CreateAccountPage accountPage,String formName, String fieldName, UserData user){
        accountPage.inputDataInField(formName,fieldName,user.getEmail());
    }

    @Step
    public static void setPassword(CreateAccountPage accountPage, String formName, String fieldName, UserData user){
        accountPage.inputDataInField(formName,fieldName,user.getPassword());
    }

    @Step
    public static void setDateOfBirth(CreateAccountPage accountPage, UserData user){
        accountPage.setDateOfBirth(user.getDateOfBirth());
    }

    @Step
    public static void setCompany(CreateAccountPage accountPage,String formName, String fieldName, UserAddress address){
        accountPage.inputDataInField(formName,fieldName, address.getCompany());
    }

    @Step
    public static void setAddress(CreateAccountPage accountPage,String formName, String fieldName, UserAddress address){
        accountPage.inputDataInField(formName,fieldName, address.getAddress());
    }

    @Step
    public static void setCity (CreateAccountPage accountPage,String formName, String fieldName, UserAddress address){
        accountPage.inputDataInField(formName,fieldName, address.getCity());
    }

    @Step
    public static void setState (CreateAccountPage accountPage,UserAddress address){
        accountPage.setState(address.getState());
    }

    @Step
    public static void setZipCode (CreateAccountPage accountPage,String formName, String fieldName, UserAddress address){
        accountPage.inputDataInField(formName,fieldName, address.getZipCode());
    }

    @Step
    public static void setCountry (CreateAccountPage accountPage,UserAddress address){
        accountPage.setCountry(address.getCountry());
    }

    @Step
    public static void setMobilePhone  (CreateAccountPage accountPage,String formName, String fieldName, UserAddress address){
        accountPage.inputDataInField(formName, fieldName, address.getMobilePhone());
    }

    @Step
    public static void setAlias(CreateAccountPage accountPage,String formName, String fieldName, UserAddress address){
        accountPage.inputDataInField(formName,fieldName,address.getAddressAlias());
    }

    @Step
    public static void clickRegisterButton(CreateAccountPage accountPage, String buttonName){
        accountPage.clickSubmitButton(buttonName);
    }

}
