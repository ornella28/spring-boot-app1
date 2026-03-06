package se.lexicon.spring_boot_app.service;

import se.lexicon.spring_boot_app.dto.request.ProductRequest;
import se.lexicon.spring_boot_app.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest request);
    List<ProductResponse> findAll();
    List<ProductResponse> searchByName(String name);
}
