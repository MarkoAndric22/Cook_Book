package com.cooker.cook.dtos.cooker;

public record CookerResponseDto(

  Long id,

  String firstName,

  String lastName,

  String username,

  String password
) {
}
