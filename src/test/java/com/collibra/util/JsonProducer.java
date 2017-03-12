package com.collibra.util;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by vitis on 11.03.2017.
 */
public class JsonProducer {
    public enum JsonTemplate {
        ADD_POST
    }

    public static String renderAddPost(int userId, String title, String body) {
        return String.format(loadJson(JsonTemplate.ADD_POST), userId, title, body);
    }

    public static String loadJson(JsonTemplate jsonTemplate) {
        String fileName = "/json_" + jsonTemplate.toString().toLowerCase() + ".json";
        InputStream is = JsonProducer.class.getResourceAsStream(fileName);
        Assert.assertNotNull("Cann't find file " + fileName, is);
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(is, writer, "utf-8");
        } catch (IOException e) {
            Assert.assertFalse("Cann't load json from file " + fileName + e.getMessage(), true);
        }
        String json = writer.toString();
        return json;
    }
}
