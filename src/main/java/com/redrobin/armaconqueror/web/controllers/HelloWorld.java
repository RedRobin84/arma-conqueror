package com.redrobin.armaconqueror.web.controllers;

import javax.inject.Named;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Named
public class HelloWorld {

    public String showGreeting() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return "Hello " + authentication.getName();
    }
}