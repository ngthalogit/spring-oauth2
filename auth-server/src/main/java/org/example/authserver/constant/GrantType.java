package org.example.authserver.constant;

public enum GrantType {
    CODE("code"),
    TOKEN("token"),
    UNKNOWN("unknown");


    private final String type;
    GrantType(String type) {
        this.type = type;
    }


    public static GrantType from(String code) {
        for (GrantType grantType : GrantType.values()) {
            if (grantType.type.equalsIgnoreCase(code)) {
                return grantType;
            }
        }
        return UNKNOWN;
    }
}
