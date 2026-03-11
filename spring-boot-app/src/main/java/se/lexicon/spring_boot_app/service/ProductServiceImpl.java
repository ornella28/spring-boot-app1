package se.lexicon.spring_boot_app.service;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import se.lexicon.spring_boot_app.dto.request.ProductRequest;
import se.lexicon.spring_boot_app.dto.response.ProductResponse;
import se.lexicon.spring_boot_app.entity.Category;
import se.lexicon.spring_boot_app.entity.Product;
import se.lexicon.spring_boot_app.exception.ResourceNotFoundException;
import se.lexicon.spring_boot_app.mapper.ProductMapper;
import se.lexicon.spring_boot_app.repository.CategoryRepository;
import se.lexicon.spring_boot_app.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponse create(ProductRequest request){

        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found with id: " + request.categoryId()));

        Product product = productMapper.toEntity(request, category);
        Product saved = productRepository.save(product);

        return productMapper.toResponse(saved);

    }

    @Override
    public List<ProductResponse> findAll(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> searchByName(String name){
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }
}
