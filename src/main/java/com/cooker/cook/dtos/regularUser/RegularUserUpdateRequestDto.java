package com.cooker.cook.dtos.regularUser;

public record RegularUserUpdateRequestDto(

  String firstName,

  String lastName,

  String username,

  String password

) {
}
