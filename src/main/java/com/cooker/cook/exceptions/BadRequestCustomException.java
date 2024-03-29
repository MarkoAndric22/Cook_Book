package com.cooker.cook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestCustomException extends Exception{
  public BadRequestCustomException(String message) {
    super(message);
  }
}
