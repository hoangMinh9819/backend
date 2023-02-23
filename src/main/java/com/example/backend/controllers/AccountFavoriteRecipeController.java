package com.example.backend.controllers;

import com.example.backend.entities.AccountFavoriteRecipe;
import com.example.backend.repositories.AccountFavoriteRecipeRepository;
import com.example.backend.services.AccountFavoriteRecipeService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ ")
public class AccountFavoriteRecipeController {
    @Autowired
    AccountFavoriteRecipeService accountFavoriteRecipeService;
    @Autowired
    AccountFavoriteRecipeRepository accountFavoriteRecipeRepository;
    @PostMapping("/")
    public ResponseEntity<AccountFavoriteRecipe> createAccountFavoriteRecipe(@RequestBody AccountFavoriteRecipe accountFavoriteRecipe) {
        return new ResponseEntity<AccountFavoriteRecipe>(accountFavoriteRecipeRepository.save(accountFavoriteRecipe), HttpStatus.OK);
    }
    @DeleteMapping("/")
    public void deleteAccountFavoriteRecipe(@PathVariable("id") Integer id) {
        accountFavoriteRecipeRepository.deleteById(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountFavoriteRecipe>> getAllAccountFavoriteRecipe() {
        return new ResponseEntity<List<AccountFavoriteRecipe>>(accountFavoriteRecipeService.getAllAccountFavorites(), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<AccountFavoriteRecipe>> searchLike(
            @RequestParam("keyword") @Nullable String keyword,
            @RequestParam("column") String column
    ) {
        switch (column) {
            case "account":
                return ResponseEntity.ok(accountFavoriteRecipeService.searchAccount(keyword));
            case "recipe":
                return ResponseEntity.ok(accountFavoriteRecipeService.searchRecipe(keyword));
            default:
                return ResponseEntity.ok(accountFavoriteRecipeService.getAllAccountFavorites());
        }
    }
}
