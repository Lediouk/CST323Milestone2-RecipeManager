package com.recipemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipemanagement.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
