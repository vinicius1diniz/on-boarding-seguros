package com.picpay.exceptions;

public class AddresNotFoundException extends RuntimeException {
    public AddresNotFoundException(String message){
        super(message);
    }
}
