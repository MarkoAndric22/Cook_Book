package com.cooker.cook.dtos.nutrition;

public record NutritionUpdateRequestDto(

  Integer numberCaloria,

  Integer carbohydrates,

  Integer fats,

  Integer proteins
) {
}
