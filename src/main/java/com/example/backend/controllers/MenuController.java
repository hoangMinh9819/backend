package com.example.backend.controllers;

import com.example.backend.entities.Recipe;
import com.example.backend.repositories.RecipeRepository;
import com.example.backend.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/")
    public List<Recipe> getMenu(
            @RequestParam("calories") Float calories,
            @RequestParam("meal") Integer meal) {
        List<Recipe> recipeBreakfast = recipeRepository.getRecipeBreakfast();
        List<Recipe> recipeLunch = recipeRepository.getRecipeLunch();
        List<Recipe> recipeDinner = recipeRepository.getRecipeDinner();
        List<Recipe> recipeSnack = recipeRepository.getRecipeSnack();

        switch (meal) {
            case 1:
                List<Recipe> returnListRecipe1 = new ArrayList<>();
                Float count1 = 0F;
                for (int i = 0; i < recipeBreakfast.size(); i++) {
                    if (count1 > calories) break;
                    count1 = count1 + recipeBreakfast.get(i).getCalories();
                    returnListRecipe1.add(recipeBreakfast.get(i));
                }
                return returnListRecipe1;
            case 2:
                List<Recipe> returnListRecipe2 = new ArrayList<>();
                Float count2 = 0F;
                for (int i = 0; i < recipeBreakfast.size(); i++) {
                    if (count2 > calories / 2) break;
                    count2 = count2 + recipeBreakfast.get(i).getCalories();
                    returnListRecipe2.add(recipeBreakfast.get(i));
                }
                for (int i = 0; i < recipeLunch.size(); i++) {
                    if (count2 > calories) break;
                    count2 = count2 + recipeLunch.get(i).getCalories();
                    returnListRecipe2.add(recipeLunch.get(i));
                }
                return returnListRecipe2;
            case 3:
                List<Recipe> returnListRecipe3 = new ArrayList<>();
                Float count3 = 0F;
                for (int i = 0; i < recipeBreakfast.size(); i++) {
                    if (count3 > calories / 3) break;
                    count3 = count3 + recipeBreakfast.get(i).getCalories();
                    returnListRecipe3.add(recipeBreakfast.get(i));
                }
                for (int i = 0; i < recipeLunch.size(); i++) {
                    if (count3 > calories / 3 * 2) break;
                    count3 = count3 + recipeLunch.get(i).getCalories();
                    returnListRecipe3.add(recipeLunch.get(i));
                }
                for (int i = 0; i < recipeDinner.size(); i++) {
                    if (count3 > calories) break;
                    count3 = count3 + recipeDinner.get(i).getCalories();
                    returnListRecipe3.add(recipeDinner.get(i));
                }
                return returnListRecipe3;
            case 4:
                List<Recipe> returnListRecipe4 = new ArrayList<>();
                Float count4 = 0F;
                for (int i = 0; i < recipeBreakfast.size(); i++) {
                    if (count4 > calories/4) break;
                    count4 = count4 + recipeBreakfast.get(i).getCalories();
                    returnListRecipe4.add(recipeBreakfast.get(i));
                }
                for (int i = 0; i < recipeLunch.size(); i++) {
                    if (count4 > calories/2) break;
                    count4 = count4 + recipeLunch.get(i).getCalories();
                    returnListRecipe4.add(recipeLunch.get(i));
                }
                for (int i = 0; i < recipeDinner.size(); i++) {
                    if (count4 > calories/4*3) break;
                    count4 = count4 + recipeDinner.get(i).getCalories();
                    returnListRecipe4.add(recipeDinner.get(i));
                }
                for (int i = 0; i < recipeSnack.size(); i++) {
                    if (count4 > calories) break;
                    count4 = count4 + recipeSnack.get(i).getCalories();
                    returnListRecipe4.add(recipeSnack.get(i));
                }
                return returnListRecipe4;
            default:
                return null;
        }
    }
}
