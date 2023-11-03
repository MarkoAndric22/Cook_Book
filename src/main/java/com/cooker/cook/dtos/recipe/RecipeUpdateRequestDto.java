package com.cooker.cook.dtos.recipe;

import com.cooker.cook.dtos.ingridient.IngridientCreateRequestDto;

import java.util.List;

public record RecipeUpdateRequestDto(

  String name,
  String description,
  String stepsForPrepare,
  Integer timeForPrepare,
  Integer quantity,
  List<IngridientCreateRequestDto> ingridients
) {
}
