package org.example.authserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenResponse {
    private String tokenType;
    private String expires_in;
    private String access_token;
    private String refreshToken;
    private String scope;

    private AccessTokenResponse(Builder builder) {
        setTokenType(builder.tokenType);
        setExpires_in(builder.expires_in);
        setAccess_token(builder.access_token);
        setRefreshToken(builder.refreshToken);
        setScope(builder.scope);
    }


    public static final class Builder {
        private String tokenType;
        private String expires_in;
        private String access_token;
        private String refreshToken;
        private String scope;

        public Builder() {
        }

        public Builder withTokenType(String val) {
            tokenType = val;
            return this;
        }

        public Builder withExpires_in(String val) {
            expires_in = val;
            return this;
        }

        public Builder withAccess_token(String val) {
            access_token = val;
            return this;
        }

        public Builder withRefreshToken(String val) {
            refreshToken = val;
            return this;
        }

        public Builder withScope(String val) {
            scope = val;
            return this;
        }

        public AccessTokenResponse build() {
            return new AccessTokenResponse(this);
        }
    }
}
