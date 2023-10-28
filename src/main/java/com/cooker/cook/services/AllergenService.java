package com.cooker.cook.services;

import com.cooker.cook.dtos.allergen.AllergenCreateRequestDto;
import com.cooker.cook.dtos.allergen.AllergenResponseDto;
import com.cooker.cook.dtos.allergen.AllergenUpdateRequestDto;
import com.cooker.cook.entities.Allergen;
import com.cooker.cook.exceptions.NotFoundCustomException;

import java.util.List;

public interface AllergenService {

  AllergenResponseDto createAllergen(AllergenCreateRequestDto allergenCreateRequestDto);

  AllergenResponseDto updateAllergen(Long allergenId, AllergenUpdateRequestDto allergenUpdateRequestDto) throws NotFoundCustomException;

  AllergenResponseDto deleteAllergen(Long allergenId) throws NotFoundCustomException;

  List<AllergenResponseDto> getAllAllergen();

  AllergenResponseDto getbyId(Long allergenId) throws NotFoundCustomException;
}
