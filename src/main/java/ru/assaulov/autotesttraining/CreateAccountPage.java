package ru.assaulov.autotesttraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage extends AuthenticationPage{



    public CreateAccountPage(WebDriver chromeDriver, int waitSeconds) {
        super(chromeDriver, waitSeconds);
    }

    public WebElement getCreatePage() {
        webDriverWait.until(ExpectedConditions.urlContains("#account-creation"));
        String namePageSelector = "//h1[@class='page-heading']";
        WebElement namePage =new WebDriverWait(chromeDriver, 30).until(ExpectedConditions.visibilityOf((chromeDriver.findElement(By.xpath(namePageSelector)))));
        if(namePage.isDisplayed())
            return namePage;
        return null;
    }
    public void setGender(String gender){
        String selectorGenderRadioButton = "//form[contains(*,'Your personal information')]//div[@class='radio-inline']//input[@value="+defineGender(gender)+"]";
        WebElement genderButton = chromeDriver.findElement(By.xpath(selectorGenderRadioButton));
        genderButton.click();
    }

    public void setDateOfBirth(String dateOfBirth){
        String[] dataOfBirthSplit = dateOfBirth.split("\\.");
        String selectorDivDateOfBirth = "//div[contains(label, 'Date of Birth')]";
        String selectorDays= "//select[@name='days']";
        String selectorMonths = "//select[@name='months']";
        String selectorYears = "//select[@name='years']";
        selectFactory(selectorDivDateOfBirth+selectorDays).selectByValue(dataOfBirthSplit[0]);
        selectFactory(selectorDivDateOfBirth+selectorMonths).selectByValue(dataOfBirthSplit[1]);
        selectFactory(selectorDivDateOfBirth+selectorYears).selectByValue(dataOfBirthSplit[2]);
    }

    public void setState(String state){
        String selectorStateField = "//select[@name='id_state']";
        selectFactory(selectorStateField).selectByVisibleText(state);
    }

    public void setCountry(String country){
        String selectorCountry = "//select[@name='id_country']";
        selectFactory(selectorCountry).selectByVisibleText(country);
    }

    private Select selectFactory(String selector){
        WebElement selectorElement = chromeDriver.findElement(By.xpath(selector));
        return new Select(selectorElement);
    }

    private int defineGender(String gender) {
        if(gender.equalsIgnoreCase("mr.")){
            return 1;
        } else if(gender.equalsIgnoreCase("mrs.")) {
            return 2;
        }
        return 1;
    }
}
