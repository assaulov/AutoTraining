

Feature: Регистрация нового пользователя на сайте

  @registration
  Scenario: Создание нового пользователя
    Given Главная страница сайта 'http://automationpractice.com/'
    When Нажать кнопку 'Sign in'
    Then Откроется страница 'AUTHENTICATION'
    When В разделе 'Create an account' ввести e-mail в поле 'Email address' для регистрации
      |         Email         |
      |  antonina.antonova3@foxy.com  |
    When Нажать на кнопку 'Create an account'
    Then Откроется страница 'CREATE AN ACCOUNT'
    When Заполнить поля 'Your personal information' следующими данными:
    |Title|Date of Birth|First name|Last name |   Password   |
    | Mrs.|  15.3.1995  |Antonina | Antonova   |    12345      |
    When Заполнить поля 'Your personal information' следующими данными:
    |  Company       |  Address        |City      | State | Zip/Postal Code | Country        | Mobile phone |Assign an address alias for future reference|
    |  Some Company  |  some street 2  |City Name | Alabama | 12345         | United States  | 999999999    |Home                                 |
    When Нажать на кнопку 'Register'
    Then Откроется страница 'MY ACCOUNT'





