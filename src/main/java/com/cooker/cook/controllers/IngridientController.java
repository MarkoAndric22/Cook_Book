package com.cooker.cook.controllers;

import com.cooker.cook.dtos.ingridient.IngridientCreateRequestDto;
import com.cooker.cook.dtos.ingridient.IngridientResponseDto;
import com.cooker.cook.dtos.ingridient.IngridientUpdateRequestDto;
import com.cooker.cook.dtos.ingridient.IngridientupdateResponse;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.services.IngridientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/ingridient")
public class IngridientController {

  @Autowired
  IngridientService ingridientService;

  @RequestMapping(method = RequestMethod.POST,value = "/create")
  public IngridientResponseDto createIngridient(@RequestBody @Valid IngridientCreateRequestDto ingridientCreateRequestDto){
    return ingridientService.createIngridient(ingridientCreateRequestDto);
  }

  @RequestMapping(method = RequestMethod.PUT,value = "/{ingridientId}")
  public IngridientupdateResponse ingridientupdateResponse(@PathVariable Long ingridientId, @RequestBody @Valid IngridientUpdateRequestDto ingridientUpdateRequestDto) throws NotFoundCustomException {
    return ingridientService.updateIngridient(ingridientId,ingridientUpdateRequestDto);
  }

  @RequestMapping(method = RequestMethod.DELETE,value = "/{ingridientId}")
  public IngridientResponseDto deleteIngridient(@PathVariable Long ingridientId) throws NotFoundCustomException {
    return ingridientService.deleteIngridient(ingridientId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<IngridientResponseDto> getAllIngridient(){
    return ingridientService.getAllIngridient();
  }

  @RequestMapping(method = RequestMethod.GET,value = "{ingridientId}")
  public IngridientResponseDto IngridientResponseDto(@PathVariable Long ingridientId) throws NotFoundCustomException {
    return ingridientService.getByIdIngridient(ingridientId);
  }

}
