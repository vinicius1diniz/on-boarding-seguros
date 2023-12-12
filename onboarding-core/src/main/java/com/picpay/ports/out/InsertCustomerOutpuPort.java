package com.picpay.ports.out;

import com.picpay.domain.Customer;
public interface InsertCustomerOutpuPort {
    boolean insert(Customer customer);
}
