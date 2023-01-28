package com.example.organization_info.security;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 4L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

}