package com.cooker.cook.dtos.cooker;

public record CookerUpdateRequestDto(

  String firstName,

  String lastName,

  String username,

  String password
) {
}
