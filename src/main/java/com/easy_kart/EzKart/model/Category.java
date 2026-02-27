package com.easy_kart.EzKart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank(message = "Category name must not be empty")
    @Pattern(regexp = "^[a-zA-Z]+( [a-zA-Z]+)*$", message = "Category name must contain only letters.")
    @Size(min = 5, max = 30, message = "Category name must be between 5 and 30 characters.")
    private String categoryName;
}
