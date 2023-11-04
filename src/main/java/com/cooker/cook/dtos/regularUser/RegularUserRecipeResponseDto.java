package com.cooker.cook.dtos.regularUser;

import com.cooker.cook.dtos.recipe.RecipeResponseDto;

import java.util.List;

public record RegularUserRecipeResponseDto(

  Long id,

  String firstName,

  String lastName,

  String username,

  String password,

  List<RecipeResponseDto> recipes

) {
}
