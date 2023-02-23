package com.example.backend.services;

import com.example.backend.entities.RecipeDetail;

import java.util.List;

public interface RecipeDetailService {
    public RecipeDetail createRecipeDetail(RecipeDetail recipeDetail);

    public List<RecipeDetail> getRecipeDetailByRecipeId(Integer id);

    public void deleteRecipeDetailById(Integer id);

    public RecipeDetail updateRecipeDetail(Integer id, RecipeDetail recipeDetail);
}
