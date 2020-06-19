package com.redrobin.armaconqueror.security.models;

import lombok.Data;

@Data
public class ConquerorUser {
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}

