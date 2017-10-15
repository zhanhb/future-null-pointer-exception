package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public Future<?> test() {
        return CompletableFuture.supplyAsync(() -> null);
    }

}
