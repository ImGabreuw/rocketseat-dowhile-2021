package com.example.paymentservice.client;

import com.example.paymentservice.response.AccountResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(
        url = "http://localhost:8082/account",
        name = "accountService"
)
public interface AccountFeignClient {

    @GetMapping(path = "/{id}")
    Mono<AccountResponse> getAccountById(@RequestParam String id);

}
