package com.picpay.mapper;

import com.picpay.client.response.AdressResponse;
import com.picpay.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdressResponseMapper {
    Address toAdress(AdressResponse adressResponse);
}
