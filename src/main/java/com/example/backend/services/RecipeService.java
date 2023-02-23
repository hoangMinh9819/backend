package com.example.backend.services;

import com.example.backend.entities.Recipe;

import java.util.List;

public interface RecipeService {

    public Recipe createRecipe(Recipe recipe);

    public List<Recipe> getAllRecipes();
    public Recipe getRecipeByName(String name);

    public Recipe getRecipeById(Integer id);

    public void deleteRecipeById(Integer id);

    public Recipe updateRecipe(Integer id, Recipe recipe);

    public List<Recipe> searchAll(String keyword);

    public List<Recipe> searchName(String keyword);

    public List<Recipe> searchMeal(String keyword);

    public List<Recipe> searchCalories(Float fromCalories, Float toCalories);
    public List<Recipe> searchFromCalories(Float fromCalories);

    public List<Recipe> searchToCalories(Float toCalories);

    public List<Recipe> searchDescription(String keyword);

    public List<Recipe> searchTutorial(String keyword);
}
