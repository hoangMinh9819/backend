package com.example.backend.services;

import com.example.backend.entities.Account;
import com.example.backend.entities.AccountFavoriteRecipe;
import com.example.backend.entities.Recipe;

import java.util.List;

public interface AccountFavoriteRecipeService {

    public List<AccountFavoriteRecipe> getAllAccountFavorites();
    public void deleteFavoriteRecipe(Account account, Recipe recipe);
    public AccountFavoriteRecipe createAccountFavoriteRecipe(AccountFavoriteRecipe accountFavoriteRecipe);

    public List<AccountFavoriteRecipe> searchAccount(String keyword);

    public List<AccountFavoriteRecipe> searchRecipe(String keyword);
}
