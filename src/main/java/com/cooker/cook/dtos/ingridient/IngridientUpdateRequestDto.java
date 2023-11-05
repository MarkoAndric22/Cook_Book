package com.cooker.cook.dtos.ingridient;

public record IngridientUpdateRequestDto(

  String name,

  Integer unitOfMeasure,

  Integer numberCaloria,

  Integer carbohydrates,

  Integer fats,

  Integer proteins

) {
}
