package com.cooker.cook.mappers;


import com.cooker.cook.dtos.regularUser.RegularUserCreateRequestDto;
import com.cooker.cook.dtos.regularUser.RegularUserResponseDto;
import com.cooker.cook.dtos.regularUser.RegularUserUpdateRequestDto;
import com.cooker.cook.entities.RegularUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegularUserMapper {

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "role",ignore = true)
  })
  RegularUser toEntityCreate(RegularUserCreateRequestDto regularUserCreateRequestDto);

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "recipes",ignore = true),
    @Mapping(target = "role",ignore = true)
  })
  RegularUser toEntityUpdate(RegularUserUpdateRequestDto regularUserUpdateRequestDto);

  @Mapping(target = "id", ignore = true)
  RegularUserResponseDto toDtoResponse(RegularUser regularUser);

  List<RegularUserResponseDto> toDtoListResponse(List<RegularUser> regularUserList);
}
