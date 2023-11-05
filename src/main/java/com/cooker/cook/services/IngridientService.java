package com.cooker.cook.services;

import com.cooker.cook.dtos.ingridient.IngridientCreateRequestDto;
import com.cooker.cook.dtos.ingridient.IngridientResponseDto;
import com.cooker.cook.dtos.ingridient.IngridientUpdateRequestDto;
import com.cooker.cook.dtos.ingridient.IngridientupdateResponse;
import com.cooker.cook.exceptions.NotFoundCustomException;

import java.util.List;

public interface IngridientService {

  IngridientResponseDto createIngridient (IngridientCreateRequestDto ingridientCreateRequestDto);

  IngridientupdateResponse updateIngridient (Long ingridientId, IngridientUpdateRequestDto ingridientUpdateRequestDto) throws NotFoundCustomException;

  IngridientResponseDto deleteIngridient (Long ingridientId) throws NotFoundCustomException;

  List<IngridientResponseDto> getAllIngridient ();

  IngridientResponseDto getByIdIngridient (Long ingridientId) throws NotFoundCustomException;

}
