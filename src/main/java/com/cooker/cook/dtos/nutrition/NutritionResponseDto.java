package com.cooker.cook.dtos.nutrition;

public record NutritionResponseDto(

  Long id,

  Integer numberCaloria,

  Integer carbohydrates,

  Integer fats,

  Integer proteins
) {
}
