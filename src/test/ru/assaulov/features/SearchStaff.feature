

Feature: Поиск вещей

  Scenario: Поиск по сайту вещей через строку поиска
    Given Главная страница сайта 'http://automationpractice.com/'
    When Ввести в строку поиска 'Blouse' и нажать кнопку 'Search' в виде лупы
    Then Появилась карточка с именем 'Blouse'