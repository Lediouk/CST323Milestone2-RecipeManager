package com.recipemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.recipemanagement.entity.Recipe;
import com.recipemanagement.repository.RecipeRepository;

@Service
public class RecipeService {
    @Autowired
    private static RecipeRepository recipeRepository;

    public static List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

	public Recipe findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}
}
