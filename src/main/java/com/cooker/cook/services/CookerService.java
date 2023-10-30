package com.cooker.cook.services;

import com.cooker.cook.dtos.cooker.CookerCreateRequestDto;
import com.cooker.cook.dtos.cooker.CookerResponseDto;
import com.cooker.cook.dtos.cooker.CookerUpdateRequestDto;
import com.cooker.cook.exceptions.NotFoundCustomException;

import java.util.List;

public interface CookerService {

  CookerResponseDto createCooker(CookerCreateRequestDto cookerCreateRequestDto);

  CookerResponseDto updateCooker(Long cookerId, CookerUpdateRequestDto cookerUpdateRequestDto) throws NotFoundCustomException;

  CookerResponseDto getById(Long cookerId) throws NotFoundCustomException;

  List<CookerResponseDto> getAllCooker();

  CookerResponseDto deleteCooker(Long cookerId) throws NotFoundCustomException;
}
