package com.example.backend.services;

import com.example.backend.entities.Recipe;
import com.example.backend.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeServiceImp implements RecipeService{
    @Autowired
    private RecipeRepository recipeRepository;
    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeByName(String name) {
        return recipeRepository.getRecipeByName(name);
    }

    @Override
    public Recipe getRecipeById(Integer id) {
        return recipeRepository.findById(id).get();
    }

    @Override
    public void deleteRecipeById(Integer id) {
        Recipe recipe = recipeRepository.findById(id).get();
        if(recipe != null){
            recipeRepository.delete(recipe);
        }
    }

    @Override
    public Recipe updateRecipe(Integer id, Recipe recipe) {

        Recipe oldRecipe = recipeRepository.findById(id).get();
        if(oldRecipe != null){
            recipe.setId(id);
            return recipeRepository.save(recipe);
        }
        return null;
    }

    @Override
    public List<Recipe> searchAll(String keyword) {
        return recipeRepository.searchAll(keyword);
    }

    @Override
    public List<Recipe> searchName(String keyword) {
        return recipeRepository.searchName(keyword);
    }

    @Override
    public List<Recipe> searchMeal(String keyword) {
        return recipeRepository.searchMeal(keyword);
    }

    @Override
    public List<Recipe> searchCalories(Float fromCalories, Float toCalories) {
        return recipeRepository.searchCalories(fromCalories,toCalories);
    }

    @Override
    public List<Recipe> searchFromCalories(Float fromCalories) {
        return recipeRepository.searchFromCalories(fromCalories);
    }

    @Override
    public List<Recipe> searchToCalories(Float toCalories) {
        return recipeRepository.searchToCalories(toCalories);
    }

    @Override
    public List<Recipe> searchDescription(String keyword) {
        return recipeRepository.searchDescription(keyword);
    }

    @Override
    public List<Recipe> searchTutorial(String keyword) {
        return recipeRepository.searchTutorial(keyword);
    }
}
