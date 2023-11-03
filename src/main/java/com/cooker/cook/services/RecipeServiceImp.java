package com.cooker.cook.services;

import com.cooker.cook.dtos.recipe.RecipeCreateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeResponseDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateResponseDto;
import com.cooker.cook.entities.Recipe;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.mappers.RecipeMapper;
import com.cooker.cook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImp implements RecipeService{

  @Autowired
  RecipeRepository recipeRepository;
  @Autowired
  RecipeMapper recipeMapper;

  @Override
  public RecipeResponseDto createRecipe(RecipeCreateRequestDto recipeCreateRequestDto) {
    return recipeMapper.toResponseDto(recipeRepository.save(recipeMapper.toEntityCreate(recipeCreateRequestDto)));
  }

  @Override
  public RecipeUpdateResponseDto updateRecipe(Long recipeId, RecipeUpdateRequestDto recipeUpdateRequestDto) throws NotFoundCustomException {
    Optional<Recipe> optionalRecipe= recipeRepository.findById(recipeId);
    if (optionalRecipe.isEmpty()){
      throw new NotFoundCustomException("Recipe not found");
    }
    Recipe recipe=recipeMapper.toEntityUpdate(recipeUpdateRequestDto);
    recipe.setId(recipeId);
    return recipeMapper.toUpdateResponseDto(recipeRepository.save(recipe));
  }

  @Override
  public RecipeResponseDto deleteRecipe(Long recipeId) throws NotFoundCustomException {
    Optional<Recipe> optionalRecipe= recipeRepository.findById(recipeId);
    if (optionalRecipe.isEmpty()){
      throw new NotFoundCustomException("Recipe not found");
    }
    recipeRepository.delete(optionalRecipe.get());
    return recipeMapper.toResponseDto(optionalRecipe.get());
  }

  @Override
  public RecipeResponseDto getByRecipeId(Long recipeId) throws NotFoundCustomException {
    Optional<Recipe> optionalRecipe= recipeRepository.findById(recipeId);
    if (optionalRecipe.isEmpty()){
      throw new NotFoundCustomException("Recipe not found");
    }
    return recipeMapper.toResponseDto(optionalRecipe.get());
  }

  @Override
  public List<RecipeResponseDto> getAllRecipe() {
    return recipeMapper.toListResponseDto(recipeRepository.findAll());
  }
}
