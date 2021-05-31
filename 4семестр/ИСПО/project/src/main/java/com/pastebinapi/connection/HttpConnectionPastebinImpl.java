package com.pastebinapi.connection;

import com.pastebinapi.response.Response;
import com.pastebinapi.response.ResponseResult;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class HttpConnectionPastebinImpl {
    private final static String pastebinApiPost = "https://pastebin.com/api/api_post.php";
    private final PostParameters postParameters = new PostParameters();
    public HttpConnectionPastebinImpl() {
    }

    public void Add(String key, String value) {
        postParameters.put(key, value);
    }

    public void Remove(String key) {
        postParameters.remove(key);
    }

    private HttpURLConnection openConnection() throws IOException {
        return (HttpURLConnection) URI
                .create(pastebinApiPost)
                .toURL()
                .openConnection();
    }

    private void send(OutputStream stream) throws IOException {
        try (DataOutputStream outputStream = new DataOutputStream(stream)) {
            outputStream.write(postParameters.toUrl().getBytes(StandardCharsets.UTF_8));
        }
    }

    private String getResponse(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder builder = new StringBuilder();
        for (String line; (line = reader.readLine()) != null; ) {
            builder.append(line).append('\n');
        }
        return builder.toString();
    }

    private Response returnResponse(String response) {
        if (response.startsWith("Bad API request")) {
            return ResponseResult.error(response);
        }
        return ResponseResult.success(response);
    }

    public Response post() {
        HttpURLConnection connection;
        try {
            connection = openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            send(connection.getOutputStream());
            return returnResponse(getResponse(connection.getInputStream()));
        } catch (IOException e) {
            return ResponseResult.error("Unable to connect to Pastebin");
        }
    }
}
