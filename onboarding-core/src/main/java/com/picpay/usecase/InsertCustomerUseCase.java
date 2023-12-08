package com.picpay.usecase;

import com.picpay.domain.Customer;
import com.picpay.ports.in.InsertCustomerInputPort;
import com.picpay.ports.out.FindAddressByZipCodeOutpuPort;
import com.picpay.ports.out.InsertCustomerOutpuPort;
import com.picpay.ports.out.PublishCpfValidationOutPutPort;
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

    @Override
    public void insert(Customer customer, String zipCode ){
            var address = findAddressByZipCodeOutpuPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutpuPort.insert(customer);
        sendCpfForValidationOutputPort.sendValidation(customer.getCpf());
        validateAndPublishCpfUseCase.validateAndPublish(customer.getCpf());
    }

}
