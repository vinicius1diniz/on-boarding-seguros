package com.example.hexagonal.application.core.usecase;

import com.example.hexagonal.application.core.domain.Adress;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutpuPort;
import com.example.hexagonal.application.ports.out.InsertCustomerOutpuPort;
import com.example.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort;

    private final InsertCustomerOutpuPort insertCustomerOutpuPort;

    private  final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort,
            InsertCustomerOutpuPort insertCustomerOutpuPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort){
        this.findAddressByZipCodeOutpuPort = findAddressByZipCodeOutpuPort;
        this.insertCustomerOutpuPort = insertCustomerOutpuPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode ){
        var address = findAddressByZipCodeOutpuPort.find(zipCode);
        customer.setAdress(address);
        insertCustomerOutpuPort.insert(customer);

    }

}
