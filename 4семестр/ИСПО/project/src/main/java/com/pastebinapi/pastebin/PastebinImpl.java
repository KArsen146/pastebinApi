package com.pastebinapi.pastebin;

import com.pastebinapi.connection.HttpConnectionPastebinImpl;
import com.pastebinapi.paste.Paste;
import com.pastebinapi.response.Response;
import org.jetbrains.annotations.NotNull;

public class PastebinImpl implements Pastebin {
    private final static String option = "paste";

    @NotNull
    private final String devKey;


    public PastebinImpl(@NotNull String devKey){
        this.devKey = devKey;
    }

    @Override
    public @NotNull Response post(Paste paste) {
        HttpConnectionPastebinImpl connectionPastebin = new HttpConnectionPastebinImpl();
        connectionPastebin.Add(ApiParameters.Option.apiParameter(), option);
        connectionPastebin.Add(ApiParameters.DeveloperKey.apiParameter(), devKey);
        connectionPastebin.Add(ApiParameters.PasteCode.apiParameter(), paste.getPasteCode());
        if (paste.getPasteName() != null) {
            connectionPastebin.Add(ApiParameters.PasteName.apiParameter(), paste.getPasteName());
        }
        connectionPastebin.Add(ApiParameters.ExpireDate.apiParameter(), paste.getExpireDate().getValue());
        connectionPastebin.Add(ApiParameters.PasteFormat.apiParameter(), paste.getPasteFormat().getValue());
        return connectionPastebin.post();
    }

}
