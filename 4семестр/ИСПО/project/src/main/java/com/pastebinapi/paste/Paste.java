package com.pastebinapi.paste;

public interface Paste {
    String getPasteCode();
    String getPasteName();
    ExpireDate getExpireDate();
    PasteFormat getPasteFormat();
}
