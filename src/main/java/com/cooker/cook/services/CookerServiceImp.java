package com.cooker.cook.services;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.cooker.cook.dtos.cooker.CookerCreateRequestDto;
import com.cooker.cook.dtos.cooker.CookerResponseDto;
import com.cooker.cook.dtos.cooker.CookerUpdateRequestDto;
import com.cooker.cook.entities.Cooker;
import com.cooker.cook.entities.Role;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.mappers.CookerMapper;
import com.cooker.cook.repositories.CookerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookerServiceImp implements CookerService{

  @Autowired
  CookerRepository cookerRepository;
  @Autowired
  CookerMapper cookerMapper;

  @Override
  public CookerResponseDto createCooker(CookerCreateRequestDto cookerCreateRequestDto) {
    Cooker cooker = cookerMapper.toEntityCreate(cookerCreateRequestDto);
    cooker.setRole(Role.COOK);
    cooker = cookerRepository.save(cooker);
    return cookerMapper.toResponseDto(cooker);
  }



  @Override
  public CookerResponseDto updateCooker(Long cookerId, CookerUpdateRequestDto cookerUpdateRequestDto) throws NotFoundCustomException {
    Optional<Cooker>optionalCooker=cookerRepository.findById(cookerId);
    if (optionalCooker.isEmpty()){
      throw new NotFoundCustomException("Cooker not found");
    }
    Cooker cooker=cookerMapper.toEntityUpdate(cookerUpdateRequestDto);
    cooker.setId(cookerId);
    return cookerMapper.toResponseDto(cookerRepository.save(cooker));
  }

  @Override
  public CookerResponseDto getById(Long cookerId) throws NotFoundCustomException {
    Optional<Cooker>optionalCooker=cookerRepository.findById(cookerId);
    if (optionalCooker.isEmpty()){
      throw new NotFoundCustomException("Cooker not found");
    }
    return cookerMapper.toResponseDto(optionalCooker.get());
  }

  @Override
  public List<CookerResponseDto> getAllCooker() {
    List<Cooker>cookerList=cookerRepository.findAll();
    return cookerMapper.toResponseListDto(cookerList);
  }

  @Override
  public CookerResponseDto deleteCooker(Long cookerId) throws NotFoundCustomException {
    Optional<Cooker>optionalCooker=cookerRepository.findById(cookerId);
    if (optionalCooker.isEmpty()){
      throw new NotFoundCustomException("Cooker not found");
    }
    cookerRepository.delete(optionalCooker.get());
    return cookerMapper.toResponseDto(optionalCooker.get());
  }
}
