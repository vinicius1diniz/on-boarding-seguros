package com.example.hexagonal.application.core.usecase;

import com.example.hexagonal.application.core.domain.Adress;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutpuPort;
import com.example.hexagonal.application.ports.out.InsertCustomerOutpuPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort;

    private final InsertCustomerOutpuPort insertCustomerOutpuPort;
    public InsertCustomerUseCase(FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort,
    InsertCustomerOutpuPort insertCustomerOutpuPort){
        this.findAddressByZipCodeOutpuPort = findAddressByZipCodeOutpuPort;
        this.insertCustomerOutpuPort = insertCustomerOutpuPort;
    }

    @Override
    public void insert(Customer customer, String zipCode ){
        var address = findAddressByZipCodeOutpuPort.find(zipCode);
        customer.setAdress(address);
        insertCustomerOutpuPort.insert(customer);
    }

}
