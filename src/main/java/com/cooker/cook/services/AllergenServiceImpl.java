package com.cooker.cook.services;

import com.cooker.cook.dtos.allergen.AllergenCreateRequestDto;
import com.cooker.cook.dtos.allergen.AllergenResponseDto;
import com.cooker.cook.dtos.allergen.AllergenUpdateRequestDto;
import com.cooker.cook.entities.Allergen;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.mappers.AllergenMapper;
import com.cooker.cook.repositories.AllergenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllergenServiceImpl implements AllergenService {
  @Autowired
  AllergenRepository allergenRepository;
  @Autowired
  AllergenMapper allergenMapper;

  @Override
  public AllergenResponseDto createAllergen(AllergenCreateRequestDto allergenCreateRequestDto) {
    return allergenMapper.toResponseDto(allergenRepository.save(allergenMapper.toEntityCreate(allergenCreateRequestDto)));
  }

  @Override
  public AllergenResponseDto updateAllergen(Long allergenId, AllergenUpdateRequestDto allergenUpdateRequestDto) throws NotFoundCustomException {
    Optional<Allergen> allergenOptional = allergenRepository.findById(allergenId);
    if(allergenOptional.isEmpty()){
      throw new NotFoundCustomException("Allergen not found");
    }
    Allergen allergen = allergenMapper.toEntityUpdate(allergenUpdateRequestDto);
    allergen.setId(allergenId);
    return allergenMapper.toResponseDto(allergenRepository.save(allergen));
  }

  @Override
  public AllergenResponseDto deleteAllergen(Long allergenId) throws NotFoundCustomException {
    Optional<Allergen> allergenOptional = allergenRepository.findById(allergenId);
    if(allergenOptional.isEmpty()){
      throw new NotFoundCustomException("Allergen not found");
    }
    allergenRepository.delete(allergenOptional.get());
    return allergenMapper.toResponseDto(allergenOptional.get());
  }

  @Override
  public List<AllergenResponseDto> getAllAllergen() {
    List<Allergen> allergens = allergenRepository.findAll();
    return allergenMapper.toResponseDtoList(allergens);
  }

  @Override
  public AllergenResponseDto getbyId(Long allergenId) throws NotFoundCustomException {
    Optional<Allergen> allergenOptional = allergenRepository.findById(allergenId);
    if(allergenOptional.isEmpty()){
      throw new NotFoundCustomException("Allergen not found");
    }
    return allergenMapper.toResponseDto(allergenOptional.get());
  }
}
