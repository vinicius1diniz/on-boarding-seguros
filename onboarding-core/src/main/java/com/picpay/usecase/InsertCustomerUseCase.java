package com.picpay.usecase;

import com.picpay.domain.Address;
import com.picpay.domain.Customer;
import com.picpay.exceptions.AddresNotFoundException;
import com.picpay.exceptions.CpfAlreadyExistsException;
import com.picpay.ports.in.InsertCustomerInputPort;
import com.picpay.ports.out.FIndCustomerByCpfOutputPort;
import com.picpay.ports.out.FindAddressByZipCodeOutpuPort;
import com.picpay.ports.out.InsertCustomerOutpuPort;
import com.picpay.ports.out.SendCpfForValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InsertCustomerUseCase implements InsertCustomerInputPort {


    private final FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort;

    private final InsertCustomerOutpuPort insertCustomerOutpuPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;
    private final ValidateAndPublishCpfUseCase validateAndPublishCpfUseCase;
    private final FIndCustomerByCpfOutputPort fIndCustomerByCpfOutputPort;

    @Override
    public void insert(Customer customer, String zipCode ){
        Address address;
        try{
            address = findAddressByZipCodeOutpuPort.find(zipCode);
        }catch(Exception e){
            throw new AddresNotFoundException("Invalid ZipCode");
        }
        boolean isPresent = fIndCustomerByCpfOutputPort.findByCpf(customer.getCpf()).isPresent();
        if(isPresent){
            throw new CpfAlreadyExistsException("Cpf already exists");
        }
        customer.setAddress(address);
        insertCustomerOutpuPort.insert(customer);
        sendCpfForValidationOutputPort.sendValidation(customer.getCpf());
    }

}
