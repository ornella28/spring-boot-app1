package se.lexicon.spring_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.spring_boot_app.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategoryNameIgnoreCase(String name);

    List<Product> findByPriceBetween(BigDecimal min,  BigDecimal max);

    //Optional part

    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
    long countByCategoryId(Long id);
    List<Product> findByCategoryId(Long id);


}
