package com.example.paymentservice.service;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Mono<Payment> savePayment(Payment payment) {
        log.info("Criando um novo pagamento [{}]", payment);
        return paymentRepository.save(payment);
    }

    public Mono<Payment> findPaymentById(String id) {
        log.info("Buscando pagamento com o id [{}]", id);
        return paymentRepository
                .findById(id)
                .switchIfEmpty(
                        Mono.error(new ResponseStatusException(NOT_FOUND))
                );
    }

    public Flux<Payment> findAllPayments() {
        log.info("Listando todos os pagamentos cadastrados na base");
        return paymentRepository.findAll();
    }

}
