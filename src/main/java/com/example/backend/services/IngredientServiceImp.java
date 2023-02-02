package com.example.backend.services;

import com.example.backend.entities.Account;
import com.example.backend.entities.Ingredient;
import com.example.backend.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class IngredientServiceImp implements IngredientService{
    @Autowired
    private IngredientRepository ingredientRepository;
    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getIngredientById(Integer id) {
        return ingredientRepository.findById(id).get();
    }

    @Override
    public void deleteIngredientById(Integer id) {
        Ingredient ingredient = ingredientRepository.findById(id).get();
        if(ingredient != null){
            ingredientRepository.delete(ingredient);
        }
    }

    @Override
    public Ingredient updateIngredient(Integer id, Ingredient ingredient) {
        Ingredient oldIngredient = ingredientRepository.findById(id).get();
        if(oldIngredient != null){
            ingredient.setId(id);
            return ingredientRepository.save(ingredient);
        }
        return null;
    }

    @Override
    public List<Ingredient> searchName(String keyword) {
        return ingredientRepository.searchName(keyword);
    }

    @Override
    public List<Ingredient> searchDescription(String keyword) {
        return ingredientRepository.searchDescription(keyword);
    }

    @Override
    public List<Ingredient> searchPrice(BigDecimal fromPrice, BigDecimal toPrice) {
        return ingredientRepository.searchPrice(fromPrice, toPrice);
    }

    @Override
    public List<Ingredient> searchToPrice(BigDecimal toPrice) {
        return ingredientRepository.searchToPrice(toPrice);
    }

    @Override
    public List<Ingredient> searchFromPrice(BigDecimal fromPrice) {
        return ingredientRepository.searchFromPrice(fromPrice);
    }

    @Override
    public List<Ingredient> searchCalories(Float fromCalories, Float toCalories) {
        return ingredientRepository.searchCalories(fromCalories, toCalories);
    }

    @Override
    public List<Ingredient> searchToCalories(Float toCalories) {
        return ingredientRepository.searchToCalories(toCalories);
    }

    @Override
    public List<Ingredient> searchFromCalories(Float fromCalories) {
        return ingredientRepository.searchFromCalories(fromCalories);
    }
}
