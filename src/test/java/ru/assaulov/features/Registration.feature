# new feature
# Tags: optional

Feature: Регистрация нового пользователя на сайте

  @registration
  Scenario: Создание нового пользователя
    Given Главная страница сайта 'http://automationpractice.com/'
    When Нажать кнопку 'Sign in'
    Then Откроется страница 'Authentication'
    When В поле Email address раздела CREATE AN ACCOUNT ввести e-mail для регистрации
    When Нажать на кнопку 'Create an account'
    Then Откроется страница 'CREATE AN ACCOUNT'  с полями для ввода
    When Заполнить поля YOUR PERSONAL INFORMATION следующими данными:
    |Title|First name|Last name|         Email        |Password |Date of Birth|
    | Mr. | Mark     | Avrelii  | merk.avr@frnla.com | 12345    | 01.01.1971  |
    When Заполнить поля YOUR ADDRESS следующими данными:
    |  Company       |  Address        |City      | State | Zip/Postal Code | Country       | Mobile phone |Assign an address alias for future reference|
    |  Some Company  |  some street 1  |City Name | Alabama | 12345          | United States | 999999999     |My address                                 |
    Then Открается страница ' My account'





