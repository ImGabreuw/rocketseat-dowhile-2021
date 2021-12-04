package com.example.accountservice.controller;

import com.example.accountservice.model.Account;
import com.example.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping(path = "/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(CREATED)
    public Account createAccount(@RequestBody Account account) {
        log.info("Criando uma nova conta com as informações [{}]", account);
        return accountService.createAccount(account);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<Account> getAllAccounts() {
        log.info("Listando todas as contas cadastradas na base");
        return accountService.listAllAccounts();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        log.info("Buscando uma conta pelo id [{}]", id);
        return accountService.findAccountById(id);
    }

}
