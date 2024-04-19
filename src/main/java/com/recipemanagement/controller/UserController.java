package com.recipemanagement.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.recipemanagement.entity.Recipe;
import com.recipemanagement.service.RecipeService;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        List<Recipe> recipes = null;
		try {
			recipes = RecipeService.getAllRecipes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Change 'recipes' to 'recipeService'
        model.addAttribute("recipes", recipes);
        return "dashboard";
    }
}
