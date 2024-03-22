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
    private String expiresIn;
    private String accessToken;
    private String refreshToken;
    private String scope;

    private AccessTokenResponse(Builder builder) {
        setTokenType(builder.tokenType);
        setExpiresIn(builder.expiresIn);
        setAccessToken(builder.accessToken);
        setRefreshToken(builder.refreshToken);
        setScope(builder.scope);
    }


    public static final class Builder {
        private String tokenType;
        private String expiresIn;
        private String accessToken;
        private String refreshToken;
        private String scope;

        public Builder() {
        }

        public Builder withTokenType(String val) {
            tokenType = val;
            return this;
        }

        public Builder withExpiresIn(String val) {
            expiresIn = val;
            return this;
        }

        public Builder withAccessToken(String val) {
            accessToken = val;
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
