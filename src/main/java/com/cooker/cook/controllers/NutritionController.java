package com.cooker.cook.controllers;

import com.cooker.cook.dtos.nutrition.NutritionCreateRequestDto;
import com.cooker.cook.dtos.nutrition.NutritionResponseDto;
import com.cooker.cook.dtos.nutrition.NutritionUpdateRequestDto;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.services.NutrititonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/nutrition")
public class NutritionController {

  @Autowired
  NutrititonService nutrititonService;


  @RequestMapping(method = RequestMethod.POST,value = "create")
  public NutritionResponseDto create(@RequestBody @Valid NutritionCreateRequestDto nutritionCreateRequestDto){
    return nutrititonService.createNutrition(nutritionCreateRequestDto);
  }
  @RequestMapping(method = RequestMethod.PUT,value = "update")
  public  NutritionResponseDto update(@PathVariable Long nutritionId, @RequestBody @Valid NutritionUpdateRequestDto nutritionUpdateRequestDto) throws NotFoundCustomException {
    return nutrititonService.updateNutrition(nutritionId,nutritionUpdateRequestDto);
  }
  @RequestMapping(method = RequestMethod.DELETE,value = "delete")
  public  NutritionResponseDto delete(@PathVariable Long nutritionId) throws NotFoundCustomException {
    return nutrititonService.deleteNutrition(nutritionId);
  }
  @RequestMapping(method = RequestMethod.GET)
  public List<NutritionResponseDto> getAll() {
    return nutrititonService.getAllNutrition();
  }
  @RequestMapping(method = RequestMethod.GET,value = "/{nutritionId}")
  public NutritionResponseDto getById(@PathVariable Long nutritionId) throws NotFoundCustomException {
    return nutrititonService.getById(nutritionId);
  }

}
