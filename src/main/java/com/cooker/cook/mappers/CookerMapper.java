package com.cooker.cook.mappers;

import com.cooker.cook.dtos.cooker.CookerCreateRequestDto;
import com.cooker.cook.dtos.cooker.CookerResponseDto;
import com.cooker.cook.dtos.cooker.CookerUpdateRequestDto;
import com.cooker.cook.entities.Cooker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CookerMapper {


    @Mapping(target = "id", ignore = true)
  Cooker toEntityCreate(CookerCreateRequestDto cookerCreateRequestDto);

  @Mapping(target = "id", ignore = true)
  Cooker toEntityUpdate(CookerUpdateRequestDto cookerCreateRequestDto);

  CookerResponseDto toResponseDto(Cooker cooker);

  List<CookerResponseDto> toResponseListDto(List<Cooker>cookerList);
}
