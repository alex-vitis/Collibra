package com.collibra.util;

import com.collibra.util.data.Comment;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.Assert;

/**
 * Created by vitis on 11.03.2017.
 */
public class JsonReader {
    public static Object readJson(RestApiResponce templ, String jsonPath) {
        return readJson(templ.getBodyAsString(), jsonPath);
    }

    public static Object readJson(String json, String jsonPath) {
        try {
            return JsonPath.read(json, jsonPath);
        } catch (Exception e) {
            throw new RuntimeException("Cann't read json file " + json, e);
        }
    }

    public static int countNumOfElem(RestApiResponce resp) {
        JSONArray arr = (JSONArray) readJson(resp, "$.[*]");
        return arr.size();
    }

    // Read from JSON and inialize Comment object
    public static Comment readComment(RestApiResponce resp, int i) {
        Comment cm = new Comment();
        Object name = readJson(resp, "[" + i + "].name");
        Assert.assertNotNull(name);
        cm.setCommenterName((String) name);

        name = readJson(resp, "[" + i + "].email");
        Assert.assertNotNull(name);
        cm.setCommenterEmail((String) name);

        name = readJson(resp, "[" + i + "].body");
        Assert.assertNotNull(name);
        cm.setCommentBody((String) name);

        name = readJson(resp, "[" + i + "].postId");
        Assert.assertNotNull(name);
        cm.setPostId((Integer) name);

        return cm;
    }
}
