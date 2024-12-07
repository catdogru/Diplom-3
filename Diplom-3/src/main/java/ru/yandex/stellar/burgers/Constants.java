package ru.yandex.stellar.burgers;

public class Constants {
    public static final String STELLAR_BURGERS_BASE_API_URI = "https://stellarburgers.nomoreparties.site";
    public static final String API_PATH = "/api";

    // common json keys
    public static final String SUCCESS_JSON_KEY = "success";
    public static final String MESSAGE_JSON_KEY = "message";

    public static class UserConstants {
        // api path
        public static final String CREATE_USER_PATH = API_PATH + "/auth/register";
        public static final String DELETE_USER_PATH = API_PATH + "/auth/user";

        // response message
        public static final String USER_REMOVED_MESSAGE = "User successfully removed";
    }
}
