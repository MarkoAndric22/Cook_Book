package com.cooker.cook.mappers;

import com.cooker.cook.dtos.ingridient.IngridientCreateRequestDto;
import com.cooker.cook.dtos.ingridient.IngridientResponseDto;
import com.cooker.cook.dtos.ingridient.IngridientUpdateRequestDto;
import com.cooker.cook.dtos.ingridient.IngridientupdateResponse;
import com.cooker.cook.entities.Ingridient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngridientMapper {

  @Mapping(target = "id", ignore = true)
  Ingridient toEntityCreate(IngridientCreateRequestDto ingridientCreateRequestDto);

  @Mappings({
    @Mapping(target = "id", ignore = true)
  })
  Ingridient toEntityUpdate(IngridientUpdateRequestDto ingridientUpdateRequestDTO);

  @Mapping(target = "id", ignore = true)
  IngridientResponseDto toResponseDto(Ingridient ingridient);

  IngridientupdateResponse toUpdateResponse(Ingridient ingridient);

  List<IngridientResponseDto> toResponseListDto(List<Ingridient> ingridientList);

}
