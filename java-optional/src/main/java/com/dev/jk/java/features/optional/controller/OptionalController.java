package com.dev.jk.java.features.optional.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/api/java/features")
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

    @GetMapping("/optional")
    @ResponseStatus(HttpStatus.OK)
    public Optional<String> nullable(@RequestParam(name = "input", defaultValue = "") String input) {
        Optional<String> optional = Optional.empty();
        if(input != null && !input.isEmpty()) {
            optional = Optional.of(input);
        }
        optional = Optional.of(optional.orElse("Hello, there was no input provided for the request parameter named input !!!"));
        return optional;
    }

    @GetMapping("/optional/null")
    @ResponseStatus(HttpStatus.OK)
    public Optional<String> nullAssignment() {
        Optional<String> optional = Optional.ofNullable(null);
        return optional;
    }

    @GetMapping("/optional/filter-with-false")
    @ResponseStatus(HttpStatus.OK)
    public Optional<String> filterWithNullResults() {
        Optional<String> optional = Optional.empty();
        optional = optional.filter(
                (s) -> (s != null && !s.isEmpty())
        );
        return optional;
    }

    @GetMapping("/optional/filter-with-true")
    @ResponseStatus(HttpStatus.OK)
    public Optional<String> filterWithNonNullResults() {
        Optional<String> optional = Optional.ofNullable("Hello World!!!");
        optional = optional.filter(
                (value) -> value != null && !value.isEmpty()
        );
        return optional;
    }

    @GetMapping("/optional/or-else-with-original-value")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> orElseWithOriginalValue() {
        Optional<String> optional = Optional.ofNullable("ORIGINAL VALUE");
        return ResponseEntity.ok(optional.orElse("SUBSTITUTED VALUE"));
    }

    @GetMapping("/optional/or-else-with-substituted-value")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> orElseWithSubstitutedValue() {
        Optional<String> optional = Optional.empty();
        return ResponseEntity.ok(optional.orElse("SUBSTITUTED VALUE"));
    }

    @GetMapping("/optional/if-present-with-true")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> ifPresentWithTrue() {
        Optional<String> optional = Optional.of("Hello world");
        StringBuffer sb = new StringBuffer();
        optional.ifPresent((s) ->
        {
            System.out.println(s + " is present" );
            sb.append(s);
            sb.append(" is present");
        }
        );
        return ResponseEntity.ok(sb.toString());
    }

    @GetMapping("/optional/if-present-with-false")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> ifPresentWithFalse() {
        Optional<String> optional = Optional.empty();
        StringBuffer sb = new StringBuffer();
        sb.append("****** Hello world is not present ******");
        optional.ifPresent((s) ->
                {
                    System.out.println(s + " is present" );
                    sb.append(s);
                    sb.append(" is present");
                }
        );
        return ResponseEntity.ok(sb.toString());
    }

    @GetMapping("/optional/or-else-get-with-false")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> orElseGetWithFalse() {
        Optional<String> optional = Optional.empty();
        StringBuffer sb = new StringBuffer();
        sb.append("Returning supplier value");
        String results = optional.orElseGet(() ->
                sb.toString()
        );
        return ResponseEntity.ok(results);
    }

    @GetMapping("/optional/or-else-get-with-true")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> orElseGetWithTrue() {
        Optional<String> optional = Optional.of("Hello world! non empty value present");
        StringBuffer sb = new StringBuffer();
        sb.append("Returning supplier value");
        String results = optional.orElseGet(() ->
                sb.toString()
        );
        return ResponseEntity.ok(results);
    }

    @GetMapping("/optional/or-else-throw-with-exception")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> orElseThrowException() {
        Optional<String> optional = Optional.empty();
        String results = optional.orElseThrow(() ->
                new RuntimeException("Value not found. Hence throwing exception")
        );
        return ResponseEntity.ok(results);
    }

    @GetMapping("/optional/flatmap")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> flatmap() {
        Optional<String> optional = Optional.of("Hello");
        Function<String , Optional<String>> fun = (s) -> Optional.of(s + " added mapper");
        Optional<String> flatMapResults = optional.flatMap(fun);
        return ResponseEntity.ok(flatMapResults.get());
    }
}
