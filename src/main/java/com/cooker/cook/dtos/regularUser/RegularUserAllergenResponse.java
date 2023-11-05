package com.cooker.cook.dtos.regularUser;

import com.cooker.cook.dtos.allergen.AllergenResponseDto;

import java.util.List;

public record RegularUserAllergenResponse(

  Long id,

  String firstName,

  String lastName,

  String username,

  String password,

  List<AllergenResponseDto> allergens

) {
}
