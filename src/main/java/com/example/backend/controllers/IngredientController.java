package com.example.backend.controllers;

import com.example.backend.entities.Account;
import com.example.backend.entities.Ingredient;
import com.example.backend.services.AccountService;
import com.example.backend.services.IngredientService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping("/")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return new ResponseEntity<List<Ingredient>>(ingredientService.getAllIngredients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Ingredient>(ingredientService.getIngredientById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        return new ResponseEntity<Ingredient>(ingredientService.createIngredient(ingredient), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable("id") Integer id, @RequestBody Ingredient ingredient) {
        return new ResponseEntity<Ingredient>(ingredientService.updateIngredient(id, ingredient), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable("id") Integer id) {
        ingredientService.deleteIngredientById(id);
        return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Ingredient>> searchLike(
            @RequestParam("keyword") @Nullable String keyword,
            @RequestParam("column") String column,
            @RequestParam("fromPrice") @Nullable BigDecimal fromPrice,
            @RequestParam("toPrice") @Nullable BigDecimal toPrice,
            @RequestParam("fromCalories") @Nullable Float fromCalories,
            @RequestParam("toCalories") @Nullable Float toCalories
    ) {
        switch (column) {
            case "name":
                return ResponseEntity.ok(ingredientService.searchName(keyword));
            case "description":
                return ResponseEntity.ok(ingredientService.searchDescription(keyword));
            case "price":
                if (fromPrice != null && toPrice != null) {
                    return ResponseEntity.ok(ingredientService.searchPrice(fromPrice, toPrice));
                } else if (fromPrice == null && toPrice != null) {
                    return ResponseEntity.ok(ingredientService.searchToPrice(toPrice));
                } else if (toPrice == null && fromPrice != null) {
                    return ResponseEntity.ok(ingredientService.searchFromPrice(fromPrice));
                } else {
                    return ResponseEntity.ok(ingredientService.getAllIngredients());
                }
            case "calories":
                if (fromCalories != null && toCalories != null) {
                    return ResponseEntity.ok(ingredientService.searchCalories(fromCalories, toCalories));
                } else if (fromCalories == null && toCalories != null) {
                    return ResponseEntity.ok(ingredientService.searchToCalories(toCalories));
                } else if (toCalories == null && fromCalories != null) {
                    return ResponseEntity.ok(ingredientService.searchFromCalories(fromCalories));
                } else {
                    return ResponseEntity.ok(ingredientService.getAllIngredients());
                }
            default:
                return ResponseEntity.ok(ingredientService.getAllIngredients());
        }
    }
}
