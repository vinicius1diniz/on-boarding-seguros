package com.picpay.adapter;

import com.picpay.client.response.AdressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${jhonatas.client.address.url}"
//        url = "localhost:8082/addresses"
)
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}")
    AdressResponse find(@PathVariable("zipCode") String zipcode);
}
