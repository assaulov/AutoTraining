

Feature: Добавление вещей в корзину
    Background:
        Given Главная страница сайта 'http://automationpractice.com/'

    Scenario: Добавление одной вещи с главной страницы в корзину не автаризованным пользователем
        When Навести курсор на карточку с товаром 'Blouse' и нажать на кнопку 'Add to cart'
        Then Появится сообщение 'Product successfully added to your shopping cart'


