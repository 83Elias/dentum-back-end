package com.clinic.dentum.interfaces;

import com.clinic.dentum.model.Customer;

public interface ICustomerService {
    
  public Customer findByUsername(String username);
}
