package com.picpay.adapter;

import com.picpay.database.entity.CustomerEntity;
import com.picpay.database.repository.CustomerRepository;
import com.picpay.domain.Customer;
import com.picpay.mapper.CustomerEntityMapper;
import com.picpay.ports.out.FIndCustomerByCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByCpfAdapter implements FIndCustomerByCpfOutputPort {
    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;
    @Override
    public Optional<Customer> findByCpf(String cpf) {
        Optional<CustomerEntity> customerEntity = customerRepository.findByCpf(cpf);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
