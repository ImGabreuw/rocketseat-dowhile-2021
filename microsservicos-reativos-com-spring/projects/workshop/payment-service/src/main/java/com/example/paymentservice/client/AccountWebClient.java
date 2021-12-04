package com.example.paymentservice.client;

import com.example.paymentservice.response.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Service
public class AccountWebClient {

    private final WebClient webClient;

    public AccountWebClient(WebClient.Builder builder) {
        webClient = WebClient.builder()
                .baseUrl("http://localhost:8082/account")
                .build();
    }

    public Flux<AccountResponse> listAllAccounts() {
        log.info("Buscando todas as contas criadas");
        return webClient
                .get()
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(AccountResponse.class);
    }

}
