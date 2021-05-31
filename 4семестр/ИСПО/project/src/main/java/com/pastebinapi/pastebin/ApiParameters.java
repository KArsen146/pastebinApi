package com.pastebinapi.pastebin;

public enum ApiParameters {
    DeveloperKey {
        @Override
        public String apiParameter() {
            return "api_dev_key";
        }
    },
    Option {
        @Override
        public String apiParameter() {
            return "api_option";
        }
    },
    PasteCode {
        @Override
        public String apiParameter() {
            return "api_paste_code";
        }
    },
    PasteName{
        @Override
        public String apiParameter() {
            return "api_paste_name";
        }
    },
    PasteFormat {
        @Override
        public String apiParameter() {
            return "api_paste_format";
        }
    },
    ExpireDate {
        @Override
        public String apiParameter() {
            return "api_paste_expire_date";
        }
    };
    public abstract String apiParameter();
}
