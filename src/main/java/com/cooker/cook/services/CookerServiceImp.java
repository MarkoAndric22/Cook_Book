package com.cooker.cook.services;

import com.cooker.cook.dtos.cooker.*;
import com.cooker.cook.entities.Cooker;
import com.cooker.cook.entities.Recipe;
import com.cooker.cook.entities.Role;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.mappers.CookerMapper;
import com.cooker.cook.repositories.CookerRepository;
import com.cooker.cook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CookerServiceImp implements CookerService{

  @Autowired
  CookerRepository cookerRepository;
  @Autowired
  CookerMapper cookerMapper;
  @Autowired
  RecipeRepository recipeRepository;

  @Override
  public CookerResponseDto createCooker(CookerCreateRequestDto cookerCreateRequestDto) {
    Cooker cooker = cookerMapper.toEntityCreate(cookerCreateRequestDto);
    cooker.setRole(Role.COOK);
    cooker = cookerRepository.save(cooker);
    return cookerMapper.toResponseDto(cooker);
  }

  @Override
  public CookerResponseDto updateCooker(Long cookerId, CookerUpdateRequestDto cookerUpdateRequestDto) throws NotFoundCustomException {
    Optional<Cooker>optionalCooker=cookerRepository.findById(cookerId);
    if (optionalCooker.isEmpty()){
      throw new NotFoundCustomException("Cooker not found");
    }
    Cooker cooker=cookerMapper.toEntityUpdate(cookerUpdateRequestDto);
    cooker.setId(cookerId);
    return cookerMapper.toResponseDto(cookerRepository.save(cooker));
  }

  @Override
  public CookerResponseDto deleteCooker(Long cookerId) throws NotFoundCustomException {
    Optional<Cooker>optionalCooker=cookerRepository.findById(cookerId);
    if (optionalCooker.isEmpty()){
      throw new NotFoundCustomException("Cooker not found");
    }
    cookerRepository.delete(optionalCooker.get());
    return cookerMapper.toResponseDto(optionalCooker.get());
  }

  @Override
  public CookerRecipeResponseDto createCookerAddRecipe(Long cookerId, List<Long> listRecipeId) {

    Cooker cooker= cookerRepository.findById(cookerId).get();
    List<Recipe> recipeList= new ArrayList<>();
    for (Long id : listRecipeId){
      Recipe recipe=recipeRepository.findById(id).get();
      recipeList.add(recipe);
    }
    cooker.setRecipes(recipeList);

    return cookerMapper.toResponseCookerRecipeDto(cookerRepository.save(cooker));
  }

  @Override
  public CookerRecipeResponseDto getByIdCookerAddRecipe(Long id) throws NotFoundCustomException {
    Optional<Cooker> optionalCooker=cookerRepository.findById(id);
    if (optionalCooker.isEmpty()){
      throw new NotFoundCustomException("Cooker not found");
    }
    return cookerMapper.toResponseCookerRecipeDto(optionalCooker.get());
  }

  @Override
  public List<CookerRecipeResponseDto> getAllCookerAddRecipe() {
    return cookerMapper.toResponseListCookerRecipeDto(cookerRepository.findAll());
  }
}
