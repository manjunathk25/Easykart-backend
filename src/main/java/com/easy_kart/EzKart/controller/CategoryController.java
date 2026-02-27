package com.easy_kart.EzKart.controller;

import com.easy_kart.EzKart.model.Category;
import com.easy_kart.EzKart.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.getCategories());
    }

    @PostMapping("/admin/categories")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.addCategory(category));
    }

    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        String status = categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category,
                                                   @PathVariable Long id){
        String status = categoryService.updateCategory(category, id);
        return ResponseEntity.status(HttpStatus.OK)
                    .body(status);
    }
}
