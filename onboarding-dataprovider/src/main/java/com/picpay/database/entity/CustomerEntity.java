package com.picpay.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "customers")
public class CustomerEntity {
    @Id
    private String id;

    private String name;
    private AddressEntity address;

    private String cpf;

    @Field(name = "is_valid_cpf")
    private Boolean isValidCpf;


}
