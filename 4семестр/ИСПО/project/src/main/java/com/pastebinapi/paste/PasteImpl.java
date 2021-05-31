package com.pastebinapi.paste;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PasteImpl implements Paste {
    @NotNull
    private final String pasteCode;
    @Nullable
    private final String pasteName;
    private final ExpireDate expireDate;
    @Nullable
    private final PasteFormat pasteFormat;

    public static PasteImpl createSimplePaste(@NotNull String pasteCode) {
        return new PasteImpl(pasteCode, null, ExpireDate.Never, PasteFormat.Text);
    }

    public static PasteImpl createSimplePaste(@NotNull String pasteCode, @Nullable String pasteName) {
        return new PasteImpl(pasteCode, pasteName, ExpireDate.Never, PasteFormat.Text);
    }

    public static PasteImpl createPaste(@NotNull String pasteCode, @Nullable String pasteName, ExpireDate expireDate, @Nullable PasteFormat pasteFormat){
        return new PasteImpl(pasteCode, pasteName, expireDate, pasteFormat);
    }

    private PasteImpl(@NotNull String pasteCode, @Nullable String pasteName, ExpireDate expireDate, @Nullable PasteFormat pasteFormat) {
        this.pasteCode = pasteCode;
        this.pasteName = pasteName;
        this.expireDate = expireDate;
        this.pasteFormat = pasteFormat;
    }

    @Override
    public @NotNull String getPasteCode() {
        return pasteCode;
    }

    @Override
    public @Nullable String getPasteName() {
        return pasteName;
    }

    @Override
    public ExpireDate getExpireDate() {
        return expireDate;
    }

    @Override
    public PasteFormat getPasteFormat() {
        return pasteFormat;
    }

}
