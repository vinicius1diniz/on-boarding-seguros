package com.picpay.adapter.controller.mapper;

import com.picpay.adapter.controller.request.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.picpay.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
}
