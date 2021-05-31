package com.pastebinapi.response;

import org.jetbrains.annotations.NotNull;

public class FailedResponse implements Response{
    @NotNull
    private final String payload;

    public FailedResponse(@NotNull String payload) {
        this.payload = payload;
    }

    @Override
    public boolean isError() {
        return true;
    }

    @Override
    public String get() {
        return payload;
    }
}
