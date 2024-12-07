package ru.yandex.stellar.burgers;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import ru.yandex.stellar.burgers.client.UserClient;
import ru.yandex.stellar.burgers.model.user.UserData;
import ru.yandex.stellar.burgers.pages.LoginPage;
import ru.yandex.stellar.burgers.pages.MainPage;
import ru.yandex.stellar.burgers.pages.ProfilePage;
import ru.yandex.stellar.burgers.rule.SelenideConfigurationRule;
import ru.yandex.stellar.burgers.service.check.UserCheck;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.localStorage;
import static ru.yandex.stellar.burgers.constants.Constants.ACCESS_TOKEN_LOCAL_STORAGE_ITEM;
import static ru.yandex.stellar.burgers.constants.Constants.Data.*;
import static ru.yandex.stellar.burgers.pages.LoginPage.openLoginPage;

public class ProfileTest {
    @Rule
    public SelenideConfigurationRule browserRule = new SelenideConfigurationRule();

    private final UserClient userClient = new UserClient();
    private final UserCheck userCheck = new UserCheck();
    private UserData user;
    private String userAccessToken;

    @Before
    public void setUp() {
        createUser();
        loginUser();
        userAccessToken = localStorage().getItem(ACCESS_TOKEN_LOCAL_STORAGE_ITEM);
    }

    @After
    public void deleteUser() {
        if (userAccessToken != null)
            userCheck.deletedSuccessfully(userClient.deleteUser(userAccessToken));
    }

    @Test
    @Description("Open profile page from main page and check user profile email")
    public void shouldOpenProfileFromMainPage() {
        ProfilePage profilePage = MainPage.openMainPage().openProfileWithAuth();
        profilePage.getLoginInput().shouldHave(value(user.getEmail()));
    }

    @Test
    @Description("Click builder button on profile page and check builder page loading")
    public void shouldOpenBuilderFromBuilderButton() {
        ProfilePage profilePage = MainPage.openMainPage().openProfileWithAuth().pageShouldBeLoaded();
        MainPage mainPage = profilePage.clickBuilderButton();
        mainPage.pageShouldBeLoaded();
    }

    @Test
    @Description("Click logo on profile page and check builder page loading")
    public void shouldOpenBuilderFromLogoClick() {
        ProfilePage profilePage = MainPage.openMainPage().openProfileWithAuth().pageShouldBeLoaded();
        MainPage mainPage = profilePage.clickLogoImage();
        mainPage.pageShouldBeLoaded();
    }

    @Test
    @Description("Click logout button on profile page and check login page loading")
    public void shouldLogoutFromProfile() {
        ProfilePage profilePage = MainPage.openMainPage().openProfileWithAuth();
        LoginPage loginPage = profilePage.clickLogoutButton();
        loginPage.pageShouldBeLoaded();
    }

    @Step
    private void createUser() {
        user = new UserData(generateRandomEmail(), DEFAULT_PASSWORD, DEFAULT_USER_NAME);
        userCheck.createdSuccessfully(userClient.createUser(user));
    }

    @Step
    private void loginUser() {
        MainPage mainPage = openLoginPage().login(user.getEmail(), user.getPassword());
        mainPage.pageShouldBeLoaded();
    }
}
