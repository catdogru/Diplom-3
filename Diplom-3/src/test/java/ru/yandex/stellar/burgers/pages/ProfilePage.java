package ru.yandex.stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {
    @Getter
    @FindBy(xpath = "//*[text() = 'Профиль']")
    SelenideElement profileTab;

    @Getter
    @FindBy(xpath = "//label[text() = 'Логин']/parent::div/input")
    SelenideElement loginInput;

    @FindBy(xpath = "//*[text() = 'Конструктор']/parent::a")
    SelenideElement builderButton;

    @FindBy(xpath = "//div[contains(@class, 'logo')]")
    SelenideElement logoImage;

    @FindBy(xpath = "//button[text() = 'Выход']")
    SelenideElement logoutButton;

    @Step("Wait profile page loading")
    public ProfilePage pageShouldBeLoaded() {
        getProfileTab().shouldBe(visible);
        return this;
    }

    @Step("Open main page by builder button")
    public MainPage clickBuilderButton() {
        builderButton.click();
        return page(MainPage.class);
    }

    @Step("Open main page by logo click")
    public MainPage clickLogoImage() {
        logoImage.click();
        return page(MainPage.class);
    }

    @Step
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return page(LoginPage.class);
    }
}
