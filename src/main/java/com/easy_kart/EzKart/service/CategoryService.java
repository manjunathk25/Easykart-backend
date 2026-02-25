package com.easy_kart.EzKart.service;

import com.easy_kart.EzKart.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category addCategory(Category category);

    String deleteCategory(Long id);

    String updateCategory(Category category, Long id);
}
