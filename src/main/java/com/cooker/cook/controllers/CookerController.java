package com.cooker.cook.controllers;

import com.cooker.cook.dtos.cooker.*;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.services.CookerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RequestMapping("/cooker")
@RestController
public class CookerController {

  @Autowired
  CookerService cookerService;

  @RequestMapping(method = RequestMethod.POST,value = "/create")
  public CookerResponseDto createCooker(@RequestBody @Valid CookerCreateRequestDto cookerCreateRequestDto){
    return cookerService.createCooker(cookerCreateRequestDto);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{cookerId}")
  public CookerResponseDto updateCooker(@PathVariable Long cookerId, @RequestBody @Valid CookerUpdateRequestDto cookerUpdateRequestDto) throws NotFoundCustomException {
    return cookerService.updateCooker(cookerId,cookerUpdateRequestDto);
  }

  @RequestMapping(method = RequestMethod.DELETE,value = "/{cookerId}")
  public CookerResponseDto deleteCooker(@PathVariable Long cookerId) throws NotFoundCustomException {
    return cookerService.deleteCooker(cookerId);
  }

  @RequestMapping(method = RequestMethod.POST,value = "/{cookerId}/addRecipe")
  public CookerRecipeResponseDto addRecipe(@PathVariable Long cookerId,@RequestBody List<Long> listRecipeId)  {
    return cookerService.createCookerAddRecipe(cookerId,listRecipeId);
  }

  @RequestMapping(method = RequestMethod.GET,value = "/{cookerId}")
  public CookerRecipeResponseDto getById(@PathVariable Long cookerId) throws NotFoundCustomException {
    return cookerService.getByIdCookerAddRecipe(cookerId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<CookerRecipeResponseDto> getAll(){
    return cookerService.getAllCookerAddRecipe();
  }

}
