package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public Future<?> test() {
        return CompletableFuture.supplyAsync(() -> null);
    }

}
