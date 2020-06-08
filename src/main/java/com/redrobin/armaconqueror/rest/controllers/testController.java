package com.redrobin.armaconqueror.rest.controllers;

import com.redrobin.armaconqueror.rest.models.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    private static final String template = "hello %s";

    @GetMapping("/greeting")
    public Test test(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Test(String.format(template, name));
    }
}
