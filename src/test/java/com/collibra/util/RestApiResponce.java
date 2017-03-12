package com.collibra.util;

import org.springframework.http.ResponseEntity;

/**
 * Created by vitis on 11.03.2017.
 */
public class RestApiResponce<T> {
    private String url;
    private ResponseEntity<T> response;

    public RestApiResponce(String url, ResponseEntity<T> responce) {
        this.url = url;
        this.response = responce;
    }

    public String getUrl() {
        return url;
    }

    public String getBodyAsString() {
        T body = response.getBody();
        if (body == null) {
            return null;
        }
        return body.toString();
    }

    public T getBody() {
        return response.getBody();
    }

    public int getHttpCode() {
        return response.getStatusCode().value();
    }

    public String getHeaderValue(String headerName) {
        return response.getHeaders().getFirst(headerName);
    }

}
