package com.pastebinapi.paste;

public enum PasteFormat {
    XML("xml"),
    Kotlin("kotlin"),
    Java("java"),
    Javascript("javaScript"),
    Text("text");

    private final String value;

    PasteFormat(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PasteFormat fromValue(final String value) {
        switch (value) {
            case "xml":
                return XML;
            case "kotlin":
                return Kotlin;
            case "java":
                return Java;
            case "javaScript":
                return Javascript;
            case "text":
                return Text;
        }
        throw new UnsupportedOperationException(String.format("Unsupported paste format %s", value));
    }
}
