package ru.yandex.stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static ru.yandex.stellar.burgers.constants.Constants.STELLAR_BURGER_REGISTER_URL;

public class RegistrationPage {
    @FindBy(xpath = "//label[text() = 'Имя']/parent::div/input")
    private SelenideElement nameInput;

    @FindBy(xpath = "//label[text() = 'Email']/parent::div/input")
    private SelenideElement emailInput;

    @FindBy(xpath = "//label[text() = 'Пароль']/parent::div/input")
    private SelenideElement passwordInput;

    @FindBy(xpath = "//button[text() = 'Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(xpath = "//*[text() = 'Некорректный пароль']")
    private SelenideElement invalidPasswordWarning;

    @FindBy(xpath = "//p[text() = 'Уже зарегистрированы?']/child::a[text() = 'Войти']")
    private SelenideElement loginIfAlreadyRegisteredButton;

    @Step
    public static RegistrationPage openRegistrationPage() {
        return open(STELLAR_BURGER_REGISTER_URL, RegistrationPage.class);
    }

    @Step("Input user data and click register button")
    public LoginPage register(String name, String email, String password) {
        setNameValue(name);
        setEmailValue(email);
        setPasswordValue(password);
        clickRegisterButton();
        return page(LoginPage.class);
    }

    public LoginPage clickLoginIfAlreadyRegisteredButton() {
        loginIfAlreadyRegisteredButton.click();
        return page(LoginPage.class);
    }

    @Step("Wait registration page loading")
    public RegistrationPage pageShouldBeLoaded() {
        registrationButton.shouldBe(visible);
        return this;
    }

    @Step()
    public SelenideElement getInvalidPasswordWarning() {
        return invalidPasswordWarning;
    }

    private RegistrationPage setNameValue(String nameValue) {
        nameInput.setValue(nameValue);
        return this;
    }

    private RegistrationPage setEmailValue(String emailValue) {
        emailInput.setValue(emailValue);
        return this;
    }

    private RegistrationPage setPasswordValue(String passwordValue) {
        passwordInput.setValue(passwordValue);
        return this;
    }

    private RegistrationPage clickRegisterButton() {
        registrationButton.click();
        return this;
    }

}
