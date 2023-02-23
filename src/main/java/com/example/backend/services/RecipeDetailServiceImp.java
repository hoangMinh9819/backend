package com.example.backend.services;

import com.example.backend.entities.RecipeDetail;
import com.example.backend.repositories.RecipeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeDetailServiceImp implements RecipeDetailService{
    @Autowired
    private RecipeDetailRepository recipeDetailRepository;
    @Override
    public RecipeDetail createRecipeDetail(RecipeDetail recipeDetail) {
        return recipeDetailRepository.save(recipeDetail);
    }

    @Override
    public List<RecipeDetail> getRecipeDetailByRecipeId(Integer id) {
        return recipeDetailRepository.getRecipeDetailByRecipeId(id);
    }

    @Override
    public void deleteRecipeDetailById(Integer id) {
        RecipeDetail recipeDetail = recipeDetailRepository.findById(id).get();
        if(recipeDetail != null){
            recipeDetailRepository.delete(recipeDetail);
        }
    }

    @Override
    public RecipeDetail updateRecipeDetail(Integer id, RecipeDetail recipeDetail) {
        RecipeDetail oldRecipeDetail = recipeDetailRepository.findById(id).get();
        if(oldRecipeDetail != null){
            recipeDetail.setId(id);
            return recipeDetailRepository.save(recipeDetail);
        }
        return null;
    }
}
