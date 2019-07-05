package com.dev.jk.java.features.foreach.controller;

import com.dev.jk.java.domain.DomainResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/api/java/features")
public class ForEachController {

    @GetMapping("/foreach/internal-consumer")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> internalConsumer() {
        List<Integer> counter = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            counter.add(i);
        }
        DomainResponse domainResponse = new DomainResponse();
        counter.forEach((count)->{
            domainResponse.appendContent("**************** s.no:   ");
            domainResponse.appendContent(count.toString());
        });
        return ResponseEntity.ok(domainResponse);
    }

    @GetMapping("/foreach/external-consumer")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> externalConsumer() {
        List<Integer> counter = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            counter.add(i);
        }
        DomainResponse domainResponse = new DomainResponse();
        counter.forEach(new ExternalConsumer());
        domainResponse.appendContent(" DONE with internal side effect on consumer");
        return ResponseEntity.ok(domainResponse);
    }

    public static class ExternalConsumer implements Consumer<Integer> {
        @Override
        public void accept(Integer integer) {
            System.out.println(integer);
        }
    }

}




