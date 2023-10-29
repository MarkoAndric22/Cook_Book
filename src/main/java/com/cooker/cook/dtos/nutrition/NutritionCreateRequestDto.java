package com.cooker.cook.dtos.nutrition;

public record NutritionCreateRequestDto(
  Integer numberCaloria,

  Integer carbohydrates,

  Integer fats,

  Integer proteins
) {

}
