package com.cooker.cook.services;

import com.cooker.cook.dtos.nutrition.NutritionCreateRequestDto;
import com.cooker.cook.dtos.nutrition.NutritionResponseDto;
import com.cooker.cook.dtos.nutrition.NutritionUpdateRequestDto;
import com.cooker.cook.exceptions.NotFoundCustomException;

import java.util.List;

public interface NutrititonService {

  NutritionResponseDto createNutrition(NutritionCreateRequestDto nutritionCreateRequestDto);

  NutritionResponseDto updateNutrition(Long nutritionId,NutritionUpdateRequestDto nutritionUpdateRequestDto) throws NotFoundCustomException;

  NutritionResponseDto deleteNutrition(Long nutritionId) throws NotFoundCustomException;

  List<NutritionResponseDto> getAllNutrition();

  NutritionResponseDto getById(Long nutritionId) throws NotFoundCustomException;
}
