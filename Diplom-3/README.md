## Тестирование веб-интерфейса [Stellar Burgers](https://stellarburgers.nomoreparties.site/)

#### Запуск

1. CHROME (по умолчанию): ```bash mvn test```
2. YANDEX BROWSER: дополнительно передать в параметрах ключ "browser=yandex", путь к браузеру и версию поддерживаемого
   браузером драйвера:

- Пример Debian ```bash mvn -Dbrowser=yandex -Ddriver.bin=/usr/bin/yandex-browser -Ddriver.version=122.0.6261.94 test```
- Пример
  Windows ```bash mvn -Dbrowser=yandex -Ddriver.bin="C:/Program Files (x86)/Yandex/YandexBrowser/Application/browser.exe" -Ddriver.version=122.0.6261.94 test```

#### Инструмены

- JUnit 4
- Selenide
- Allure

#### Сценарии

- Регистрация
- Логин
- Личный кабинет
- Конструктор