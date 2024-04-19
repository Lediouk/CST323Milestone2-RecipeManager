package com.recipemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.recipemanagement.entity.Recipe;
import com.recipemanagement.service.RecipeService;

@Controller
public class DashboardController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        // Assuming you have a method in your service layer to retrieve recipes
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "dashboard"; // Assuming you have a dashboard.html template in your resources/templates directory
    }
}
