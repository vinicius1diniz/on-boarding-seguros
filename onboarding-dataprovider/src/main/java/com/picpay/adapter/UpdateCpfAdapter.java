package com.picpay.adapter;

import com.picpay.database.entity.CustomerEntity;
import com.picpay.database.repository.CustomerRepository;
import com.picpay.domain.Customer;
import com.picpay.mapper.CustomerEntityMapper;
import com.picpay.ports.out.UpdateCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCpfAdapter implements UpdateCpfOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void updateValidCpf(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
