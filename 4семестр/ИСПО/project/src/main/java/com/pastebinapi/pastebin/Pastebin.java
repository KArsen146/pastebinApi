package com.pastebinapi.pastebin;

import com.pastebinapi.paste.Paste;
import com.pastebinapi.response.Response;
import org.jetbrains.annotations.NotNull;

public interface Pastebin {
    @NotNull
    Response post(Paste paste);
}
