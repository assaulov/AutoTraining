# new feature
# Tags: optional

Feature: Search Staff

  Scenario: поиск по сайту вещей через строку поиска
    Given Главная страница сайта 'http://automationpractice.com/'
    When Ввести в строку поиска 'Blouse' и нажать кнопку 'Search' в виде лупы
    Then Появилась карточка с именем 'Blouse'