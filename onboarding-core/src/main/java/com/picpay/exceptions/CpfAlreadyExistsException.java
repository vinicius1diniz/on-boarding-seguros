package com.picpay.exceptions;

public class CpfAlreadyExistsException extends RuntimeException{
        public CpfAlreadyExistsException(String message){
            super(message);
        }

}
