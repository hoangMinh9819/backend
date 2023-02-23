package com.example.backend.controllers;

import com.example.backend.entities.Recipe;
import com.example.backend.services.IngredientService;
import com.example.backend.services.RecipeDetailService;
import com.example.backend.services.RecipeService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeDetailService recipeDetailService;
    @Autowired
    IngredientService ingredientService;

    @GetMapping("/")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<List<Recipe>>(recipeService.getAllRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Recipe>(recipeService.getRecipeById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<Recipe>(recipeService.createRecipe(recipe), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") Integer id, @RequestBody Recipe
            recipe) {
        return new ResponseEntity<Recipe>(recipeService.updateRecipe(id, recipe), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("id") Integer id) {
        recipeService.deleteRecipeById(id);
        return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> searchLike(
            @RequestParam("keyword") @Nullable String keyword,
            @RequestParam("column") String column,
            @RequestParam("fromCalories") @Nullable Float fromCalories,
            @RequestParam("toCalories") @Nullable Float toCalories
    ) {
        switch (column) {
            case "all":
                return ResponseEntity.ok(recipeService.searchAll(keyword));
            case "meal":
                return ResponseEntity.ok(recipeService.searchMeal(keyword));
            case "name":
                return ResponseEntity.ok(recipeService.searchName(keyword));
            case "description":
                return ResponseEntity.ok(recipeService.searchDescription(keyword));
            case "tutorial":
                return ResponseEntity.ok(recipeService.searchTutorial(keyword));
            case "calories":
                if (fromCalories != null && toCalories != null) {
                    return ResponseEntity.ok(recipeService.searchCalories(fromCalories, toCalories));
                } else if (fromCalories == null && toCalories != null) {
                    return ResponseEntity.ok(recipeService.searchToCalories(toCalories));
                } else if (toCalories == null && fromCalories != null) {
                    return ResponseEntity.ok(recipeService.searchFromCalories(fromCalories));
                } else {
                    return ResponseEntity.ok(recipeService.getAllRecipes());
                }
            default:
                return ResponseEntity.ok(recipeService.getAllRecipes());
        }
    }
}

