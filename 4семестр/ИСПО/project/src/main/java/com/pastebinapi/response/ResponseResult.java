package com.pastebinapi.response;

public interface ResponseResult {
    static Response success(String result) {
        return new SuccessResponse(result);
    }

    static Response error(String message) {
        return new FailedResponse(message);
    }

    static Response error(Exception e) {
        return new FailedResponse(e.getMessage());
    }
}
