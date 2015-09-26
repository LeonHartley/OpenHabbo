package com.openhabbo.commons.web.transformers;

import com.openhabbo.commons.json.JsonUtil;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {
    /**
     * Render the template as JSON using the GSON instance
     *
     * @param o The object which we need to transform into JSON format
     * @return JSON formatted string
     * @throws Exception
     */
    @Override
    public String render(Object o) throws Exception {
        try {
            String gsonString = JsonUtil.stringify(o);

            if (!gsonString.startsWith("{")) {
                return "{\"response\":" + gsonString + "}";
            } else {
                return gsonString;
            }
        } catch (Exception e) {
            return JsonUtil.stringify(e);
        } finally {
            // Dispose object..
        }
    }
}
