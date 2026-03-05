package se.lexicon.spring_boot_app.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.spring_boot_app.dto.request.CustomerRequest;
import se.lexicon.spring_boot_app.dto.response.AddressResponse;
import se.lexicon.spring_boot_app.dto.response.CustomerResponse;
import se.lexicon.spring_boot_app.entity.Address;
import se.lexicon.spring_boot_app.entity.Customer;



@Component//Spring will automatically inject this mapper into the service layer
public class CustomerMapper {

    /*
    * transform entity -> dto method
    * */

    public CustomerResponse toCustomerResponse(Customer customer){

        if(customer == null){
            return null;
        }

        Address address = customer.getAddress();//we extract the address entity
        /*
        * we convert address into addressResponse
        * record does not use setters
        * */
        AddressResponse addressResponse = new AddressResponse(
                address.getStreet(),
                address.getCity(),
                address.getZipcode()
        );
        /*
        * we combine latName and firstName to get full name
        * and finally transform an entity into a DTO
        * */
        String fullName = customer.getFirstName() + " " + customer.getLastName();

        return new CustomerResponse(
                customer.getId(),
                fullName,
                customer.getEmail(),
                addressResponse
        );
    }

    /*
    * dto-> entity method
    * we convert customerRequest to customer Entity
    * we then create an address entity
    * we create a customer entity
    * */


    public Customer toEntity(CustomerRequest request){
        if (request == null){
            return null;
        }
        Address address = new Address(
                null,//id will be generated
                request.street(),
                request.city(),
                request.zipCode()
        );

        return new Customer(
                null,
                request.firstName(),
                request.lastName(),
                request.email(),
                null,
                address,
                null
        );
    }


}
