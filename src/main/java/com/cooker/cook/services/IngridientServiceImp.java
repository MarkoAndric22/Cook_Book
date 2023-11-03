package com.cooker.cook.services;

import com.cooker.cook.dtos.ingridient.IngridientCreateRequestDto;
import com.cooker.cook.dtos.ingridient.IngridientResponseDto;
import com.cooker.cook.dtos.ingridient.IngridientUpdateRequestDto;
import com.cooker.cook.dtos.ingridient.IngridientupdateResponse;
import com.cooker.cook.entities.Ingridient;
import com.cooker.cook.exceptions.NotFoundCustomException;
import com.cooker.cook.mappers.IngridientMapper;
import com.cooker.cook.repositories.IngridientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngridientServiceImp implements IngridientService{

  @Autowired
  IngridientRepository ingridientRepository;
  @Autowired
  IngridientMapper ingridientMapper;

  @Override
  public IngridientResponseDto createIngridient(IngridientCreateRequestDto ingridientCreateRequestDto) {
    return ingridientMapper.toResponseDto(ingridientRepository.save(ingridientMapper.toEntityCreate(ingridientCreateRequestDto)));
  }

  @Override
  public IngridientupdateResponse updateIngridient(Long ingridientId, IngridientUpdateRequestDto ingridientUpdateRequestDto) throws NotFoundCustomException {
    Optional<Ingridient> optionalIngridient= ingridientRepository.findById(ingridientId);
    if (optionalIngridient.isEmpty()){
      throw new NotFoundCustomException("Ingridient not found");
    }
    Ingridient ingridient=ingridientMapper.toEntityUpdate(ingridientUpdateRequestDto);
    ingridient.setId(ingridientId);
    return ingridientMapper.toUpdateResponse(ingridientRepository.save(ingridient));
  }

  @Override
  public IngridientResponseDto deleteIngridient(Long ingridientId) throws NotFoundCustomException {
    Optional<Ingridient> optionalIngridient= ingridientRepository.findById(ingridientId);
    if (optionalIngridient.isEmpty()){
      throw new NotFoundCustomException("Ingridient not found");
    }
     ingridientRepository.delete(optionalIngridient.get());
    return ingridientMapper.toResponseDto(optionalIngridient.get());
  }

  @Override
  public List<IngridientResponseDto> getAllIngridient() {
    return ingridientMapper.toResponseListDto(ingridientRepository.findAll());
  }

  @Override
  public IngridientResponseDto getByIdIngridient(Long ingridientId) throws NotFoundCustomException {
    Optional<Ingridient> optionalIngridient= ingridientRepository.findById(ingridientId);
    if (optionalIngridient.isEmpty()){
      throw new NotFoundCustomException("Ingridient not found");
    }
    return ingridientMapper.toResponseDto(optionalIngridient.get());
  }
}
