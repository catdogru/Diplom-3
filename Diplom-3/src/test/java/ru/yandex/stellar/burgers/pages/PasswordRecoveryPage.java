package ru.yandex.stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static ru.yandex.stellar.burgers.constants.Constants.STELLAR_BURGER_FORGOT_PASSWORD_URL;

public class PasswordRecoveryPage {
    @FindBy(xpath = "//p[text() = 'Вспомнили пароль?']/child::a[text() = 'Войти']")
    private SelenideElement loginIfRememberPasswordButton;

    @Step
    public static PasswordRecoveryPage openPasswordRecoveryPage() {
        return open(STELLAR_BURGER_FORGOT_PASSWORD_URL, PasswordRecoveryPage.class);
    }

    @Step("Click login-if-remember-password button")
    public LoginPage clickLoginIfRememberPasswordButton() {
        loginIfRememberPasswordButton.click();
        return page(LoginPage.class);
    }
}
