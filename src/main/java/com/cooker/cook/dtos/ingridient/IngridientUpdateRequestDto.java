package com.cooker.cook.dtos.ingridient;

public record IngridientUpdateRequestDto(
  Long id,

  String name,

  Integer unitOfMeasure
) {
}
