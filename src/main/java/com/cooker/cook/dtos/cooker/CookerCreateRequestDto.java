package com.cooker.cook.dtos.cooker;


import com.cooker.cook.dtos.recipe.RecipeCreateRequestDto;

import java.util.List;

public record CookerCreateRequestDto(

  String firstName,

  String lastName,

  String username,

  String password

) {
}
