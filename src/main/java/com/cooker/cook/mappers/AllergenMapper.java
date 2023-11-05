package com.cooker.cook.mappers;

import com.cooker.cook.dtos.allergen.AllergenCreateRequestDto;
import com.cooker.cook.dtos.allergen.AllergenResponseDto;
import com.cooker.cook.dtos.allergen.AllergenUpdateRequestDto;
import com.cooker.cook.entities.Allergen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AllergenMapper {

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "ingridients", ignore = true)
  })
  Allergen toEntityCreate(AllergenCreateRequestDto allergenCreateRequestDTO);

  @Mapping(target = "id", ignore = true)
  Allergen toEntityUpdate(AllergenUpdateRequestDto allergenUpdateRequestDTO);

  @Mapping(target = "id", ignore = true)
  AllergenResponseDto toResponseDto(Allergen allergen);

  @Mappings({
    @Mapping(target = "id", ignore = true)
    })
  List<AllergenResponseDto> toResponseDtoList(List<Allergen>allergenList);

}
