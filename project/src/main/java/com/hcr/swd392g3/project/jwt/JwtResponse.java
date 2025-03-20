package com.hcr.swd392g3.project.jwt;

import java.io.Serializable;
import java.util.Set;

/*
This is class is required for creating a response containing the JWT to be returned to the user.
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    private Set<String> roles;
    private String redirectUrl;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getJwttoken() {
        return jwttoken;
    }


}
