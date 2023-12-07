package com.picpay.adapter;

import com.picpay.database.entity.CustomerEntity;
import com.picpay.database.repository.CustomerRepository;
import com.picpay.ports.out.ValidateCpfOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateCpfAdapter implements ValidateCpfOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void updateValidCpf(String cpf, boolean status) {
        CustomerEntity customer =  customerRepository.findByCpf(cpf);
        customer.setIsValidCpf(status);
        customerRepository.save(customer);
    }
}
