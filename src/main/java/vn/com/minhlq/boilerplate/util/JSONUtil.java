package vn.com.minhlq.boilerplate.util;

import com.google.gson.Gson;
import org.apache.commons.lang3.ObjectUtils;

public class JSONUtil {

    private JSONUtil() {}

    public static String toJsonStr(Object obj) {
        if (ObjectUtils.isEmpty(obj))
            return "";
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

}
