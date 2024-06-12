package ru.yandex.stellar.burgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static ru.yandex.stellar.burgers.constants.Constants.STELLAR_BURGER_BASE_SITE_URL;

@Getter
public class MainPage {
    @FindBy(xpath = "//span[text() = 'Булки']/parent::div[contains(@class, 'tab')]")
    SelenideElement bunTab;
    @FindBy(xpath = "//span[text() = 'Соусы']/parent::div[contains(@class, 'tab')]")
    SelenideElement sauceTab;
    @FindBy(xpath = "//span[text() = 'Начинки']/parent::div[contains(@class, 'tab')]")
    SelenideElement fillingTab;
    @FindBy(xpath = "//a[@href = '/account']")
    private SelenideElement profileLink;
    @FindBy(xpath = "//button[text() = 'Войти в аккаунт']")
    private SelenideElement loginButton;
    @FindBy(xpath = "//section[contains(@class, 'BurgerIngredients')]")
    private SelenideElement ingredientsPanel;

    @Step
    public static MainPage openMainPage() {
        return open(STELLAR_BURGER_BASE_SITE_URL, MainPage.class);
    }

    @Step("Open profile as unauthorized user")
    public LoginPage openProfileWithoutAuth() {
        profileLink.click();
        return page(LoginPage.class);
    }

    @Step("Open profile as authorized user")
    public ProfilePage openProfileWithAuth() {
        profileLink.click();
        return page(ProfilePage.class);
    }

    @Step
    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step
    public MainPage clickOnBunTab() {
        bunTab.click(usingJavaScript());
        return this;
    }

    @Step
    public MainPage clickOnSauceTab() {
        sauceTab.click(usingJavaScript());
        return this;
    }

    @Step
    public MainPage clickOnFillingTab() {
        fillingTab.click(usingJavaScript());
        return this;
    }

    @Step("Wait main page loading")
    public MainPage pageShouldBeLoaded() {
        ingredientsPanel.shouldBe(visible);
        return this;
    }
}