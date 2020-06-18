package com.redrobin.armaconqueror.security.services;

import com.redrobin.armaconqueror.security.exceptions.EmailExistsException;
import com.redrobin.armaconqueror.security.models.AuthenticatedUser;
import com.redrobin.armaconqueror.security.models.ConquerorUser;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface ConquerorUserService extends UserDetailsService {
    public AuthenticatedUser registerNewUserAccount(ConquerorUser accountDto) throws EmailExistsException;
}

