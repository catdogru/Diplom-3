package ru.yandex.stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(xpath = "//label[text() = 'Email']/parent::div/input")
    private SelenideElement emailInput;

    @FindBy(xpath = "//label[text() = 'Пароль']/parent::div/input")
    private SelenideElement passwordInput;

    @FindBy(xpath = "//button[text() = 'Войти']")
    private SelenideElement loginButton;

    @FindBy(xpath = "//a[@href = '/register']")
    private SelenideElement registerLink;

    @Step("Wait login page loading")
    public LoginPage pageShouldBeLoaded() {
        registerLink.shouldBe(visible);
        return this;
    }

    @Step("Open registration page")
    public RegistrationPage openRegistrationPage() {
        registerLink.click();
        return page(RegistrationPage.class);
    }

    @Step("Input user data and click login button")
    public MainPage login(String email, String password) {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
        return page(MainPage.class);
    }

    public LoginPage setEmailValue(String emailValue) {
        emailInput.setValue(emailValue);
        return this;
    }

    public LoginPage setPasswordValue(String passwordValue) {
        passwordInput.setValue(passwordValue);
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }
}
