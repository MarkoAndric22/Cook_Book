package com.cooker.cook.mappers;

import com.cooker.cook.dtos.nutrition.NutritionCreateRequestDto;
import com.cooker.cook.dtos.nutrition.NutritionResponseDto;
import com.cooker.cook.dtos.nutrition.NutritionUpdateRequestDto;
import com.cooker.cook.entities.Nutrition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NutritionMapper {

  @Mapping(target = "id", ignore = true)
  Nutrition toEntityCreate(NutritionCreateRequestDto nutritionCreateRequestDto);

  @Mapping(target = "id", ignore = true)
  Nutrition toEntityUpdate(NutritionUpdateRequestDto nutritionUpdateRequestDto);

  NutritionResponseDto toResponseDto(Nutrition nutrition);

  List<NutritionResponseDto>toResponseListDto(List<Nutrition>nutritionList);



}
