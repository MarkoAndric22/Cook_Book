package com.cooker.cook.services;

import com.cooker.cook.dtos.recipe.RecipeCreateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeResponseDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateResponseDto;
import com.cooker.cook.entities.Ingridient;
import com.cooker.cook.entities.Recipe;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.mappers.RecipeMapper;
import com.cooker.cook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImp implements RecipeService{

  @Autowired
  RecipeRepository recipeRepository;
  @Autowired
  RecipeMapper recipeMapper;

  @Override
  public RecipeResponseDto createRecipe(RecipeCreateRequestDto recipeCreateRequestDto) {
    return recipeMapper.toResponseDto(recipeRepository.save(recipeMapper.toEntityCreate(recipeCreateRequestDto)));
  }

  @Override
  public RecipeUpdateResponseDto updateRecipe(Long recipeId, RecipeUpdateRequestDto recipeUpdateRequestDto) throws NotFoundCustomException {
    Optional<Recipe> optionalRecipe= recipeRepository.findById(recipeId);
    if (optionalRecipe.isEmpty()){
      throw new NotFoundCustomException("Recipe not found");
    }
    Recipe recipe=recipeMapper.toEntityUpdate(recipeUpdateRequestDto);
    recipe.setId(recipeId);
    return recipeMapper.toUpdateResponseDto(recipeRepository.save(recipe));
  }

  @Override
  public RecipeResponseDto deleteRecipe(Long recipeId) throws NotFoundCustomException {
    Optional<Recipe> optionalRecipe= recipeRepository.findById(recipeId);
    if (optionalRecipe.isEmpty()){
      throw new NotFoundCustomException("Recipe not found");
    }
    recipeRepository.delete(optionalRecipe.get());
    return recipeMapper.toResponseDto(optionalRecipe.get());
  }

  @Override
  public RecipeResponseDto getByRecipeId(Long recipeId) throws NotFoundCustomException {
    Optional<Recipe> optionalRecipe= recipeRepository.findById(recipeId);
    if (optionalRecipe.isEmpty()){
      throw new NotFoundCustomException("Recipe not found");
    }
    return recipeMapper.toResponseDto(optionalRecipe.get());
  }

  @Override
  public List<RecipeResponseDto> getAllRecipe() {
    return recipeMapper.toListResponseDto(recipeRepository.findAll());
  }

  public double calculateNutritionalValuePer100g(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        List<Ingridient> ingredients = recipe.getIngridients();
        int finalProductQuantity = recipe.getQuantity();

        int totalCalories = 0;
        int totalCarbohydrates = 0;
        int totalFats = 0;
        int totalProteins = 0;

        for (Ingridient ingredient : ingredients) {
          int ingredientQuantity = ingredient.getUnitOfMeasure();
          int calories = ingredient.getNumberCaloria();
          int carbohydrates = ingredient.getCarbohydrates();
          int fats = ingredient.getFats();
          int proteins = ingredient.getProteins();

          totalCalories += calories * ingredientQuantity;
          totalCarbohydrates += carbohydrates * ingredientQuantity;
          totalFats += fats * ingredientQuantity;
          totalProteins += proteins * ingredientQuantity;
        }

        double nutritionPer100g = calculateNutritionPer100g(
          totalCalories, totalCarbohydrates, totalFats, totalProteins, finalProductQuantity
        );

        return nutritionPer100g;
      }

      private double calculateNutritionPer100g(int totalCalories, int totalCarbohydrates, int totalFats, int totalProteins, int finalProductQuantity) {
        double caloriesPer100g = (totalCalories * 100.0) / finalProductQuantity;
        double carbohydratesPer100g = (totalCarbohydrates * 100.0) / finalProductQuantity;
        double fatsPer100g = (totalFats * 100.0) / finalProductQuantity;
        double proteinsPer100g = (totalProteins * 100.0) / finalProductQuantity;

        return caloriesPer100g + carbohydratesPer100g + fatsPer100g + proteinsPer100g;
      }

  }
