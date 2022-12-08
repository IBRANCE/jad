package com.jad.jad.biz.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class PriceController {

    @GetMapping("/price/get")
    public Flux<String> getPrice() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(x -> "test" + ThreadLocalRandom.current().nextDouble(100));
    }

    @GetMapping("/get/val")
    public String getVal() {
        return "test";
    }

}
