package com.cooker.cook.services;

import com.cooker.cook.dtos.recipe.RecipeCreateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeResponseDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateResponseDto;
import com.cooker.cook.exceptions.NotFoundCustomException;

import java.util.List;

public interface RecipeService {

  RecipeResponseDto createRecipe(RecipeCreateRequestDto recipeCreateRequestDto);

  RecipeUpdateResponseDto updateRecipe(Long recipeId,RecipeUpdateRequestDto recipeUpdateRequestDto) throws NotFoundCustomException;

  RecipeResponseDto deleteRecipe(Long recipeId) throws NotFoundCustomException;

  RecipeResponseDto getByRecipeId(Long recipeId) throws NotFoundCustomException;

  List<RecipeResponseDto> getAllRecipe();
}
