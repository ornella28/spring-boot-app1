package se.lexicon.spring_boot_app.runner;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.spring_boot_app.entity.Category;
import se.lexicon.spring_boot_app.entity.Product;
import se.lexicon.spring_boot_app.repository.CategoryRepository;
import se.lexicon.spring_boot_app.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeed implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void run(String... args){

        System.out.println("✅ DataSeeder is running!");

        //Avoid duplicates

        if (categoryRepository.count() > 0){
            System.out.println("Category already exists. Seeding skipped");
            return;
        }

        //Create category first

        Category electronics = categoryRepository.save(Category.builder().name("Electronics").build());
        Category books = categoryRepository.save(Category.builder().name("Books").build());
        Category clothing = categoryRepository.save(Category.builder().name("Clothing").build());


        //Create products linked to categories

        List<Product> products = List.of(
                Product.builder()
                        .name("Laptop")
                        .price(new BigDecimal("12000"))
                        .category(electronics)
                        .build(),
                Product.builder()
                        .name("How to become a billionaire")
                        .price(new BigDecimal("600"))
                        .category(books)
                        .build(),
                Product.builder()
                        .name("T-shirt")
                        .price(new BigDecimal(150))
                        .category(clothing)
                        .build()
        );
        productRepository.saveAll(products);

        System.out.println("All products have been saved successfully");





    }


}
