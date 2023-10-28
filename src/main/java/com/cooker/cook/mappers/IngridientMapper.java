package com.cooker.cook.mappers;

import com.cooker.cook.dtos.ingridient.IngridientUpdateRequestDto;
import com.cooker.cook.entities.Ingridient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IngridientMapper {

  Ingridient toEntityUpdate(IngridientUpdateRequestDto ingridientUpdateRequestDTO);
}
