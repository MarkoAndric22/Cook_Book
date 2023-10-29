package com.cooker.cook.services;

import com.cooker.cook.dtos.nutrition.NutritionCreateRequestDto;
import com.cooker.cook.dtos.nutrition.NutritionResponseDto;
import com.cooker.cook.dtos.nutrition.NutritionUpdateRequestDto;
import com.cooker.cook.entities.Nutrition;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.mappers.NutritionMapper;
import com.cooker.cook.repositories.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionServiceImp implements NutrititonService{

  @Autowired
  NutritionRepository nutritionRepository;
  @Autowired
  NutritionMapper nutritionMapper;


  @Override
  public NutritionResponseDto createNutrition(NutritionCreateRequestDto nutritionCreateRequestDto) {
    return nutritionMapper.toResponseDto(nutritionRepository.save(nutritionMapper.toEntityCreate(nutritionCreateRequestDto)));
  }

  @Override
  public NutritionResponseDto updateNutrition(Long nutritionId,NutritionUpdateRequestDto nutritionUpdateRequestDto) throws NotFoundCustomException {
    Optional<Nutrition> nutritionOptional=nutritionRepository.findById(nutritionId);
    if (nutritionOptional.isEmpty()){
      throw new NotFoundCustomException("Nutrition not found");
    }
    Nutrition nutrition= nutritionMapper.toEntityUpdate(nutritionUpdateRequestDto);
    nutrition.setId(nutritionId);
    return nutritionMapper.toResponseDto(nutrition);
  }

  @Override
  public NutritionResponseDto deleteNutrition(Long nutritionId) throws NotFoundCustomException {
    Optional<Nutrition> nutritionOptional=nutritionRepository.findById(nutritionId);
    if (nutritionOptional.isEmpty()){
      throw new NotFoundCustomException("Nutrition not found");
    }
    nutritionRepository.delete(nutritionOptional.get());
    return nutritionMapper.toResponseDto(nutritionOptional.get());
  }

  @Override
  public List<NutritionResponseDto> getAllNutrition() {
    List<Nutrition> nutritionList=nutritionRepository.findAll();
    return nutritionMapper.toResponseListDto(nutritionList);
  }

  @Override
  public NutritionResponseDto getById(Long nutritionId) throws NotFoundCustomException {
    Optional<Nutrition> nutritionOptional=nutritionRepository.findById(nutritionId);
    if (nutritionOptional.isEmpty()){
      throw new NotFoundCustomException("Nutrition not found");
    }
    return nutritionMapper.toResponseDto(nutritionOptional.get());
  }
}
