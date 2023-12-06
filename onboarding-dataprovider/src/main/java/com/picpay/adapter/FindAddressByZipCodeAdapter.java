package com.picpay.adapter;

import com.picpay.client.response.AdressResponse;
import com.picpay.domain.Address;
import com.picpay.mapper.AdressResponseMapper;
import com.picpay.ports.out.FindAddressByZipCodeOutpuPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutpuPort {

    @Autowired
    private  FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AdressResponseMapper adressResponseMapper;
    @Override
    public Address find(String zipcode) {
        AdressResponse address = findAddressByZipCodeClient.find(zipcode);
        return adressResponseMapper.toAdress(address);
    }
}
