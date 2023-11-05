package com.cooker.cook.services;

import com.cooker.cook.dtos.regularUser.*;
import com.cooker.cook.exceptions.NotFoundCustomException;

import java.util.List;

public interface RegularUserService {

  RegularUserResponseDto createUser(RegularUserCreateRequestDto regularUserCreateRequestDto);

  RegularUserResponseDto updateUser(Long userId, RegularUserUpdateRequestDto regularUserUpdateRequestDto) throws NotFoundCustomException;

  RegularUserResponseDto deleteUser(Long userId) throws NotFoundCustomException;

  RegularUserRecipeResponseDto createCookerAddRecipe(Long userId, List<Long> listRecipeId) ;

  RegularUserRecipeResponseDto getByIdCookerAddRecipe(Long id) throws NotFoundCustomException;

  List<RegularUserRecipeResponseDto> getAllCookerAddRecipe();

  RegularUserAllergenResponse createCookerAddAllergen(Long userId,List<Long> listAllergenId);

  RegularUserAllergenResponse getByIdCookerAddAllergen(Long id) throws NotFoundCustomException;

  List<RegularUserAllergenResponse> getAllCookerAddAllergen();

}
