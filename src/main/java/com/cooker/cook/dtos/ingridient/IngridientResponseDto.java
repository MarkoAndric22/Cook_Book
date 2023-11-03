package com.cooker.cook.dtos.ingridient;

import com.cooker.cook.dtos.allergen.AllergenResponseDto;

import java.util.List;

public record IngridientResponseDto(

  Long id,

  String name,

  Integer unitOfMeasure,

  Integer numberCaloria,

  Integer carbohydrates,

  Integer fats,

  Integer proteins,

  List<AllergenResponseDto>allergens
) {
}
