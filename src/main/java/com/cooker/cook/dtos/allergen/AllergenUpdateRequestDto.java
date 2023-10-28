package com.cooker.cook.dtos.allergen;

import com.cooker.cook.dtos.ingridient.IngridientUpdateRequestDto;

import java.util.List;

public record AllergenUpdateRequestDto(

  String name,

  List<IngridientUpdateRequestDto> ingridients


) {
}
