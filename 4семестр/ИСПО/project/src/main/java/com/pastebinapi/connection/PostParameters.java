package com.pastebinapi.connection;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostParameters {
    private Map<String, String> parameters = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        parameters.put(URLEncoder.encode(key , StandardCharsets.UTF_8),
                URLEncoder.encode(value, StandardCharsets.UTF_8));
    }

    public void remove(String key) {
        parameters.remove(URLEncoder.encode(key, StandardCharsets.UTF_8));
    }

    public String get(String key) {
        return parameters.get(URLEncoder.encode(key, StandardCharsets.UTF_8));
    }

    public String toUrl() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> parameter:
             parameters.entrySet()) {
            builder.append(parameter.getKey())
                    .append('=')
                    .append(parameter.getValue())
                    .append('&');
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }
}
