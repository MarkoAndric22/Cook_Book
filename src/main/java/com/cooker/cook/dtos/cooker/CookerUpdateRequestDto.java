package com.cooker.cook.dtos.cooker;

import com.cooker.cook.dtos.recipe.RecipeUpdateRequestDto;
import com.cooker.cook.entities.Recipe;

import java.util.List;

public record CookerUpdateRequestDto(

  String FirstName,

  String LastName,

  String username,

  String password
){
}
