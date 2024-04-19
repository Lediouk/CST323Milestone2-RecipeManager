package com.recipemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.recipeapp.entity.Recipe;
import com.example.recipeapp.service.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public String getAllRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes";
    }

    @PostMapping
    public String addRecipe(@ModelAttribute Recipe recipe) {
        recipeService.save(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/{id}")
    public String getRecipeById(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipe", recipe);
        return "recipe_details";
    }

    @PutMapping("/{id}")
    public String updateRecipe(@PathVariable Long id, @ModelAttribute Recipe recipe) {
        recipe.setId(id);
        recipeService.save(recipe);
        return "redirect:/recipes";
    }

    @DeleteMapping("/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return "redirect:/recipes";
    }
}
