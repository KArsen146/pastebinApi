package com.pastebinapi;

import com.pastebinapi.paste.ExpireDate;
import com.pastebinapi.paste.PasteFormat;
import com.pastebinapi.paste.PasteImpl;
import com.pastebinapi.pastebin.Pastebin;
import com.pastebinapi.pastebin.PastebinImpl;
import com.pastebinapi.response.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CommandList {
    public static String post(@NotNull String devKey,
                              @NotNull String pasteCode,
                              @Nullable String pasteName,
                              @Nullable ExpireDate expireDate,
                              @Nullable PasteFormat pasteFormat) {
        Pastebin pastebin = new PastebinImpl(devKey);
        Response result = pastebin.post(PasteImpl.createPaste(pasteCode, pasteName, expireDate, pasteFormat));
        if (result.isError()) {
            return String.format("Something gone wrong: %s", result.get());
        }
        return result.get();
    }

    public static String post(@NotNull String devKey,
                              @NotNull String pasteCode,
                              @Nullable String pasteName,
                              @Nullable String expireDate,
                              @Nullable String pasteFormat) {
        Pastebin pastebin = new PastebinImpl(devKey);
        Response result = pastebin.post(PasteImpl.createPaste(pasteCode, pasteName,
                expireDate != null ? ExpireDate.fromValue(expireDate) : ExpireDate.Never,
                pasteFormat != null ? PasteFormat.fromValue(pasteFormat) : PasteFormat.Text));
        if (result.isError()) {
            return String.format("Something gone wrong: %s", result.get());
        }
        return result.get();
    }
    
    public static String simplePost(@NotNull String devKey, @NotNull String pasteCode) {
        Pastebin pastebin = new PastebinImpl(devKey);
        Response result = pastebin.post(PasteImpl.createSimplePaste(pasteCode));
        if (result.isError()) {
            return String.format("Something gone wrong: %s", result.get());
        }
        return result.get();
    }
}
