package com.dev.jk.java.features.stream.controller;

import com.dev.jk.java.domain.DomainResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequestMapping("/api/java/features/stream")
public class StreamController {

    @GetMapping("/collect-list")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> collectIntoList() {
        DomainResponse domainResponse = new DomainResponse();
        domainResponse.appendContent("Stream examples: collected numbers divisible by 3 upto 10");
        List<Integer> numbers = getIntegers(10);
        Stream<Integer> numbersStream =  numbers.stream().filter((i) -> i % 3 == 0);
        List<Integer> results = numbersStream.collect(Collectors.toList());
        return ResponseEntity.ok(domainResponse.appendContent(results.toString()));
    }

    @GetMapping("/collect-set")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> collectIntoSet() {
        DomainResponse domainResponse = new DomainResponse();
        domainResponse.appendContent("Stream examples: collected numbers divisible by 4 upto 10 to set");
        List<Integer> numbers = getIntegers(10);
        Stream<Integer> numbersStream =  numbers.stream().filter((i) -> i % 4 == 0);
        Set<Integer> results = numbersStream.collect(Collectors.toSet());
        return ResponseEntity.ok(domainResponse.appendContent(results.toString()));
    }

    @GetMapping("/collect-distinct")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> collectIntoSets() {
        DomainResponse domainResponse = new DomainResponse();
        domainResponse.appendContent("Stream examples: collect distinct numbers ");
        Integer[] integers = {3, 6, 3, 6, 9};
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, integers);
        List<Integer> distinctNumbers =  numbers.stream().distinct().collect(Collectors.toList());
        return ResponseEntity.ok(domainResponse.appendContent(distinctNumbers.toString()));
    }

    private List<Integer> getIntegers(int upperBound) {
        List<Integer> integers = new ArrayList<>();
        for(int i=0; i < upperBound; i++) {
            integers.add(Integer.valueOf(i));
        }
        return integers;
    }

}
