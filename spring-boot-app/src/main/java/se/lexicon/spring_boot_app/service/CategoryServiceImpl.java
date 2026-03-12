package se.lexicon.spring_boot_app.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.lexicon.spring_boot_app.dto.response.CategoryResponse;
import se.lexicon.spring_boot_app.entity.Category;
import se.lexicon.spring_boot_app.exception.DuplicateResourceException;
import se.lexicon.spring_boot_app.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public CategoryResponse create(String name) {

        if (categoryRepository.existsByNameIgnoreCase(name)) {
            throw new DuplicateResourceException("Category already exits: " +  name);
        }

        Category category = new Category();
        category.setName(name);

        Category saved =  categoryRepository.save(category);

        return new CategoryResponse(saved.getId(), saved.getName());
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryResponse(category.getId(), category.getName()))
                .toList();
    }


}
