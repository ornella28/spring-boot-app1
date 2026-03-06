package se.lexicon.spring_boot_app.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.lexicon.spring_boot_app.dto.request.CustomerRequest;
import se.lexicon.spring_boot_app.dto.response.CustomerResponse;
import se.lexicon.spring_boot_app.entity.Customer;
import se.lexicon.spring_boot_app.mapper.CustomerMapper;
import se.lexicon.spring_boot_app.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper  customerMapper;

    //Register a new customer

    @Override
    @Transactional
    public CustomerResponse register(CustomerRequest request){
        if (customerRepository.existsByEmail(request.email())){
            throw new IllegalArgumentException("Email already taken");
        }

        Customer customer = customerMapper.toEntity(request);
        Customer saved =  customerRepository.save(customer);
        return customerMapper.toCustomerResponse(saved);
    }

    //Find custome by id

    @Override
    public CustomerResponse findById(Long id){

        Customer customer = customerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Customer not found"));

        return customerMapper.toCustomerResponse(customer);
    }

    //update customer

    @Override
    @Transactional
    public CustomerResponse update(Long id, CustomerRequest request){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Customer not found"));

        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());

        customer.getAddress().setStreet(request.street());
        customer.getAddress().setCity(request.city());
        customer.getAddress().setZipcode(request.zipCode());

        Customer updated = customerRepository.save(customer);

        return customerMapper.toCustomerResponse(updated);
    }


}
