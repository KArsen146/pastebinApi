package com.pastebinapi.response;

import org.jetbrains.annotations.NotNull;

public class SuccessResponse implements Response {
    @NotNull
    private final String payload;

    public SuccessResponse(@NotNull String payload) {
        this.payload = payload;
    }

    @Override
    public boolean isError() {
        return false;
    }

    @Override
    public String get() {
        return payload;
    }
}
