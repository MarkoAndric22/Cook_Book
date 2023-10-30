package com.cooker.cook.controllers;

import com.cooker.cook.dtos.cooker.CookerCreateRequestDto;
import com.cooker.cook.dtos.cooker.CookerResponseDto;
import com.cooker.cook.dtos.cooker.CookerUpdateRequestDto;
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

  @RequestMapping(method = RequestMethod.PUT, value = "/update")
  public CookerResponseDto updateCooker(@PathVariable Long cookerId, @RequestBody @Valid CookerUpdateRequestDto cookerUpdateRequestDto) throws NotFoundCustomException {
    return cookerService.updateCooker(cookerId,cookerUpdateRequestDto);
  }

  @RequestMapping(method =RequestMethod.GET, value = "/{cookerId}")
  public CookerResponseDto getByIdCooker(@PathVariable Long cookerId) throws NotFoundCustomException {
    return cookerService.getById(cookerId);
  }
  @RequestMapping(method = RequestMethod.GET)
  public List<CookerResponseDto> getAllCooker(){
    return cookerService.getAllCooker();
  }
  @RequestMapping(method = RequestMethod.DELETE,value = "/{cookerId}")
  public CookerResponseDto deleteCooker(@PathVariable Long cookerId) throws NotFoundCustomException {
    return cookerService.deleteCooker(cookerId);
  }
}
