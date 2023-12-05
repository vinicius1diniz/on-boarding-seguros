package com.picpay.hexagonal.adapters.out;

import com.picpay.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.picpay.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.picpay.hexagonal.application.core.domain.Adress;
import com.picpay.hexagonal.application.ports.out.FindAddressByZipCodeOutpuPort;
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
