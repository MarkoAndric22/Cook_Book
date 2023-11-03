package com.cooker.cook.dtos.regularUser;

public record RegularUserResponseDto(

  Long id,

  String firstName,

  String lastName,

  String username,

  String password
) {
}
