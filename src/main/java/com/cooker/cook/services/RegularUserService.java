package com.cooker.cook.services;

import com.cooker.cook.dtos.regularUser.RegularUserCreateRequestDto;
import com.cooker.cook.dtos.regularUser.RegularUserResponseDto;
import com.cooker.cook.dtos.regularUser.RegularUserUpdateRequestDto;
import com.cooker.cook.exceptions.NotFoundCustomException;

import java.util.List;

public interface RegularUserService {

  RegularUserResponseDto createUser(RegularUserCreateRequestDto regularUserCreateRequestDto);

  RegularUserResponseDto updateUser(Long userId, RegularUserUpdateRequestDto regularUserUpdateRequestDto) throws NotFoundCustomException;

  RegularUserResponseDto deleteUser(Long userId) throws NotFoundCustomException;

  RegularUserResponseDto getByIdUser(Long userId) throws NotFoundCustomException;

  List<RegularUserResponseDto> getAllUser();
}
