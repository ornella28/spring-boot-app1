package se.lexicon.spring_boot_app.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.spring_boot_app.entity.Address;
import se.lexicon.spring_boot_app.entity.Customer;
import se.lexicon.spring_boot_app.entity.UserProfile;
import se.lexicon.spring_boot_app.repository.AddressRepository;
import se.lexicon.spring_boot_app.repository.CustomerRepository;
import se.lexicon.spring_boot_app.repository.UserProfileRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {


    /*
    * for inserting in the database
    * */
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final UserProfileRepository userProfileRepository;

    public MyCommandLineRunner(CustomerRepository customerRepository, AddressRepository addressRepository, UserProfileRepository userProfileRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /* Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("joe@test.com");

        Address address = new Address();
        address.setStreet("123 Main St");
        address.setZipcode("12345");
        address.setCity("New York");

        customer.setAddress(address);

        UserProfile  userProfile = new UserProfile();
        userProfile.setNickname("John");
        userProfile.setPhoneNumber("1234567890");
        userProfile.setBio("John Doe");

        customer.setUserProfile(userProfile);

        customerRepository.save(customer);


        UserProfile savedUserProfile = userProfileRepository.save(userProfile);

        Customer savedCustomer = customerRepository.save(customer);

        *a builder method for inserting in the DB
        */

        Address address = Address.builder()
                .street("Main Street 1")
                .city("Stockholm")
                .zipcode("12345")
                .build();

        UserProfile userProfile = UserProfile.builder()
                .nickname("John")
                .phoneNumber("12345678")
                .bio("John Doe")
                .build();

        Customer customer = Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .email("joe@test.com")
                .address(address)
                .userProfile(userProfile)
                .build();

        customerRepository.save(customer);





    }


}
