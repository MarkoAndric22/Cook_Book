package com.cooker.cook.controllers;

import com.cooker.cook.dtos.regularUser.*;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.services.RegularUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/user")
public class RegularUserController {

  @Autowired
  RegularUserService regularUserService;

  @RequestMapping(method = RequestMethod.POST, value = "create")
  public RegularUserResponseDto createUser(@RequestBody @Valid RegularUserCreateRequestDto regularUserCreateRequestDto) {
    return regularUserService.createUser(regularUserCreateRequestDto);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{userId}")
  public RegularUserResponseDto updateUser(@PathVariable Long userId, @RequestBody @Valid RegularUserUpdateRequestDto regularUserUpdateRequestDto) throws NotFoundCustomException {
    return regularUserService.updateUser(userId, regularUserUpdateRequestDto);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
  public RegularUserResponseDto deleteUser(@PathVariable Long userId) throws NotFoundCustomException {
    return regularUserService.deleteUser(userId);
  }

  @RequestMapping(method = RequestMethod.POST,value ="/{userId}/addRecipe")
  public RegularUserRecipeResponseDto addRecipe(@PathVariable Long userId, @RequestBody List<Long> listRecipeId){
    return regularUserService.createCookerAddRecipe(userId,listRecipeId);
  }

  @RequestMapping(method = RequestMethod.GET,value = "/{userId}")
  public RegularUserRecipeResponseDto getById(@PathVariable Long userId) throws NotFoundCustomException {
    return regularUserService.getByIdCookerAddRecipe(userId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<RegularUserRecipeResponseDto> getAll(){
    return regularUserService.getAllCookerAddRecipe();
  }
  @RequestMapping(method = RequestMethod.POST,value = "/{userId}/addAllergen")
  public RegularUserAllergenResponse addAllergen(@PathVariable Long userId, @RequestBody List<Long> listAllergenId){
    return regularUserService.createCookerAddAllergen(userId,listAllergenId);
  }

  @RequestMapping(method = RequestMethod.GET,value = "{id}/getById")
  public RegularUserAllergenResponse getByIdAllergen(@PathVariable Long id) throws NotFoundCustomException {
    return regularUserService.getByIdCookerAddAllergen(id);
  }

  @RequestMapping(method = RequestMethod.GET,value = "getAll")
  public List<RegularUserAllergenResponse> getAllUserAllergen(){
    return regularUserService.getAllCookerAddAllergen();
  }

}
