package com.example.hexagonal.adapters.in.controller.mapper;

import com.example.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.example.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.example.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @Mapping(target = "adress", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
