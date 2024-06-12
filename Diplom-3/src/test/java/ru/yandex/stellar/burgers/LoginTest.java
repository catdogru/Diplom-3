package ru.yandex.stellar.burgers;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.stellar.burgers.client.UserClient;
import ru.yandex.stellar.burgers.model.user.UserData;
import ru.yandex.stellar.burgers.pages.LoginPage;
import ru.yandex.stellar.burgers.pages.MainPage;
import ru.yandex.stellar.burgers.pages.PasswordRecoveryPage;
import ru.yandex.stellar.burgers.pages.RegistrationPage;
import ru.yandex.stellar.burgers.service.check.UserCheck;

import static com.codeborne.selenide.Selenide.localStorage;
import static ru.yandex.stellar.burgers.constants.Constants.ACCESS_TOKEN_LOCAL_STORAGE_ITEM;
import static ru.yandex.stellar.burgers.constants.Constants.Data.*;
import static ru.yandex.stellar.burgers.pages.MainPage.openMainPage;
import static ru.yandex.stellar.burgers.pages.PasswordRecoveryPage.openPasswordRecoveryPage;
import static ru.yandex.stellar.burgers.pages.RegistrationPage.openRegistrationPage;

public class LoginTest {
    private final UserClient userClient = new UserClient();
    private final UserCheck userCheck = new UserCheck();
    private UserData user;
    private String userAccessToken;

    @Before
    public void createUser() {
        user = new UserData(generateRandomEmail(), DEFAULT_PASSWORD, DEFAULT_USER_NAME);
        userCheck.createdSuccessfully(userClient.createUser(user));
    }

    @After
    public void deleteUser() {
        if (userAccessToken != null)
            userCheck.deletedSuccessfully(userClient.deleteUser(userAccessToken));
    }

    @Test
    @Description("Open login page from main page, login and check redirection on main page")
    public void shouldLoginFromMainPageLoginButton() {
        MainPage mainPage = openMainPage();
        LoginPage loginPage = mainPage.clickLoginButton();
        loginShouldBeSuccessful(loginPage);
        getlUserAccessTokenFromLocalStorage();
    }

    @Test
    @Description("Open login page from profile page, login and check redirection on main page")
    public void shouldLoginFromMainPageProfileButton() {
        MainPage mainPage = openMainPage();
        LoginPage loginPage = mainPage.openProfileWithoutAuth();
        loginShouldBeSuccessful(loginPage);
        getlUserAccessTokenFromLocalStorage();
    }

    @Test
    @Description("Open login page from registration page, login and check redirection on main page")
    public void shouldLoginFromRegistrationPage() {
        RegistrationPage registrationPage = openRegistrationPage();
        LoginPage loginPage = registrationPage.clickLoginIfAlreadyRegisteredButton();
        loginShouldBeSuccessful(loginPage);
        getlUserAccessTokenFromLocalStorage();
    }

    @Test
    @Description("Open login page from password recovery page, login and check redirection on main page")
    public void shouldLoginFromPasswordRecoveryPage() {
        PasswordRecoveryPage passwordRecoveryPage = openPasswordRecoveryPage();
        LoginPage loginPage = passwordRecoveryPage.clickLoginIfRememberPasswordButton();
        loginShouldBeSuccessful(loginPage);
        getlUserAccessTokenFromLocalStorage();
    }

    private void loginShouldBeSuccessful(LoginPage loginPage) {
        MainPage mainPage = loginPage.pageShouldBeLoaded().login(user.getEmail(), user.getPassword());
        mainPage.pageShouldBeLoaded();
    }

    private void getlUserAccessTokenFromLocalStorage() {
        userAccessToken = localStorage().getItem(ACCESS_TOKEN_LOCAL_STORAGE_ITEM);
    }
}
