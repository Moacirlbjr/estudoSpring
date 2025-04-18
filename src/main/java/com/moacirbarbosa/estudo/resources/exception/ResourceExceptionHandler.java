package com.moacirbarbosa.estudo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.moacirbarbosa.estudo.services.exception.DataIntegrityException;
import com.moacirbarbosa.estudo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public 	ResponseEntity<StandardErro> objectNotFound(ObjectNotFoundException e , HttpServletRequest request){
		StandardErro err = new StandardErro(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public 	ResponseEntity<StandardErro> dataIntegrity(DataIntegrityException e , HttpServletRequest request){
		StandardErro err = new StandardErro(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	//Retorna uma lista de erros referente ao @valilation @length @notnull
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public 	ResponseEntity<StandardErro> valitarion(MethodArgumentNotValidException e , HttpServletRequest request){
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	
}
