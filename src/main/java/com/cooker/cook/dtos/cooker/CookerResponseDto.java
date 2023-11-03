package com.cooker.cook.dtos.cooker;

import com.cooker.cook.dtos.recipe.RecipeResponseDto;
import com.cooker.cook.entities.Recipe;
import com.cooker.cook.entities.Role;

import java.util.List;

public record CookerResponseDto(

  Long id,

  String firstName,

  String lastName,

  String username,

  String password

) {
}
