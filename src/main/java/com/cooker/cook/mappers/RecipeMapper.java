package com.cooker.cook.mappers;

import com.cooker.cook.dtos.recipe.RecipeCreateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeResponseDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateRequestDto;
import com.cooker.cook.dtos.recipe.RecipeUpdateResponseDto;
import com.cooker.cook.entities.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

  @Mappings({
    @Mapping(target = "id", ignore = true)
  })
  Recipe toEntityCreate(RecipeCreateRequestDto recipeCreateRequestDTO);

  @Mapping(target = "id", ignore = true)
  Recipe toEntityUpdate(RecipeUpdateRequestDto recipeUpdateRequestDTO);

  @Mapping(target = "id", ignore = true)
  RecipeResponseDto toResponseDto(Recipe recipe);

  RecipeUpdateResponseDto toUpdateResponseDto(Recipe recipe);

  List<RecipeResponseDto> toListResponseDto(List<Recipe> recipeList);
}
