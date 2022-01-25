package com.infosys.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infosys.dto.ErrorMessage;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@Autowired
	private ErrorMessage errClass;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorMessage DtoValidationException(MethodArgumentNotValidException exp) {
		
		String message = exp.getBindingResult().getAllErrors()
				.stream()
				.map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining(","));	
		errClass.setMessage(message);
		
		  final List<String> errors = new ArrayList<String>();
	        for (final FieldError error : exp.getBindingResult().getFieldErrors()) {
	            System.out.println(error.getRejectedValue()+ ": " + error.getDefaultMessage());
	        }
		return errClass;	
	}
	@ExceptionHandler
	public ErrorMessage exceptionHandler(ConstraintViolationException ex)
	{
		
		String message = ex.getConstraintViolations()
							.stream()
							.map(ConstraintViolation::getMessage)
							.collect(Collectors.joining(","));
		
		errClass.setMessage(message);
		
		return errClass;
	}
	
	@ExceptionHandler
	public ErrorMessage exceptionHandler(Exception ex)
	{
		errClass.setMessage(ex.getMessage()+"Gloner");	
		return errClass;
	}
}
