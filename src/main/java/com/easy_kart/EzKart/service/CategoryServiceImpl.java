package com.easy_kart.EzKart.service;

import com.easy_kart.EzKart.exception_handler.APIException;
import com.easy_kart.EzKart.exception_handler.ResourceNotFoundException;
import com.easy_kart.EzKart.model.Category;
import com.easy_kart.EzKart.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()){
            throw new APIException("No categories found.");
        }
        return categories;
    }

    @Override
    public Category addCategory(Category category) {
        Category existingCategory = categoryRepository.findByCategoryName(
                category.getCategoryName());
        if(existingCategory != null){
            throw new APIException(String.format(
                    "Category with Category name: %s already exists.", category.getCategoryName()
            ));
        }
        return categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", id));
        categoryRepository.delete(existingCategory);
        return "Category deleted successfully.";
    }

    @Override
    public String updateCategory(Category category, Long id) {
        Category existingCategoryById = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", id));
        Category existingCategoryByName = categoryRepository.findByCategoryName(
                category.getCategoryName());

        if(existingCategoryByName != null && !existingCategoryByName.getCategoryId().equals(id)){
                throw new APIException(String.format("Category with category name: %s already exists.", category.getCategoryName()
            ));
        }
        existingCategoryById.setCategoryName(category.getCategoryName());
        categoryRepository.save(existingCategoryById);
        return "Category updated successfully.";
    }
}
