package com.openhabbo.commons.json;

import com.google.gson.Gson;


public class JsonUtil {
    private static final Gson gsonInstance = new Gson();

    public static <T> T parse(Class<T> clazz, String payload) {
        return gsonInstance.fromJson(payload, clazz);
    }

    public static String stringify(Object obj) {
        return gsonInstance.toJson(obj);
    }

    public static Gson getGsonInstance() {
        return gsonInstance;
    }
}
