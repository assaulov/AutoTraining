

Feature: Вход существущим пользователем
    Background:
        Given Главная страница сайта 'http://automationpractice.com/'
        When Нажать кнопку 'Sign in'
        Then Откроется страница 'Authentication'

    @signin
    Scenario: Вход в систему
      When В поля формы 'Already registered?' ввести ввести данные из таблицы:
          |    Email address            | Password |
          | antonina.antonova3@foxy.com | 12345    |
        When Нажать на кнопку 'Sign in'
        Then Откроется страница 'My account'

