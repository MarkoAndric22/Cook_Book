package com.cooker.cook.dtos.ingridient;

import com.cooker.cook.dtos.allergen.AllergenCreateRequestDto;

import java.util.List;

public record IngridientCreateRequestDto(

  String name,

  Integer unitOfMeasure,

  Integer numberCaloria,

  Integer carbohydrates,

  Integer fats,

  Integer proteins,

  List<AllergenCreateRequestDto> allergens

) {
}
