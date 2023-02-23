package com.example.backend.repositories;

import com.example.backend.entities.Account;
import com.example.backend.entities.AccountFavoriteRecipe;
import com.example.backend.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountFavoriteRecipeRepository extends JpaRepository<AccountFavoriteRecipe, Integer> {
    @Query("SELECT afr FROM AccountFavoriteRecipe afr WHERE afr.account.username Like %?1%")
    public List<AccountFavoriteRecipe> searchAccount(String keyword);
    @Query("SELECT afr FROM AccountFavoriteRecipe afr WHERE afr.recipe.name Like %?1%")
    public List<AccountFavoriteRecipe> searchRecipe(String keyword);
    @Query("SELECT afr FROM AccountFavoriteRecipe afr WHERE afr.account = ?1 and afr.recipe = ?2")
    public void deleteFavoriteRecipe(Account account, Recipe recipe);
}

