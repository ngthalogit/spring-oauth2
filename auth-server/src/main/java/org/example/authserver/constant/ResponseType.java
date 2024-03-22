package org.example.authserver.constant;

public enum ResponseType {
    CODE("code"),
    TOKEN("token"),
    UNKNOWN("unknown");


    private final String type;
    ResponseType(String type) {
        this.type = type;
    }


    public static ResponseType from(String code) {
        for (ResponseType responseType : ResponseType.values()) {
            if (responseType.type.equalsIgnoreCase(code)) {
                return responseType;
            }
        }
        return UNKNOWN;
    }
}
