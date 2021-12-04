package com.example.paymentservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@With
public class Payment {

    @Id
    private String uuid;

    private String sellerId;

    private String customerId;

    private Long amount;

    private Long tax;

}
