package com.example.backend.services;

import com.example.backend.entities.Account;
import com.example.backend.entities.AccountFavoriteRecipe;
import com.example.backend.entities.Recipe;
import com.example.backend.repositories.AccountFavoriteRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountFavoriteRecipeImp implements AccountFavoriteRecipeService{

    @Autowired
    private AccountFavoriteRecipeRepository accountFavoriteRecipeRepository;

    @Override
    public List<AccountFavoriteRecipe> getAllAccountFavorites() {
        return accountFavoriteRecipeRepository.findAll();
    }

    @Override
    public void deleteFavoriteRecipe(Account account, Recipe recipe) {
        accountFavoriteRecipeRepository.deleteFavoriteRecipe(account,recipe);
    }

    @Override
    public AccountFavoriteRecipe createAccountFavoriteRecipe(AccountFavoriteRecipe accountFavoriteRecipe) {
        return null;
    }

    @Override
    public List<AccountFavoriteRecipe> searchAccount(String keyword) {
        return accountFavoriteRecipeRepository.searchAccount(keyword);
    }

    @Override
    public List<AccountFavoriteRecipe> searchRecipe(String keyword) {
        return accountFavoriteRecipeRepository.searchRecipe(keyword);
    }
}
