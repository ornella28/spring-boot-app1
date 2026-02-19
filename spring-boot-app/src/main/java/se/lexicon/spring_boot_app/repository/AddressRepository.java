package se.lexicon.spring_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.spring_boot_app.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByZipcode(String zipcode);
}
