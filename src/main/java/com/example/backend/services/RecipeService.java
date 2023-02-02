package com.example.backend.services;

import com.example.backend.entities.Account;
import com.example.backend.entities.Recipe;

import java.time.LocalDate;
import java.util.List;

public interface RecipeService {

    public Recipe createRecipe(Recipe recipe);

    public List<Recipe> getAllRecipes();

    public Recipe getRecipeById(Integer id);

    public void deleteRecipeById(Integer id);

    public Recipe updateRecipe(Integer id, Recipe recipe);

    public List<Recipe> searchAll(String keyword);

    public List<Recipe> searchName(String keyword);

    public List<Account> searchMeal(String keyword);

    public List<Account> searchDob(LocalDate fromDate, LocalDate toDate);

    public List<Account> searchToDob(LocalDate toDate);

    public List<Account> searchFromDob(LocalDate fromDate);

    public List<Account> searchGender(String keyword);

    public List<Account> searchRole(String keyword);

    public List<Account> searchStatus(String keyword);
    public List<Account> searchPhone(String keyword);
}
