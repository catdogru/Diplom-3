package ru.yandex.stellar.burgers.constants;

import lombok.Getter;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class Constants {
    public static final String STELLAR_BURGER_BASE_SITE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String STELLAR_BURGER_REGISTER_URL = STELLAR_BURGER_BASE_SITE_URL + "/register";
    public static final String STELLAR_BURGER_LOGIN_URL = STELLAR_BURGER_BASE_SITE_URL + "/login";
    public static final String STELLAR_BURGER_FORGOT_PASSWORD_URL = STELLAR_BURGER_BASE_SITE_URL + "/forgot-password";
    public static final String ACCESS_TOKEN_LOCAL_STORAGE_ITEM = "accessToken";

    public static final String CLASS_ATTRIBUTE = "class";
    public static final String containsCurrent = ".*current.*";

    @Getter
    public enum Browser {
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

    public static class SystemProperties {
        public static final String BROWSER_PROPERTY = "browser";
        public static final String DRIVER_VERSION_PROPERTY = "driver.version";
        public static final String DRIVER_BINARY_PROPERTY = "driver.bin";
    }

    public static class Data {
        public static final String DEFAULT_USER_NAME = "Тестовый Тест Тестович";
        public static final String DEFAULT_PASSWORD = "Qwerty12345";
        public static final String SHORT_PASSWORD = "Qw..";

        public static String generateRandomEmail() {
            return "testEmail_" + randomNumeric(4) + "@yandex.ru";
        }
    }
}