package com.picpay.hexagonal.adapters.out;

import com.picpay.hexagonal.adapters.out.repository.CustomerRepository;
import com.picpay.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.picpay.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.picpay.hexagonal.application.core.domain.Customer;
import com.picpay.hexagonal.application.ports.out.InsertCustomerOutpuPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutpuPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
//