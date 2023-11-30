package com.example.hexagonal.application.core.usecase;

import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.example.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutpuPort;
import com.example.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

   private final FindCustomerByIdInputPort findCustomerByIdInputPort;

   private final FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort;
   private final UpdateCustomerOutputPort updateCustomerOutputPort;

   public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort,
                                UpdateCustomerOutputPort updateCustomerOutputPort){
       this.findCustomerByIdInputPort = findCustomerByIdInputPort;
       this.findAddressByZipCodeOutpuPort = findAddressByZipCodeOutpuPort;
       this.updateCustomerOutputPort = updateCustomerOutputPort;
   }

   @Override
    public void update(Customer customer, String zipCode){
       findCustomerByIdInputPort.find(customer.getId());
       var address = findAddressByZipCodeOutpuPort.find(zipCode);
       customer.setAdress(address);
       updateCustomerOutputPort.update(customer);

    }
}
