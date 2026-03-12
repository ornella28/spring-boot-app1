package se.lexicon.spring_boot_app.service;

import se.lexicon.spring_boot_app.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse create(String name);
    List<CategoryResponse> findAll();
}
