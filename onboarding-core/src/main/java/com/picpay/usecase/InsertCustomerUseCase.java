package com.picpay.usecase;

import com.picpay.domain.Customer;
import com.picpay.ports.in.InsertCustomerInputPort;
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
    private  final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;




    @Override
    public boolean insert(Customer customer, String zipCode ){
        try{
            var address = findAddressByZipCodeOutpuPort.find(zipCode);
            customer.setAddress(address);
            sendCpfForValidationOutputPort.sendValidation(customer.getCpf());
//            customer.setIsValidCpf(sendCpfForValidationOutputPort.sendValidation(customer.getCpf()));
            insertCustomerOutpuPort.insert(customer);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }


    }

}
