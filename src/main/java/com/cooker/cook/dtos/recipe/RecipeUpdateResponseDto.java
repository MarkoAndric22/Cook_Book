package com.cooker.cook.dtos.recipe;

public record RecipeUpdateResponseDto(

  String name,
  String description,
  String stepsForPrepare,
  Integer timeForPrepare,
  Integer quantity
) {
}
