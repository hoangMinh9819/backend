package com.example.backend.repositories;

import com.example.backend.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query("SELECT i FROM  Ingredient i WHERE i.name LIKE %?1%")
    public List<Ingredient> searchName(String keyword);
    @Query("SELECT i FROM  Ingredient i WHERE i.description LIKE %?1%")
    public List<Ingredient> searchDescription(String keyword);
    @Query("SELECT i FROM  Ingredient i WHERE i.price >= ?1 and i.price <= ?2")
    public List<Ingredient> searchPrice(BigDecimal fromPrice, BigDecimal toPrice);
    @Query("SELECT i FROM  Ingredient i WHERE i.price <= ?1")
    public List<Ingredient> searchToPrice(BigDecimal toPrice);
    @Query("SELECT i FROM  Ingredient i WHERE i.price >= ?1")
    public List<Ingredient> searchFromPrice(BigDecimal fromPrice);
    @Query("SELECT i FROM  Ingredient i WHERE i.calories >= ?1 and i.calories <= ?2")
    public List<Ingredient> searchCalories(Float fromCalories, Float toCalories);
    @Query("SELECT i FROM  Ingredient i WHERE i.calories <= ?1")
    public List<Ingredient> searchToCalories(Float toCalories);
    @Query("SELECT i FROM  Ingredient i WHERE i.calories >= ?1")
    public List<Ingredient> searchFromCalories(Float fromCalories);
}