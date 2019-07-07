package com.dev.jk.java.features.time.controller;

import com.dev.jk.java.domain.DomainResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/java/features")
public class TimeController {

    @GetMapping("/time/date-and-time")
    public ResponseEntity<DomainResponse> getDate() {
        DomainResponse domainResponse = new DomainResponse();
        domainResponse.appendContent("Date: ");
        LocalDate today = LocalDate.now();
        domainResponse.appendContent(today.toString());
        LocalTime localTime = LocalTime.now();
        domainResponse.appendContent("; Time: ");
        domainResponse.appendContent(localTime.toString());
        return ResponseEntity.ok(domainResponse);
    }



}

