package com.cooker.cook.mappers;

import com.cooker.cook.dtos.cooker.*;
import com.cooker.cook.entities.Cooker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",
uses = RecipeMapper.class)
public interface CookerMapper {


  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "role",ignore = true)
  })
  Cooker toEntityCreate(CookerCreateRequestDto cookerCreateRequestDto);

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "role",ignore = true)
  })
  Cooker toEntityUpdate(CookerUpdateRequestDto cookerCreateRequestDto);

  @Mappings({
    @Mapping(target = "id", ignore = true)
  })
  CookerResponseDto toResponseDto(Cooker cooker);


  List<CookerResponseDto> toResponseListDto(List<Cooker>cookerList);


  CookerCreateRequestDto toRequestDto(Cooker cooker);

  CookerRecipeResponseDto toResponseCookerRecipeDto(Cooker cooker);

  @Mapping(target = "id", ignore = true)
  List<CookerRecipeResponseDto> toResponseListCookerRecipeDto(List<Cooker> cookerList);


}
