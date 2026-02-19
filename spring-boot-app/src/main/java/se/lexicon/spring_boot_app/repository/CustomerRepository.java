package se.lexicon.spring_boot_app.repository;

import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.spring_boot_app.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    /*
    * Using optional in case the customer does not exist
    * */
    Optional<Customer> findByEmail(String email);
    List<Customer> findByLastNameIgnoreCase(String lastName);
    List<Customer> findByAddressCityIgnoreCase(String city);



}
