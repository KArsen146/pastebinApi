package com.pastebinapi;

import com.pastebinapi.paste.ExpireDate;
import com.pastebinapi.paste.PasteFormat;

public class Main {
    public static void main(String args[]) {
        System.out.println(CommandList.post("v2gvvuSlNTV5ewPUwMICqT27VcN5JFgp",
                "package com.pastebinapi.paste;\n" +
                        "\n" +
                        "public enum PasteFormat {\n" +
                        "    xml(\"XML\"),\n" +
                        "    kotlin(\"Kotlin\"),\n" +
                        "    java(\"Java\"),\n" +
                        "    javascript(\"JavaScript\"),\n" +
                        "    text(\"text\");\n" +
                        "\n" +
                        "    private final String value;\n" +
                        "\n" +
                        "    PasteFormat(final String value) {\n" +
                        "        this.value = value;\n" +
                        "    }\n" +
                        "\n" +
                        "    public String getValue() {\n" +
                        "        return value;\n" +
                        "    }\n" +
                        "\n" +
                        "    public static PasteFormat fromValue(final String value) {\n" +
                        "        switch (value) {\n" +
                        "            case \"XML\":\n" +
                        "                return xml;\n" +
                        "            case \"Kotlin\":\n" +
                        "                return kotlin;\n" +
                        "            case \"Java\":\n" +
                        "                return java;\n" +
                        "            case \"JavaScript\":\n" +
                        "                return javascript;\n" +
                        "            case \"Text\":\n" +
                        "                return text;\n" +
                        "        }\n" +
                        "        throw new UnsupportedOperationException(String.format(\"Unsupported paste format %s\", value));\n" +
                        "    }\n" +
                        "}\n",
                "Paste format",
                ExpireDate.OneHour,
                PasteFormat.Java));
    }
}
