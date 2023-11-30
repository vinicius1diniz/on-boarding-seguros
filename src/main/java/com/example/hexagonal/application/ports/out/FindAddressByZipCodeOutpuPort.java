package com.example.hexagonal.application.ports.out;

import com.example.hexagonal.application.core.domain.Adress;

public interface FindAddressByZipCodeOutpuPort {

    Adress find(String zipcode);
}
