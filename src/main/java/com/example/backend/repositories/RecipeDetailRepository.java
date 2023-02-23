package com.example.backend.repositories;

import com.example.backend.entities.RecipeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeDetailRepository extends JpaRepository<RecipeDetail, Integer> {

    @Query("SELECT r FROM RecipeDetail r WHERE r.recipe.id = ?1")
    public List<RecipeDetail> getRecipeDetailByRecipeId(Integer id);
}
