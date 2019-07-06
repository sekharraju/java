package com.dev.jk.java.features.lambda.controller;

import com.dev.jk.java.domain.DomainResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/java/features")
public class LambdaController {

    @GetMapping("/lambda/runnable")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> internalConsumer() {
        DomainResponse domainResponse = new DomainResponse();
        domainResponse.appendContent("Lambda example with Runnable: ");
        Thread thread = new Thread(
                ()  ->    domainResponse.appendContent(" Execution done within Runnable")
        );
        thread.run();
        return ResponseEntity.ok(domainResponse);
    }

    @GetMapping("/lambda/prime-int-stream")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> primeIntStream(@RequestParam(name = "number", defaultValue = "347") Integer number) {
        DomainResponse domainResponse = new DomainResponse();
        domainResponse.appendContent("Lambda with prime finding: ");
        boolean isPrime = number > 1
                && IntStream.range(2, number).noneMatch(index -> number % index == 0);
        return ResponseEntity.ok(domainResponse.appendContent(number.toString()).appendContent(" is prime ?: ").appendContent(Boolean.toString(isPrime)));
    }

    @GetMapping("/lambda/sum-with-predicate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> sumWithPredicate() {
        DomainResponse domainResponse = new DomainResponse();
        List<Integer> integers = getIntegerList(50);
        int sumOfFirst50Integers = integers.parallelStream().filter((i) -> (i > 0)).mapToInt((i) -> i).sum();
        domainResponse.appendContent("Lambda: sum-with-predicate: sum of first 50 integers is: " + sumOfFirst50Integers);
        return ResponseEntity.ok(domainResponse);
    }

    @GetMapping("/lambda/lazy-evaluation")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> lazyEvaluation() {
        DomainResponse domainResponse = new DomainResponse();
        List<Integer> integers = getIntegerList(100);
        Stream<Integer> integerStream = integers.stream().filter(NumberUtils::isOdd).filter(NumberUtils::isGreaterThan10).filter(NumberUtils::isLessThan1000);
        Optional<Integer> maxOddInteger = integerStream.max(Comparator.naturalOrder());
        Optional<Integer> mappedInteger = maxOddInteger.map((i) -> (i * i));
        Integer squaredResults = mappedInteger.get();
        domainResponse.appendContent("Lambda: max Odd Square Computation in first 100 integers results : " + squaredResults.intValue());
        return ResponseEntity.ok(domainResponse);
    }

    @GetMapping("/lambda/empty-params-empty-body")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> emptyBodyEmptyParams() {
        DomainResponse domainResponse = new DomainResponse();
        Thread thread = new Thread(() -> {});
        thread.run();
        domainResponse.appendContent("Lambda: Thread thread = new Thread(   () -> {}    )");
        return ResponseEntity.ok(domainResponse);
    }

    @GetMapping("/lambda/empty-params-no-curly-braces")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> emptyParamsNoCurlyBraces() {
        DomainResponse domainResponse = new DomainResponse();
        Supplier<Boolean> supplier = () -> true;
        supplier.get();
        domainResponse.appendContent("Lambda:  Supplier<Boolean> supplier = () -> true;");
        return ResponseEntity.ok(domainResponse);
    }

    @GetMapping("/lambda/empty-params-with-body")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> emptyParamsWithBody() {
        DomainResponse domainResponse = new DomainResponse();
        Thread thread = new Thread(() ->
            {
                System.out.println("Welcome to Lambda functions");
                System.out.println("Lambda functions with body");
            });
        thread.run();
        domainResponse.appendContent("Lambda: Thread thread = new Thread(   () ->" +
                "            {  " +
                "                   System.out.println(\"Welcome to Lambda functions\");" +
                "                   System.out.println(\"Lambda functions with body\");" +
                "            }  );");
        return ResponseEntity.ok(domainResponse);
    }

    @GetMapping("/lambda/empty-params-with-single-line-body")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DomainResponse> emptyParamsWithSingleLineBody() {
        DomainResponse domainResponse = new DomainResponse();
        Thread thread = new Thread(() -> System.out.println("Welcome to Lambda functions"));
        thread.run();
        domainResponse.appendContent("Lambda: Thread thread = Thread thread = new Thread(   () -> System.out.println(\"Welcome to Lambda functions\")   );");
        return ResponseEntity.ok(domainResponse);
    }

    private List<Integer> getIntegerList(int upperBound) {
        List<Integer> integers = new ArrayList<>();
        for(int i=0; i < upperBound; i++) {
            integers.add(Integer.valueOf(i));
        }
        return integers;
    }

    public static class NumberUtils {
        public static boolean isGreaterThan10(int i) {
            return i > 10;
        }

        public static boolean isLessThan1000(int i) {
            return i < 1000;
        }

        public static boolean isOdd(int i) {
            return i % 2 != 0;
        }
    }

}





