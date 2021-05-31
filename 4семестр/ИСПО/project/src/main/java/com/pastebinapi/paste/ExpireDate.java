package com.pastebinapi.paste;

public enum ExpireDate {
    Never("N"),
    TenMinutes("10M"),
    OneHour("1H"),
    OneDay("1D"),
    OneWeek("1W"),
    TwoWeeks("2W"),
    OneMonth("1M"),
    SixMonths("6M"),
    OneYear("1Y");

    private final String value;

    ExpireDate(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExpireDate fromValue(final String value) {
        switch (value) {
            case "N":
                return Never;
            case "10M":
                return TenMinutes;
            case "1H":
                return OneHour;
            case "1D":
                return OneDay;
            case "1W":
                return OneWeek;
            case "2W":
                return TwoWeeks;
            case "1M":
                return OneMonth;
            case "6M":
                return SixMonths;
            case "1Y":
                return OneYear;
        }
        throw new UnsupportedOperationException(String.format("Unsupported expire date %s", value));
    }
}
