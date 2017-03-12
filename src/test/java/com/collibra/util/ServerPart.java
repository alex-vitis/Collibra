package com.collibra.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vitis on 11.03.2017.
 */
public class ServerPart {

    private final String URL_BASE;
    private RestTemplate rt;

    public ServerPart(String baseURL) {
        this.URL_BASE = baseURL;
        rt = new RestTemplate();
    }

    public RestApiResponce getCommentsFromServer() {
        final String url = URL_BASE + "/comments";
        return new RestApiResponce(url, rt.getForEntity(url, String.class));
    }

    public RestApiResponce addPostToServer(int userId, String title, String body) {
        final String url = URL_BASE + "/posts";
        String json = JsonProducer.renderAddPost(userId, title, body);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = null;
        return new RestApiResponce(url, rt.postForEntity(url, entity, String.class));
    }
}
