package com.favarao.helpdeskapi.constant;

public class PathAuthConstant {
    public static final String VERSION = "v1";

    public static final String BASE_PATH = "/api/" + VERSION;

    public static final String BASE_PATH_AUTH = BASE_PATH + "/auth";

    public static final String BASE_PATH_AUTH_LOGIN = BASE_PATH_AUTH + "/login";

    public static final String BASE_PATH_AUTH_SUBSCRIBE = BASE_PATH_AUTH + "/subscribe";

    public static final String BASE_PATH_TRANSACTION = BASE_PATH + "/transactions";
}
