package com.cooker.cook.dtos.regularUser;

public record RegularUserCreateRequestDto(
  String firstName,

  String lastName,

  String username,

  String password
) {
}
