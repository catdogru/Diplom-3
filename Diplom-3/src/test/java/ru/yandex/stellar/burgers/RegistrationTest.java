package ru.yandex.stellar.burgers;

import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import ru.yandex.stellar.burgers.pages.LoginPage;
import ru.yandex.stellar.burgers.pages.MainPage;
import ru.yandex.stellar.burgers.pages.RegistrationPage;
import ru.yandex.stellar.burgers.rule.SelenideConfigurationRule;

import static com.codeborne.selenide.Condition.visible;
import static ru.yandex.stellar.burgers.constants.Constants.Data.*;
import static ru.yandex.stellar.burgers.pages.MainPage.openMainPage;

public class RegistrationTest {
    @Rule
    public SelenideConfigurationRule browserRule = new SelenideConfigurationRule();
    private RegistrationPage registrationPage;

    @Before
    @Description("Open profile page from main page and check profile page loading")
    public void openRegistrationPage() {
        MainPage mainPage = openMainPage();
        LoginPage loginPage = mainPage.openProfileWithoutAuth();
        registrationPage = loginPage.pageShouldBeLoaded().openRegistrationPage();
        registrationPage.pageShouldBeLoaded();
    }

    @Test
    @Description("Fill user data, click register button and check login page loading")
    public void registeredSuccessfully() {
        LoginPage loginPage = registrationPage.register(DEFAULT_USER_NAME, generateRandomEmail(), DEFAULT_PASSWORD);
        loginPage.pageShouldBeLoaded();
    }

    @Test
    @Description("Fill user data with short password, click register button and check error warning")
    public void shortPasswordShouldNotAllowRegistration() {
        registrationPage.register(DEFAULT_USER_NAME, generateRandomEmail(), SHORT_PASSWORD);
        registrationPage
                .getInvalidPasswordWarning()
                .shouldBe(visible);
    }
}