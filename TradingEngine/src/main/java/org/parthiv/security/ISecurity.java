package org.parthiv.security;

/**
 * This interface represents a security
 */
public interface ISecurity {
    /**
     * Return the unique identifier for the security.
     * @return string that represents the unique id of the security
     */
    public String getSecurityId();

    /**
     * Get the owner of the security
     * @return unique id of the owner of the security
     */
    public String getIssuer();
}
