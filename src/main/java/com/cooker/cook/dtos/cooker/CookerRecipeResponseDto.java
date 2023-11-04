package com.cooker.cook.dtos.cooker;

import com.cooker.cook.dtos.recipe.RecipeResponseDto;
import com.cooker.cook.entities.Recipe;

import java.util.List;

public record CookerRecipeResponseDto(

  Long id,

  String firstName,

  String lastName,

  String username,

  String password,

  List<RecipeResponseDto> recipes
) {
}
