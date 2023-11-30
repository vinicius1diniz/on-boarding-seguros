package com.example.hexagonal.adapters.out;

import com.example.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.example.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.example.hexagonal.application.core.domain.Adress;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutpuPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutpuPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;
    @Override
    public Adress find(String zipcode) {
        var addressResponse = findAddressByZipCodeClient.find(zipcode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
