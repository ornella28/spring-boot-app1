package se.lexicon.spring_boot_app.service;

import se.lexicon.spring_boot_app.dto.request.CustomerRequest;
import se.lexicon.spring_boot_app.dto.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse register(CustomerRequest request);
    CustomerResponse findById(Long id);
    CustomerResponse update(Long id, CustomerRequest request);
}
