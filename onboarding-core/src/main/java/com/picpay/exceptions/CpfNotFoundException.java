package com.picpay.exceptions;

public class CpfNotFoundException extends RuntimeException{
    public CpfNotFoundException(String message){
        super(message);
    }
}
