package com.picpay.adapter;

import com.picpay.database.entity.CustomerEntity;
import com.picpay.database.repository.CustomerRepository;
import com.picpay.mapper.CustomerEntityMapper;
import com.picpay.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.picpay.ports.out.InsertCustomerOutpuPort;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutpuPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
            customerRepository.save(customerEntity);
    }
}
