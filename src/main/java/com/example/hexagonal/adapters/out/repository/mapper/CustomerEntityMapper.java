package com.example.hexagonal.adapters.out.repository.mapper;

import com.example.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.example.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}

