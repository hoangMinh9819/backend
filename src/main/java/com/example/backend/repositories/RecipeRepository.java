package com.example.backend.repositories;

import com.example.backend.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    @Query("SELECT r FROM Recipe r WHERE CONCAT(r.name, r.meal, r.description, r.tutorial) LIKE %?1%")
    public List<Recipe> searchAll(String keyword);
    @Query("SELECT r FROM  Recipe r WHERE r.name LIKE %?1%")
    public List<Recipe> searchName(String keyword);
    @Query("SELECT r FROM  Recipe r WHERE r.meal LIKE %?1%")
    public List<Recipe> searchMeal(String keyword);
    @Query("SELECT r FROM  Recipe r WHERE r.description LIKE %?1%")
    public List<Recipe> searchDescription(String keyword);
    @Query("SELECT r FROM  Recipe r WHERE r.tutorial LIKE %?1%")
    public List<Recipe> searchTutorial(String keyword);
    @Query("SELECT r FROM  Recipe r WHERE r.calories >= ?1 and r.calories <= ?2")
    public List<Recipe> searchCalories(Float fromCalories, Float toCalories);
    @Query("SELECT r FROM  Recipe r WHERE r.calories <= ?1")
    public List<Recipe> searchToCalories(Float toCalories);
    @Query("SELECT r FROM  Recipe r WHERE r.calories >= ?1")
    public List<Recipe> searchFromCalories(Float fromCalories);
    @Query("SELECT r FROM  Recipe r WHERE r.name = ?1")
    public Recipe getRecipeByName(String recipeName);
    @Query("SELECT r FROM  Recipe r WHERE r.meal = 'Breakfast'")
    public List<Recipe> getRecipeBreakfast();
    @Query("SELECT r FROM  Recipe r WHERE r.meal = 'Lunch'")
    public List<Recipe> getRecipeLunch();
    @Query("SELECT r FROM  Recipe r WHERE r.meal = 'Dinner'")
    public List<Recipe> getRecipeDinner();
    @Query("SELECT r FROM  Recipe r WHERE r.meal = 'Snack'")
    public List<Recipe> getRecipeSnack();
}