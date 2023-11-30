package com.example.hexagonal.adapters.out.client.mapper;

import com.example.hexagonal.adapters.out.client.response.AddressResponse;
import com.example.hexagonal.application.core.domain.Adress;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

     Adress toAddress(AddressResponse addressResponse);
}
