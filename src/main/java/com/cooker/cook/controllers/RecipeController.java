package com.cooker.cook.controllers;

import com.cooker.cook.dtos.recipe.RecipeCreateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeResponseDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateResponseDto;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/recipe")
public class RecipeController {

  @Autowired
  RecipeService recipeService;

  @RequestMapping(method = RequestMethod.POST,value = "/create")
  public RecipeResponseDto createRecipe(@RequestBody @Valid RecipeCreateRequestDto recipeCreateRequestDto){
    return recipeService.createRecipe(recipeCreateRequestDto);
  }

  @RequestMapping(method = RequestMethod.PUT,value = "/{recipeId}")
  public RecipeUpdateResponseDto updateRecipe(@PathVariable Long recipeId, @RequestBody @Valid RecipeUpdateRequestDto recipeUpdateRequestDto) throws NotFoundCustomException {
    return recipeService.updateRecipe(recipeId,recipeUpdateRequestDto);
  }

  @RequestMapping(method = RequestMethod.DELETE,value = "/{recipeId}")
  public  RecipeResponseDto deleteRecipe(@PathVariable Long recipeId) throws NotFoundCustomException {
    return recipeService.deleteRecipe(recipeId);
  }

  @RequestMapping(method = RequestMethod.GET,value = "/{recipeId}")
  public RecipeResponseDto getByIdRecipe(@PathVariable Long recipeId) throws NotFoundCustomException {
    return recipeService.getByRecipeId(recipeId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<RecipeResponseDto> getAllRecipe(){
    return recipeService.getAllRecipe();
  }
}
