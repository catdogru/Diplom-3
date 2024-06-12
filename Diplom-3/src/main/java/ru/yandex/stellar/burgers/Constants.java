package ru.yandex.stellar.burgers;

public interface Constants {
    String STELLAR_BURGERS_BASE_API_URI = "https://stellarburgers.nomoreparties.site";
    String API_PATH = "/api";

    // common json keys
    String SUCCESS_JSON_KEY = "success";
    String MESSAGE_JSON_KEY = "message";

    // common messages
    String UNAUTHORIZED_USER_MESSAGE = "You should be authorised";

    interface UserConstants {
        // api path
        String CREATE_USER_PATH = API_PATH + "/auth/register";
        String LOGIN_USER_PATH = API_PATH + "/auth/login";
        String UPDATE_USER_PATH = API_PATH + "/auth/user";
        String DELETE_USER_PATH = API_PATH + "/auth/user";

        // response message
        String USER_ALREADY_EXISTS_MESSAGE = "User already exists";
        String EMPTY_REQUIRED_FIELD_MESSAGE = "Email, password and name are required fields";
        String USER_REMOVED_MESSAGE = "User successfully removed";
        String INCORRECT_CREDENTIALS_MESSAGE = "email or password are incorrect";
        String EMAIL_ALREADY_IN_USE_MESSAGE = "User with such email already exists";

    }
}
