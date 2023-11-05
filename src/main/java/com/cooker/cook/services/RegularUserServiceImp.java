package com.cooker.cook.services;

import com.cooker.cook.dtos.regularUser.*;
import com.cooker.cook.entities.Allergen;
import com.cooker.cook.entities.Recipe;
import com.cooker.cook.entities.RegularUser;
import com.cooker.cook.entities.Role;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.mappers.RegularUserMapper;
import com.cooker.cook.repositories.AllergenRepository;
import com.cooker.cook.repositories.RecipeRepository;
import com.cooker.cook.repositories.RegularUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegularUserServiceImp implements RegularUserService{

  @Autowired
  RegularUserRepository regularUserRepository;
  @Autowired
  RegularUserMapper regularUserMapper;
  @Autowired
  RecipeRepository recipeRepository;
  @Autowired
  AllergenRepository allergenRepository;

  @Override
  public RegularUserResponseDto createUser(RegularUserCreateRequestDto regularUserCreateRequestDto) {
    RegularUser regularUser= regularUserMapper.toEntityCreate(regularUserCreateRequestDto);
    regularUser.setRole(Role.USER);
    regularUser=regularUserRepository.save(regularUser);
    return regularUserMapper.toDtoResponse(regularUserRepository.save(regularUser));

  }

  @Override
  public RegularUserResponseDto updateUser(Long userId, RegularUserUpdateRequestDto regularUserUpdateRequestDto) throws NotFoundCustomException {
    Optional<RegularUser>optionalRegularUser= regularUserRepository.findById(userId);
    if (optionalRegularUser.isEmpty()){
      throw new NotFoundCustomException("User not found");
    }
    RegularUser regularUser= regularUserMapper.toEntityUpdate(regularUserUpdateRequestDto);
    regularUser.setId(userId);
    return regularUserMapper.toDtoResponse(regularUserRepository.save(regularUser));
  }

  @Override
  public RegularUserResponseDto deleteUser(Long userId) throws NotFoundCustomException {
    Optional<RegularUser>optionalRegularUser= regularUserRepository.findById(userId);
    if (optionalRegularUser.isEmpty()){
      throw new NotFoundCustomException("User not found");
    }
    regularUserRepository.delete(optionalRegularUser.get());
    return regularUserMapper.toDtoResponse(optionalRegularUser.get());
  }

  @Override
  public RegularUserRecipeResponseDto createCookerAddRecipe(Long userId, List<Long> listRecipeId) {
    RegularUser regularUser=regularUserRepository.findById(userId).get();
    List<Recipe> recipeList=new ArrayList<>();
    for (Long id: listRecipeId){
      Recipe recipe= recipeRepository.findById(id).get();
      recipeList.add(recipe);
    }
    regularUser.setRecipes(recipeList);
    return regularUserMapper.toDtoResponseUserRecipt(regularUserRepository.save(regularUser));
  }

  @Override
  public RegularUserRecipeResponseDto getByIdCookerAddRecipe(Long userId) throws NotFoundCustomException {
   Optional<RegularUser> optionalRegularUser=regularUserRepository.findById(userId);
   if (optionalRegularUser.isEmpty()){
     throw new NotFoundCustomException("User not found");
   }
    return regularUserMapper.toDtoResponseUserRecipt(optionalRegularUser.get());
  }

  @Override
  public List<RegularUserRecipeResponseDto> getAllCookerAddRecipe() {
    return regularUserMapper.toDtoResponseListUserRecipt(regularUserRepository.findAll());
  }

  @Override
  public RegularUserAllergenResponse createCookerAddAllergen(Long userId, List<Long> listAllergenId) {
    RegularUser regularUser=regularUserRepository.findById(userId).get();
    List<Allergen> allergenList=new ArrayList<>();
    for (Long id: listAllergenId){
      Allergen allergen= allergenRepository.findById(id).get();
      allergenList.add(allergen);
    }
    regularUser.setAllergens(allergenList);
    return regularUserMapper.toDtoResponseUserAllergen(regularUserRepository.save(regularUser));
  }

  @Override
  public RegularUserAllergenResponse getByIdCookerAddAllergen(Long id) throws NotFoundCustomException {
    Optional<RegularUser> optionalRegularUser=regularUserRepository.findById(id);
    if (optionalRegularUser.isEmpty()){
      throw new NotFoundCustomException("User not found");
    }
    return regularUserMapper.toDtoResponseUserAllergen(optionalRegularUser.get());
  }

  @Override
  public List<RegularUserAllergenResponse> getAllCookerAddAllergen() {
    return regularUserMapper.toDtoResponseListUserAllergen(regularUserRepository.findAll());
  }

}
