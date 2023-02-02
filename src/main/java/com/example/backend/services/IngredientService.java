package com.example.backend.services;

import com.example.backend.entities.Account;
import com.example.backend.entities.Ingredient;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService {
    public Ingredient createIngredient(Ingredient ingredient);

    public List<Ingredient> getAllIngredients();

    public Ingredient getIngredientById(Integer id);

    public void deleteIngredientById(Integer id);

    public Ingredient updateIngredient(Integer id, Ingredient ingredient);
    public List<Ingredient> searchName(String keyword);
    public List<Ingredient> searchDescription(String keyword);
    public List<Ingredient> searchPrice(BigDecimal fromPrice, BigDecimal toPrice);
    public List<Ingredient> searchToPrice(BigDecimal toPrice);
    public List<Ingredient> searchFromPrice(BigDecimal fromPrice);
    public List<Ingredient> searchCalories(Float fromCalories, Float toCalories);
    public List<Ingredient> searchToCalories(Float toCalories);
    public List<Ingredient> searchFromCalories(Float fromCalories);
}
