package com.collibra.test;

import com.collibra.util.RestApiResponce;
import com.collibra.util.ServerPart;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by vitis on 11.03.2017.
 */
public class RestBaseTest {
    protected ServerPart server;
    protected final String url = "https://jsonplaceholder.typicode.com";

    @Before
    public void beforeTest() {
        if (server == null) {
            server = new ServerPart(url);
        }
    }

    protected RestApiResponce validate(RestApiResponce r) {
        // Check status of response
        Assert.assertTrue(r.getHttpCode() >= 200 && r.getHttpCode() <= 299);
        Assert.assertNotNull(r.getBodyAsString());
        System.out.println("Response from server:" + r.getBodyAsString());
        return r;
    }

}
