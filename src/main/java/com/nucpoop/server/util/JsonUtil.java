package com.nucpoop.server.util;

import com.google.gson.Gson;

public class JsonUtil {

    private static final Gson gson = new Gson();

    private JsonUtil() {

    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

}
