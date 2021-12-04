package com.example.paymentservice.controller;

import com.example.paymentservice.client.AccountFeignClient;
import com.example.paymentservice.client.AccountWebClient;
import com.example.paymentservice.model.Payment;
import com.example.paymentservice.response.AccountResponse;
import com.example.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final AccountFeignClient accountFeignClient;
    private final AccountWebClient accountWebClient;

    @PostMapping
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        log.info("Criando um novo pagamento [{}]", payment);
        return paymentService.savePayment(payment);
    }

    @GetMapping(path = "/{id}")
    public Mono<Payment> getPaymentById(@PathVariable String id) {
        log.info("Buscando pagamento com o id [{}]", id);
        return paymentService.findPaymentById(id);
    }

    @GetMapping
    public Flux<Payment> findAllPayments() {
        log.info("Listando todos os pagamentos cadastrados na base");
        return paymentService.findAllPayments();
    }

    @GetMapping(path = "/account/{id}")
    public Mono<AccountResponse> getAccountById(@PathVariable String id) {
        log.info("Buscando o pagamento com o id [{}]", id);
        return accountFeignClient.getAccountById(id);
    }

    @GetMapping(path = "/account")
    public Flux<AccountResponse> findAllAccounts() {
        log.info("Listando todas as contas");
        return accountWebClient.listAllAccounts();
    }

}
