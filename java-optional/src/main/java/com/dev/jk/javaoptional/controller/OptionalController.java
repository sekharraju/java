package com.dev.jk.javaoptional.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/java/feature")
public class OptionalController {

    @GetMapping("/optional/empty")
    @ResponseStatus(HttpStatus.OK)
    public Optional<String> empty() {
        Optional<String> optional = Optional.empty();
        return optional;
    }

    @GetMapping("/optional/non-empty")
    @ResponseStatus(HttpStatus.OK)
    public Optional<String> nonempty() {
        Optional<String> optional = Optional.of("Hello, Welcome to Java world!!!");
        return optional;
    }

}
