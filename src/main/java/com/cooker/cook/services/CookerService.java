package com.cooker.cook.services;

import com.cooker.cook.dtos.cooker.*;
import com.cooker.cook.exceptions.NotFoundCustomException;

import java.util.List;

public interface CookerService {

  CookerResponseDto createCooker(CookerCreateRequestDto cookerCreateRequestDto);

  CookerResponseDto updateCooker(Long cookerId, CookerUpdateRequestDto cookerUpdateRequestDto) throws NotFoundCustomException;

  CookerResponseDto deleteCooker(Long cookerId) throws NotFoundCustomException;

  CookerRecipeResponseDto createCookerAddRecipe(Long cookerId,List<Long> listRecipeId) ;

  CookerRecipeResponseDto getByIdCookerAddRecipe(Long id) throws NotFoundCustomException;

  List<CookerRecipeResponseDto> getAllCookerAddRecipe();

}
