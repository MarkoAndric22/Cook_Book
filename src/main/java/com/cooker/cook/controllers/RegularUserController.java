package com.cooker.cook.controllers;

import com.cooker.cook.dtos.regularUser.RegularUserCreateRequestDto;
import com.cooker.cook.dtos.regularUser.RegularUserResponseDto;
import com.cooker.cook.dtos.regularUser.RegularUserUpdateRequestDto;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.services.RegularUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/user")
public class RegularUserController {

  @Autowired
  RegularUserService regularUserService;

  @RequestMapping(method = RequestMethod.POST,value = "create")
  public RegularUserResponseDto createUser(@RequestBody @Valid RegularUserCreateRequestDto regularUserCreateRequestDto){
    return regularUserService.createUser(regularUserCreateRequestDto);
  }

  @RequestMapping(method = RequestMethod.PUT,value = "/{userId}")
  public RegularUserResponseDto updateUser(@PathVariable Long userId, @RequestBody @Valid RegularUserUpdateRequestDto regularUserUpdateRequestDto) throws NotFoundCustomException {
    return regularUserService.updateUser(userId,regularUserUpdateRequestDto);
  }

  @RequestMapping(method = RequestMethod.DELETE,value = "/{userId}" )
  public RegularUserResponseDto deleteUser(@PathVariable Long userId) throws NotFoundCustomException {
    return regularUserService.deleteUser(userId);
  }

  @RequestMapping(method = RequestMethod.GET,value = "/{userId}" )
  public RegularUserResponseDto getByIdUser(@PathVariable Long userId) throws NotFoundCustomException {
    return regularUserService.deleteUser(userId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<RegularUserResponseDto> getAllUser(){
    return regularUserService.getAllUser();
  }
}
