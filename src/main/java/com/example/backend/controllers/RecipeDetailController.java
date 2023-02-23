package com.example.backend.controllers;

import com.example.backend.entities.RecipeDetail;
import com.example.backend.services.RecipeDetailService;
import com.example.backend.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recipeDetail")
public class RecipeDetailController {
    @Autowired
    RecipeDetailService recipeDetailService;
    @Autowired
    RecipeService recipeService;

    @GetMapping("/{id}")
    public ResponseEntity<List<RecipeDetail>> getRecipeDetailByRecipeId(@PathVariable("id") Integer id) {
        return new ResponseEntity<List<RecipeDetail>>(recipeDetailService.getRecipeDetailByRecipeId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RecipeDetail> createRecipeDetail(@RequestBody RecipeDetail recipeDetail) {
        return new ResponseEntity<RecipeDetail>(recipeDetailService.createRecipeDetail(recipeDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDetail> updateRecipeDetail(@PathVariable("id") Integer id, @RequestBody RecipeDetail
            recipeDetail) {
        return new ResponseEntity<RecipeDetail>(recipeDetailService.updateRecipeDetail(id, recipeDetail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("id") Integer id) {
        recipeDetailService.deleteRecipeDetailById(id);
        return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
    }
}

