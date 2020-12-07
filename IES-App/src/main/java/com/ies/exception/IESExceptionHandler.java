package com.ies.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class IESExceptionHandler {
	@ExceptionHandler(value = SSANotValidException.class)
  public String SSANotValidException() {
	  return null;
  }
}
