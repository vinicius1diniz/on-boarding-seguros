package com.picpay.ports.in;

import com.picpay.domain.Customer;

public interface InsertCustomerInputPort {

    boolean insert(Customer customer, String zipCode);
}
