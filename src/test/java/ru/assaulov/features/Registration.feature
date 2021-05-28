

Feature: Регистрация нового пользователя на сайте

  @registration
  Scenario: Создание нового пользователя
    Given Главная страница сайта 'http://automationpractice.com/'
    When Нажать кнопку 'Sign in'
    Then Откроется страница 'Authentication'
    When В разделе 'CREATE AN ACCOUNT' ввести e-mail в поле 'Email address' для регистрации
      |         Email        |
      |  merk.avr@frnla.com  |
    When Нажать на кнопку 'Create an account'
    Then Откроется страница 'Create an account'  с полями для ввода
    When Заполнить поля 'Your personal information' следующими данными:
    |Title|First name|Last name|         Email        |Password |Date of Birth|
    | Mr. | Mark     | Avrelii  | merk.avr@frnla.com | 12345    | 01.01.1971  |
    When Заполнить поля 'Your personal information' следующими данными:
    |  Company       |  Address        |City      | State | Zip/Postal Code | Country       | Mobile phone |Assign an address alias for future reference|
    |  Some Company  |  some street 1  |City Name | Alabama | 12345          | United States | 999999999   |My address                                  |
    Then Открается страница 'MY ACCOUNT'





