package com.cooker.cook.controllers;

import com.cooker.cook.dtos.allergen.AllergenCreateRequestDto;
import com.cooker.cook.dtos.allergen.AllergenResponseDto;
import com.cooker.cook.dtos.allergen.AllergenUpdateRequestDto;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.services.AllergenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
@RequestMapping("/allergen")
public class AllergenController {
  @Autowired
  AllergenService allergenService;

  @RequestMapping(method = RequestMethod.POST,value = "create")
  public AllergenResponseDto create(@RequestBody @Valid AllergenCreateRequestDto allergenCreateRequestDto){
    return allergenService.createAllergen(allergenCreateRequestDto);
  }

  @RequestMapping(method = RequestMethod.PUT,value = "/{allergenId}")
  public AllergenResponseDto update(@PathVariable Long allergenId, @RequestBody @Valid AllergenUpdateRequestDto allergenUpdateRequestDto) throws NotFoundCustomException {
    return allergenService.updateAllergen(allergenId, allergenUpdateRequestDto);
  }

  @RequestMapping(method = RequestMethod.DELETE,value ="/{allergenId}")
  public AllergenResponseDto delete(@PathVariable Long allergenId) throws NotFoundCustomException {
    return allergenService.deleteAllergen(allergenId);
  }

  @RequestMapping(method =RequestMethod.GET )
  public List<AllergenResponseDto> getAllAllergen(){
    return allergenService.getAllAllergen();
  }
  @RequestMapping(method = RequestMethod.GET,value = "/{allergenId}")
  public AllergenResponseDto getByIdAllergen(@PathVariable Long allergenId) throws NotFoundCustomException {
    return allergenService.getbyId(allergenId);
  }
}
