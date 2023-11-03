package com.cooker.cook.dtos.ingridient;

public record IngridientupdateResponse(

  String name,

  Integer unitOfMeasure,

  Integer numberCaloria,

  Integer carbohydrates,

  Integer fats,

  Integer protein
) {
}
