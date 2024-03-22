package org.example.authserver.constant;

public enum GrantType {
    AUTHORIZATION_CODE("authorization_code"),
    TOKEN("token"),
    UNKNOWN("unknown");


    private final String type;
    GrantType(String type) {
        this.type = type;
    }


    public static GrantType from(String type) {
        for (GrantType grantType : GrantType.values()) {
            if (grantType.type.equalsIgnoreCase(type)) {
                return grantType;
            }
        }
        return UNKNOWN;
    }
}
