package com.example.paymentservice.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public class AccountResponse {

    private Long id;

    private Long amount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
