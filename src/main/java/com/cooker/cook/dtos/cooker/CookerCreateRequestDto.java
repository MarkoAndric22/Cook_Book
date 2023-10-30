package com.cooker.cook.dtos.cooker;

public record CookerCreateRequestDto(
  String firstName,

  String lastName,

  String username,

  String password
) {
}
