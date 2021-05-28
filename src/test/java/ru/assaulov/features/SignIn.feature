

Feature: Вход существущим пользователем
    Background:
        Given Главная страница сайта 'http://automationpractice.com/'
        When Нажать кнопку 'Sign in'
        Then Откроется страница 'Authentication'
    Scenario: Вход в систему
      When В поля <Email address> и <Password> ввести данные:
          |         Email        | Password |
          | pojofoy474@frnla.com | 12345    |
      Then Открается страница 'My account'

