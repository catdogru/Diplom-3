package ru.yandex.stellar.burgers.constants;

import lombok.Getter;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public interface Constants {
    String STELLAR_BURGER_BASE_SITE_URL = "https://stellarburgers.nomoreparties.site";
    String STELLAR_BURGER_REGISTER_URL = STELLAR_BURGER_BASE_SITE_URL + "/register";
    String STELLAR_BURGER_LOGIN_URL = STELLAR_BURGER_BASE_SITE_URL + "/login";
    String STELLAR_BURGER_FORGOT_PASSWORD_URL = STELLAR_BURGER_BASE_SITE_URL + "/forgot-password";
    String ACCESS_TOKEN_LOCAL_STORAGE_ITEM = "accessToken";

    String CLASS_ATTRIBUTE = "class";
    String containsCurrent = ".*current.*";

    @Getter
    enum Browser {
        YANDEX_BROWSER("yandex"),
        FIREFOX_BROWSER("firefox"),
        CHROME_BROWSER("chrome"),
        DEFAULT_BROWSER("default");

        private final String value;

        Browser(String value) {
            this.value = value;
        }

        public static Browser getBrowserByValue(String value) {
            return stream(values())
                    .filter(it -> it.getValue().equals(value))
                    .findFirst()
                    .orElse(DEFAULT_BROWSER);
        }
    }

    interface SystemProperties {
        String BROWSER_PROPERTY = "browser";
        String DRIVER_VERSION_PROPERTY = "driver.version";
        String DRIVER_BINARY_PROPERTY = "driver.bin";
    }

    interface Data {
        String DEFAULT_USER_NAME = "Тестовый Тест Тестович";
        String DEFAULT_PASSWORD = "Qwerty12345";
        String SHORT_PASSWORD = "Qw..";

        static String generateRandomEmail() {
            return "testEmail_" + randomNumeric(4) + "@yandex.ru";
        }
    }
}