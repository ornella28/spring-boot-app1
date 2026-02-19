package se.lexicon.spring_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.spring_boot_app.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByZipcode(String zipcode);


    /*
    * Optional part
    * */
    List<Address> findByCityIgnoreCase(String city);
    List<Address> findByStreetContainingIgnoreCase(String street);
    long countByZipcode(@Param("zip") String zipcode);
    List<Address> findByZipcodeStartingWith(String zipcode);



}
