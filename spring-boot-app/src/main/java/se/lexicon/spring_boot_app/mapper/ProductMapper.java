package se.lexicon.spring_boot_app.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.spring_boot_app.dto.request.ProductRequest;
import se.lexicon.spring_boot_app.dto.response.ProductResponse;
import se.lexicon.spring_boot_app.entity.Category;
import se.lexicon.spring_boot_app.entity.Product;

import java.util.HashSet;

@Component
public class ProductMapper {

    //entity-> response DTO

    public ProductResponse toResponse(Product product) {
        if (product == null) {
            return null;
        }

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory().getName()
        );
    }

    //DTO -> Entity(category is provided by the service)
    public Product toEntity(ProductRequest request, Category  category) {
        if (request == null) {
            return null;
        }

        return new Product(
                null,
                request.name(),
                request.price(),
                category,
                new HashSet<>()// we will not handle promotions yet
        );
    }
}
