package com.example.accountservice.service;

import com.example.accountservice.model.Account;
import com.example.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account createAccount(Account account) {
        log.info("Criando uma nova conta com as informações [{}]", account);
        return accountRepository.save(account);
    }

    public List<Account> listAllAccounts() {
        log.info("Listando todas as contas cadastradas na base");
        return accountRepository.findAll();
    }

    public ResponseEntity<Account> findAccountById(Long id) {
        log.info("Buscando uma conta pelo id [{}]", id);
        return accountRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
