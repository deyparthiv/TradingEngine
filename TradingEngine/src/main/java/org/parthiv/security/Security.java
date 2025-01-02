package org.parthiv.security;

/**
 * Represents a security;
 */
public class Security implements ISecurity{
    private final String id;
    private final String issuer;

    public Security(String id, String issuer) {
        this.id = id;
        this.issuer = issuer;
    }

    @Override
    public String getSecurityId() {
        return this.id;
    }

    @Override
    public String getIssuer() {
        return this.issuer;
    }
}
