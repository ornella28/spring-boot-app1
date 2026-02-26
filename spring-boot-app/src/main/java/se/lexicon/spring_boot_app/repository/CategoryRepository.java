package se.lexicon.spring_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.spring_boot_app.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);

    //Optional part

    List<Category> findByNameContainingIgnoreCase(String name);
    long countBy();



}
